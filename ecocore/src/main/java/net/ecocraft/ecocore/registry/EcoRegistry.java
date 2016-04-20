package net.ecocraft.ecocore.registry;

import java.util.Random;

import net.ecocraft.ecocore.registry.helper.ChunkUserEntry;
import net.ecocraft.ecocore.registry.helper.ContentObject;
import net.ecocraft.ecocore.registry.helper.EntityEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

public class EcoRegistry {
	public static final Random random = new Random();
	public static EcoRegistryInstance instance = new EcoRegistryInstance();

	// ObjectRegistry
	public static void registerObject(Object modClass, ContentObject objectRegister) {
		instance.addObjReg(modClass.getClass().getAnnotation(Mod.class), objectRegister, true);
	}

	public static void registerEntity(Object modClass, EntityEntry<?> entityEntry) {
		instance.addEntity(modClass, entityEntry);
	}

	/**
	 * Registers the data object and returns a key to be used for access in the future
	 */
	public static String registerChunkData(Object modClass, ChunkUserEntry chunkData) {
		Mod mod = modClass.getClass().getAnnotation(Mod.class);
		return instance.addChunkUser(mod, chunkData);
	}

	public static void removeItemStack(ItemStack item) {
		instance.removeItemStack(item);
	}

	public static void registerObjRecipes() {
		instance.registerObjRecipes();
	}

	public static void registerOreDicts() {
		instance.registerOreDicts();
	}

	public static void registerIRegisters() {
		instance.registerIRegisters();
	}

	public static void registerEntities() {
		instance.registerEntities();
	}

	public static void registerChunkDataUsers() {
		instance.registerChunkUsers();
	}

}
