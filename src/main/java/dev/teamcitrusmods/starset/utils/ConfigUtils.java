package dev.teamcitrusmods.starset.utils;

import dev.teamcitrusmods.starset.config.FIModConfig;

public class ConfigUtils {
    public static void checkConfig() {
        if(FIModConfig.normalEtheriaChunkMax.get() < FIModConfig.normalEtheriaChunkMin.get()) {
            throwRuntime("The value of 'normalEtheriaChunkMax' cannot be smaller than 'normalEtheriaChunkMin'");
        }
        if(FIModConfig.richEtheriaChunkMax.get() < FIModConfig.richEtheriaChunkMin.get()) {
            throwRuntime("The value of 'richEtheriaChunkMax' cannot be smaller than 'richEtheriaChunkMin'");
        }
        if(FIModConfig.richEtheriaChunkMax.get() < FIModConfig.normalEtheriaChunkMax.get()) {
            throwRuntime("The value of 'richEtheriaChunkMax' cannot be smaller than 'normalEtheriaChunkMax'");
        }
        if(FIModConfig.richEtheriaChunkMin.get() < FIModConfig.normalEtheriaChunkMin.get()) {
            throwRuntime("The value of 'richEtheriaChunkMin' cannot be smaller than 'normalEtheriaChunkMin'");
        }
    }

    private static void throwRuntime(String message) {
        throw new RuntimeException(message);
    }
}
