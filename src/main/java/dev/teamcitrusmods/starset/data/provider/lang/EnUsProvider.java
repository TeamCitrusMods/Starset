package dev.teamcitrusmods.starset.data.provider.lang;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.registry.StarsetModBlocks;
import dev.teamcitrusmods.starset.registry.StarsetModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import team.lodestar.lodestone.helpers.DataHelper;

import java.util.HashSet;
import java.util.Set;

public class EnUsProvider extends LanguageProvider {
    public EnUsProvider(DataGenerator gen) {
        super(gen, Starset.MODID, "en_us");
    }

    @Override
    public String getName() {
        return "Starset Language Entries";
    }

    @Override
    protected void addTranslations() {
        Set<RegistryObject<Block>> blocks = new HashSet<>(StarsetModBlocks.BLOCKS.getEntries());
        Set<RegistryObject<Item>> items = new HashSet<>(StarsetModItems.ITEMS.getEntries());

        DataHelper.takeAll(items, i -> i.get() instanceof BlockItem);

        add("itemGroup.starset", "Starset");

        blocks.forEach(b -> {
            String name = b.get().getDescriptionId().replaceFirst("block\\.starset\\.", "");
            name = DataHelper.toTitleCase(name, "_");
            add(b.get().getDescriptionId(), name);
        });

        items.forEach(i -> {
            String name = i.get().getDescriptionId().replaceFirst("item\\.starset\\.", "");
            name = DataHelper.toTitleCase(name, "_");
            add(i.get().getDescriptionId(), name);
        });
    }
}
