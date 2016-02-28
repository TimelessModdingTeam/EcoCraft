package net.ecocraft.ecoterra.server.registry;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroundItemRegistry {

    protected List<GroundItemRegister> _groundItemRegisters = new ArrayList<GroundItemRegister>();
    protected boolean hasUpdatedNewStacks = false;

    public void registerGroundItem(ItemStack stack, double dropWeight) {
        this._groundItemRegisters.add(new GroundItemRegister(stack, dropWeight));
    }

    protected void updateProbabilities() {
        double sum = 0.0;

        for (GroundItemRegister r : this._groundItemRegisters) {
            sum += r.dropWeight;
        }

        double temp = 0.0;
        for (int i = 0; i < this._groundItemRegisters.size(); i++) {
            temp += this._groundItemRegisters.get(i).dropWeight / sum;
            this._groundItemRegisters.get(i).dropProb = temp;
        }
    }

    public ItemStack getGroundStack(Random rnd) {
        if (!this.hasUpdatedNewStacks) {
            this.updateProbabilities();
            this.hasUpdatedNewStacks = true;
        }

        double prob = rnd.nextDouble();

        for (int i = 0; i < this._groundItemRegisters.size(); i++) {
            if (prob < this._groundItemRegisters.get(i).dropProb) {
                return this._groundItemRegisters.get(i).dropStack.copy();
            }
        }

        if (this._groundItemRegisters.size() == 0) {
            return null;
        } else {
            return this._groundItemRegisters.get(0).dropStack;
        }
    }

    protected class GroundItemRegister {
        public double dropWeight;
        public double dropProb;
        public ItemStack dropStack;

        public GroundItemRegister(ItemStack stack, double dropWeight) {
            this.dropStack = stack;
            this.dropWeight = dropWeight;
        }
    }
}
