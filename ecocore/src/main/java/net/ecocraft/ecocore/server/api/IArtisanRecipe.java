package net.ecocraft.ecocore.server.api;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public interface IArtisanRecipe extends IRecipe {
    ItemStack getCraftingResult(InventoryCrafting inventoryCrafting, List<ItemStack> toolListObs);

    ItemStack[] getRemainingItems(InventoryCrafting p_179532_1_);
}
