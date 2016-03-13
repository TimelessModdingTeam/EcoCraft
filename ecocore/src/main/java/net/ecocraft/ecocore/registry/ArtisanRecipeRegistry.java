package net.ecocraft.ecocore.registry;

import net.ecocraft.ecocore.api.IArtisanRecipe;
import net.ecocraft.ecocore.registry.recipe.ShapelessArtisanRecipes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class ArtisanRecipeRegistry {
    protected List<IArtisanRecipe> artisanRecipes = new ArrayList<IArtisanRecipe>();

    public void registerShapelessRecipe(ItemStack output, List<ItemStack> recipeList, List<ItemStack> addList, boolean includeCraftingTable) {
        if (includeCraftingTable) {
            artisanRecipes.add(new ShapelessArtisanRecipes(output, recipeList, addList));
        }

        GameRegistry.addShapelessRecipe(output, recipeList);
    }

    public void registerShapelessRecipe(ItemStack output, List<ItemStack> recipeList, List<ItemStack> addList) {
        this.registerShapelessRecipe(output, recipeList, addList, false);
    }

    public void registerShapedRecipe(ItemStack output) {

    }
}
