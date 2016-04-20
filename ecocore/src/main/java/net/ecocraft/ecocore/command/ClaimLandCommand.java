package net.ecocraft.ecocore.command;

import net.ecocraft.ecocore.claims.ClaimInformation;
import net.ecocraft.ecocore.registry.ChunkRegistry;
import net.ecocraft.ecocore.registry.ChunkRegistry.ChunkInformation;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.chunk.Chunk;

public class ClaimLandCommand extends CommandBase {
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
			Chunk chunk = senderEntity.worldObj.getChunkFromBlockCoords(senderEntity.getPosition());
			ChunkInformation chunkInformation = ChunkRegistry.getChunkInformation(chunk);
			if (chunkInformation == null) {
				String diagnostic = "Chunk " + chunk.getChunkCoordIntPair() + " is not loaded in eco core";
				sender.addChatMessage(new ChatComponentText(diagnostic));
				return;
			}
			ClaimInformation claimInformation = ClaimInformation.get(chunkInformation);
			if (claimInformation == null) {
				sender.addChatMessage(new ChatComponentText("Claim is not possible for this chunk"));
			}
			if (claimInformation.isOwner(senderEntity)) {
				sender.addChatMessage(new ChatComponentText("You already own this chunk"));
			} else if (claimInformation.hasOwner()) {
				String errorMessage = "This chunk is already registered to " + claimInformation.getOwnerName();
				sender.addChatMessage(new ChatComponentText(errorMessage));
			} else {
				claimInformation.setOwner(senderEntity);
				String message = "Set owner to " + sender.getName();
				sender.addChatMessage(new ChatComponentText(message));
			}
		}
	}

}
