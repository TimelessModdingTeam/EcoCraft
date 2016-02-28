package net.ecocraft.ecoterra.server.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material {
    //Tool Materials
    public static final Item.ToolMaterial toolMaterialWood = EnumHelper.addToolMaterial("WOOD", 0, 21, 1.5F, 0, 26);
    public static final Item.ToolMaterial toolMaterialStone = EnumHelper.addToolMaterial("STONE", 0, 41, 2.0F, 1, 26);
    public static final Item.ToolMaterial toolMaterialFlint = EnumHelper.addToolMaterial("FLINT", 0, 131, 4.0F, 1.5f, 26);
    public static final Item.ToolMaterial toolMaterialBone = EnumHelper.addToolMaterial("BONE", 0, 131, 4.0F, 1.5f, 26);
    public static final Item.ToolMaterial toolMaterialCopper = EnumHelper.addToolMaterial("COPPER", 1, 250, 6.0F, 2, 26);
    public static final Item.ToolMaterial toolMaterialBronze = EnumHelper.addToolMaterial("BRONZE", 2, 500, 8.0F, 3, 26);
    public static final Item.ToolMaterial toolMaterialIron = EnumHelper.addToolMaterial("IRON", 3, 1000, 10.0F, 3, 26);
    public static final Item.ToolMaterial toolMaterialSteel = EnumHelper.addToolMaterial("STEEL", 4, 2000, 12.0F, 4, 26);

    //Armor Materials
    public static ItemArmor.ArmorMaterial armorMaterialLeather = EnumHelper.addArmorMaterial("LEATHER", "ecoterra:leather", 5, new int[]{1, 2, 1, 1}, 30);

    public static ItemArmor.ArmorMaterial armorMaterialCopperStudded = EnumHelper.addArmorMaterial("COPPERSTUDDED", "ecoterra:copper_studded", 10, new int[]{1, 3, 2, 1}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialCopperChain = EnumHelper.addArmorMaterial("COPPERCHAIN", "ecoterra:copper_chain", 12, new int[]{1, 4, 3, 1}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialCopper = EnumHelper.addArmorMaterial("COPPER", "ecoterra:copper", 14, new int[]{2, 5, 3, 2}, 30);

    public static ItemArmor.ArmorMaterial armorMaterialBronzeStudded = EnumHelper.addArmorMaterial("BRONZESTUDDED", "ecoterra:bronze_studded", 14, new int[]{2, 4, 3, 2}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialBronzeChain = EnumHelper.addArmorMaterial("BRONZECHAIN", "ecoterra:bronze_chain", 18, new int[]{2, 5, 3, 2}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialBronze = EnumHelper.addArmorMaterial("BRONZE", "ecoterra:bronze", 23, new int[]{2, 6, 4, 2}, 30);

    public static ItemArmor.ArmorMaterial armorMaterialIronStudded = EnumHelper.addArmorMaterial("IRONSTUDDED", "ecoterra:iron_studded", 23, new int[]{2, 5, 3, 2}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialIronChain = EnumHelper.addArmorMaterial("IRON", "ecoterra:iron_chain", 27, new int[]{3, 6, 4, 3}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialIron = EnumHelper.addArmorMaterial("IRON", "ecoterra:iron", 31, new int[]{3, 7, 5, 3}, 30);

    public static ItemArmor.ArmorMaterial armorMaterialSteelStudded = EnumHelper.addArmorMaterial("STEELSTUDDED", "ecoterra:steel_studded", 31, new int[]{3, 6, 4, 3}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialSteelChain = EnumHelper.addArmorMaterial("STEELCHAIN", "ecoterra:steel_chain", 35, new int[]{3, 7, 5, 3}, 30);
    public static ItemArmor.ArmorMaterial armorMaterialSteel = EnumHelper.addArmorMaterial("STEEL", "ecoterra:steel", 40, new int[]{3, 8, 6, 3}, 30);

}
