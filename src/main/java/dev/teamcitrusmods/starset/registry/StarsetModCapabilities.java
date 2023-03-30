package dev.teamcitrusmods.starset.registry;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.capability.ego.EgoCapability;
import dev.teamcitrusmods.starset.capability.ego.IEgoCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Starset.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class StarsetModCapabilities {
    public static final Capability<IEgoCapability> EGO = CapabilityManager.get(new CapabilityToken<>(){});

    @SubscribeEvent
    public static void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(IEgoCapability.class);
    }

    @SubscribeEvent
    public static void attachEntityCaps(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(Starset.MODID, "ego"), new EgoCapability.EgoProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(EGO).ifPresent(oldStore -> {
                event.getEntity().getCapability(EGO).ifPresent(newStore -> {
                    newStore.setEgo(oldStore.getEgoAmount());
                });
            });
        }
    }
}
