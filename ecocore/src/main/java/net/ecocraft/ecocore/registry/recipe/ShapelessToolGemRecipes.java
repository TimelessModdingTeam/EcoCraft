package net.ecocraft.ecocore.registry.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.ArrayList;
import java.util.List;

public class ShapelessToolGemRecipes extends ShapelessRecipes {
    public List<ItemStack> toolList = null;

    public ShapelessToolGemRecipes(ItemStack output, List<ItemStack> inputList) {
        super(output, inputList);

        this.toolList = new ArrayList(toolList);
    }

    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        ItemStack ret = super.getCraftingResult(inventoryCrafting);

        return ret;
    }

    public ItemStack[] getRemainingItems(InventoryCrafting p_179532_1_) {
        ItemStack[] aitemstack = super.getRemainingItems(p_179532_1_);

        return aitemstack;
    }
}
