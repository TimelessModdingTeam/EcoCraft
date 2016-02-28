package net.ecocraft.ecoterra.server.block.entity.terra;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class GroundItemBlockEntity extends TileEntity implements ITickable {
    private ItemStack stack;
    private int rotation;

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
//        this.markDirty();
        this.stack = stack;
        //worldObj.markBlockForUpdate(pos);
    }

    public void update() {
        if (this.worldObj.getBlockState(this.getPos().add(0, -1, 0)) == Blocks.air.getDefaultState() && !this.worldObj.isRemote) {
            this.worldObj.setBlockState(this.getPos(), Blocks.air.getDefaultState());
            EntityItem a = new EntityItem(this.worldObj, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), this.getStack());
            this.worldObj.spawnEntityInWorld(a);
        }
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        NBTTagCompound item = new NBTTagCompound();

        if (stack != null) {
            stack.writeToNBT(item);
        }

        nbt.setTag("GroundItemBlock", item);

        nbt.setInteger("Rotation", rotation);
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        NBTTagCompound item = nbt.getCompoundTag("GroundItemBlock");

        stack = ItemStack.loadItemStackFromNBT(item);

        rotation = nbt.getInteger("Rotation");
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound compound = new NBTTagCompound();
        this.writeToNBT(compound);

        return new S35PacketUpdateTileEntity(pos, this.getBlockMetadata(), compound);
    }

    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        NBTTagCompound compound = packet.getNbtCompound();
        this.readFromNBT(compound);
    }


}
