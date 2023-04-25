package dev.teamcitrusmods.starset.data;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.data.provider.StarsetItemProvider;
import dev.teamcitrusmods.starset.data.provider.StarsetStateProvider;
import dev.teamcitrusmods.starset.data.provider.lang.EnUsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Starset.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StarsetData {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper file = event.getExistingFileHelper();
        LanguageProvider lang = new EnUsProvider(gen);
        StarsetItemProvider itemProvider = new StarsetItemProvider(gen, file);
        StarsetStateProvider stateProvider = new StarsetStateProvider(gen, file, itemProvider);

        gen.addProvider(event.includeClient(), lang);
        gen.addProvider(event.includeClient(), stateProvider);
        gen.addProvider(event.includeClient(), itemProvider);
    }
}
