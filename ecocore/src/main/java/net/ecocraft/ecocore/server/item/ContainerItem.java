package net.ecocraft.ecocore.server.item;


import net.minecraft.client.gui.Gui;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ContainerItem extends Item {
    public ContainerItem() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public static boolean itemsEqual(ItemStack i1, ItemStack i2) {
        return (i1 == null && i2 == null) || (i1 != null && i2 != null && i1.getItem() == i2.getItem() && i1.getItemDamage() == i2.getItemDamage());
    }

    //GUI Functions
    public boolean hasGui() {
        return false;
    }

    public int containerSize() {
        return 0;
    }

    public Container getContainer(int guiMeta, EntityPlayer player, World world, ItemStack stack, int x, int y, int z) {
        return null;
    }

    public Gui getGui(int guiMeta, EntityPlayer player, World world, ItemStack stack, int x, int y, int z) {
        return null;
    }
}
