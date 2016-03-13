package net.ecocraft.ecocore.container;

import net.ecocraft.ecocore.tileentity.TableBlockEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class TableContainer extends Container {
    protected EntityPlayer player;
    protected IInventory playerInventory, tableInventory;
    protected TableBlockEntity table;
    protected int numRows = 6;

    public TableContainer(IInventory table, EntityPlayer player) {
        this.tableInventory = table;
        if (table instanceof TableBlockEntity) {
            this.table = (TableBlockEntity) table;
        }

        this.player = player;
        this.playerInventory = player.inventory;

        player.inventory.openInventory(player);
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }

    public IInventory getPlayerInventory() {
        return this.playerInventory;
    }

    public IInventory tableInventory() {
        return this.tableInventory;
    }

    public TableBlockEntity getTileEntityTable() {
        return this.table;
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

            if (par2 < this.numRows * 9) {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
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
        super.onContainerClosed(par1EntityPlayer);
        this.playerInventory.closeInventory(par1EntityPlayer);
    }
}
