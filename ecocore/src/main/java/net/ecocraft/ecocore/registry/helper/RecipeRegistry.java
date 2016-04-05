package net.ecocraft.ecocore.registry.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.ecocraft.ecocore.registry.EcoRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeRegistry {
	protected boolean isShaped = false;
	protected String top, middle, bottom;
	protected Object output;
	protected HashMap<Character, Object> itemChars = new HashMap<Character, Object>();

	public RecipeRegistry(Object output, Object... items) {
		if (output != null && (!(output instanceof ItemStack || output instanceof Item || output instanceof Block
				|| output instanceof String) || items.length < 1)) {
			throw new ExceptionInInitializerError();
		}

		if (output instanceof ItemStack) {
			this.output = ((ItemStack) output).copy();
		} else if (output instanceof String) {
			this.output = output;
		} else if (output != null) {
			throw new ExceptionInInitializerError();
		}

		if (items[0] instanceof Character) {
			for (int i = 0; i + 1 < items.length; i += 2) {
				if (!(items[i] instanceof Character)) {
					break;
				}

				if (items[i + 1] == null || !(items[i + 1] instanceof ItemStack || items[i + 1] instanceof Item
						|| items[i + 1] instanceof Block || items[i + 1] instanceof String
						|| items[i + 1] instanceof PseudeItemStack)) {
					throw new ExceptionInInitializerError();
				}

				this.itemChars.put((Character) items[i], items[i + 1]);
			}
		} else {
			for (int i = 0; i + 1 < items.length; i++) {
				if (items[i] == null
						|| !(items[i] instanceof ItemStack || items[i] instanceof Item || items[i] instanceof Block
								|| items[i] instanceof String || items[i] instanceof PseudeItemStack)) {
					throw new ExceptionInInitializerError();
				}

				this.itemChars.put(("" + i).charAt(0), items[i + 1]);
			}
		}
	}

	public RecipeRegistry(String output, String top, String middle, String bottom, Object... items) {
		this((Object) output, top, middle, bottom, items);
	}

	public RecipeRegistry(Object output, String top, String middle, String bottom, Object... items) {
		this(output, items);

		if (items.length < 2 || top.length() != 3 || middle.length() != 3 || bottom.length() != 3) {
			throw new ExceptionInInitializerError();
		}

		this.top = top;
		this.middle = middle;
		this.bottom = bottom;

		this.isShaped = true;
	}

	public RecipeRegistry(String top, String middle, String bottom, Object... items) {
		this(null, top, middle, bottom, items);
	}

	public void registerRecipe() {
		List<Object> objs = new ArrayList<Object>();
		Character[] cs = new Character[itemChars.keySet().size()];
		cs = itemChars.keySet().toArray(cs);

		if (this.output == null) {
			throw new ExceptionInInitializerError();
		}

		if (this.isShaped) {
			objs.add(this.top);
			objs.add(this.middle);
			objs.add(this.bottom);
		}

		for (Character c : cs) {
			if (isShaped) {
				objs.add(c);
			}

			Object curObj = itemChars.get(c);

			ItemStack is = null;
			if (curObj instanceof ItemStack) {
				is = ((ItemStack) curObj).copy();
			} else if (curObj instanceof Item) {
				is = new ItemStack((Item) curObj);
			} else if (curObj instanceof Block) {
				is = new ItemStack((Block) curObj);
			} else if (curObj instanceof String) {
				String name = (String) curObj;
				is = EcoRegistry.instance.getObjReg(name).getItemStack();
			}

			if (is == null) {
				throw new ExceptionInInitializerError();
			}

			objs.add(is);
		}

		ItemStack outStack = null;
		if (this.output instanceof ItemStack) {
			outStack = (ItemStack) this.output;
		} else if (this.output instanceof String) {
			String name = (String) this.output;
			outStack = EcoRegistry.instance.getObjReg(name).getItemStack();
		} else if (this.output instanceof PseudeItemStack) {
			String name = ((PseudeItemStack) this.output).name;
			outStack = EcoRegistry.instance.getObjReg(name).getItemStack();
			outStack.stackSize = ((PseudeItemStack) this.output).amount;
			outStack.setItemDamage(((PseudeItemStack) this.output).meta);
		} else {
			throw new ExceptionInInitializerError();
		}

		if (this.isShaped) {
			GameRegistry.addShapedRecipe(outStack, objs.toArray());
		} else {
			GameRegistry.addShapelessRecipe(outStack, objs.toArray());
		}
	}

	protected class PseudeItemStack {
		public String name;
		public int amount, meta;

		public PseudeItemStack(String name, int amount, int meta) {
			this.name = name;
			this.amount = amount;
			this.meta = meta;
		}
	}

	public void setOutput(String unlocalizedName) {
		this.output = unlocalizedName;
	}
}
