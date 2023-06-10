package dev.teamcitrusmods.starset.registry;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.item.ChunkDebuggerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StarsetModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Starset.MODID);

    public static final RegistryObject<Item> CHUNK_DEBUGGER = ITEMS.register("chunk_debugger", () -> new ChunkDebuggerItem(new Item.Properties().tab(Starset.TAB)));

    public static final RegistryObject<Item> OVERGROWN_RHINE_PANEL_ITEM = ITEMS.register("overgrown_rhine_panel", () -> new BlockItem(StarsetModBlocks.OVERGROWN_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> PAINTED_RHINE_PANEL_ITEM = ITEMS.register("painted_rhine_panel", () -> new BlockItem(StarsetModBlocks.PAINTED_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> MOSTLY_PAINTED_RHINE_PANEL_ITEM = ITEMS.register("mostly_painted_rhine_panel", () -> new BlockItem(StarsetModBlocks.MOSTLY_PAINTED_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> MARKED_RHINE_PANEL_ITEM = ITEMS.register("marked_rhine_panel", () -> new BlockItem(StarsetModBlocks.MARKED_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHINE_HATCH_ITEM = ITEMS.register("rhine_hatch", () -> new BlockItem(StarsetModBlocks.RHINE_HATCH.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> GROOVED_RHINE_PANEL_ITEM = ITEMS.register("grooved_rhine_panel", () -> new BlockItem(StarsetModBlocks.GROOVED_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> EXPOSED_RHINE_CIRCUITRY_ITEM = ITEMS.register("exposed_rhine_circuitry", () -> new BlockItem(StarsetModBlocks.EXPOSED_RHINE_CIRCUITRY.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHINELABS_EMBLEM_BL_ITEM = ITEMS.register("rhinelabs_emblem_bl", () -> new BlockItem(StarsetModBlocks.RHINELABS_EMBLEM_BL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHINELABS_EMBLEM_BR_ITEM = ITEMS.register("rhinelabs_emblem_br", () -> new BlockItem(StarsetModBlocks.RHINELABS_EMBLEM_BR.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHINELABS_EMBLEM_TL_ITEM = ITEMS.register("rhinelabs_emblem_tl", () -> new BlockItem(StarsetModBlocks.RHINELABS_EMBLEM_TL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHINELABS_EMBLEM_TR_ITEM = ITEMS.register("rhinelabs_emblem_tr", () -> new BlockItem(StarsetModBlocks.RHINELABS_EMBLEM_TR.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> COMB_RHINE_PANELLING_ITEM = ITEMS.register("comb_rhine_panelling", () -> new BlockItem(StarsetModBlocks.COMB_RHINE_PANELLING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> TILED_RHINE_PANELLING_ITEM = ITEMS.register("tiled_rhine_panelling", () -> new BlockItem(StarsetModBlocks.TILED_RHINE_PANELLING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> SLANTED_PAINTED_RHINE_PANEL_ITEM = ITEMS.register("slanted_painted_rhine_panel", () -> new BlockItem(StarsetModBlocks.SLANTED_PAINTED_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> QUARTER_PAINTED_RHINE_PANEL_ITEM = ITEMS.register("quarter_painted_rhine_panel", () -> new BlockItem(StarsetModBlocks.QUARTER_PAINTED_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> PILLAR_RHINE_PANEL_ITEM = ITEMS.register("pillar_rhine_panel", () -> new BlockItem(StarsetModBlocks.PILLAR_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> PARTIALLY_PAINTED_RHINE_PANEL_ITEM = ITEMS.register("partially_painted_rhine_panel", () -> new BlockItem(StarsetModBlocks.PARTIALLY_PAINTED_RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHINE_PANEL_ITEM = ITEMS.register("rhine_panel", () -> new BlockItem(StarsetModBlocks.RHINE_PANEL.get(), new Item.Properties().tab(Starset.TAB)));

    public static final RegistryObject<Item> HAPHAZARD_RHODES_PLATING_ITEM = ITEMS.register("haphazard_rhodes_plating", () -> new BlockItem(StarsetModBlocks.HAPHAZARD_RHODES_PLATING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> MARKED_RHODES_SHEETMETAL_ITEM = ITEMS.register("marked_rhodes_sheetmetal", () -> new BlockItem(StarsetModBlocks.MARKED_RHODES_SHEETMETAL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_INTERFACE_PANEL_1_ITEM = ITEMS.register("rhodes_interface_panel_1", () -> new BlockItem(StarsetModBlocks.RHODES_INTERFACE_PANEL_1.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_INTERFACE_PANEL_2_ITEM = ITEMS.register("rhodes_interface_panel_2", () -> new BlockItem(StarsetModBlocks.RHODES_INTERFACE_PANEL_2.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> EXPOSED_RHODES_CIRCUITRY_1_ITEM = ITEMS.register("exposed_rhodes_circuitry_1", () -> new BlockItem(StarsetModBlocks.EXPOSED_RHODES_CIRCUITRY_1.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> EXPOSED_RHODES_CIRCUITRY_2_ITEM = ITEMS.register("exposed_rhodes_circuitry_2", () -> new BlockItem(StarsetModBlocks.EXPOSED_RHODES_CIRCUITRY_2.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> EXPOSED_RHODES_PLATING_ITEM = ITEMS.register("exposed_rhodes_plating", () -> new BlockItem(StarsetModBlocks.EXPOSED_RHODES_PLATING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_ISLAND_EMBLEM_BL_ITEM = ITEMS.register("rhodes_island_emblem_bl", () -> new BlockItem(StarsetModBlocks.RHODES_ISLAND_EMBLEM_BL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_ISLAND_EMBLEM_BR_ITEM = ITEMS.register("rhodes_island_emblem_br", () -> new BlockItem(StarsetModBlocks.RHODES_ISLAND_EMBLEM_BR.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_ISLAND_EMBLEM_TL_ITEM = ITEMS.register("rhodes_island_emblem_tl", () -> new BlockItem(StarsetModBlocks.RHODES_ISLAND_EMBLEM_TL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_ISLAND_EMBLEM_TR_ITEM = ITEMS.register("rhodes_island_emblem_tr", () -> new BlockItem(StarsetModBlocks.RHODES_ISLAND_EMBLEM_TR.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> CORNER_RHODES_SAFETYMARKING_ITEM = ITEMS.register("corner_rhodes_safetymarking", () -> new BlockItem(StarsetModBlocks.CORNER_RHODES_SAFETYMARKING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> TRANSITIONAL_RHODES_PLATING_ITEM = ITEMS.register("transitional_rhodes_plating", () -> new BlockItem(StarsetModBlocks.TRANSITIONAL_RHODES_PLATING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> TILED_RHODES_PLATING_ITEM = ITEMS.register("tiled_rhodes_plating", () -> new BlockItem(StarsetModBlocks.TILED_RHODES_PLATING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> SMALL_TRANSITIONAL_RHODES_PLATING_ITEM = ITEMS.register("small_transitional_rhodes_plating", () -> new BlockItem(StarsetModBlocks.SMALL_TRANSITIONAL_RHODES_PLATING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_SHEETMETAL_ITEM = ITEMS.register("rhodes_sheetmetal", () -> new BlockItem(StarsetModBlocks.RHODES_SHEETMETAL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> SEEPING_TRANSITIONAL_RHODES_PLATING_ITEM = ITEMS.register("seeping_transitional_rhodes_plating", () -> new BlockItem(StarsetModBlocks.SEEPING_TRANSITIONAL_RHODES_PLATING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> SEEPING_RHODES_SHEETMETAL_ITEM = ITEMS.register("seeping_rhodes_sheetmetal", () -> new BlockItem(StarsetModBlocks.SEEPING_RHODES_SHEETMETAL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_SAFETYMARKING_ITEM = ITEMS.register("rhodes_safetymarking", () -> new BlockItem(StarsetModBlocks.RHODES_SAFETYMARKING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> QUARTER_RHODES_SAFETYMARKING_ITEM = ITEMS.register("quarter_rhodes_safetymarking", () -> new BlockItem(StarsetModBlocks.QUARTER_RHODES_SAFETYMARKING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> RHODES_PLATING_ITEM = ITEMS.register("rhodes_plating", () -> new BlockItem(StarsetModBlocks.RHODES_PLATING.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> PARTIAL_RHODES_SAFETYMARKING_ITEM = ITEMS.register("partial_rhodes_safetymarking", () -> new BlockItem(StarsetModBlocks.PARTIAL_RHODES_SAFETYMARKING.get(), new Item.Properties().tab(Starset.TAB)));

    public static final RegistryObject<Item> RUNED_STARGAZED_BLOCK_ITEM = ITEMS.register("runed_stargazed_block", () -> new BlockItem(StarsetModBlocks.RUNED_STARGAZED_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> PARTIALLY_ACTIVE_STARSOIL_ITEM = ITEMS.register("partially_active_starsoil", () -> new BlockItem(StarsetModBlocks.PARTIALLY_ACTIVE_STARSOIL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> GROOVED_STARGAZED_BLOCK_ITEM = ITEMS.register("grooved_stargazed_block", () -> new BlockItem(StarsetModBlocks.GROOVED_STARGAZED_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> EXPOSED_STARGAZED_BLOCK_ITEM = ITEMS.register("exposed_stargazed_block", () -> new BlockItem(StarsetModBlocks.EXPOSED_STARGAZED_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> EMBEDDED_STARGAZED_BLOCK_ITEM = ITEMS.register("embedded_stargazed_block", () -> new BlockItem(StarsetModBlocks.EMBEDDED_STARGAZED_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> CIRCUITED_STARGAZED_BLOCK_ITEM = ITEMS.register("circuited_stargazed_block", () -> new BlockItem(StarsetModBlocks.CIRCUITED_STARGAZED_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> ARKED_STARGAZED_BLOCK_ITEM = ITEMS.register("arked_stargazed_block", () -> new BlockItem(StarsetModBlocks.ARKED_STARGAZED_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> ACTIVE_STARSOIL_ITEM = ITEMS.register("active_starsoil", () -> new BlockItem(StarsetModBlocks.ACTIVE_STARSOIL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> STARSOIL_ITEM = ITEMS.register("starsoil", () -> new BlockItem(StarsetModBlocks.STARSOIL.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> STARGAZED_TILES_BLOCK_ITEM = ITEMS.register("stargazed_tiles_block", () -> new BlockItem(StarsetModBlocks.STARGAZED_TILES_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> STARGAZED_BLOCK_ITEM = ITEMS.register("stargazed_block", () -> new BlockItem(StarsetModBlocks.STARGAZED_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));

    public static final RegistryObject<Item> ORUNDUM_BLOCK_ITEM = ITEMS.register("orundum_block", () -> new BlockItem(StarsetModBlocks.ORUNDUM_BLOCK.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> ORIGINITE_PRIME_ITEM = ITEMS.register("originite_prime", () -> new BlockItem(StarsetModBlocks.ORIGINITE_PRIME.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> INACTIVE_ORIGINIUM_ITEM = ITEMS.register("inactive_originium", () -> new BlockItem(StarsetModBlocks.INACTIVE_ORIGINIUM.get(), new Item.Properties().tab(Starset.TAB)));
    public static final RegistryObject<Item> REFINED_ORIGINIUM = ITEMS.register("refined_originium", () -> new BlockItem(StarsetModBlocks.REFINED_ORIGINIUM.get(), new Item.Properties().tab(Starset.TAB)));
}
