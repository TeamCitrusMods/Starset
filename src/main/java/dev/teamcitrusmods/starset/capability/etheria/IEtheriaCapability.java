package dev.teamcitrusmods.starset.capability.etheria;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IEtheriaCapability extends INBTSerializable<CompoundTag> {

    void setEtheria(int amount);

    int getEtheriaInChunk();

}
