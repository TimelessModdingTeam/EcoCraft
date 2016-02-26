package net.ecocraft.ecocore;

import net.ecocraft.ecocore.server.ServerProxy;
import net.ecocraft.ecocore.server.registry.helper.ContentObject;
import net.ecocraft.ecocore.server.registry.recipe.StatRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.RecipeSorter;

@Mod(modid = EcoCore.MODID, name = "EcoCore", version = EcoCore.VERSION, dependencies = "required-after:llibrary@[" + EcoCore.LLIBRARY_VERSION + ",)")
public class EcoCore {
    public static final String MODID = "ecocore";
    public static final String VERSION = "0.1.0";
    public static final String LLIBRARY_VERSION = "0.8.0";

    @Mod.Instance(MODID)
    public static EcoCore instance;
    @SidedProxy(serverSide = "net.ecocraft.ecocore.server.ServerProxy", clientSide = "net.ecocraft.ecocore.client.ClientProxy")
    public static ServerProxy proxy;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        RecipeSorter.register("StatRecipes", StatRecipes.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");

        proxy.onPreInit();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        proxy.onInit();

        ContentObject.registerObjRecipes();
        ContentObject.registerOreDicts();
        ContentObject.registerIRegisters();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        proxy.onPostInit();
    }
}
