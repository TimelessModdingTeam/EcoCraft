package net.ecocraft.ecoearth.server.event;

import net.ecocraft.ecoearth.server.world.gen.WorldTypeEarth;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ServerEventHandler {
    @SubscribeEvent
    public void worldLoad(WorldEvent.Load event) {
        World world = event.world;

        if (world.getWorldType() instanceof WorldTypeEarth) {
            world.setSpawnPoint(new BlockPos(30000, 0, 0));
        }
    }
}
