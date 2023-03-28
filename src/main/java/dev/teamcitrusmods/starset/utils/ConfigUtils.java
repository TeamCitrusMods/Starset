package dev.teamcitrusmods.starset.utils;

import dev.teamcitrusmods.starset.config.StarsetModConfig;

public class ConfigUtils {
    public static void checkConfig() {
        if(StarsetModConfig.normalEtheriaChunkMax.get() < StarsetModConfig.normalEtheriaChunkMin.get()) {
            throwRuntime("The value of 'normalEtheriaChunkMax' cannot be smaller than 'normalEtheriaChunkMin'");
        }
        if(StarsetModConfig.richEtheriaChunkMax.get() < StarsetModConfig.richEtheriaChunkMin.get()) {
            throwRuntime("The value of 'richEtheriaChunkMax' cannot be smaller than 'richEtheriaChunkMin'");
        }
        if(StarsetModConfig.richEtheriaChunkMax.get() < StarsetModConfig.normalEtheriaChunkMax.get()) {
            throwRuntime("The value of 'richEtheriaChunkMax' cannot be smaller than 'normalEtheriaChunkMax'");
        }
        if(StarsetModConfig.richEtheriaChunkMin.get() < StarsetModConfig.normalEtheriaChunkMin.get()) {
            throwRuntime("The value of 'richEtheriaChunkMin' cannot be smaller than 'normalEtheriaChunkMin'");
        }
    }

    private static void throwRuntime(String message) {
        throw new RuntimeException(message);
    }
}
