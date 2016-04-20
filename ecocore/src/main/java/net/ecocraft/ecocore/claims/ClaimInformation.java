package net.ecocraft.ecocore.claims;

import net.ecocraft.ecocore.registry.ChunkRegistry.ChunkInformation;
import net.ecocraft.ecocore.registry.helper.ChunkUserEntry.IChunkData;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;

public class ClaimInformation implements IChunkData {

	public static String CLAIM_KEY;

	public static ClaimInformation get(ChunkInformation information) {
		try {
			return information.getData(ClaimInformation.class, CLAIM_KEY);
		} catch (ClassCastException ex) {
			return null;
		}
	}

	private static final String KEY_OWNER = "owner";
	// FIXME don't use a the name string to identify the owner, that's just bad
	private String ownerId;

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		if (ownerId != null) {
			tag.setString(KEY_OWNER, ownerId);
		}
		return tag;
	}

	@Override
	public void populateDefaultInformation(Chunk chunk) {
		ownerId = null;
	}

	@Override
	public void populateSubstituteInformation(Chunk chunk, NBTBase faultyNBT) {
		// FIXME log the possible deletion of the old owner
		populateDefaultInformation(chunk);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) throws IllegalArgumentException {
		try {
			if (nbt.hasKey(KEY_OWNER)) {
				ownerId = nbt.getString(KEY_OWNER);
			} else {
				ownerId = null;
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException();
		}
	}

	public void setOwner(Entity player) {
		ownerId = player.getName();
	}

	public boolean isOwner(Entity player) {
		return player.getName() == ownerId;
	}

	public boolean hasOwner() {
		return ownerId != null;
	}

	public String getOwnerName() {
		return ownerId;
	}
}
