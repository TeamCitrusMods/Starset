package dev.teamcitrusmods.starset.world.etheria;

import dev.teamcitrusmods.starset.config.StarsetModConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * Credit to McJty and his tutorial on SavedData
 * <a href="https://www.mcjty.eu/docs/1.18/ep7#saved-data-manamanager">...</a>
 */
public class EtheriaManager extends SavedData {
    private final Map<ChunkPos, Etheria> etheriaMap = new HashMap<>();
    private final Random random = new Random();

    private final Set<BlockPos> chunkUpdate = new HashSet<>();

    private int regenCounter = 0;
    private int eveningCounter = 0;

    public EtheriaManager() {
    }

    public EtheriaManager(CompoundTag tag) {
        ListTag list = tag.getList("etheria", Tag.TAG_COMPOUND);
        for (Tag t : list) {
            CompoundTag etheriaTag = (CompoundTag) t;
            Etheria etheria = new Etheria(etheriaTag.getInt("etheria"), etheriaTag.getBoolean("isRich"), etheriaTag.getInt("cap"));
            ChunkPos pos = new ChunkPos(etheriaTag.getInt("x"), etheriaTag.getInt("z"));
            etheriaMap.put(pos, etheria);
        }
    }

    @Nonnull
    public static EtheriaManager get(Level level) {
        if (level.isClientSide) {
            throw new RuntimeException("Don't access this client-side!");
        }

        DimensionDataStorage storage = ((ServerLevel)level).getDataStorage();
        return storage.computeIfAbsent(EtheriaManager::new, EtheriaManager::new, "etheriamanager");
    }

    @NotNull
    private Etheria getEtheriaInternal(BlockPos pos) {
        ChunkPos chunkPos = new ChunkPos(pos);

        if(random.nextInt(StarsetModConfig.richEtheriaChunkChance.get(), 101) == 1) {
            int richAmount = random.nextInt(StarsetModConfig.richEtheriaChunkMin.get(), StarsetModConfig.richEtheriaChunkMax.get() + 1);
            return etheriaMap.computeIfAbsent(chunkPos, cp -> new Etheria(richAmount, true, richAmount));
        }

        int amount = random.nextInt(StarsetModConfig.normalEtheriaChunkMin.get(), StarsetModConfig.normalEtheriaChunkMax.get() + 1);
        return etheriaMap.computeIfAbsent(chunkPos, cp -> new Etheria(amount, false, amount));
    }

    public void regenTick(Level level) {
        regenCounter--;

        if (regenCounter <= 0) {
            regenCounter = 3600;

            etheriaMap.forEach((chunkPos, etheria) -> {
                if (etheria.getEtheria() < etheria.getCap()) {
                    etheria.addEtheria(1);
                }
            });
        }
    }

    public void eveningTick(Level level) {
        eveningCounter--;

        if (eveningCounter <= 0) {
            eveningCounter = 12000;

            etheriaMap.forEach((chunkPos, etheria) -> {
                if (etheria.getEtheria() < etheria.getCap()) {
                    LevelChunk northChunk = level.getChunkAt(new BlockPos(chunkPos.getMiddleBlockX(), 0, chunkPos.getMiddleBlockZ() - 9));
                    LevelChunk eastChunk = level.getChunkAt(new BlockPos(chunkPos.getMiddleBlockX() + 9, 0, chunkPos.getMiddleBlockZ()));
                    LevelChunk southChunk = level.getChunkAt(new BlockPos(chunkPos.getMiddleBlockX(), 0, chunkPos.getMiddleBlockZ() + 8));
                    LevelChunk westChunk = level.getChunkAt(new BlockPos(chunkPos.getMiddleBlockX() - 8, 0, chunkPos.getMiddleBlockZ()));

                    BlockPos northPos = northChunk.getPos().getWorldPosition();
                    BlockPos eastPos = eastChunk.getPos().getWorldPosition();
                    BlockPos southPos = southChunk.getPos().getWorldPosition();
                    BlockPos westPos = westChunk.getPos().getWorldPosition();

                    chunkUpdate.add(northPos);
                    chunkUpdate.add(eastPos);
                    chunkUpdate.add(southPos);
                    chunkUpdate.add(westPos);

                    etheria.addEtheria(4);
                }
            });

            chunkUpdate.forEach(blockPos -> drainEtheria(blockPos, 1));
            chunkUpdate.clear();
        }
    }

    @Override
    @NotNull
    public CompoundTag save(CompoundTag tag) {
        ListTag list = new ListTag();
        etheriaMap.forEach((chunkPos, etheria) -> {
            CompoundTag etheriaTag = new CompoundTag();
            etheriaTag.putInt("x", chunkPos.x);
            etheriaTag.putInt("z", chunkPos.z);
            etheriaTag.putInt("etheria", etheria.getEtheria());
            etheriaTag.putBoolean("isRich", etheria.isRich());
            etheriaTag.putInt("cap", etheria.getCap());
            list.add(etheriaTag);
        });
        tag.put("etheria", list);
        return tag;
    }

    public int getEtheria(BlockPos pos) {
        Etheria etheria = getEtheriaInternal(pos);
        return etheria.getEtheria();
    }

    public boolean getIsRich(BlockPos pos) {
        Etheria etheria = getEtheriaInternal(pos);
        return etheria.isRich();
    }

    public int getCap(BlockPos pos) {
        Etheria etheria = getEtheriaInternal(pos);
        return etheria.getCap();
    }

    public void setEtheria(BlockPos pos, int etheria) {
        getEtheriaInternal(pos).setEtheria(etheria);
        setDirty();
    }

    public void drainEtheria(BlockPos pos, int amount) {
        getEtheriaInternal(pos).drainEtheria(amount);
        setDirty();
    }

    public void addEtheria(BlockPos pos, int amount) {
        getEtheriaInternal(pos).addEtheria(amount);
        setDirty();
    }
}
