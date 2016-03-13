package net.ecocraft.ecoterra.block.terra;

import net.ecocraft.ecoterra.tileentity.terra.GroundItemBlockEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class GroundItemBlock extends BlockContainer {
    public GroundItemBlock() {
        super(Material.wood);
        this.setUnlocalizedName("block_item");
        this.setHardness(0.0F);
        this.setResistance(0.0F);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.1F, 0.9F);
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te) {
        //player.triggerAchievement(StatList.mineBlockStatArray[getIdFromBlock(this)]);
        player.addExhaustion(0.025F);

        java.util.ArrayList<ItemStack> items = new java.util.ArrayList<ItemStack>();

        GroundItemBlockEntity tile = (GroundItemBlockEntity) te;

        items.add(tile.getStack());

        for (ItemStack stack : items) {
            worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), stack.copy()));
        }
    }


    /**
     * Called when a user uses the creative pick block button on this block
     *
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
     */
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
        GroundItemBlockEntity te = (GroundItemBlockEntity) world.getTileEntity(pos);

        return te.getStack();
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new GroundItemBlockEntity();
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
