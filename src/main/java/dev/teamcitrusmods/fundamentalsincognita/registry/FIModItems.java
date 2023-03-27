package dev.teamcitrusmods.fundamentalsincognita.registry;

import dev.teamcitrusmods.fundamentalsincognita.FundamentalsIncognita;
import dev.teamcitrusmods.fundamentalsincognita.item.EtheriaDowser;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FIModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FundamentalsIncognita.MODID);
    public static final RegistryObject<Item> ETHERIA_DOWSER = ITEMS.register("etheria_dowser", () -> new EtheriaDowser(new Item.Properties().tab(FundamentalsIncognita.TAB)));
}
