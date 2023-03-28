package dev.teamcitrusmods.starset.item;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.capability.etheria.IEtheriaCapability;
import dev.teamcitrusmods.starset.registry.StarsetModCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

import java.util.Random;

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
            if(chunk.getCapability(StarsetModCapabilities.ETHERIA).resolve().isPresent()) {
                IEtheriaCapability cap = chunk.getCapability(StarsetModCapabilities.ETHERIA).resolve().get();
                if(player != null) {
                    player.displayClientMessage(Component.literal("Chunk contains " + cap.getEtheriaInChunk() + " etheria. And rich is: " + cap.isRich()), true);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}
