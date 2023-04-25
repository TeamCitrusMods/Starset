package dev.teamcitrusmods.starset.data.provider;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.data.smithtype.StarsetStateSmithTypes;
import dev.teamcitrusmods.starset.registry.StarsetModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import team.lodestar.lodestone.systems.datagen.BlockStateSmithTypes;
import team.lodestar.lodestone.systems.datagen.providers.LodestoneBlockStateProvider;
import team.lodestar.lodestone.systems.datagen.providers.LodestoneItemModelProvider;
import team.lodestar.lodestone.systems.datagen.statesmith.AbstractBlockStateSmith;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class StarsetStateProvider extends LodestoneBlockStateProvider {
    public StarsetStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper, LodestoneItemModelProvider itemModelProvider) {
        super(gen, Starset.MODID, exFileHelper, itemModelProvider);
    }

    @Override
    public @NotNull String getName() {
        return "Starset Blockstates";
    }

    @Override
    protected void registerStatesAndModels() {
        Set<Supplier<Block>> blocks = new HashSet<>(StarsetModBlocks.BLOCKS.getEntries());

        AbstractBlockStateSmith.StateSmithData data = new AbstractBlockStateSmith.StateSmithData(this, blocks::remove);

        setTexturePath("rhinelabs/");
        BlockStateSmithTypes.FULL_BLOCK.act(data,
                StarsetModBlocks.PAINTED_RHINE_PANEL, StarsetModBlocks.MARKED_RHINE_PANEL,
                StarsetModBlocks.RHINE_HATCH, StarsetModBlocks.GROOVED_RHINE_PANEL,
                StarsetModBlocks.EXPOSED_RHINE_CIRCUITRY, StarsetModBlocks.COMB_RHINE_PANELLING,
                StarsetModBlocks.TILED_RHINE_PANELLING, StarsetModBlocks.PILLAR_RHINE_PANEL, StarsetModBlocks.RHINE_PANEL
        );

        StarsetStateSmithTypes.ORIENTABLE_FRONT.act(data,
                StarsetModBlocks.RHINELABS_EMBLEM_BL, StarsetModBlocks.RHINELABS_EMBLEM_BR,
                StarsetModBlocks.RHINELABS_EMBLEM_TL, StarsetModBlocks.RHINELABS_EMBLEM_TR
        );

        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::simpleBlock, block -> customBottomTopModel(block,
                "mostly_painted_rhine_panel",
                "painted_rhine_panel",
                "rhine_panel"), StarsetModBlocks.MOSTLY_PAINTED_RHINE_PANEL);
        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::simpleBlock, block -> customBottomTopModel(block,
                "partially_painted_rhine_panel",
                "painted_rhine_panel",
                "rhine_panel"), StarsetModBlocks.PARTIALLY_PAINTED_RHINE_PANEL);
        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::horizontalBlock, block -> fullCustomBlock(block,
                "rhine_panel", "mostly_painted_rhine_panel",
                "partially_painted_rhine_panel", "rhine_panel",
                "quarter_painted_rhine_panel", "quarter_painted_rhine_panel_reverse"), StarsetModBlocks.QUARTER_PAINTED_RHINE_PANEL);
        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::horizontalBlock, block -> fullCustomBlock(block,
                "rhine_panel", "painted_rhine_panel",
                "partially_painted_rhine_panel", "mostly_painted_rhine_panel",
                "slanted_painted_rhine_panel_reverse", "slanted_painted_rhine_panel"), StarsetModBlocks.SLANTED_PAINTED_RHINE_PANEL);

        setTexturePath("rhodes_island/");
        BlockStateSmithTypes.FULL_BLOCK.act(data,
                StarsetModBlocks.HAPHAZARD_RHODES_PLATING, StarsetModBlocks.MARKED_RHODES_SHEETMETAL, StarsetModBlocks.EXPOSED_RHODES_CIRCUITRY_1,
                StarsetModBlocks.EXPOSED_RHODES_CIRCUITRY_2, StarsetModBlocks.EXPOSED_RHODES_PLATING, StarsetModBlocks.TILED_RHODES_PLATING,
                StarsetModBlocks.RHODES_SHEETMETAL, StarsetModBlocks.SEEPING_RHODES_SHEETMETAL,
                StarsetModBlocks.RHODES_SAFETYMARKING, StarsetModBlocks.RHODES_PLATING
        );

        setTexturePath("");
        BlockStateSmithTypes.FULL_BLOCK.act(data,
                StarsetModBlocks.ORUNDUM_BLOCK, StarsetModBlocks.INACTIVE_ORIGINIUM,
                StarsetModBlocks.ORIGINITE_PRIME
        );
        BlockStateSmithTypes.LOG_BLOCK.act(data, StarsetModBlocks.REFINED_ORIGINIUM);

        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::simpleBlock, block -> customBottomMinecraftTopModel(block, "rhinelabs/overgrown_rhine_panel", "rhinelabs/rhine_panel", new ResourceLocation("block/azalea_top")) , StarsetModBlocks.OVERGROWN_RHINE_PANEL);
    }

    public ModelFile customBottomTopModel(Block block, String side, String bottom, String top) {
        String name = getBlockName(block);
        ResourceLocation sideTexture = getBlockTexture(side);
        ResourceLocation bottomTexture = getBlockTexture(bottom);
        ResourceLocation topTexture = getBlockTexture(top);
        return models().cubeBottomTop(name, sideTexture, bottomTexture, topTexture);
    }

    public ModelFile customBottomMinecraftTopModel(Block block, String side, String bottom, ResourceLocation topTexture) {
        String name = getBlockName(block);
        ResourceLocation sideTexture = getBlockTexture(side);
        ResourceLocation bottomTexture = getBlockTexture(bottom);
        return models().cubeBottomTop(name, sideTexture, bottomTexture, topTexture);
    }

    public ModelFile fullCustomBlock(Block block, String up, String down, String north, String south, String east, String west) {
        String name = getBlockName(block);
        ResourceLocation upTexture = getBlockTexture(up);
        ResourceLocation downTexture = getBlockTexture(down);
        ResourceLocation northTexture = getBlockTexture(north);
        ResourceLocation southTexture = getBlockTexture(south);
        ResourceLocation eastTexture = getBlockTexture(east);
        ResourceLocation westTexture = getBlockTexture(west);
        ResourceLocation particleTexture = getBlockTexture(name);
        return models().withExistingParent(name, ModelProvider.BLOCK_FOLDER + "/cube_all")
                .texture("up", upTexture)
                .texture("down", downTexture)
                .texture("north", northTexture)
                .texture("south", southTexture)
                .texture("east", eastTexture)
                .texture("west", westTexture)
                .texture("particle", particleTexture);
    }
}
