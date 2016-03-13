package net.ecocraft.ecocore.registry.helper;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHelper {
    public static ItemStack Clone(ItemStack stack, int amount) {
        ItemStack ostack = stack.copy();
        ostack.stackSize = amount;
        return ostack;
    }

    //Item Amalgamation registers
    public static void registerOreGemBlock(String gemType) {
        ItemStack ore = ContentObject.getStack(gemType + "_ore");
        ItemStack gemName = ContentObject.getStack(gemType + "_gem");
        ItemStack blockName = ContentObject.getStack(gemType + "_block");

        RecipeHelper.registerOreGemBlock(ore, gemName, blockName);
    }

    protected static void registerOreGemBlock(ItemStack ore, ItemStack ingotName, ItemStack blockName) {
        RecipeHelper.registerOreNuggetIngotBlock(ore, null, ingotName, blockName);
    }

    protected static void registerOreNuggetIngotBlock(ItemStack ore, ItemStack nuggetStack, ItemStack ingotStack, ItemStack blockStack) {
        if (nuggetStack != null && ingotStack != null) {
            GameRegistry.addShapelessRecipe(RecipeHelper.Clone(nuggetStack, 9), ingotStack);
            GameRegistry.addShapedRecipe(ingotStack, "nnn", "nnn", "nnn", 'n', nuggetStack);
        }

        if (ore != null && ingotStack != null) {
            GameRegistry.addSmelting(ore, ingotStack, 1f);
        }

        if (ingotStack != null && blockStack != null) {
            GameRegistry.addShapelessRecipe(RecipeHelper.Clone(ingotStack, 9), blockStack);
            GameRegistry.addShapedRecipe(blockStack, "nnn", "nnn", "nnn", 'n', ingotStack);
        }
    }

    public static void registerMetal(String metalType) {
        RecipeHelper.registerMetal(metalType, true);
    }

    public static void registerMetal(String metalType, boolean hasOre) {
        ItemStack ore = null;
        if (hasOre) {
            ore = ContentObject.getStack(metalType + "_ore");
        }
        ItemStack nugget = ContentObject.getStack(metalType + "_nugget");
        ItemStack ingot = ContentObject.getStack(metalType + "_ingot");
        ItemStack block = ContentObject.getStack(metalType + "_block");
        ItemStack chain = ContentObject.getStack(metalType + "_chain");
        ItemStack studded = ContentObject.getStack(metalType + "_studded");

        ItemStack plateboots = ContentObject.getStack(metalType + "_boots");
        ItemStack platehelmet = ContentObject.getStack(metalType + "_helmet");
        ItemStack platechestplate = ContentObject.getStack(metalType + "_chestplate");
        ItemStack plateleggings = ContentObject.getStack(metalType + "_leggings");

        ItemStack studdedboots = ContentObject.getStack(metalType + "_studded_boots");
        ItemStack studdedhelmet = ContentObject.getStack(metalType + "_studded_helmet");
        ItemStack studdedchestplate = ContentObject.getStack(metalType + "_studded_chestplate");
        ItemStack studdedleggings = ContentObject.getStack(metalType + "_studded_leggings");

        ItemStack chainboots = ContentObject.getStack(metalType + "_chain_boots");
        ItemStack chainhelmet = ContentObject.getStack(metalType + "_chain_helmet");
        ItemStack chainchestplate = ContentObject.getStack(metalType + "_chain_chestplate");
        ItemStack chainleggings = ContentObject.getStack(metalType + "_chain_leggings");

        ItemStack axe = ContentObject.getStack(metalType + "_axe");
        ItemStack hoe = ContentObject.getStack(metalType + "_hoe");
        ItemStack pickaxe = ContentObject.getStack(metalType + "_pickaxe");
        ItemStack shovel = ContentObject.getStack(metalType + "_shovel");

        ItemStack anvil = ContentObject.getStack(metalType + "_anvil");

        RecipeHelper.registerOreNuggetIngotBlock(ore, nugget, ingot, block);
        RecipeHelper.registerChain(chain, nugget);
        RecipeHelper.registerStuddedLeather(studded, nugget, new ItemStack(Items.leather));

        RecipeHelper.registerArmorSet(ingot, plateboots, platehelmet, platechestplate, plateleggings);
        RecipeHelper.registerArmorSet(chain, chainboots, chainhelmet, chainchestplate, chainleggings);
        RecipeHelper.registerArmorSet(studded, studdedboots, studdedhelmet, studdedchestplate, studdedleggings);
        RecipeHelper.registerToolSet(ingot, axe, hoe, pickaxe, shovel);

        RecipeHelper.registerAnvil(ingot, anvil);
    }

    //Item Recipes
    public static void registerAnvil(ItemStack ingot, ItemStack anvil) {
        GameRegistry.addShapedRecipe(anvil, "nnn", " n ", "nnn", 'n', ingot);
    }

    public static void registerChain(ItemStack chain, ItemStack nugget) {
        GameRegistry.addShapedRecipe(chain, "nn ", "n n", " nn", 'n', nugget);
        GameRegistry.addShapedRecipe(chain, " nn", "n n", "nn ", 'n', nugget);
    }

    public static void registerStuddedLeather(ItemStack studded, ItemStack nugget, ItemStack leather) {
        GameRegistry.addShapedRecipe(studded, "ln ", "nn ", "   ", 'n', nugget, 'l', leather);
        GameRegistry.addShapedRecipe(studded, "nl ", "nn ", "   ", 'n', nugget, 'l', leather);
        GameRegistry.addShapedRecipe(studded, "nn ", "ln ", "   ", 'n', nugget, 'l', leather);
        GameRegistry.addShapedRecipe(studded, "nn ", "nl ", "   ", 'n', nugget, 'l', leather);
    }

    public static void registerArmorSet(ItemStack ingot, ItemStack boots, ItemStack helmet, ItemStack chestplate, ItemStack leggings) {
        GameRegistry.addShapedRecipe(boots, "   ", "x x", "x x", 'x', ingot);
        GameRegistry.addShapedRecipe(helmet, "xxx", "x x", "   ", 'x', ingot);
        GameRegistry.addShapedRecipe(chestplate, "x x", "xxx", "xxx", 'x', ingot);
        GameRegistry.addShapedRecipe(leggings, "xxx", "x x", "x x", 'x', ingot);
    }

    public static void registerToolSet(ItemStack ingot, ItemStack axe, ItemStack hoe, ItemStack pickaxe, ItemStack shovel) {
        GameRegistry.addShapedRecipe(axe, "xx ", "xs ", " s ", 'x', ingot, 's', Items.stick);
        GameRegistry.addShapedRecipe(axe, " xx", " sx", " s ", 'x', ingot, 's', Items.stick);
        GameRegistry.addShapedRecipe(hoe, "xx ", " s ", " s ", 'x', ingot, 's', Items.stick);
        GameRegistry.addShapedRecipe(hoe, " xx", " s ", " s ", 'x', ingot, 's', Items.stick);
        GameRegistry.addShapedRecipe(pickaxe, "xxx", " s ", " s ", 'x', ingot, 's', Items.stick);
        GameRegistry.addShapedRecipe(shovel, " x ", " s ", " s ", 'x', ingot, 's', Items.stick);
    }
}
