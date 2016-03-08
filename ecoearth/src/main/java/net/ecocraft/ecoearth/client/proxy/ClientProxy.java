package net.ecocraft.ecoearth.client.proxy;

import net.ecocraft.ecoearth.client.event.ClientEventHandler;
import net.ecocraft.ecoearth.client.key.EarthKeyBinds;
import net.ecocraft.ecoearth.server.proxy.ServerProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends ServerProxy {
    @Override
    public void preInit() {
        super.preInit();

        EarthKeyBinds.init();

        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }

    @Override
    public void scheduleTask(MessageContext ctx, Runnable runnable) {
        Minecraft.getMinecraft().addScheduledTask(runnable);
    }
}
