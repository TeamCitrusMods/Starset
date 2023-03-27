package dev.teamcitrusmods.fundamentalsincognita.registry;

import dev.teamcitrusmods.fundamentalsincognita.FundamentalsIncognita;
import dev.teamcitrusmods.fundamentalsincognita.capability.ego.EgoCapability;
import dev.teamcitrusmods.fundamentalsincognita.capability.ego.IEgoCapability;
import dev.teamcitrusmods.fundamentalsincognita.capability.etheria.EtheriaCapability;
import dev.teamcitrusmods.fundamentalsincognita.capability.etheria.IEtheriaCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FundamentalsIncognita.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FIModCapabilities {
    public static final Capability<IEgoCapability> EGO = CapabilityManager.get(new CapabilityToken<>(){});
    public static final Capability<IEtheriaCapability> ETHERIA = CapabilityManager.get(new CapabilityToken<>(){});

    @SubscribeEvent
    public static void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(IEgoCapability.class);
        event.register(IEtheriaCapability.class);
    }

    @SubscribeEvent
    public static void attachEntityCaps(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(FundamentalsIncognita.MODID, "ego"), new EgoCapability.EgoProvider());
        }
    }

    @SubscribeEvent
    public static void attachChunkCaps(AttachCapabilitiesEvent<LevelChunk> event) {
        event.addCapability(new ResourceLocation(FundamentalsIncognita.MODID, "etheria"), new EtheriaCapability.EtheriaProvider());
    }
}
