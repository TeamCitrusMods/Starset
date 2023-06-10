package dev.teamcitrusmods.starset.data.provider;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.data.smithtype.StarsetStateSmithTypes;
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

import static dev.teamcitrusmods.starset.registry.StarsetModBlocks.*;

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
        Set<Supplier<Block>> blocks = new HashSet<>(BLOCKS.getEntries());

        AbstractBlockStateSmith.StateSmithData data = new AbstractBlockStateSmith.StateSmithData(this, blocks::remove);

        setTexturePath("rhinelabs/");
        BlockStateSmithTypes.FULL_BLOCK.act(data,
                PAINTED_RHINE_PANEL, MARKED_RHINE_PANEL,
                RHINE_HATCH, GROOVED_RHINE_PANEL,
                EXPOSED_RHINE_CIRCUITRY, COMB_RHINE_PANELLING,
                TILED_RHINE_PANELLING, PILLAR_RHINE_PANEL, RHINE_PANEL
        );

        StarsetStateSmithTypes.ORIENTABLE_FRONT.act(data,
                RHINELABS_EMBLEM_BL, RHINELABS_EMBLEM_BR,
                RHINELABS_EMBLEM_TL, RHINELABS_EMBLEM_TR
        );

        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::simpleBlock, block -> customBottomTopModel(block,
                "mostly_painted_rhine_panel",
                "painted_rhine_panel",
                "rhine_panel"), MOSTLY_PAINTED_RHINE_PANEL);
        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::simpleBlock, block -> customBottomTopModel(block,
                "partially_painted_rhine_panel",
                "painted_rhine_panel",
                "rhine_panel"), PARTIALLY_PAINTED_RHINE_PANEL);
        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::horizontalBlock, block -> fullCustomBlock(block,
                "rhine_panel", "mostly_painted_rhine_panel",
                "partially_painted_rhine_panel", "rhine_panel",
                "quarter_painted_rhine_panel", "quarter_painted_rhine_panel_reverse"), QUARTER_PAINTED_RHINE_PANEL);
        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::horizontalBlock, block -> fullCustomBlock(block,
                "rhine_panel", "painted_rhine_panel",
                "partially_painted_rhine_panel", "mostly_painted_rhine_panel",
                "slanted_painted_rhine_panel_reverse", "slanted_painted_rhine_panel"), SLANTED_PAINTED_RHINE_PANEL);

        setTexturePath("rhodes_island/");
        BlockStateSmithTypes.FULL_BLOCK.act(data,
                HAPHAZARD_RHODES_PLATING, MARKED_RHODES_SHEETMETAL, EXPOSED_RHODES_CIRCUITRY_1,
                EXPOSED_RHODES_CIRCUITRY_2, EXPOSED_RHODES_PLATING, TILED_RHODES_PLATING,
                RHODES_SHEETMETAL, SEEPING_RHODES_SHEETMETAL,
                RHODES_SAFETYMARKING, RHODES_PLATING
        );

        setTexturePath("stargazed/");
        BlockStateSmithTypes.FULL_BLOCK.act(data,
                RUNED_STARGAZED_BLOCK, EMBEDDED_STARGAZED_BLOCK, STARGAZED_TILES_BLOCK, STARGAZED_BLOCK
        );

        setTexturePath("");
        BlockStateSmithTypes.FULL_BLOCK.act(data,
                ORUNDUM_BLOCK, INACTIVE_ORIGINIUM,
                ORIGINITE_PRIME
        );
        BlockStateSmithTypes.LOG_BLOCK.act(data, REFINED_ORIGINIUM);

        BlockStateSmithTypes.CUSTOM_MODEL.act(data, this::simpleBlock, block -> customBottomMinecraftTopModel(block, "rhinelabs/overgrown_rhine_panel", "rhinelabs/rhine_panel", new ResourceLocation("block/azalea_top")) , OVERGROWN_RHINE_PANEL);
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
