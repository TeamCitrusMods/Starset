package dev.teamcitrusmods.fundamentalsincognita;

import com.mojang.logging.LogUtils;
import dev.teamcitrusmods.fundamentalsincognita.config.FIModConfig;
import dev.teamcitrusmods.fundamentalsincognita.registry.FIModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FundamentalsIncognita.MODID)
public class FundamentalsIncognita {
    public static final String MODID = "fundamentalsincognita";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.ACACIA_BOAT);
        }
    };

    public FundamentalsIncognita() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FIModConfig.GENERAL_SPEC);

        FIModItems.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
