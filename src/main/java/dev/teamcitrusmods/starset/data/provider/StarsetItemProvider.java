package dev.teamcitrusmods.starset.data.provider;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.registry.StarsetModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import team.lodestar.lodestone.systems.datagen.ItemModelSmithTypes;
import team.lodestar.lodestone.systems.datagen.itemsmith.AbstractItemModelSmith;
import team.lodestar.lodestone.systems.datagen.providers.LodestoneItemModelProvider;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class StarsetItemProvider extends LodestoneItemModelProvider {
    public StarsetItemProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Starset.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Starset Item Models";
    }

    @Override
    protected void registerModels() {
        Set<Supplier<Item>> items = new HashSet<>(StarsetModItems.ITEMS.getEntries());

        items.removeIf(i -> i.get() instanceof BlockItem);

        AbstractItemModelSmith.ItemModelSmithData data = new AbstractItemModelSmith.ItemModelSmithData(this, items::remove);

        setTexturePath("");
        ItemModelSmithTypes.GENERATED_ITEM.act(data, items);
    }
}
