package net.ecocraft.ecoearth;

import net.ecocraft.ecoearth.server.proxy.ServerProxy;
import net.ecocraft.ecoearth.server.world.gen.EarthGen;
import net.ecocraft.ecoearth.server.world.gen.WorldTypeEarth;
import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = EcoEarth.MODID, name = "EcoEarth", version = EcoEarth.VERSION, dependencies = "before:ecocore;required-after:llibrary@[" + EcoEarth.LLIBRARY_VERSION + ",)")
public class EcoEarth {
    public static final String MODID = "ecoearth";
    public static final String VERSION = "0.1.0";
    public static final String LLIBRARY_VERSION = "0.8.0";

    public static EarthGen generator;

    private WorldType earth;

    @SidedProxy(clientSide = "net.ecocraft.ecoearth.client.proxy.ClientProxy", serverSide = "net.ecocraft.ecoearth.server.proxy.ServerProxy")
    public static ServerProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        generator = new EarthGen();
        earth = new WorldTypeEarth(generator);

        proxy.preInit();
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStart(event);
    }
}
