package dev.teamcitrusmods.starset.capability.etheria;

import dev.teamcitrusmods.starset.registry.StarsetModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EtheriaCapability implements IEtheriaCapability {
    private int etheria = -1;
    private final Random random = new Random();

    @Override
    public void setEtheria(int amount) {
        this.etheria = amount;
    }

    @Override
    public int getEtheriaInChunk() {
        if(this.etheria == -1) {
            this.etheria = random.nextInt(550, 650);
        }
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
            return StarsetModCapabilities.ETHERIA.orEmpty(cap, this.lazyEgo);
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
