package dev.teamcitrusmods.starset.registry;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.item.EtheriaDowser;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StarsetModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Starset.MODID);
    public static final RegistryObject<Item> ETHERIA_DOWSER = ITEMS.register("etheria_dowser", () -> new EtheriaDowser(new Item.Properties().tab(Starset.TAB)));
}
