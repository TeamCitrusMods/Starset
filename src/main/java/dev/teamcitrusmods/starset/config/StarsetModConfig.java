package dev.teamcitrusmods.starset.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class StarsetModConfig {
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
        badEgoEffectsMin = builder.comment("Minimum value for at which the player starts to receive Negative Ego effects.")
                .defineInRange("badEgoEffectsMin", 70, 1, 99);
        builder.pop();

        builder.push("Etheria Chunk Config");
        richEtheriaChunkChance = builder.comment("Chance for a Rich Etheria chunk to generate instead of a normal Etheria chunk. Value is a percentage. E.g. a value of 1 is 1%")
                .defineInRange("richEtheriaChunkChance", 1, 1, 100);
        normalEtheriaChunkMin = builder.comment("Value that defines the minimum Etheria cap of a normal Etheria chunk can generate as.")
                .defineInRange("normalEtheriaChunkMin", 550, 1, Integer.MAX_VALUE);
        normalEtheriaChunkMax = builder.comment("Value that defines the maximum Etheria cap of a normal Etheria chunk can generate as. Cannot be smaller than 'normalEtheriaChunkMin'")
                .defineInRange("normalEtheriaChunkMax", 650, 1, Integer.MAX_VALUE);
        richEtheriaChunkMin = builder.comment("Value that defines the minimum Etheria cap of a Rich Etheria chunk can generate as.")
                .defineInRange("richEtheriaChunkMin", 900, 1, Integer.MAX_VALUE);
        richEtheriaChunkMax = builder.comment("Value that defines the maximum Etheria cap of a Rich Etheria chunk can generate as. Cannot be smaller than 'richEtheriaChunkMin'")
                .defineInRange("richEtheriaChunkMax", 1000, 1, Integer.MAX_VALUE);
        builder.pop();
    }
}
