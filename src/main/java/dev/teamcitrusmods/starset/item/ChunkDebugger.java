package dev.teamcitrusmods.starset.item;

import dev.teamcitrusmods.starset.world.etheria.EtheriaManager;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

public class ChunkDebugger extends Item {
    public ChunkDebugger(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if(!level.isClientSide()) {
            int amount = EtheriaManager.get(level).getEtheria(pos);
            boolean rich = EtheriaManager.get(level).getIsRich(pos);
            int cap = EtheriaManager.get(level).getCap(pos);
            LevelChunk chunk = level.getChunkAt(pos);
            ChunkPos chunkPos = chunk.getPos();

            if(player != null) {
                if(!player.isCrouching()) {
                    player.sendSystemMessage(Component.literal("[[Chunk Debug]]")
                            .append("\nChunk ID: " + chunk)
                            .append("\nCentre Pos: X = " + chunkPos.getMiddleBlockX() + ". Z = " + chunkPos.getMiddleBlockZ())
                            .append("\nEtheria in Chunk: " + amount)
                            .append("\nIs Rich?: " + rich)
                            .append("\nInnate Chunk Etheria Cap: " + cap)
                            .withStyle(ChatFormatting.GREEN));
                } else {
                    EtheriaManager.get(level).drainEtheria(pos, 10);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }
}
