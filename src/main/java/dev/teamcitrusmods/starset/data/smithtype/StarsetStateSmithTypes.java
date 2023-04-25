package dev.teamcitrusmods.starset.data.smithtype;

import dev.teamcitrusmods.starset.Starset;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import team.lodestar.lodestone.systems.datagen.ItemModelSmithTypes;
import team.lodestar.lodestone.systems.datagen.statesmith.BlockStateSmith;

public class StarsetStateSmithTypes {
    public static BlockStateSmith<HorizontalDirectionalBlock> ORIENTABLE_FRONT = new BlockStateSmith<>(HorizontalDirectionalBlock.class, ItemModelSmithTypes.BLOCK_MODEL_ITEM, (block, provider) -> {
        String name = provider.getBlockName(block);
        ResourceLocation frontTexture = provider.getBlockTexture(name);
        ResourceLocation particleTexture = provider.getBlockTexture(name);
        provider.getVariantBuilder(block).forAllStates(s -> {
            ModelFile oBlock = provider.models().withExistingParent(name, ModelProvider.BLOCK_FOLDER + "/orientable")
                    .texture("front", frontTexture)
                    .texture("side", new ResourceLocation(Starset.MODID, "block/rhine_panel"))
                    .texture("top", new ResourceLocation(Starset.MODID, "block/rhine_panel"))
                    .texture("particle", particleTexture);
            return ConfiguredModel.builder().modelFile(oBlock).rotationY(((int) s.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360).build();
        });
    });
}
