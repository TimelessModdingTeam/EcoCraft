package net.ecocraft.ecocore.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.ecocraft.ecocore.registry.helper.ContentObject;
import net.ecocraft.ecocore.registry.helper.EntityEntry;
import net.ecocraft.ecocore.registry.helper.IRegisterContent;
import net.ecocraft.ecocore.registry.helper.RecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;

public class EcoRegistryInstance {

	// Static Object Registry
	public final HashMap<Object, List<ContentObject>> objectRegistry = new HashMap<Object, List<ContentObject>>();
	public final HashMap<Object, List<RecipeRegistry>> recipeRegistry = new HashMap<Object, List<RecipeRegistry>>();
	public final HashMap<Object, List<EntityEntry<?>>> entityRegistry = new HashMap<>();
	public final HashSet<IRegisterContent> iregisters = new HashSet<>();

	public Set<Object> getRegMods() {
		Set<Object> mods = new HashSet<>();
		mods.addAll(objectRegistry.keySet());
		mods.addAll(recipeRegistry.keySet());
		mods.addAll(entityRegistry.keySet());
		return mods;
	}

	public List<ContentObject> getObjRegs(Object modClass) {
		List<ContentObject> l = objectRegistry.get(modClass);
		if (l == null) {
			return new ArrayList<ContentObject>();
		}
		return new ArrayList<ContentObject>(l);
	}

	public List<ContentObject> getAllObjRegs() {
		ArrayList<ContentObject> allregs = new ArrayList<ContentObject>();

		for (Entry<Object, List<ContentObject>> modList : objectRegistry.entrySet()) {
			allregs.addAll(modList.getValue());
		}

		return allregs;
	}

	public List<RecipeRegistry> getObjRecs() {
		ArrayList<RecipeRegistry> allrecs = new ArrayList<RecipeRegistry>();

		for (Entry<Object, List<RecipeRegistry>> modList : recipeRegistry.entrySet()) {
			allrecs.addAll(modList.getValue());
		}

		return allrecs;
	}

	public List<EntityEntry<?>> getEntityEntries(Object modClass) {
		List<EntityEntry<?>> l = entityRegistry.get(modClass);
		if (l == null) {
			return new ArrayList<>();
		}
		return new ArrayList<>(l);
	}

	public void addObjReg(Object modClass, ContentObject objectToRegister, boolean register) {
		List<ContentObject> regList = objectRegistry.computeIfAbsent(modClass, (k) -> new ArrayList<ContentObject>());

		regList.add(objectToRegister);

		if (register) {
			objectToRegister.registerObject(modClass);
		}
	}

	public void addRecipes(Object modClass, Collection<RecipeRegistry> recipes) {
		List<RecipeRegistry> recList = recipeRegistry.computeIfAbsent(modClass, (k) -> new ArrayList<RecipeRegistry>());

		for (RecipeRegistry obj : recipes) {
			recList.add((RecipeRegistry) obj);
		}
	}

	public void addRecipesForItem(Object modClass, ContentObject itemObject, Collection<RecipeRegistry> recipes) {
		for (RecipeRegistry recipe : recipes) {
			recipe.setOutput(itemObject.getUnlocalizedName());
		}
		addRecipes(modClass, recipes);
	}

	public void addEntity(Object modClass, EntityEntry<?> entityEntry) {
		List<EntityEntry<?>> entryList = entityRegistry.computeIfAbsent(modClass, (k) -> new ArrayList<>());
		entryList.add(entityEntry);
	}

	// Object Removal
	public void remove(Block block) {
		remove(Item.getItemFromBlock(block));
	}

	public void remove(Item item) {
		removeItemStack(new ItemStack(item));
	}

	public void removeItemStack(ItemStack itemStack) {
		removeCreativeTabs(itemStack.getItem());
		removeCraftingRecipes(itemStack);
		removeSmeltingRecipes(itemStack);
		removeChestGenHooks(itemStack);
	}

	public void removeCreativeTabs(Item item) {
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

	public void removeCraftingRecipes(ItemStack itemStack) {
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

	public void removeSmeltingRecipes(ItemStack itemStack) {
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

	public void removeChestGenHooks(ItemStack itemStack) {
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

	public ContentObject getObjReg(String unlocalizedName) {
		ContentObject reg = null;
		List<ContentObject> regs = getAllObjRegs();
		for (ContentObject reg1 : regs) {
			if (reg1.getUnlocalizedName().equalsIgnoreCase(unlocalizedName)) {
				reg = reg1;
				break;
			}
		}
		return reg;
	}

	// Game registration methods
	public void registerOreDicts() {
		List<ContentObject> regs = getAllObjRegs();
		for (ContentObject rec : regs) {
			OreDictionary.registerOre(rec.getUnlocalizedName(), rec.getItemStack());
		}
	}

	public void registerObjRegs(Object modClass) {
		List<ContentObject> curList = objectRegistry.get(modClass);

		if (curList != null) {
			for (ContentObject aCurList : curList) {
				aCurList.registerObject(modClass);
			}
		}
	}

	public void registerObjRecipes() {
		for (Object mod : recipeRegistry.keySet()) {
			List<ContentObject> modContentRegistries = objectRegistry.get(mod);
			List<RecipeRegistry> modRecipeRegistries = recipeRegistry.get(mod);

			for (ContentObject or : modContentRegistries) {
				or.registerTypeRecipes();
			}

			for (RecipeRegistry rec : modRecipeRegistries) {
				rec.registerRecipe();
			}
		}
	}

	public void registerIRegisters() {
		List<ContentObject> regs = getAllObjRegs();
		for (ContentObject rec : regs) {
			if (rec.getBlock() instanceof IRegisterContent) {
				((IRegisterContent) rec.getBlock()).register();
			} else if (rec.getItem() instanceof IRegisterContent) {
				((IRegisterContent) rec.getItem()).register();
			}
		}
		for (IRegisterContent content : iregisters) {
			content.register();
		}
	}

	public void registerEntities() {
		for (Entry<Object, List<EntityEntry<?>>> modList : entityRegistry.entrySet()) {
			for (EntityEntry<?> entry : modList.getValue()) {
				entry.registerEntity(modList.getKey());
			}
		}
	}

}
