package dev.teamcitrusmods.fundamentalsincognita.item;

import dev.teamcitrusmods.fundamentalsincognita.capability.etheria.IEtheriaCapability;
import dev.teamcitrusmods.fundamentalsincognita.registry.FIModCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

public class EtheriaDowser extends Item {
    public EtheriaDowser(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        LevelChunk chunk = level.getChunkAt(pos);
        Player player = context.getPlayer();

        if(!level.isClientSide()) {
            if(chunk.getCapability(FIModCapabilities.ETHERIA).resolve().isPresent()) {
                IEtheriaCapability cap = chunk.getCapability(FIModCapabilities.ETHERIA).resolve().get();
                if(player != null) {
                    player.displayClientMessage(Component.literal("Chunk contains " + cap.getEtheriaInChunk() + " etheria"), true);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}
