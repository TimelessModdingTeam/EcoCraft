package net.ecocraft.ecocore.proxy;

import net.ecocraft.ecocore.registry.ChunkRegistry;
import net.minecraftforge.common.MinecraftForge;

public class ServerProxy implements IProxy {
	@Override
	public void onPreInit() {

	}

	@Override
	public void onInit() {
		MinecraftForge.EVENT_BUS.register(ChunkRegistry.ChunkListener.instance);
	}

	@Override
	public void onPostInit() {

	}
}
