package dev.teamcitrusmods.starset.registry;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.block.BaseHorizontalDirectionBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StarsetModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Starset.MODID);

    public static final RegistryObject<Block> OVERGROWN_RHINE_PANEL = BLOCKS.register("overgrown_rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PAINTED_RHINE_PANEL = BLOCKS.register("painted_rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSTLY_PAINTED_RHINE_PANEL = BLOCKS.register("mostly_painted_rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MARKED_RHINE_PANEL = BLOCKS.register("marked_rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHINE_HATCH = BLOCKS.register("rhine_hatch", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GROOVED_RHINE_PANEL = BLOCKS.register("grooved_rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EXPOSED_RHINE_CIRCUITRY = BLOCKS.register("exposed_rhine_circuitry", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHINELABS_EMBLEM_BL = BLOCKS.register("rhinelabs_emblem_bl", () -> new BaseHorizontalDirectionBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHINELABS_EMBLEM_BR = BLOCKS.register("rhinelabs_emblem_br", () -> new BaseHorizontalDirectionBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHINELABS_EMBLEM_TL = BLOCKS.register("rhinelabs_emblem_tl", () -> new BaseHorizontalDirectionBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHINELABS_EMBLEM_TR = BLOCKS.register("rhinelabs_emblem_tr", () -> new BaseHorizontalDirectionBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COMB_RHINE_PANELLING = BLOCKS.register("comb_rhine_panelling", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TILED_RHINE_PANELLING = BLOCKS.register("tiled_rhine_panelling", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SLANTED_PAINTED_RHINE_PANEL = BLOCKS.register("slanted_painted_rhine_panel", () -> new BaseHorizontalDirectionBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> QUARTER_PAINTED_RHINE_PANEL = BLOCKS.register("quarter_painted_rhine_panel", () -> new BaseHorizontalDirectionBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PILLAR_RHINE_PANEL = BLOCKS.register("pillar_rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PARTIALLY_PAINTED_RHINE_PANEL = BLOCKS.register("partially_painted_rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHINE_PANEL = BLOCKS.register("rhine_panel", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HAPHAZARD_RHODES_PLATING = BLOCKS.register("haphazard_rhodes_plating", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MARKED_RHODES_SHEETMETAL = BLOCKS.register("marked_rhodes_sheetmetal", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_INTERFACE_PANEL_1 = BLOCKS.register("rhodes_interface_panel_1", ()-> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_INTERFACE_PANEL_2 = BLOCKS.register("rhodes_interface_panel_2", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EXPOSED_RHODES_CIRCUITRY_1 = BLOCKS.register("exposed_rhodes_circuitry_1", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EXPOSED_RHODES_CIRCUITRY_2 = BLOCKS.register("exposed_rhodes_circuitry_2", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EXPOSED_RHODES_PLATING = BLOCKS.register("exposed_rhodes_plating", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_ISLAND_EMBLEM_BL = BLOCKS.register("rhodes_island_emblem_bl", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_ISLAND_EMBLEM_BR = BLOCKS.register("rhodes_island_emblem_br", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_ISLAND_EMBLEM_TL = BLOCKS.register("rhodes_island_emblem_tl", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_ISLAND_EMBLEM_TR = BLOCKS.register("rhodes_island_emblem_tr", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORNER_RHODES_SAFETYMARKING = BLOCKS.register("corner_rhodes_safetymarking", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TRANSITIONAL_RHODES_PLATING = BLOCKS.register("transitional_rhodes_plating", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TILED_RHODES_PLATING = BLOCKS.register("tiled_rhodes_plating", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMALL_TRANSITIONAL_RHODES_PLATING = BLOCKS.register("small_transitional_rhodes_plating", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_SHEETMETAL = BLOCKS.register("rhodes_sheetmetal", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SEEPING_TRANSITIONAL_RHODES_PLATING = BLOCKS.register("seeping_transitional_rhodes_plating", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SEEPING_RHODES_SHEETMETAL = BLOCKS.register("seeping_rhodes_sheetmetal", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_SAFETYMARKING = BLOCKS.register("rhodes_safetymarking", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> QUARTER_RHODES_SAFETYMARKING = BLOCKS.register("quarter_rhodes_safetymarking", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RHODES_PLATING = BLOCKS.register("rhodes_plating", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PARTIAL_RHODES_SAFETYMARKING = BLOCKS.register("partial_rhodes_safetymarking", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RUNED_STARGAZED_BLOCK = BLOCKS.register("runed_stargazed_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PARTIALLY_ACTIVE_STARSOIL = BLOCKS.register("partially_active_starsoil", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GROOVED_STARGAZED_BLOCK = BLOCKS.register("grooved_stargazed_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EXPOSED_STARGAZED_BLOCK = BLOCKS.register("exposed_stargazed_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> EMBEDDED_STARGAZED_BLOCK = BLOCKS.register("embedded_stargazed_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CIRCUITED_STARGAZED_BLOCK = BLOCKS.register("circuited_stargazed_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ARKED_STARGAZED_BLOCK = BLOCKS.register("arked_stargazed_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ACTIVE_STARSOIL = BLOCKS.register("active_starsoil", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STARSOIL = BLOCKS.register("starsoil", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STARGAZED_TILES_BLOCK = BLOCKS.register("stargazed_tiles_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STARGAZED_BLOCK = BLOCKS.register("stargazed_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ORUNDUM_BLOCK = BLOCKS.register("orundum_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ORIGINITE_PRIME = BLOCKS.register("originite_prime", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> INACTIVE_ORIGINIUM = BLOCKS.register("inactive_originium", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REFINED_ORIGINIUM = BLOCKS.register("refined_originium", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2.0f).requiresCorrectToolForDrops()));
}
