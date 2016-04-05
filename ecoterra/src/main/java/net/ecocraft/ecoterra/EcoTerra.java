package net.ecocraft.ecoterra;

import net.ecocraft.ecocore.registry.EcoRegistry;
import net.ecocraft.ecocore.registry.helper.ContentObject;
import net.ecocraft.ecocore.registry.helper.RecipeHelper;
import net.ecocraft.ecoterra.api.EcoTerraAPI;
import net.ecocraft.ecoterra.block.table.AnvilBlock;
import net.ecocraft.ecoterra.block.table.SmelteryBlock;
import net.ecocraft.ecoterra.block.terra.GemBlock;
import net.ecocraft.ecoterra.block.terra.GemOreBlock;
import net.ecocraft.ecoterra.block.terra.MetalBlock;
import net.ecocraft.ecoterra.block.terra.MetalOreBlock;
import net.ecocraft.ecoterra.gui.GUIHandler;
import net.ecocraft.ecoterra.item.Material;
import net.ecocraft.ecoterra.item.commodity.MetalChainItem;
import net.ecocraft.ecoterra.item.commodity.StuddedLeatherItem;
import net.ecocraft.ecoterra.item.terra.GemItem;
import net.ecocraft.ecoterra.item.terra.IngotItem;
import net.ecocraft.ecoterra.item.terra.NuggetItem;
import net.ecocraft.ecoterra.item.tools.AxeItem;
import net.ecocraft.ecoterra.item.tools.HoeItem;
import net.ecocraft.ecoterra.item.tools.PickaxeItem;
import net.ecocraft.ecoterra.item.tools.ShovelItem;
import net.ecocraft.ecoterra.proxy.ServerProxy;
import net.ecocraft.ecoterra.tileentity.table.AnvilBlockEntity;
import net.ecocraft.ecoterra.tileentity.table.SmelteryBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = EcoTerra.MODID, name = "EcoTerra", version = EcoTerra.VERSION)
public class EcoTerra {
	public static final String MODID = "ecoterra";
	public static final String VERSION = "0.1.0";

	@Mod.Instance(MODID)
	public static EcoTerra instance;
	@SidedProxy(
			serverSide = "net.ecocraft.ecoterra.proxy.ServerProxy",
			clientSide = "net.ecocraft.ecoterra.proxy.ClientProxy")
	public static ServerProxy proxy;

	@Mod.EventHandler
	public void onPreInit(FMLPreInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());

		this.removeContent();
		this.registerContent();

		proxy.onPreInit();
	}

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		proxy.onInit();

		this.registerRecipes();
	}

	@Mod.EventHandler
	public void onPostInit(FMLPostInitializationEvent event) {
		proxy.onPostInit();
	}

	//@formatter:off
    //Functions
    public void removeContent() {
        //Resources and Derived Tools
        EcoRegistry.removeItemStack(new ItemStack(Items.wooden_sword));
        EcoRegistry.removeItemStack(new ItemStack(Items.wooden_shovel));
        EcoRegistry.removeItemStack(new ItemStack(Items.wooden_hoe));
        EcoRegistry.removeItemStack(new ItemStack(Items.wooden_axe));
        EcoRegistry.removeItemStack(new ItemStack(Items.wooden_pickaxe));

        EcoRegistry.removeItemStack(new ItemStack(Items.stone_sword));
        EcoRegistry.removeItemStack(new ItemStack(Items.stone_shovel));
        EcoRegistry.removeItemStack(new ItemStack(Items.stone_hoe));
        EcoRegistry.removeItemStack(new ItemStack(Items.stone_axe));
        EcoRegistry.removeItemStack(new ItemStack(Items.stone_pickaxe));

        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.iron_ore)));
        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.iron_block)));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_ingot));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_horse_armor));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_boots));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_helmet));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_chestplate));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_leggings));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_sword));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_shovel));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_hoe));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_axe));
        EcoRegistry.removeItemStack(new ItemStack(Items.iron_pickaxe));

        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.gold_ore)));
        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.gold_block)));
        EcoRegistry.removeItemStack(new ItemStack(Items.gold_ingot));
        EcoRegistry.removeItemStack(new ItemStack(Items.gold_nugget));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_horse_armor));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_boots));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_helmet));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_chestplate));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_leggings));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_sword));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_shovel));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_hoe));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_axe));
        EcoRegistry.removeItemStack(new ItemStack(Items.golden_pickaxe));

        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.diamond_ore)));
        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.diamond_block)));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_horse_armor));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_boots));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_helmet));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_chestplate));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_leggings));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_sword));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_shovel));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_hoe));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_axe));
        EcoRegistry.removeItemStack(new ItemStack(Items.diamond_pickaxe));

        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.emerald_ore)));
        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.emerald_block)));
        EcoRegistry.removeItemStack(new ItemStack(Items.emerald));

        //Anvils
        EcoRegistry.removeItemStack(new ItemStack(Item.getItemFromBlock(Blocks.anvil)));

    }

    public void registerContent() {
        //Tables
        EcoRegistry.registerObject(this, new ContentObject(new SmelteryBlock(false), "smeltery", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0)
                .setTileEntity(SmelteryBlockEntity.class, "smeltery"));
        EcoRegistry.registerObject(this, new ContentObject(new SmelteryBlock(true), "smeltery_lit", null, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new AnvilBlock(), "stone_anvil", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0)
                .setTileEntity(AnvilBlockEntity.class, "anvil"));

        EcoRegistry.registerObject(this, new ContentObject(new AnvilBlock(), "copper_anvil", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new AnvilBlock(), "bronze_anvil", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new AnvilBlock(), "iron_anvil", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new AnvilBlock(), "steel_anvil", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));

        //Gem Ores
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "amethyst_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "aquamarine_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "citrine_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "diamond_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "emerald_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "garnet_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "opal_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "peridot_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "ruby_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "sapphire_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemOreBlock(), "turquoise_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));

        //Gems
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "amethyst_gem", CreativeTabs.tabMaterials).addRegTypes("stat_luck"));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "aquamarine_gem", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "citrine_gem", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "diamond_gem", CreativeTabs.tabMaterials).addRegTypes("stat_durability"));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "emerald_gem", CreativeTabs.tabMaterials).addRegTypes("stat_agility"));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "garnet_gem", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "opal_gem", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "peridot_gem", CreativeTabs.tabMaterials).addRegTypes("stat_accuracy"));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "ruby_gem", CreativeTabs.tabMaterials).addRegTypes("stat_attack"));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "sapphire_gem", CreativeTabs.tabMaterials).addRegTypes("stat_defense"));
        EcoRegistry.registerObject(this, new ContentObject(new GemItem(), "turquoise_gem", CreativeTabs.tabMaterials));

        //Gem Blocks
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "amethyst_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "aquamarine_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "citrine_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "diamond_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "emerald_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "garnet_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "opal_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "peridot_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "ruby_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "sapphire_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new GemBlock(), "turquoise_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));

        //Metal Ores
        EcoRegistry.registerObject(this, new ContentObject(new MetalOreBlock(), "copper_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalOreBlock(), "tin_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalOreBlock(), "iron_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalOreBlock(), "silver_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalOreBlock(), "gold_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalOreBlock(), "platinum_ore", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeStone, "pickaxe", 0));

        //Metal Nuggets
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "copper_nugget", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "tin_nugget", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "bronze_nugget", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "iron_nugget", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "steel_nugget", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "silver_nugget", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "gold_nugget", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new NuggetItem(), "platinum_nugget", CreativeTabs.tabMaterials));

        //Metal Ingots
        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "copper_ingot", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "tin_ingot", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "bronze_ingot", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "iron_ingot", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "steel_ingot", CreativeTabs.tabMaterials));

        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "silver_ingot", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "gold_ingot", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new IngotItem(), "platinum_ingot", CreativeTabs.tabMaterials));

        //Metal Blocks
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "copper_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0).setOreDict());
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "tin_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "bronze_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "iron_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "steel_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "silver_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "gold_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0));
        EcoRegistry.registerObject(this, new ContentObject(new MetalBlock(), "platinum_block", CreativeTabs.tabMaterials, 3.0F, 5.0F, Block.soundTypeMetal, "pickaxe", 0));

        //Metal Commodities
        EcoRegistry.registerObject(this, new ContentObject(new MetalChainItem(), "copper_chain", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new MetalChainItem(), "bronze_chain", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new MetalChainItem(), "iron_chain", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new MetalChainItem(), "steel_chain", CreativeTabs.tabMaterials));

        EcoRegistry.registerObject(this, new ContentObject(new StuddedLeatherItem(), "copper_studded", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new StuddedLeatherItem(), "bronze_studded", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new StuddedLeatherItem(), "iron_studded", CreativeTabs.tabMaterials));
        EcoRegistry.registerObject(this, new ContentObject(new StuddedLeatherItem(), "steel_studded", CreativeTabs.tabMaterials));

        //Metal Tools
        EcoRegistry.registerObject(this, new ContentObject(new HoeItem(Material.toolMaterialCopper), "wood_hoe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ShovelItem(Material.toolMaterialCopper), "wood_shovel", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new HoeItem(Material.toolMaterialCopper), "stone_hoe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ShovelItem(Material.toolMaterialCopper), "stone_shovel", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new AxeItem(Material.toolMaterialCopper), "flint_axe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new HoeItem(Material.toolMaterialCopper), "flint_hoe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new PickaxeItem(Material.toolMaterialCopper), "flint_pickaxe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ShovelItem(Material.toolMaterialCopper), "flint_shovel", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new AxeItem(Material.toolMaterialCopper), "copper_axe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new HoeItem(Material.toolMaterialCopper), "copper_hoe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new PickaxeItem(Material.toolMaterialCopper), "copper_pickaxe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ShovelItem(Material.toolMaterialCopper), "copper_shovel", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new AxeItem(Material.toolMaterialBronze), "bronze_axe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new HoeItem(Material.toolMaterialBronze), "bronze_hoe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new PickaxeItem(Material.toolMaterialBronze), "bronze_pickaxe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ShovelItem(Material.toolMaterialBronze), "bronze_shovel", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new AxeItem(Material.toolMaterialIron), "iron_axe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new HoeItem(Material.toolMaterialIron), "iron_hoe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new PickaxeItem(Material.toolMaterialIron), "iron_pickaxe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ShovelItem(Material.toolMaterialIron), "iron_shovel", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new AxeItem(Material.toolMaterialSteel), "steel_axe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new HoeItem(Material.toolMaterialSteel), "steel_hoe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new PickaxeItem(Material.toolMaterialSteel), "steel_pickaxe", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ShovelItem(Material.toolMaterialSteel), "steel_shovel", CreativeTabs.tabTools));

        //Armors
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopper, 1, 3), "copper_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopper, 1, 0), "copper_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopper, 1, 1), "copper_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopper, 1, 2), "copper_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperChain, 1, 3), "copper_chain_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperChain, 1, 0), "copper_chain_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperChain, 1, 1), "copper_chain_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperChain, 1, 2), "copper_chain_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperStudded, 1, 3), "copper_studded_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperStudded, 1, 0), "copper_studded_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperStudded, 1, 1), "copper_studded_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopperStudded, 1, 2), "copper_studded_leggings", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronze, 1, 3), "bronze_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronze, 1, 0), "bronze_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronze, 1, 1), "bronze_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronze, 1, 2), "bronze_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeChain, 1, 3), "bronze_chain_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeChain, 1, 0), "bronze_chain_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeChain, 1, 1), "bronze_chain_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeChain, 1, 2), "bronze_chain_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeStudded, 1, 3), "bronze_studded_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeStudded, 1, 0), "bronze_studded_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeStudded, 1, 1), "bronze_studded_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialBronzeStudded, 1, 2), "bronze_studded_leggings", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIron, 1, 3), "iron_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIron, 1, 0), "iron_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIron, 1, 1), "iron_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIron, 1, 2), "iron_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronChain, 1, 3), "iron_chain_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronChain, 1, 0), "iron_chain_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronChain, 1, 1), "iron_chain_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronChain, 1, 2), "iron_chain_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronStudded, 1, 3), "iron_studded_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronStudded, 1, 0), "iron_studded_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronStudded, 1, 1), "iron_studded_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialIronStudded, 1, 2), "iron_studded_leggings", CreativeTabs.tabTools));

        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialCopper, 1, 3), "steel_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteel, 1, 0), "steel_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteel, 1, 1), "steel_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteel, 1, 2), "steel_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelChain, 1, 3), "steel_chain_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelChain, 1, 0), "steel_chain_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelChain, 1, 1), "steel_chain_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelChain, 1, 2), "steel_chain_leggings", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelStudded, 1, 3), "steel_studded_boots", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelStudded, 1, 0), "steel_studded_helmet", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelStudded, 1, 1), "steel_studded_chestplate", CreativeTabs.tabTools));
        EcoRegistry.registerObject(this, new ContentObject(new ItemArmor(Material.armorMaterialSteelStudded, 1, 2), "steel_studded_leggings", CreativeTabs.tabTools));
    }

    public void registerRecipes() {
        RecipeHelper.registerOreGemBlock("amethyst");
        RecipeHelper.registerOreGemBlock("aquamarine");
        RecipeHelper.registerOreGemBlock("citrine");
        RecipeHelper.registerOreGemBlock("diamond");
        RecipeHelper.registerOreGemBlock("emerald");
        RecipeHelper.registerOreGemBlock("garnet");
        RecipeHelper.registerOreGemBlock("opal");
        RecipeHelper.registerOreGemBlock("peridot");
        RecipeHelper.registerOreGemBlock("ruby");
        RecipeHelper.registerOreGemBlock("sapphire");
        RecipeHelper.registerOreGemBlock("turquoise");

        RecipeHelper.registerMetal("copper");
        RecipeHelper.registerMetal("bronze", false);
        RecipeHelper.registerMetal("iron");
        RecipeHelper.registerMetal("steel", false);

        EcoTerraAPI.addDualSmeltingRecipe(new ItemStack(EcoRegistry.instance.getObjReg("bronze_ingot").getItem(), 2), new ItemStack[]{
                new ItemStack(Item.getItemFromBlock(EcoRegistry.instance.getObjReg("copper_ore").getBlock())),
                new ItemStack(Item.getItemFromBlock(EcoRegistry.instance.getObjReg("tin_ore").getBlock()))});
        EcoTerraAPI.addDualSmeltingRecipe(new ItemStack(EcoRegistry.instance.getObjReg("bronze_ingot").getItem(), 2), new ItemStack[]{
                new ItemStack(EcoRegistry.instance.getObjReg("copper_ingot").getItem()),
                new ItemStack(EcoRegistry.instance.getObjReg("tin_ingot").getItem())});
        EcoTerraAPI.addDualSmeltingRecipe(new ItemStack(EcoRegistry.instance.getObjReg("steel_ingot").getItem(), 2), new ItemStack[]{
                new ItemStack(EcoRegistry.instance.getObjReg("iron_ingot").getItem()),
                new ItemStack(Items.coal)});
        EcoTerraAPI.addDualSmeltingRecipe(new ItemStack(EcoRegistry.instance.getObjReg("steel_ingot").getItem(), 2), new ItemStack[]{
                new ItemStack(Item.getItemFromBlock(EcoRegistry.instance.getObjReg("iron_ore").getBlock())),
                new ItemStack(Items.coal)});
    }
}
