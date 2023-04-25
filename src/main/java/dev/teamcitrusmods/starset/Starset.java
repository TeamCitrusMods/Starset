package dev.teamcitrusmods.starset;

import com.mojang.logging.LogUtils;
import dev.teamcitrusmods.starset.config.StarsetModConfig;
import dev.teamcitrusmods.starset.event.StarsetLevelEvents;
import dev.teamcitrusmods.starset.registry.StarsetModBlocks;
import dev.teamcitrusmods.starset.registry.StarsetModItems;
import dev.teamcitrusmods.starset.utils.ConfigUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(Starset.MODID)
public class Starset {
    public static final String MODID = "starset";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(StarsetModItems.ORUNDUM_BLOCK_ITEM.get());
        }
    };

    public Starset() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, StarsetModConfig.GENERAL_SPEC);

        modEventBus.addListener(this::commonSetup);

        StarsetModBlocks.BLOCKS.register(modEventBus);
        StarsetModItems.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new StarsetLevelEvents());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ConfigUtils.checkConfig();
    }
}
