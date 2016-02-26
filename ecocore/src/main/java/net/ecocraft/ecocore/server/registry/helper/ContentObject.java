package net.ecocraft.ecocore.server.registry.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ContentObject {
	// Static Object Registry
	private static final HashMap<Object, List<ContentObject>> objectRegistry = new HashMap<Object, List<ContentObject>>();
	private static final HashMap<Object, List<RecipeRegistry>> recipeRegistry = new HashMap<Object, List<RecipeRegistry>>();
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

	// Constructors
	public ContentObject(Block block, String unlocalizedName, CreativeTabs creativeTab, float hardness,
			float resistance, Block.SoundType sound) {
		this(block, unlocalizedName, creativeTab, hardness, resistance, sound, null, -1);
	}

	public ContentObject(Block block, String unlocalizedName, CreativeTabs creativeTab, float hardness,
			float resistance, Block.SoundType sound, String harvestString, int harvestLevel) {
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

	public static Object[] getRegMods() {
		Object[] ret = new Object[ContentObject.objectRegistry.keySet().size()];
		return ContentObject.objectRegistry.keySet().toArray(ret);
	}

	public static List<ContentObject> getObjRegs(Object modClass) {
		if (modClass == null || ContentObject.objectRegistry.get(modClass) == null) {
			return new ArrayList<ContentObject>();
		}

		List<ContentObject> l = ContentObject.objectRegistry.get(modClass);

		if (l == null) {
			return new ArrayList<ContentObject>();
		}

		return new ArrayList<ContentObject>(l);
	}

	public static List<ContentObject> getObjRegs() {
		ArrayList<ContentObject> allregs = new ArrayList<ContentObject>();

		Iterator i = ContentObject.objectRegistry.keySet().iterator();

		if (!i.hasNext()) {
			return allregs;
		}

		do {
			allregs.addAll(ContentObject.objectRegistry.get(i.next()));
		} while (i.hasNext());

		return allregs;
	}

	public static List<RecipeRegistry> getObjRecs() {
		ArrayList<RecipeRegistry> allrecs = new ArrayList<RecipeRegistry>();

		Iterator i = ContentObject.recipeRegistry.keySet().iterator();

		if (!i.hasNext()) {
			return allrecs;
		}

		do {
			allrecs.addAll(ContentObject.recipeRegistry.get(i.next()));
		} while (i.hasNext());

		return allrecs;
	}

	public static ContentObject getObjReg(String unlocalizedName) {
		ContentObject reg = null;
		List<ContentObject> regs = ContentObject.getObjRegs();
		for (ContentObject reg1 : regs) {
			if (reg1.unlocalizedName.equalsIgnoreCase(unlocalizedName)) {
				reg = reg1;
				break;
			}
		}
		return reg;
	}

	public static ItemStack getStack(String unlocalizedName) {
		ContentObject r = ContentObject.getObjReg(unlocalizedName);

		if (r == null) {
			throw new ExceptionInInitializerError();
		}

		return r.getItemStack();
	}

	public static void addObjReg(Object modClass, ContentObject objectRegister, boolean register, Object... recipes) {
		List<ContentObject> regList = ContentObject.objectRegistry.get(modClass);
		List<RecipeRegistry> recList = ContentObject.recipeRegistry.get(modClass);

		if (regList == null) {
			regList = new ArrayList<ContentObject>();
			recList = new ArrayList<RecipeRegistry>();
			ContentObject.objectRegistry.put(modClass, regList);
			ContentObject.recipeRegistry.put(modClass, recList);
		}

		regList.add(objectRegister);

		if (recipes != null) {
			for (Object obj : recipes) {
				if (obj instanceof RecipeRegistry) {
					((RecipeRegistry) obj).output = objectRegister.unlocalizedName;
					recList.add((RecipeRegistry) obj);
				} else if (obj instanceof RecipeRegistry[]) {
					RecipeRegistry[] reca = (RecipeRegistry[]) obj;
					for (Object reci : reca) {
						((RecipeRegistry) reci).output = objectRegister.unlocalizedName;
						recList.add((RecipeRegistry) reci);
					}
				} else {
					throw new ExceptionInInitializerError();
				}
			}
		}

		if (register) {
			objectRegister.registerObject(modClass);
		}
	}

	public static void registerObjRegs(Object modClass) {
		List<ContentObject> curList = ContentObject.objectRegistry.get(modClass);

		if (curList != null) {
			for (ContentObject aCurList : curList) {
				aCurList.registerObject(modClass);
			}
		}
	}

	public static void registerObjRecipes() {
		Iterator i = ContentObject.recipeRegistry.keySet().iterator();

		if (!i.hasNext()) {
			return;
		}

		do {
			Object o = i.next();

			List<ContentObject> modContentRegistries = objectRegistry.get(o);
			List<RecipeRegistry> modRecipeRegistries = recipeRegistry.get(o);

			for (ContentObject or : modContentRegistries) {
				or.registerTypeRecipes();
			}

			for (RecipeRegistry rec : modRecipeRegistries) {
				rec.registerRecipe();
			}
		} while (i.hasNext());
	}

	public static void registerOreDicts() {
		List<ContentObject> regs = ContentObject.getObjRegs();
		for (ContentObject rec : regs) {
			OreDictionary.registerOre(rec.unlocalizedName, rec.getItemStack());
		}
	}

	public static void registerIRegisters() {
		List<ContentObject> regs = ContentObject.getObjRegs();
		for (ContentObject rec : regs) {
			if (rec.getBlock() instanceof IRegisterContent) {
				((IRegisterContent) rec.getBlock()).register();
			} else if (rec.getItem() instanceof IRegisterContent) {
				((IRegisterContent) rec.getItem()).register();
			}
		}
	}

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

	// Static Object Removal
	public static void remove(Block block) {
		ContentObject.remove(Item.getItemFromBlock(block));
	}

	public static void remove(Item item) {
		ContentObject.removeItemStack(new ItemStack(item));
	}

	public static void removeItemStack(ItemStack itemStack) {
		ContentObject.removeCreativeTabs(itemStack.getItem());
		ContentObject.removeCraftingRecipes(itemStack);
		ContentObject.removeSmeltingRecipes(itemStack);
		ContentObject.removeChestGenHooks(itemStack);
	}

	public static void removeCreativeTabs(Item item) {
		Block block = null;
		if (ItemBlock.class.isInstance(item)) {
			block = ((ItemBlock) item).getBlock();
		}

		if (item != null) {
			item.setCreativeTab(null);
		}
		if (block != null) {
			block.setCreativeTab(null);
		}
	}

	public static void removeCraftingRecipes(ItemStack itemStack) {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> cIter = recipes.iterator();
		while (cIter.hasNext()) {
			IRecipe rec = cIter.next();
			ItemStack isOut = rec.getRecipeOutput();
			if (isOut != null && ItemStack.areItemsEqual(itemStack, isOut)) {
				cIter.remove();
			}
		}
	}

	public static void removeSmeltingRecipes(ItemStack itemStack) {
		Map<ItemStack, ItemStack> smelts = FurnaceRecipes.instance().getSmeltingList();
		Iterator<ItemStack> sIter = smelts.keySet().iterator();
		while (sIter.hasNext()) {
			ItemStack is1 = sIter.next();
			ItemStack is2 = smelts.get(is1);
			if (is1 != null) {
				if (ItemStack.areItemsEqual(itemStack, is1)) {
					sIter.remove();
					continue;
				}
			}

			if (is2 != null && ItemStack.areItemsEqual(itemStack, is2)) {
				sIter.remove();
			}
		}
	}

	public static void removeChestGenHooks(ItemStack itemStack) {
		ChestGenHooks.removeItem(ChestGenHooks.STRONGHOLD_CORRIDOR, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.VILLAGE_BLACKSMITH, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.STRONGHOLD_LIBRARY, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.BONUS_CHEST, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.PYRAMID_DESERT_CHEST, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.STRONGHOLD_CROSSING, itemStack);
		ChestGenHooks.removeItem(ChestGenHooks.MINESHAFT_CORRIDOR, itemStack);
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

	public ContentObject setTileEntity(Class<? extends TileEntity> tileEntityClass, String name,
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
			registerBlock(this.block);
		} else if (this.item != null) {
			registerItem(this.item);
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
