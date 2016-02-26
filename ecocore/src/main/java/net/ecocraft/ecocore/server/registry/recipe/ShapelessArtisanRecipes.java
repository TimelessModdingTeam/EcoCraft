package net.ecocraft.ecocore.server.registry.recipe;

import net.ecocraft.ecocore.server.api.IArtisanRecipe;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.ArrayList;
import java.util.List;

public class ShapelessArtisanRecipes extends ShapelessRecipes implements IArtisanRecipe {

    public List<ItemStack> toolList = null;

    public ShapelessArtisanRecipes(ItemStack output, List toolList, List<ItemStack> inputList) {
        super(output, inputList);

        this.toolList = new ArrayList(toolList);
    }

    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting, List<ItemStack> toolListObs) {
        ItemStack ret = super.getCraftingResult(inventoryCrafting);

        if (toolListObs.size() >= 2) {
            ItemStack tool = toolListObs.get(0);
            ItemStack additive = toolListObs.get(1);

            if (ItemStack.areItemStacksEqual(tool, this.toolList.get(0)) &&
                    ItemStack.areItemStacksEqual(additive, this.toolList.get(1))) {
                return ret;
            }
        }

        return null;
    }

    public ItemStack[] getRemainingItems(InventoryCrafting p_179532_1_) {
        ItemStack[] aitemstack = super.getRemainingItems(p_179532_1_);

        return aitemstack;
    }
}
