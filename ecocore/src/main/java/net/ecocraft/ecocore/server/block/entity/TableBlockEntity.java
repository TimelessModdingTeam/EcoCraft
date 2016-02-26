package net.ecocraft.ecocore.server.block.entity;

import net.ecocraft.ecocore.server.registry.EcoRegistry;
import net.ecocraft.ecocore.server.block.BlockPosHelper;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public abstract class TableBlockEntity extends TileEntity implements IInventory, ITickable {
    protected int tickCount = 0, updateWait = 60, inventorySize = 0;
    protected ItemStack[] chestContents;// = new ItemStack[0];
    protected String myOwner = "", customName;
    protected IInventory repository = null;
    protected BlockPos repositoryPos = null;
    //Fields
    private int numPlayersUsing = 0;

    //Constructor
    public TableBlockEntity(int inventorySize) {
        super();

        this.inventorySize = inventorySize + 1;
        this.chestContents = new ItemStack[this.inventorySize];
    }

    public IInventory getRepository() {
        return this.repository;
    }

    public BlockPos getRepositoryPos() {
        return this.repositoryPos;
    }

    public String getOwner() {
        return this.myOwner;
    }

    public void setOwner(String owner) {
        this.myOwner = owner;
    }

    //GUI Functions
    public abstract Container getContainer(int guiMeta, EntityPlayer player, World world, TileEntity te, int x, int y, int z);

    public abstract Gui getGui(int guiMeta, EntityPlayer player, World world, TileEntity te, int x, int y, int z);

    //Functions
    public void update() {
        //Handle AI Tick Delay
        if (this.tickCount > this.updateWait) {
            this.tickCount = -20 - EcoRegistry.random.nextInt(40);
        } else {
            this.tickCount++;
            return;
        }

        this.repositoryPos = this.findNeighborChest(new ArrayList<BlockPos>(), this.pos);

        if (this.repositoryPos != null) {
            this.repository = (IInventory) worldObj.getTileEntity(this.repositoryPos);
        }

        this.updatePostEntity();
    }

    public void updatePostEntity() {

    }

    public BlockPos findNeighborChest(List<BlockPos> prevPos, BlockPos p) {
        for (int x = -1; x < 2; x++) {
            for (int z = -1; z < 2; z++) {
                if (x == 0 && z == 0) {
                    continue;
                }

                TileEntity te = this.worldObj.getTileEntity(p.add(x, 0, z));

                if (te == null) {
                    continue;
                }

                if (!TileEntityChest.class.isInstance(te)) {
                    continue;
                }

                return p.add(x, 0, z);
            }
        }

        for (int x = -1; x < 2; x++) {
            for (int z = -1; z < 2; z++) {
                if (x == 0 && z == 0) {
                    continue;
                }

                TileEntity te = this.worldObj.getTileEntity(p.add(x, 0, z));

                if (te == null) {
                    continue;
                }

                if (!TableBlockEntity.class.isInstance(te)) {
                    continue;
                }

                boolean cont = false;
                for (int i = 0; i < prevPos.size(); i++) {
                    if (BlockPosHelper.blocksAreEqual(prevPos.get(i), te.getPos())) {
                        cont = true;
                        break;
                    }
                }

                if (cont) {
                    continue;
                }

                prevPos.add(te.getPos());
                this.findNeighborChest(prevPos, te.getPos());
                //return (IInventory)te;
            }
        }

        return null;
    }

    //Packet Functions
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new S35PacketUpdateTileEntity(this.pos, 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.getNbtCompound());
    }

    //NBT Functions
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        //Merchant NBT
        nbt.setString("owner", this.myOwner);

        //Storage NBT
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; this.chestContents != null && i < this.chestContents.length; ++i) {
            if (this.chestContents[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.chestContents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbt.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName()) {
            nbt.setString("CustomName", this.customName);
        }

        super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        //Merchant NBT
        this.myOwner = nbt.getString("owner");

        //Storage NBT
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.chestContents = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.chestContents.length) {
                this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        if (nbt.hasKey("CustomName", 8)) {
            this.customName = nbt.getString("CustomName");
        }
    }

    //Nameable Functions
    public int getField(int id) {
        return 0;
    }

    public void setField(int id, int value) {
    }

    public int getFieldCount() {
        return 0;
    }

    public IChatComponent getDisplayName() {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
    }

    public boolean hasCustomName() {
        return false;
    }

    public String getName() {
        return this.hasCustomName() ? this.customName : "container.post";
    }

    //Storage Functions
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
        BlockPos p = this.pos;
        return this.worldObj.getTileEntity(this.pos) != this ? false : par1EntityPlayer.getDistanceSq((double) p.getX() + 0.5D, (double) p.getY() + 0.5D, (double) p.getZ() + 0.5D) <= 64.0D;
    }

    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
        return true;
    }

    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    public int getSizeInventory() {
        return this.inventorySize;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public ItemStack getStackInSlot(int par1) {
        if (par1 >= this.chestContents.length) {
            return null;
        }

        return this.chestContents[par1];
    }

    public ItemStack removeStackFromSlot(int par1) {
        if (this.chestContents[par1] != null) {
            ItemStack itemstack = this.chestContents[par1];
            this.chestContents[par1] = null;
            return itemstack;
        } else {
            return null;
        }
    }

    public ItemStack decrStackSize(int par1, int par2) {
        if (this.chestContents[par1] != null) {
            ItemStack itemstack;

            if (this.chestContents[par1].stackSize <= par2) {
                itemstack = this.chestContents[par1];
                this.chestContents[par1] = null;
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.chestContents[par1].splitStack(par2);

                if (this.chestContents[par1].stackSize == 0) {
                    this.chestContents[par1] = null;
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        this.chestContents[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();

    }

    public void openInventory(EntityPlayer player) {
        if (this.numPlayersUsing < 0) {
            this.numPlayersUsing = 0;
        }

        ++this.numPlayersUsing;
        BlockPos p = this.pos, pl = this.pos;
        pl.add(0, -1, 0);
        this.worldObj.addBlockEvent(p, this.getBlockType(), 1, this.numPlayersUsing);
        this.worldObj.notifyNeighborsOfStateChange(p, this.getBlockType());
        this.worldObj.notifyNeighborsOfStateChange(pl, this.getBlockType());
    }

    public void closeInventory(EntityPlayer player) {
        //if (this.getBlockType() instanceof ShopPost)
        {
            --this.numPlayersUsing;
            BlockPos p = this.pos, pl = this.pos;
            pl.add(0, -1, 0);
            this.worldObj.addBlockEvent(p, this.getBlockType(), 1, this.numPlayersUsing);
            this.worldObj.notifyNeighborsOfStateChange(p, this.getBlockType());
            this.worldObj.notifyNeighborsOfStateChange(pl, this.getBlockType());

            if (this.worldObj.isRemote) {
                //NBTTagCompound nbtTag = new NBTTagCompound();
                //this.writeToNBT(nbtTag);
                //CivMod.network.sendToServer(new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag));
            }

        }
    }

    public void clear() {
        for (int i = 0; i < this.chestContents.length; ++i) {
            this.chestContents[i] = null;
        }
    }

}
