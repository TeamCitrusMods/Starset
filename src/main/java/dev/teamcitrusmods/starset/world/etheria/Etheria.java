package dev.teamcitrusmods.starset.world.etheria;

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

    public void addEtheria(int amount) {
        if((this.etheria + amount) <= this.cap) {
            this.etheria += amount;
        } else {
            if (this.etheria != this.cap) {
                int leftover = this.cap - this.etheria;
                int left2 = amount - leftover;
                this.etheria = this.etheria + left2;
            }
        }
    }

    public void drainEtheria(int amount) {
        if((this.etheria - amount) >= 0) {
            this.etheria -= amount;
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
