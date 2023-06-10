package dev.teamcitrusmods.starset.registry;

import dev.teamcitrusmods.starset.Starset;
import dev.teamcitrusmods.starset.world.biome.EtheriumBiome;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class StarsetBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, Starset.MODID);

    public static RegistryObject<Biome> ETHERIUM_BIOME;

    public static void registerBiomes(IEventBus bus) {
        EtheriumBiome.register();

        BIOMES.register(bus);
    }

    public static void addBasicFeatures(BiomeGenerationSettings.Builder generationSettings) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
    }

    public static MobSpawnSettings.Builder createDefaultSpawnSettings() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        addDefaultCreatureSpawnEntries(spawnSettings);
        addDefaultAmbientSpawnEntries(spawnSettings);
        addDefaultMonsterSpawnEntries(spawnSettings);
        return spawnSettings;
    }

    public static void addDefaultCreatureSpawnEntries(MobSpawnSettings.Builder builder) {
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
    }

    public static void addDefaultAmbientSpawnEntries(MobSpawnSettings.Builder builder) {
        builder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
    }

    public static void addDefaultMonsterSpawnEntries(MobSpawnSettings.Builder builder) {
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 100, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 100, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 100, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 10, 1, 4));
        builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
    }

    // Copied from Traverse
    public static BiomeSpecialEffects.Builder createDefaultBiomeEffects() {
        return new BiomeSpecialEffects.Builder()
                .waterColor(0x3F76E4)
                .waterFogColor(0x50533)
                .skyColor(getSkyColor(0.2F))
                .fogColor(0xC0D8FF);
    }

    // Copied from Minecraft
    private static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static RegistryObject<Biome> register(String name, Biome biome) {
        //ResourceLocation identifier = new ResourceLocation(Starset.MODID, name);
        //ResourceKey<Biome> biomeKey = ResourceKey.create(Registry.BIOME_REGISTRY, identifier);

        //BuiltinRegistries.register(BuiltinRegistries.BIOME, identifier, biome);
        //biomes.put(name, biomeKey);

        RegistryObject<Biome> biomeKey = BIOMES.register(name, () -> biome);

        return biomeKey;
    }
}
