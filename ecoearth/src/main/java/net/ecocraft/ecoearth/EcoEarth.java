package net.ecocraft.ecoearth;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = EcoEarth.MODID, name = "EcoEarth", version = EcoEarth.VERSION, dependencies = "before:ecocore;required-after:llibrary@[" + EcoEarth.LLIBRARY_VERSION + ",)")
public class EcoEarth {
    public static final String MODID = "ecoearth";
    public static final String VERSION = "0.1.0";
    public static final String LLIBRARY_VERSION = "0.8.0";
}
