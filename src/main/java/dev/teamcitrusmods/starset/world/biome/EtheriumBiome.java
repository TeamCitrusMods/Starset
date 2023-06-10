package dev.teamcitrusmods.starset.world.biome;

import dev.teamcitrusmods.starset.registry.StarsetBiomes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EtheriumBiome {
    public static void register() {
        Biome.BiomeBuilder template = new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.8f)
                .downfall(1.0f)
                .specialEffects(StarsetBiomes.createDefaultBiomeEffects().waterColor(0x54d3c0).waterFogColor(0x24a0b0).build()
                );

        StarsetBiomes.ETHERIUM_BIOME = StarsetBiomes.register("etherium", template
                .generationSettings(volcanicIslandGenerationSettings().build())
                .mobSpawnSettings(defaultSpawnSettings().build())
                .build()
        );
    }

    private static BiomeGenerationSettings.Builder volcanicIslandGenerationSettings() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        // ^^ addBasicFeatures(builder); EXCEPT addSprings and addFrozenTopLayer
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.JUNGLE_PALM_TREES);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.RARE_DUM_DUM_HEADS);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.DENSER_JUNGLE_PALM_TREES);
        BiomeDefaultFeatures.addDefaultFlowers(builder);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TerrestriaPlacedFeatures.PATCH_VOLCANIC_ISLAND_GRASS);
        BiomeDefaultFeatures.addDefaultGrass(builder);
        BiomeDefaultFeatures.addDefaultMushrooms(builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(builder);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
        BiomeDefaultFeatures.addDefaultSeagrass(builder);
        return builder;
    }

    private static MobSpawnSettings.Builder defaultSpawnSettings() {
        MobSpawnSettings.Builder builder = StarsetBiomes.createDefaultSpawnSettings();
        builder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 3, 1, 4));
        builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 15, 3, 6));
        builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.COD, 15, 1, 5));
        return builder;
    }
}
