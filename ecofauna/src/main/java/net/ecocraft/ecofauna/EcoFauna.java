package net.ecocraft.ecofauna;

import net.ecocraft.ecocore.EcoCore;
import net.ecocraft.ecocore.registry.EcoRegistry;
import net.ecocraft.ecocore.registry.helper.EntityEntry;
import net.ecocraft.ecofauna.entity.aquatic.EntityArapaima;
import net.ecocraft.ecofauna.entity.aquatic.EntityBottlenoseDolphin;
import net.ecocraft.ecofauna.entity.aquatic.EntityClownfish;
import net.ecocraft.ecofauna.entity.aquatic.EntityCommonOctopus;
import net.ecocraft.ecofauna.render.aquatic.RenderArapaima;
import net.ecocraft.ecofauna.render.aquatic.RenderBottlenoseDolphin;
import net.ecocraft.ecofauna.render.aquatic.RenderClownfish;
import net.ecocraft.ecofauna.render.aquatic.RenderCommonOctopus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = EcoFauna.MODID,
		name = "EcoFauna",
		version = EcoFauna.VERSION,
		dependencies = ("required-after:" + EcoCore.MODID))
public class EcoFauna {
	public static final String MODID = "ecofauna";
	public static final String VERSION = "0.1.0";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		registerEntities();
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event) {}

	//@formatter:off
	private void registerEntities() {
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityArapaima.class, "Arapiama", (c)->new RenderArapaima(c))
				.setEggColour(0xB0000, 0x00B000));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityBottlenoseDolphin.class, "BottlenoseDolphin", 
				(c)->new RenderBottlenoseDolphin(c)).setEggColour(0xAAAAAA, 0x404040));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityClownfish.class, "Clownfish",
				(c)->new RenderClownfish(c)));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityCommonOctopus.class, "CommonOctopus",
				(c)->new RenderCommonOctopus(c)).setEggColour(0xAAAAAA, 0xDDDDDD));
	}
}
