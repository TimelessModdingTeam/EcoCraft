package net.ecocraft.ecocore.registry.helper;

import net.ecocraft.ecocore.registry.ChunkRegistry;
import net.ecocraft.ecocore.registry.EcoRegistry;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fml.common.Mod;

public class ChunkUserEntry {
	public static interface IChunkData extends INBTSerializable<NBTTagCompound> {
		public void populateDefaultInformation(Chunk chunk);

		/**
		 * Creates substitute information for invalid nbt information in the chunk.
		 * 
		 * @param faultyNBT
		 *            The nbt object that caused the failed construction
		 */
		public void populateSubstituteInformation(Chunk chunk, NBTBase faultyNBT);

		/**
		 * Tries to deserialize the nbt object. <br>
		 * If his is not possible, {@linkplain IllegalArgumentException} is thrown and a substitute will then be
		 * constructed using {@link IChunkData#populateSubstituteInformation(Chunk, NBTBase)}.
		 */
		@Override
		void deserializeNBT(NBTTagCompound nbt) throws IllegalArgumentException;
	}

	/**
	 * A factory should construct an empty data object that can be used in case the nbt information is missing or load
	 * the nbt object if it exists.
	 */
	public static interface IChunkUser {
		public IChunkData getDataObject(Chunk chunk);
	};

	private String name;
	private IChunkUser factory;

	/**
	 * Creates an entry that can later be registered by the {@linkplain EcoRegistry}
	 * 
	 * @throws IllegalArgumentException
	 *             If the name is invalid. It mustn't contain a ':'
	 */
	public ChunkUserEntry(String name, IChunkUser factory) throws IllegalArgumentException {
		this.name = name;
		this.factory = factory;
		if (name.contains(":")) {
			throw new IllegalArgumentException("The name may not contain a ':', this character is used as a separator");
		}
	}

	public static String getUniqueKey(Mod mod, String name) {
		return mod.modid() + ":" + name;
	}

	public String getUniqueKey(Mod mod) {
		return getUniqueKey(mod, name);
	}

	public void register(Mod mod) {
		ChunkRegistry.registerChunkData(getUniqueKey(mod), factory);
	}

}
