package dev.teamcitrusmods.starset.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FIModConfig {
    public static final ForgeConfigSpec GENERAL_SPEC;

    public static ForgeConfigSpec.IntValue badEgoEffectsMin;

    public static ForgeConfigSpec.IntValue richEtheriaChunkChance;
    public static ForgeConfigSpec.IntValue normalEtheriaChunkMin;
    public static ForgeConfigSpec.IntValue normalEtheriaChunkMax;
    public static ForgeConfigSpec.IntValue richEtheriaChunkMin;
    public static ForgeConfigSpec.IntValue richEtheriaChunkMax;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        GENERAL_SPEC = configBuilder.build();
    }

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Player Ego Config");
        badEgoEffectsMin = builder.comment("The value which defines the point in a player's ego where they start receiving bad effects").defineInRange("badEgoEffectsMin", 70, 1, 99);
        builder.pop();

        builder.push("Etheria Chunk Config");
        richEtheriaChunkChance = builder.comment("The chance for a rich etheria chunk to spawn. Value is a percent. E.g. 1 is 1% chance to spawn").defineInRange("richEtheriaChunkChance", 1, 1, 100);
        normalEtheriaChunkMin = builder.comment("The value which defines the minimum value that the etheria in a chunk can naturally spawn at").defineInRange("normalEtheriaChunkMin", 550, 1, Integer.MAX_VALUE);
        normalEtheriaChunkMax = builder.comment("The value which defines the maximum value that the etheria in a chunk can naturally spawn at. THIS VALUE NEEDS TO BE ONE HIGHER THEN WHAT YOU WANT").defineInRange("normalEtheriaChunkMax", 651, 1, Integer.MAX_VALUE);
        richEtheriaChunkMin = builder.comment("The value which defines the minimum value that etheria in a rich chunk can naturally spawn at").defineInRange("richEtheriaChunkMin", 900, 1, Integer.MAX_VALUE);
        richEtheriaChunkMax = builder.comment("The value which defines the maximum value that etheria in a rich chunk can naturally spawn at. THIS VALUE NEEDS TO BE ONE HIGHER THEN WHAT YOU WANT").defineInRange("richEtheriaChunkMax", 1001, 1, Integer.MAX_VALUE);
        builder.pop();
    }
}
