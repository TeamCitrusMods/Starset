package dev.teamcitrusmods.starset.capability.ego;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IEgoCapability extends INBTSerializable<CompoundTag> {

    void addEgo(int amount);

    void drainEgo(int amount);

    int getEgoAmount();

    void setEgo(int amount);

    void setStained(boolean set);

    boolean isStained();

}
