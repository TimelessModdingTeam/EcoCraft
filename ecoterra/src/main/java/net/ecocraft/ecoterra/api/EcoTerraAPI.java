package net.ecocraft.ecoterra.api;

import net.ecocraft.ecoterra.registry.DualSmeltingRecipeRegistry;
import net.ecocraft.ecoterra.registry.GroundItemRegistry;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class EcoTerraAPI {

    private static DualSmeltingRecipeRegistry dualSmeltingRecipeRegistry = new DualSmeltingRecipeRegistry();
    private static GroundItemRegistry groundItemRegistry = new GroundItemRegistry();

    //DualSmeltingRecipeRegistry
    public static void addDualSmeltingRecipe(ItemStack result, ItemStack[] input) {
        EcoTerraAPI.dualSmeltingRecipeRegistry.addDualSmeltingRecipe(result, input);
    }

    public static ItemStack getDualSmeltingResult(ItemStack[] input) {
        return EcoTerraAPI.dualSmeltingRecipeRegistry.getDualSmeltingResult(input);
    }

    //GroundItemRegistry
    public static void addGroundItem(ItemStack result, double dropWeight) {
        EcoTerraAPI.groundItemRegistry.registerGroundItem(result, dropWeight);
    }

    public static ItemStack getGroundItem(Random random) {
        return EcoTerraAPI.groundItemRegistry.getGroundStack(random);
    }
}
