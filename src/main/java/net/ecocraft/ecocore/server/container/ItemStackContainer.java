package net.ecocraft.ecocore.server.container;

import net.ecocraft.ecocore.server.item.ContainerItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class ItemStackContainer extends Container {
    protected EntityPlayer player;
    protected IInventory playerInventory;
    protected ItemStack itemStack;
    protected InventoryBasic stackInventory;
    protected int numRows = 6;

    public ItemStackContainer(ItemStack stack, EntityPlayer player) {
        this.itemStack = stack;
        this.player = player;
        this.stackInventory = ItemStackContainer.getStackInventory(stack);
        this.playerInventory = player.inventory;
        player.inventory.openInventory(player);
    }

    public static InventoryBasic getStackInventory(ItemStack stack) {
        InventoryBasic r = new InventoryBasic("itemstack", false, ((ContainerItem) stack.getItem()).containerSize());
        if (!stack.hasTagCompound()) {
            return r;
        }

        NBTTagCompound nbt = stack.getTagCompound();

        if (!nbt.hasKey("stackinventory")) {
            return r;
        }

        NBTTagList nbtTagList = nbt.getTagList("stackinventory", 10);
        for (int i = 0; i < nbtTagList.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbtTagList.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0) {
                r.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
                //r.add(ItemStack.loadItemStackFromNBT(nbttagcompound1));
            }
        }

        return r;
    }

    public static ItemStack setStackInventory(ItemStack stack, InventoryBasic inv) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound nbt = stack.getTagCompound();

        NBTTagList nbtTagList = new NBTTagList();
        for (int i = 0; inv != null && i < inv.getSizeInventory(); ++i) {
            if (inv.getStackInSlot(i) != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                inv.getStackInSlot(i).writeToNBT(nbttagcompound1);
                nbtTagList.appendTag(nbttagcompound1);
            }
        }
        nbt.setTag("stackinventory", nbtTagList);
        stack.setTagCompound(nbt);

        return stack;
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }

    public InventoryBasic getStackInventory() {
        return this.stackInventory;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            this.stackInventory.func_174894_a(itemstack1);

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

        /*
            if (par2 < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }*/
        }

        return itemstack;
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
        return this.playerInventory.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        /*for (int i = 0; i < playerInventory.getSizeInventory(); i++)
            if (playerInventory.getStackInSlot(i) != null && playerInventory.getStackInSlot(i).hasTagCompound() && playerInventory.getStackInSlot(i).getTagCompound().hasKey("slotlocked"))
            {
                NBTTagCompound nbt = playerInventory.getStackInSlot(i).getTagCompound();
                nbt.removeTag("slotlocked");
                ItemStack stack = playerInventory.getStackInSlot(i);
                stack.setTagCompound(nbt);
                playerInventory.setInventorySlotContents(i, stack);
            }*/

        this.playerInventory.closeInventory(par1EntityPlayer);
        super.onContainerClosed(par1EntityPlayer);

        if (par1EntityPlayer.worldObj.isRemote) {
            return;
        }

        this.player.inventory.setInventorySlotContents(this.player.inventory.currentItem, ItemStackContainer.setStackInventory(this.itemStack, this.stackInventory));

    }

    /**
     * Return this chest container's lower chest inventory.
     */
    public IInventory getPlayerInventory() {
        return this.playerInventory;
    }
}
