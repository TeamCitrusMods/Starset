package dev.teamcitrusmods.fundamentalsincognita.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FIModConfig {
    public static final ForgeConfigSpec GENERAL_SPEC;

    public static ForgeConfigSpec.IntValue badEgoEffectsMin;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        GENERAL_SPEC = configBuilder.build();
    }

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        badEgoEffectsMin = builder.defineInRange("badEgoEffectsMin", 70, 1, 99);
    }
}
