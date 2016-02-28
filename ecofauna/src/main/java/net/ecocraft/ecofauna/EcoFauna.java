package net.ecocraft.ecofauna;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = EcoFauna.MODID, name = "EcoFauna", version = EcoFauna.VERSION, dependencies = "before:ecocore;required-after:llibrary@[" + EcoFauna.LLIBRARY_VERSION + ",)")
public class EcoFauna {
    public static final String MODID = "ecofauna";
    public static final String VERSION = "0.1.0";
    public static final String LLIBRARY_VERSION = "0.8.0";
}
