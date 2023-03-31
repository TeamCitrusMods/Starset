package dev.teamcitrusmods.starset.world.etheria;

import dev.teamcitrusmods.starset.Starset;

public class Etheria {
    private int etheria;
    private boolean rich;
    private int cap;

    public Etheria(int etheria, boolean rich, int cap) {
        this.etheria = etheria;
        this.rich = rich;
        this.cap = cap;
    }

    public int getEtheria() {
        return this.etheria;
    }

    public void setEtheria(int etheria) {
        this.etheria = etheria;
    }

    public void drainEtheria(int amount) {
        if((this.etheria - amount) >= 0) {
            this.etheria -= amount;
        } else {
            Starset.LOGGER.info("Etheria amount of `" + amount + "` could not be drained as it would make Etheria negative");
        }
    }

    public boolean isRich() {
        return this.rich;
    }

    public void setRich(boolean rich) {
        this.rich = rich;
    }

    public int getCap() {
        return this.cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }
}
