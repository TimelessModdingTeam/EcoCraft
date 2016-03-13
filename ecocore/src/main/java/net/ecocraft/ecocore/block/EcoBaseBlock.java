package net.ecocraft.ecocore.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public abstract class EcoBaseBlock extends Block {

    protected int baseExpDrop = 0;

    public EcoBaseBlock(Material m) {
        super(m);
    }

    public Block setExpDrop(int xp) {
        this.baseExpDrop = xp;
        return this;
    }

    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune) {
        return this.baseExpDrop;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }
}
