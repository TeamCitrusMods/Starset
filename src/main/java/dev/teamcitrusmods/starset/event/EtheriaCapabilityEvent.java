package dev.teamcitrusmods.starset.event;

import dev.teamcitrusmods.starset.world.etheria.EtheriaManager;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EtheriaCapabilityEvent {

    @SubscribeEvent
    public void etheriaTickEvent(TickEvent.LevelTickEvent event) {
        Level level = event.level;

        if(!level.isClientSide() && event.phase == TickEvent.Phase.END) {
            EtheriaManager manager = EtheriaManager.get(level);
            manager.regenTick(level);
        }
    }
}
