package net.ecocraft.ecocore.registry.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ContentObject {
	// Protected Object Fields
	protected Object mod;
	protected Block block;
	protected Item item;
	protected String unlocalizedName, harvestString;
	protected int harvestLevel;
	protected CreativeTabs creativeTab;
	protected float hardness, resistance;
	protected Block.SoundType soundType;
	// Registry Fields
	protected boolean initialized = false, registered = false, setOreDict = false;
	protected List<String> regType = new ArrayList<String>();
	// Tile Entity Fields
	protected String tileEntityName;
	protected Class<? extends TileEntity> tileEntityClass;
	protected TileEntitySpecialRenderer specialRenderer;

	// Static registration methods
	public static void registerItem(Item item) {
		String name = item.getUnlocalizedName();
		String[] strings = name.split("\\.");
		name = strings[strings.length - 1];

		if (name == null) {
			throw new ExceptionInInitializerError();
		}

		GameRegistry.registerItem(item, name);
	}

	public static void registerBlock(Block block) {
		String name = block.getUnlocalizedName();
		String[] strings = name.split("\\.");
		name = strings[strings.length - 1];

		if (name == null) {
			throw new ExceptionInInitializerError();
		}

		GameRegistry.registerBlock(block, name);
	}

	// Constructors
	public ContentObject(
			Block block,
			String unlocalizedName,
			CreativeTabs creativeTab,
			float hardness,
			float resistance,
			Block.SoundType sound) {
		this(block, unlocalizedName, creativeTab, hardness, resistance, sound, null, -1);
	}

	public ContentObject(
			Block block,
			String unlocalizedName,
			CreativeTabs creativeTab,
			float hardness,
			float resistance,
			Block.SoundType sound,
			String harvestString,
			int harvestLevel) {
		this(Item.getItemFromBlock(block), unlocalizedName, creativeTab);

		this.block = block;

		this.hardness = hardness;
		this.resistance = resistance;
		this.soundType = sound;

		this.harvestString = harvestString;
		this.harvestLevel = harvestLevel;
	}

	public ContentObject(Item item, String unlocalizedName, CreativeTabs creativeTab) {
		this.item = item;
		this.unlocalizedName = unlocalizedName;
		this.creativeTab = creativeTab;
	}

	// Getters
	public Block getBlock() {
		return this.block;
	}

	public Item getItem() {
		if (this.block != null) {
			return Item.getItemFromBlock(this.block);
		}

		return this.item;
	}

	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	public ItemStack getItemStack() {
		if (this.block != null) {
			return new ItemStack(this.block);
		}

		if (this.item != null) {
			return new ItemStack(this.item);
		}

		throw new ExceptionInInitializerError();
	}

	// Setters
	public ContentObject setOreDict() {
		this.setOreDict = true;
		return this;
	}

	public ContentObject addRegTypes(String... strings) {
		Collections.addAll(this.regType, strings);

		return this;
	}

	public void registerTypeRecipes() {
		if (this.regType.size() == 0) {
			return;
		}

		return;
	}

	public ContentObject setTileEntity(Class<? extends TileEntity> tileEntityClass, String name) {
		this.tileEntityClass = tileEntityClass;
		this.tileEntityName = name;
		return this;
	}

	public ContentObject setTileEntity(
			Class<? extends TileEntity> tileEntityClass,
			String name,
			TileEntitySpecialRenderer renderer) {
		this.tileEntityClass = tileEntityClass;
		this.tileEntityName = name;
		this.specialRenderer = renderer;
		return this;
	}

	public void init() {
		if (this.block != null) {
			this.block.setUnlocalizedName(this.unlocalizedName);

			if (this.creativeTab != null) {
				this.block.setCreativeTab(this.creativeTab);
			}

			this.block.setHardness(this.hardness);
			this.block.setResistance(this.resistance);
			this.block.setStepSound(this.soundType);

			if (this.harvestString != null && !this.harvestString.equals("") && this.harvestLevel > -1) {
				block.setHarvestLevel(this.harvestString, this.harvestLevel);
			}
		} else if (this.item != null) {
			this.item.setUnlocalizedName(this.unlocalizedName);

			if (this.creativeTab != null) {
				this.item.setCreativeTab(this.creativeTab);
			}
		}

		this.initialized = true;
	}

	public void registerObject(Object mod) {
		if (this.registered) {
			return;
		}

		if (!this.initialized) {
			this.init();
		}

		this.mod = mod;

		if (this.block != null) {
			ContentObject.registerBlock(this.block);
		} else if (this.item != null) {
			ContentObject.registerItem(this.item);
		}

		if (this.block != null && this.item == null) {
			this.item = Item.getItemFromBlock(this.block);
		}

		if (this.tileEntityClass != null) {
			GameRegistry.registerTileEntity(this.tileEntityClass, this.tileEntityName);
		}

		this.registered = true;
	}

	public void registerRenderer(ItemModelMesher itemModelMesher) {
		this.registerRenderer(itemModelMesher, "inventory");
	}

	public void registerRenderer(ItemModelMesher itemModelMesher, final String type) {
		final String modName = ((Mod) this.mod).modid();
		final String objName = this.unlocalizedName;
		itemModelMesher.register(this.item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(modName + ":" + objName, type);
			}
		});
	}

	public void registerSpecialClientRenderers() {
		if (this.specialRenderer != null) {
			ClientRegistry.bindTileEntitySpecialRenderer(this.tileEntityClass, this.specialRenderer);
		}
	}
}
