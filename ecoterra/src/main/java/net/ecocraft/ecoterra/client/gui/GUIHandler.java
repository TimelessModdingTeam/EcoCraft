package net.ecocraft.ecoterra.client.gui;

import net.ecocraft.ecocore.server.block.entity.TableBlockEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int guiMeta, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        ItemStack heldItem = player.getHeldItem();

        //if (te == null && heldItem != null && heldItem.getItem() instanceof BaseItem && ((BaseItem) heldItem.getItem()).hasGui())
        //    return ((BaseItem) heldItem.getItem()).getContainer(guiMeta, player, world, heldItem, x, y, z);

        /*if (!ItemLock.validILockableCheck(te, player))
        {
            if (((TableBlockEntity)te).getOwner() == player.getDisplayNameString())
            player.addChatMessage(new ChatComponentTranslation("Block is locked."));
            return null;
        }

        if (te instanceof TableBlockEntity && player.getHeldItem() != null && heldItem.getItem() instanceof IItemLockable)
            return new ContainerLock((TableBlockEntity) te, player);*/

        if (te instanceof TableBlockEntity) {
            return ((TableBlockEntity) te).getContainer(guiMeta, player, world, te, x, y, z);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int guiMeta, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        ItemStack heldItem = player.getHeldItem();

        /*if (te == null && heldItem != null && heldItem.getItem() instanceof BaseItem && ((BaseItem) heldItem.getItem()).hasGui())
            return ((BaseItem) heldItem.getItem()).getGui(guiMeta, player, world, heldItem, x, y, z);

        if (te instanceof TableBlockEntity && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof IItemLockable)
            return new GuiLock((TableBlockEntity) te, player);*/

        if (te instanceof TableBlockEntity) {
            return ((TableBlockEntity) te).getGui(guiMeta, player, world, te, x, y, z);
        }

        return null;
    }
}