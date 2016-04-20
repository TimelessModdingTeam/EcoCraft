package net.ecocraft.ecocore;

import net.ecocraft.ecocore.claims.ClaimInformation;
import net.ecocraft.ecocore.command.ClaimLandCommand;
import net.ecocraft.ecocore.proxy.ServerProxy;
import net.ecocraft.ecocore.registry.ChunkRegistry;
import net.ecocraft.ecocore.registry.EcoRegistry;
import net.ecocraft.ecocore.registry.helper.ChunkUserEntry;
import net.ecocraft.ecocore.registry.recipe.StatRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.oredict.RecipeSorter;

@Mod(modid = EcoCore.MODID, name = "EcoCore", version = EcoCore.VERSION)
public class EcoCore {
	public static final String MODID = "ecocore";
	public static final String VERSION = "0.1.0";

	@Mod.Instance(MODID)
	public static EcoCore instance;
	@SidedProxy(
			serverSide = "net.ecocraft.ecocore.proxy.ServerProxy",
			clientSide = "net.ecocraft.ecocore.proxy.ClientProxy")
	public static ServerProxy proxy;

	@Mod.EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		RecipeSorter.register(
				"StatRecipes",
				StatRecipes.class,
				RecipeSorter.Category.SHAPELESS,
				"after:minecraft:shapeless");
		proxy.onPreInit();
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		initializeClaimSystem();

		EcoRegistry.registerOreDicts();
		EcoRegistry.registerEntities();
		EcoRegistry.registerIRegisters();
		EcoRegistry.registerObjRecipes();
		EcoRegistry.registerChunkDataUsers();
		proxy.onInit();
	}

	private void initializeClaimSystem() {
		MinecraftForge.EVENT_BUS.register(ChunkRegistry.ChunkListener.instance);
		ClaimInformation.CLAIM_KEY = EcoRegistry
				.registerChunkData(this, new ChunkUserEntry("claim", (k) -> new ClaimInformation()));
	}

	@Mod.EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {
		proxy.onPostInit();
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new ClaimLandCommand());
	}
}
