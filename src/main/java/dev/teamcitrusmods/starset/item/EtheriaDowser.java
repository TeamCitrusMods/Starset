package dev.teamcitrusmods.starset.item;

import dev.teamcitrusmods.starset.world.etheria.EtheriaManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class EtheriaDowser extends Item {
    public EtheriaDowser(Properties properties) {
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
            if(player != null) {
                player.displayClientMessage(Component.literal("Chunk contains " + amount + " etheria. And rich is " + rich + ". And the cap is " + cap), true);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
