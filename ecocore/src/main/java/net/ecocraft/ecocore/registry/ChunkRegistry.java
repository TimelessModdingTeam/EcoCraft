package net.ecocraft.ecocore.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.ecocraft.ecocore.EcoCore;
import net.ecocraft.ecocore.registry.helper.ChunkUserEntry;
import net.ecocraft.ecocore.registry.helper.ChunkUserEntry.IChunkData;
import net.ecocraft.ecocore.registry.helper.ChunkUserEntry.IChunkUser;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkRegistry {
	private static Map<ChunkCoordIntPair, ChunkInformation> chunkData = new HashMap<>();
	private static Map<String, IChunkUser> chunkDataUsers = new HashMap<>();

	private static final String NBTKEY = EcoCore.MODID;
	private static final String VERSION = "version";
	private static final int FORMAT_VERSION = 0;

	public static class ChunkListener {
		public static ChunkListener instance = new ChunkListener();

		private ChunkListener() {}

		@SubscribeEvent
		public void chunkLoaded(ChunkDataEvent.Load loadEvent) {
			NBTTagCompound fullTag = loadEvent.getData();
			NBTTagCompound toLoad = (NBTTagCompound) fullTag.getCompoundTag(NBTKEY).copy();
			ChunkRegistry.chunkLoaded(loadEvent.getChunk(), toLoad);
		}

		@SubscribeEvent
		public void chunkSaved(ChunkDataEvent.Save saveEvent) {
			NBTTagCompound saveData = ChunkRegistry.chunkSaved(saveEvent.getChunk());
			if (saveData == null)
				return;
			saveEvent.getData().setTag(NBTKEY, saveData);
		}

		@SubscribeEvent
		public void chunkUnloaded(ChunkEvent.Unload unloadEvent) {
			ChunkRegistry.chunkUnloaded(unloadEvent.getChunk());
		}
	}

	public static class ChunkInformation {
		private final Map<String, IChunkData> dataMap = new HashMap<>();

		private void addData(String key, IChunkData data) {
			dataMap.put(key, data);
		}

		/**
		 * 
		 * @param key
		 *            The return value of {@link EcoRegistry#registerChunkData(Object, ChunkUserEntry)} }
		 * @return
		 */
		public IChunkData getData(String key) {
			return dataMap.get(key);
		}

		/**
		 * Works exactly as {@linkplain ChunkInformation#getData(String)} but enforces the type and performs a cast.
		 * 
		 * @throws ClassCastException
		 *             If the registered object is not an instance of the specified type.
		 */
		@SuppressWarnings("unchecked")
		public <T extends IChunkData> T getData(Class<T> dataClass, String key) throws ClassCastException {
			IChunkData data = getData(key);
			if (!dataClass.isInstance(data)) {
				throw new ClassCastException("Chunk information was not of expected type");
			}
			return ((T) data);
		}
	}

	static void chunkLoaded(Chunk chunk, NBTTagCompound nbtTag) {
		if (chunkData.containsKey(chunk.getChunkCoordIntPair())) {
			// FIXME this should probably be logged or use the other method
		}
		ChunkInformation information = new ChunkInformation();
		populateInformation(information, chunk, nbtTag);
		chunkData.put(chunk.getChunkCoordIntPair(), information);
	}

	private static void populateInformation(ChunkInformation information, Chunk chunk, NBTTagCompound nbtTag) {
		for (Entry<String, IChunkUser> entry : chunkDataUsers.entrySet()) {
			String key = entry.getKey();
			IChunkUser user = entry.getValue();
			IChunkData data;
			if (nbtTag.hasKey(key)) {
				NBTTagCompound chunkData = nbtTag.getCompoundTag(key);
				data = loadChunkUser(chunk, chunkData, user);
			} else {
				data = user.getDataObject(chunk);
				data.populateDefaultInformation(chunk);
			}
			information.addData(key, data);
		}
	}

	private static IChunkData loadChunkUser(Chunk chunk, NBTTagCompound userNBT, IChunkUser user) {
		IChunkData dataObject = user.getDataObject(chunk);
		try {
			dataObject.deserializeNBT(userNBT);
		} catch (IllegalArgumentException ex) {
			dataObject.populateSubstituteInformation(chunk, userNBT);
		}
		return dataObject;
	}

	static void chunkUnloaded(Chunk chunk) {
		ChunkCoordIntPair position = chunk.getChunkCoordIntPair();
		chunkData.remove(position);
	}

	static NBTTagCompound chunkSaved(Chunk chunk) {
		ChunkCoordIntPair position = chunk.getChunkCoordIntPair();
		ChunkInformation information = chunkData.get(position);
		if (information == null) {
			return null;
		}
		NBTTagCompound nbtTag = new NBTTagCompound();
		for (Entry<String, IChunkData> entry : information.dataMap.entrySet()) {
			nbtTag.setTag(entry.getKey(), entry.getValue().serializeNBT());
		}
		nbtTag.setInteger(VERSION, FORMAT_VERSION);
		return nbtTag;
	}

	public static ChunkInformation getChunkInformation(Chunk chunk) {
		return chunkData.get(chunk.getChunkCoordIntPair());
	}

	/**
	 * Sets the chunk information if the chunk is loaded.
	 */
	public static boolean setByNBTTag(Chunk chunk, NBTTagCompound tag) {
		ChunkInformation newInformation = new ChunkInformation();
		populateInformation(newInformation, chunk, tag);
		return chunkData.replace(chunk.getChunkCoordIntPair(), newInformation) != null;
	}

	/**
	 * Gets chunk information as nbt tag
	 */
	public static NBTTagCompound getNBTTag(Chunk chunk) {
		if (!chunkData.containsKey(chunk.getChunkCoordIntPair())) {
			return null;
		}
		return chunkSaved(chunk);
	}

	/**
	 * If you are extending EcoCraft you probably should use
	 * {@link EcoRegistry#registerChunkData(Object, net.ecocraft.ecocore.registry.helper.ChunkUserEntry)}. This way
	 * exceptions are already handled and reported in the log and you don't have to care about it.
	 */
	public static void registerChunkData(String key, IChunkUser user) throws IllegalArgumentException {
		if (chunkDataUsers.containsKey(key)) {
			throw new IllegalArgumentException("A chunk user with name " + key + " is already registered");
		}
		chunkDataUsers.put(key, user);
	}

}
