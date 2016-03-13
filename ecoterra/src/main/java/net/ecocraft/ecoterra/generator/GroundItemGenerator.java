package net.ecocraft.ecoterra.generator;

import net.ecocraft.ecocore.registry.helper.ContentObject;
import net.ecocraft.ecoterra.api.EcoTerraAPI;
import net.ecocraft.ecoterra.tileentity.terra.GroundItemBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class GroundItemGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimensionId() == 0) {
            generateSurface(world, random, chunkX, chunkZ);
        }
    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {

        if (random.nextInt(2) != 0) {
            return;
        }

        for (int i = random.nextInt(4) - 1; i >= 1; i--) {
            int locX = chunkX * 16 + random.nextInt(16);
            int locZ = chunkZ * 16 + random.nextInt(16);
            int locY = 64 + random.nextInt(48);
            BlockPos pos = new BlockPos(locX, locY, locZ);
            IBlockState state = world.getBlockState(pos);

            Block b = state.getBlock();
            while (b == Blocks.leaves || b == Blocks.leaves2 || b == Blocks.log || b == Blocks.log2 || b == Blocks.air) {
                pos = pos.down();
                b = world.getBlockState(pos).getBlock();
            }

            if (b == Blocks.grass || b == Blocks.dirt || b == Blocks.sand || b == Blocks.gravel) {
                if (world.getBlockState(pos.up()).getBlock() == Blocks.air) {
                    ItemStack dropStack = EcoTerraAPI.getGroundItem(random);

                    if (dropStack != null) {
                        world.setBlockState(pos.up(), ContentObject.getObjReg("ground_item").getBlock().getDefaultState());
                        GroundItemBlockEntity te = (GroundItemBlockEntity) world.getTileEntity(pos.up());

                        if (te != null) {
                            te.setStack(dropStack);
                            te.setRotation(random.nextInt(360));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
