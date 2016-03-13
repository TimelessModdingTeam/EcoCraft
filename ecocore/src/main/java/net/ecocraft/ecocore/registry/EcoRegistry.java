package net.ecocraft.ecocore.registry;

import net.ecocraft.ecocore.registry.helper.ContentObject;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

public class EcoRegistry {
    public static final Random random = new Random();

    //ObjectRegistry
    public static void registerObject(Object modClass, ContentObject objectRegister) {
        ContentObject.addObjReg(modClass.getClass().getAnnotation(Mod.class), objectRegister, true);
    }

    public static void removeItemStack(ItemStack item) {
        ContentObject.removeItemStack(item);
    }
}
