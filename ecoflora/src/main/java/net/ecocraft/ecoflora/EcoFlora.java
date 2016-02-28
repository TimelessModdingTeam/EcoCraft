package net.ecocraft.ecoflora;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = EcoFlora.MODID, name = "EcoFlora", version = EcoFlora.VERSION, dependencies = "before:ecocore;required-after:llibrary@[" + EcoFlora.LLIBRARY_VERSION + ",)")
public class EcoFlora {
    public static final String MODID = "ecoflora";
    public static final String VERSION = "0.1.0";
    public static final String LLIBRARY_VERSION = "0.8.0";
}
