package net.ecocraft.ecoearth.server.proxy;

import net.ecocraft.ecoearth.server.command.CommandTPLatLong;
import net.ecocraft.ecoearth.server.event.ServerEventHandler;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy {
    public void preInit() {
        MinecraftForge.EVENT_BUS.register(new ServerEventHandler());
    }

    public void serverStart(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandTPLatLong());
    }

    public void scheduleTask(MessageContext ctx, Runnable runnable) {
        WorldServer worldObj = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
        worldObj.addScheduledTask(runnable);
    }
}
