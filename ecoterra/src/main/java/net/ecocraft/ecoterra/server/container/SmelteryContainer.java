package net.ecocraft.ecoterra.server.container;

import net.ecocraft.ecocore.server.container.TableContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SmelteryContainer extends TableContainer {
    private int field_178152_f;
    private int field_178153_g;
    private int field_178154_h;
    private int field_178155_i;

    public SmelteryContainer(IInventory table, EntityPlayer player) {
        super(table, player);

        //for (int i = 0; i < 4; i++)
        //    this.tableInventory.setInventorySlotContents(i, table.getStackInSlot(i));

        this.addSlotToContainer(new Slot(tableInventory, 0, 38, 17));
        this.addSlotToContainer(new Slot(tableInventory, 3, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(tableInventory, 1, 47, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(player, tableInventory, 2, 116, 35));

        int xOff, yOff;
        xOff = 8;
        yOff = 142;
        int pCount = 0;
        for (int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(this.playerInventory, pCount, xOff + i * 18, yOff));
            pCount++;
        }
        yOff = 84;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlotToContainer(new Slot(this.playerInventory, pCount, xOff + col * 18, yOff + row * 18));
                pCount++;
            }
        }
    }

    /**
     * Add the given Listener to the list of Listeners. Method name is for legacy.
     */
    public void onCraftGuiOpened(ICrafting listener) {
        super.onCraftGuiOpened(listener);
        listener.sendAllWindowProperties(this, this.tableInventory);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges() {
        for (int i = 0; i < this.inventorySlots.size(); ++i) {
            ItemStack itemstack = ((Slot) this.inventorySlots.get(i)).getStack();
            ItemStack itemstack1 = (ItemStack) this.inventoryItemStacks.get(i);

            if (!ItemStack.areItemStacksEqual(itemstack1, itemstack)) {
                itemstack1 = itemstack == null ? null : itemstack.copy();
                this.inventoryItemStacks.set(i, itemstack1);

                for (int j = 0; j < this.crafters.size(); ++j) {
                    ((ICrafting) this.crafters.get(j)).sendSlotContents(this, i, itemstack1);
                }
            }
        }

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.field_178152_f != this.tableInventory.getField(2)) {
                icrafting.sendProgressBarUpdate(this, 2, this.tableInventory.getField(2));
            }

            if (this.field_178154_h != this.tableInventory.getField(0)) {
                icrafting.sendProgressBarUpdate(this, 0, this.tableInventory.getField(0));
            }

            if (this.field_178155_i != this.tableInventory.getField(1)) {
                icrafting.sendProgressBarUpdate(this, 1, this.tableInventory.getField(1));
            }

            if (this.field_178153_g != this.tableInventory.getField(3)) {
                icrafting.sendProgressBarUpdate(this, 3, this.tableInventory.getField(3));
            }
        }

        this.field_178152_f = this.tableInventory.getField(2);
        this.field_178154_h = this.tableInventory.getField(0);
        this.field_178155_i = this.tableInventory.getField(1);
        this.field_178153_g = this.tableInventory.getField(3);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tableInventory.setField(id, data);
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tableInventory.isUseableByPlayer(playerIn);
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 1 && index != 0) {
                if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntityFurnace.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                } else if (index >= 3 && index < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                } else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

}
