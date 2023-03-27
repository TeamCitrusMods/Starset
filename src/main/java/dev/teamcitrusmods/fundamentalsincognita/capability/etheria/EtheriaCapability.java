package dev.teamcitrusmods.fundamentalsincognita.capability.etheria;

import dev.teamcitrusmods.fundamentalsincognita.registry.FIModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EtheriaCapability implements IEtheriaCapability {
    private int etheria = 600;

    @Override
    public void setEtheria(int amount) {
        this.etheria = amount;
    }

    @Override
    public int getEtheriaInChunk() {
        return this.etheria;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("etheria", getEtheriaInChunk());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.etheria = nbt.getInt("etheria");
    }

    public static class EtheriaProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
        private final IEtheriaCapability cap = new EtheriaCapability();
        private final LazyOptional<IEtheriaCapability> lazyEgo = LazyOptional.of(() -> cap);

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return FIModCapabilities.ETHERIA.orEmpty(cap, this.lazyEgo);
        }

        @Override
        public CompoundTag serializeNBT() {
            return this.cap.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.cap.deserializeNBT(nbt);
        }
    }
}
