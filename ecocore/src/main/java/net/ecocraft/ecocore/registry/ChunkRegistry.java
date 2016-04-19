package net.ecocraft.ecocore.registry;

import java.util.HashMap;
import java.util.Map;

import net.ecocraft.ecocore.EcoCore;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkRegistry {
	private static Map<ChunkCoordIntPair, NBTTagCompound> chunkData = new HashMap<>();
	private static final String NBTKEY = EcoCore.MODID;
	private static final String VERSION = "version";
	private static final int FORMAT_VERSION = 0;

	public static class ChunkListener {
		public static ChunkListener instance = new ChunkListener();

		private ChunkListener() {}

		@SubscribeEvent
		public void chunkLoaded(ChunkDataEvent.Load loadEvent) {
			NBTTagCompound fullTag = loadEvent.getData();
			NBTTagCompound toSave = (NBTTagCompound) fullTag.getCompoundTag(NBTKEY).copy();
			ChunkCoordIntPair position = loadEvent.getChunk().getChunkCoordIntPair();
			ChunkRegistry.chunkLoaded(position, toSave);
		}

		@SubscribeEvent
		public void chunkSaved(ChunkDataEvent.Save saveEvent) {
			ChunkCoordIntPair position = saveEvent.getChunk().getChunkCoordIntPair();
			NBTTagCompound saveData = ChunkRegistry.chunkSaved(position);
			if (saveData == null)
				return;
			saveEvent.getData().setTag(NBTKEY, saveData);
		}

		@SubscribeEvent
		public void chunkUnloaded(ChunkEvent.Unload unloadEvent) {
			ChunkRegistry.chunkUnloaded(unloadEvent.getChunk().getChunkCoordIntPair());
		}
	}

	static void chunkLoaded(ChunkCoordIntPair coords, NBTTagCompound nbtTag) {
		NBTTagCompound previous = chunkData.put(coords, nbtTag);
		// FIXME this should probably be logged
		if (previous != null) {}
		if (!nbtTag.hasKey(VERSION)) {
			nbtTag.setInteger(VERSION, FORMAT_VERSION);
		}
	}

	public static void chunkUnloaded(ChunkCoordIntPair chunkCoordIntPair) {
		chunkData.remove(chunkCoordIntPair);
	}

	static NBTTagCompound chunkSaved(ChunkCoordIntPair coords) {
		return chunkData.get(coords);
	}

	public static NBTTagCompound getNBTTag(ChunkCoordIntPair coords) {
		return chunkData.get(coords);
	}

	public static void setNBTTag(ChunkCoordIntPair coords, NBTTagCompound tag) {
		chunkData.replace(coords, tag);
	}

}
