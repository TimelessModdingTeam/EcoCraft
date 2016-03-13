package net.ecocraft.ecoterra.container;

import net.ecocraft.ecocore.container.slot.ArtisanCraftingSlot;
import net.ecocraft.ecocore.container.TableContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class AnvilContainer extends TableContainer {
    protected World world;
    protected InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    protected IInventory craftResult = new InventoryCraftResult();

    public AnvilContainer(IInventory table, EntityPlayer player) {
        super(table, player);

        for (int i = 0; i < 9; i++) {
            this.craftMatrix.setInventorySlotContents(i, table.getStackInSlot(i));
        }

        int xOff = 36, yOff = 17;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlotToContainer(new Slot(this.craftMatrix, col + row * 3, xOff + col * 18, yOff + row * 18));
                //this.addSlotToContainer(new SlotArtisanTable(player.worldObj, this.craftMatrix, this.craftResult, col + row * 3, xOff + col * 18, yOff + row * 18));
            }
        }

        xOff = 12;
        yOff = 23;
        this.addSlotToContainer(new Slot(this.tableInventory, 10, xOff, yOff));
        this.addSlotToContainer(new Slot(this.tableInventory, 11, xOff, yOff + 24));

        //this.addSlotToContainer(new Slot(this.craftResult, 0, 124, 35));
        this.addSlotToContainer(new ArtisanCraftingSlot(player, this.craftMatrix, this.craftResult, 0, 130, 35));
        this.onCraftMatrixChanged(this.craftMatrix);

        xOff = 8;
        //yOff = 81;
        //for (int i = 0; i < 9; i++)
        //    this.addSlotToContainer(new Slot(this.tableInventory, 10 + i, xOff + i * 18, yOff));

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

    @Override
    public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        int i;
        for (i = 0; i < this.craftMatrix.getSizeInventory(); i++) {
            ItemStack is = this.craftMatrix.removeStackFromSlot(i);
            this.tableInventory.setInventorySlotContents(i, is);
        }
        if (this.craftResult.removeStackFromSlot(0) != null) {
            this.craftResult.removeStackFromSlot(0);
            this.tableInventory.setInventorySlotContents(9, this.craftResult.removeStackFromSlot(0));
        }
        super.onContainerClosed(par1EntityPlayer);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        ItemStack nitem = CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.world);

        //if (nitem != null && nitem.getMaxStackSize() == 1)
        //    SmelteryBlockEntity.setArtisan(this.player.getDisplayNameString(), nitem);

        this.craftResult.setInventorySlotContents(0, nitem);
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

            if (index == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 10 && index < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            } else if (index >= 37 && index < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
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

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack p_94530_1_, Slot p_94530_2_) {
        return p_94530_2_.inventory != this.craftResult && super.canMergeSlot(p_94530_1_, p_94530_2_);
    }
}