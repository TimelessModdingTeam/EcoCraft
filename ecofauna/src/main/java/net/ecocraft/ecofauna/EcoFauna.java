package net.ecocraft.ecofauna;

import net.ecocraft.ecocore.EcoCore;
import net.ecocraft.ecocore.registry.EcoRegistry;
import net.ecocraft.ecocore.registry.helper.EntityEntry;
import net.ecocraft.ecofauna.entity.aquatic.*;
import net.ecocraft.ecofauna.render.aquatic.RenderGharial;
import net.ecocraft.ecofauna.render.aquatic.*;
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
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityArapaima.class, "Arapiama",
				(c)->new RenderArapaima(c)).setEggColour(0x3B3B3B, 0xF73455));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityBottlenoseDolphin.class, "BottlenoseDolphin",
				(c)->new RenderBottlenoseDolphin(c)).setEggColour(0x5E5E5E, 0xB5B5B5));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityCarp.class, "Carp",
				(c)->new RenderCarp(c)).setEggColour(0xFFFFFF, 0x000000));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityClownfish.class, "Clownfish",
				(c)->new RenderClownfish(c)).setEggColour(0xEB690C, 0xFFFFFF));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityCommonOctopus.class, "CommonOctopus",
				(c)->new RenderCommonOctopus(c)).setEggColour(0x5E381D, 0x8A664C));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityGharial.class, "Gharial",
				(c)->new RenderGharial(c)).setEggColour(0x2C3B26, 0x6C8065));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityGreatBarracuda.class, "GreatBarracuda",
				(c)->new RenderGreatbarracuda(c)).setEggColour(0x4D6E4D, 0xC9C9C9));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityHumpbackWhale.class, "HumpbackWhale",
				(c)->new RenderHumpbackWhale(c)).setEggColour(0x383837, 0xD6D6D6));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityOrca.class, "Orca",
				(c)->new RenderOrca(c)).setEggColour(0x000000, 0xFFFFFF));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityPacu.class, "Pacu",
				(c)->new RenderPacu(c)).setEggColour(0xFFFFFF, 0x000000));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityPike.class, "Pike",
				(c)->new RenderPike(c)).setEggColour(0xA68844, 0xD6D6D6));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityRedTailCatfish.class, "RedTailCatfish",
				(c)->new RenderRedTailCatfish(c)).setEggColour(0x543515, 0xFF4917));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntitySeaturtle.class, "Seaturtle",
				(c)->new RenderSeaturtle(c)).setEggColour(0x11692B, 0x996531));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntitySockeyeSalmon.class, "SockeyeSalmon",
				(c)->new RenderSockeyeSalmon(c)).setEggColour(0xFF3B3B, 0x4D9462));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntitySquid.class, "Squid",
				(c)->new RenderSquid(c)).setEggColour(0xBF2121, 0xE89E9E));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntitySwordfish.class, "Swordfish",
				(c)->new RenderSwordfish(c)).setEggColour(0x3E41C9, 0xF2E1C2));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityWelsCatfish.class, "WelsCatfish",
				(c)->new RenderWelsCatfish(c)).setEggColour(0x508A5E, 0xA8B5AC));
		EcoRegistry.registerEntity(this, new EntityEntry<>(EntityWhiteShark.class, "WhiteShark",
				(c)->new RenderWhiteShark(c)).setEggColour(0x4A4A4A, 0xCCCCCC));
	}
}
