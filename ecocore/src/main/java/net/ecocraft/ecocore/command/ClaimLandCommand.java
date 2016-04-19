package net.ecocraft.ecocore.command;

import net.ecocraft.ecocore.registry.ChunkRegistry;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.ChunkCoordIntPair;

public class ClaimLandCommand extends CommandBase {

	private static final String OWNER_KEY = "owner";

	@Override
	public String getCommandName() {
		return "ecoclaim";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/ecoclaim\n Claims your current chunk to yourself";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() != null) {
			Entity senderEntity = sender.getCommandSenderEntity();
			ChunkCoordIntPair coords = senderEntity.worldObj.getChunkFromBlockCoords(senderEntity.getPosition())
					.getChunkCoordIntPair();
			// TODO I don't know, a holder object might be nicer to work with
			NBTTagCompound currentTag = ChunkRegistry.getNBTTag(coords);
			if (currentTag == null) {
				String diagnostic = "Chunk " + coords + " is not loaded in eco core";
				sender.addChatMessage(new ChatComponentText(diagnostic));
				return;
			}
			if (currentTag.hasKey(OWNER_KEY)) {
				String currentOwner = currentTag.getString(OWNER_KEY);
				if (currentOwner.equals(sender.getName())) {
					sender.addChatMessage(new ChatComponentText("You already own this chunk"));
				} else {
					String errorMessage = "This chunk is already registered to " + currentOwner;
					sender.addChatMessage(new ChatComponentText(errorMessage));
				}
			} else {
				String message = "Set owner to " + sender.getName();
				currentTag.setString(OWNER_KEY, sender.getName());
				sender.addChatMessage(new ChatComponentText(message));
			}
		}
	}

}
