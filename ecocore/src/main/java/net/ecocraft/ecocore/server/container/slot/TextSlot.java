package net.ecocraft.ecocore.server.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TextSlot extends Slot {
    protected String nullHoverText = "";
    protected ItemStack stackSlotText;

    public TextSlot(IInventory inventoryIn, String nullHoverText, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);

        this.stackSlotText = new ItemStack(new ItemSlotText(nullHoverText));

        this.backgroundName = "iron_block";

    }

    @Override
    public void putStack(ItemStack stack) {
        super.putStack(stack);

        /*if (stack == null)
        {
            super.putStack(stackSlotText);
        }*/
    }

    @Override
    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack) {
        super.onPickupFromSlot(playerIn, stack);

        /*if (this.inventory.getStackInSlot(this.getSlotIndex()) == null)
        {
            super.putStack(stackSlotText);
        }*/
    }

    public boolean canTakeStack(EntityPlayer playerIn) {
        return true;//return this.inventory.getStackInSlot(this.getSlotIndex()) != this.stackSlotText;
    }

    protected class ItemSlotText extends Item {
        protected String message;

        public ItemSlotText(String message) {
            this.message = message;
        }

        public String getItemStackDisplayName(ItemStack stack) {
            return this.message;
        }
    }
}
