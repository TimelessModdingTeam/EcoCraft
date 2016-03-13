package net.ecocraft.ecocore.registry.recipe;

import net.ecocraft.ecocore.api.IArtisanRecipe;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class ShapedArtisanRecipes extends ShapedRecipes implements IArtisanRecipe {

    public ShapedArtisanRecipes(int width, int height, ItemStack[] p_i1917_3_, ItemStack output) {
        super(width, height, p_i1917_3_, output);
    }

    public ItemStack getCraftingResult(InventoryCrafting p_77572_1_, List<ItemStack> tools) {
        ItemStack itemstack = this.getRecipeOutput().copy();

        //if (this.field_92101_f)
        {
            for (int i = 0; i < p_77572_1_.getSizeInventory(); ++i) {
                ItemStack itemstack1 = p_77572_1_.getStackInSlot(i);

                if (itemstack1 != null && itemstack1.hasTagCompound()) {
                    itemstack.setTagCompound((NBTTagCompound) itemstack1.getTagCompound().copy());
                }
            }
        }

        return itemstack;
    }

    public ItemStack[] getRemainingItems(InventoryCrafting p_179532_1_) {
        ItemStack[] aitemstack = super.getRemainingItems(p_179532_1_);

        return aitemstack;
    }
}
