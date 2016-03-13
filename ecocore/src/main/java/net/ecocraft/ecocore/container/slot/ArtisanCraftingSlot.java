package net.ecocraft.ecocore.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ArtisanCraftingSlot extends SlotCrafting {
    /**
     * The craft matrix inventory linked to this result slot.
     */
    private final InventoryCrafting craftMatrix;
    /**
     * The player that is using the GUI where this slot resides.
     */
    private final EntityPlayer thePlayer;
    /**
     * The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset.
     */
    private int amountCrafted;

    public ArtisanCraftingSlot(EntityPlayer player, InventoryCrafting craftingInventory, IInventory p_i45790_3_, int slotIndex, int xPosition, int yPosition) {
        super(player, craftingInventory, p_i45790_3_, slotIndex, xPosition, yPosition);
        this.thePlayer = player;
        this.craftMatrix = craftingInventory;
    }

    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack) {
        net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerCraftingEvent(playerIn, stack, craftMatrix);
        this.onCrafting(stack);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(playerIn);
        ItemStack[] aitemstack = CraftingManager.getInstance().func_180303_b(this.craftMatrix, playerIn.worldObj);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);

        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("recipe_retain")) {
            stack.getTagCompound().removeTag("recipe_retain");
            for (int i = 0; i < this.craftMatrix.getSizeInventory(); i++) {
                if (ItemStack.areItemsEqual(this.craftMatrix.getStackInSlot(i), stack)) {
                    this.craftMatrix.setInventorySlotContents(i, null);
                    return;
                }
            }
        }

        for (int i = 0; i < aitemstack.length; ++i) {
            ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);
            ItemStack itemstack2 = aitemstack[i];

            if (itemstack1 != null) {
                this.craftMatrix.decrStackSize(i, 1);
            }

            if (itemstack2 != null) {
                if (this.craftMatrix.getStackInSlot(i) == null) {
                    this.craftMatrix.setInventorySlotContents(i, itemstack2);
                } else if (!this.thePlayer.inventory.addItemStackToInventory(itemstack2)) {
                    this.thePlayer.dropPlayerItemWithRandomChoice(itemstack2, false);
                }
            }
        }
    }
}
