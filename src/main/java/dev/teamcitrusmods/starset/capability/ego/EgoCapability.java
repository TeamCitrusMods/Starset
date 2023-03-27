package dev.teamcitrusmods.starset.capability.ego;

import dev.teamcitrusmods.starset.registry.StarsetModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EgoCapability implements IEgoCapability {
    private int ego = 0;
    private boolean stained = false;

    @Override
    public void addEgo(int amount) {
        if((this.ego + amount) <= 100) {
            this.ego += amount;
        }
    }

    @Override
    public void drainEgo(int amount) {
        if((this.ego - amount) >= (isStained() ? 10 : 0)) {
            this.ego -= amount;
        }
    }

    @Override
    public int getEgoAmount() {
        return this.ego;
    }

    @Override
    public void setEgo(int amount) {
        this.ego = amount;
    }

    @Override
    public void setStained(boolean stained) {
        this.stained = stained;
    }

    @Override
    public boolean isStained() {
        return this.stained;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("ego", getEgoAmount());
        tag.putBoolean("stained", isStained());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.ego = nbt.getInt("ego");
        this.stained = nbt.getBoolean("stained");
    }

    public static class EgoProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
        private final IEgoCapability cap = new EgoCapability();
        private final LazyOptional<IEgoCapability> lazyEgo = LazyOptional.of(() -> cap);

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return StarsetModCapabilities.EGO.orEmpty(cap, this.lazyEgo);
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
