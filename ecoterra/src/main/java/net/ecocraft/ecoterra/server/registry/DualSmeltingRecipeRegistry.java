package net.ecocraft.ecoterra.server.registry;

import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DualSmeltingRecipeRegistry {
    public HashMap smeltingList = new HashMap<ItemStack, ItemStack[]>();

    public static boolean compareTwoItemStacks(ItemStack[] stack1, ItemStack[] stack2) {
        return (DualSmeltingRecipeRegistry.compareTwoItemStacks(stack1[0], stack2[0]) && DualSmeltingRecipeRegistry.compareTwoItemStacks(stack1[1], stack2[1])) ||
                (DualSmeltingRecipeRegistry.compareTwoItemStacks(stack1[1], stack2[0]) && DualSmeltingRecipeRegistry.compareTwoItemStacks(stack1[0], stack2[1]));

    }

    public static boolean compareTwoItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack1 != null && stack2 != null && stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public void addDualSmeltingRecipe(ItemStack result, ItemStack[] input) {
        if (getDualSmeltingResult(input) != null) {
            return;
        }

        this.smeltingList.put(result, input);
    }

    public ItemStack getDualSmeltingResult(ItemStack[] stack) {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Map.Entry entry;

        while (iterator.hasNext()) {
            entry = (Map.Entry) iterator.next();

            if (DualSmeltingRecipeRegistry.compareTwoItemStacks(stack, (ItemStack[]) entry.getValue())) {
                return ((ItemStack) entry.getKey()).copy();
            }

        }
        return null;
    }
}
