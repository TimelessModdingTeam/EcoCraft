package net.ecocraft.ecoterra.server.block.entity.table;

import net.ecocraft.ecocore.server.block.entity.TableBlockEntity;
import net.ecocraft.ecoterra.server.api.EcoTerraAPI;
import net.ecocraft.ecoterra.server.block.table.SmelteryBlock;
import net.ecocraft.ecoterra.server.container.SmelteryContainer;
import net.ecocraft.ecoterra.client.gui.table.SmelteryGUI;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SmelteryBlockEntity extends TableBlockEntity implements ITickable, ISidedInventory {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{2, 1};
    private static final int[] slotsSides = new int[]{1};
    /**
     * The number of ticks that the furnace will keep burning
     */
    private int furnaceBurnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;

    public SmelteryBlockEntity() {
        super(2 + 1 + 1);
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory p_174903_0_) {
        return p_174903_0_.getField(0) > 0;
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack p_145952_0_) {
        if (p_145952_0_ == null) {
            return 0;
        } else {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab) {
                    return 150;
                }

                if (block.getMaterial() == Material.wood) {
                    return 300;
                }

                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) {
                return 200;
            }
            if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) {
                return 200;
            }
            if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) {
                return 200;
            }
            if (item == Items.stick) {
                return 100;
            }
            if (item == Items.coal) {
                return 1600;
            }
            if (item == Items.lava_bucket) {
                return 20000;
            }
            if (item == Item.getItemFromBlock(Blocks.sapling)) {
                return 100;
            }
            if (item == Items.blaze_rod) {
                return 2400;
            }
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_) {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(p_145954_0_) > 0;
    }

    public Container getContainer(int guiMeta, EntityPlayer player, World world, TileEntity te, int x, int y, int z) {
        return new SmelteryContainer((SmelteryBlockEntity) te, player);
    }

    public Gui getGui(int guiMeta, EntityPlayer player, World world, TileEntity te, int x, int y, int z) {
        return new SmelteryGUI((SmelteryBlockEntity) te, player);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.chestContents = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.chestContents.length) {
                this.chestContents[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = compound.getShort("BurnTime");
        this.cookTime = compound.getShort("CookTime");
        this.totalCookTime = compound.getShort("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.chestContents[1]);

        if (compound.hasKey("CustomName", 8)) {
            this.furnaceCustomName = compound.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setShort("BurnTime", (short) this.furnaceBurnTime);
        compound.setShort("CookTime", (short) this.cookTime);
        compound.setShort("CookTimeTotal", (short) this.totalCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.chestContents.length; ++i) {
            if (this.chestContents[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.chestContents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        compound.setTag("Items", nbttaglist);

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.furnaceCustomName);
        }
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public void update() {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning()) {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote) {
            boolean hasOne = (this.chestContents[0] == null && this.chestContents[3] != null) || (this.chestContents[3] == null && this.chestContents[0] != null);
            boolean hasBoth = this.chestContents[0] != null && this.chestContents[3] != null;


            if (!this.isBurning() && (this.chestContents[1] == null || this.chestContents[0] == null || this.chestContents[3] == null)) {
                if (!this.isBurning() && this.cookTime > 0) {
                    this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
                }
            } else {
                if (!this.isBurning() && this.canSmelt() != null) {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.chestContents[1]);

                    if (this.isBurning()) {
                        flag1 = true;

                        if (this.chestContents[1] != null) {
                            --this.chestContents[1].stackSize;

                            if (this.chestContents[1].stackSize == 0) {
                                this.chestContents[1] = chestContents[1].getItem().getContainerItem(chestContents[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt() != null) {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime) {
                        this.cookTime = 0;
                        this.totalCookTime = this.func_174904_a(this.chestContents[0]);
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            }

            if (flag != this.isBurning()) {
                flag1 = true;
                SmelteryBlock.setState(this.isBurning(), this.worldObj, this.pos);
                this.totalCookTime = 200;
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public int func_174904_a(ItemStack p_174904_1_) {
        return 200;
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private int[] canSmelt() {
        int[] canSmelt = null;
        ItemStack itemstack = null;
        if (this.chestContents[0] != null && this.chestContents[3] != null) {
            //itemstack = FurnaceRecipes.instance().getSmeltingResult(this.chestContents[0]);
            itemstack = EcoTerraAPI.getDualSmeltingResult(new ItemStack[]{this.chestContents[0], this.chestContents[3]});
            canSmelt = new int[]{0, 3};
        } else if (this.chestContents[0] != null) {
            itemstack = FurnaceRecipes.instance().getSmeltingResult(this.chestContents[0]);
            canSmelt = new int[]{0};
        } else if (this.chestContents[3] != null) {
            itemstack = FurnaceRecipes.instance().getSmeltingResult(this.chestContents[3]);
            canSmelt = new int[]{3};
        }

        if (canSmelt != null) {
            if (itemstack == null) {
                return null;
            }
            if (this.chestContents[2] == null) {
                return canSmelt;
            }
            if (!this.chestContents[2].isItemEqual(itemstack)) {
                return null;
            }
            int result = chestContents[2].stackSize + itemstack.stackSize;

            if (result <= getInventoryStackLimit() && result <= this.chestContents[2].getMaxStackSize()) //Forge BugFix: Make it respect stack sizes properly.
            {
                return canSmelt;
            }
        }

        return null;
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem() {
        int[] canSmelt = this.canSmelt();
        if (canSmelt != null) {
            //ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0]);
            //ItemStack itemstack = EcoRecipes.getDualSmeltingResult(new ItemStack[] { this.chestContents[0], this.chestContents[3]});
            ItemStack itemstack = null;
            if (this.chestContents[0] != null && this.chestContents[3] != null) {
                //itemstack = FurnaceRecipes.instance().getSmeltingResult(this.chestContents[0]);
                itemstack = EcoTerraAPI.getDualSmeltingResult(new ItemStack[]{this.chestContents[0], this.chestContents[3]});
            } else if (this.chestContents[0] != null) {
                itemstack = FurnaceRecipes.instance().getSmeltingResult(this.chestContents[0]);
            } else if (this.chestContents[3] != null) {
                itemstack = FurnaceRecipes.instance().getSmeltingResult(this.chestContents[3]);
            }

            if (this.chestContents[2] == null) {
                this.chestContents[2] = itemstack.copy();
            } else if (this.chestContents[2].getItem() == itemstack.getItem()) {
                this.chestContents[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }


            for (int i = 0; i < canSmelt.length; i++) {
                --this.chestContents[canSmelt[i]].stackSize;
                if (this.chestContents[canSmelt[i]].stackSize <= 0) {
                    this.chestContents[canSmelt[i]] = null;
                }
            }
        }
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return index == 2 ? false : (index != 1 ? true : isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack));
    }

    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: slot, item,
     * side
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: slot, item,
     * side
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if (direction == EnumFacing.DOWN && index == 1) {
            Item item = stack.getItem();

            if (item != Items.water_bucket && item != Items.bucket) {
                return false;
            }
        }

        return true;
    }

    public int getField(int id) {
        switch (id) {
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value) {
        switch (id) {
            case 0:
                this.furnaceBurnTime = value;
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public int getFieldCount() {
        return 4;
    }

    public void clear() {
        for (int i = 0; i < this.chestContents.length; ++i) {
            this.chestContents[i] = null;
        }
    }
}
