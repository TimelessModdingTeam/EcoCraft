package net.ecocraft.ecocore.registry.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.Collections;

public class StatRecipes extends ShapelessRecipes {
    protected ItemStack StatStack = null;

    public StatRecipes(ItemStack output, ItemStack statStack) {
        super(output, Collections.singletonList(statStack));

        this.StatStack = statStack;
    }

    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return super.getCraftingResult(inventoryCrafting);
    }

    public ItemStack[] getRemainingItems(InventoryCrafting p_179532_1_) {
        return super.getRemainingItems(p_179532_1_);
    }
}