package net.ecocraft.ecocore.server.block;

import net.ecocraft.ecocore.server.registry.EcoRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

import java.util.List;

public class BlockPosHelper {
    public static BlockPos getRandomPos(BlockPos p, int dXZ, int dY) {
        return new BlockPos(p.getX() + EcoRegistry.random.nextInt(dXZ * 2) - dXZ, p.getY() + EcoRegistry.random.nextInt(dY * 2) - dY, p.getZ() + EcoRegistry.random.nextInt(dXZ * 2) - dXZ);
    }

    public static BlockPos getRandomPos(BlockPos p, int dXZ, int dY, BlockPosConditions bpc) {
        if (bpc == BlockPosConditions.IncludeYPositiveOnly) {
            return new BlockPos(p.getX() + EcoRegistry.random.nextInt(dXZ * 2) - dXZ, p.getY() + EcoRegistry.random.nextInt(dY), p.getZ() + EcoRegistry.random.nextInt(dXZ * 2) - dXZ);
        }

        return BlockPosHelper.getRandomPos(p, dXZ, dY);
    }

    public static boolean blocksAreEqual(BlockPos p1, BlockPos p2) {
        return (p1.getX() == p2.getX() && p1.getY() == p2.getY() && p1.getZ() == p2.getZ());
    }

    public static boolean blocksAreEqual(BlockPos p1, NBTTagCompound nbt, String name) {
        BlockPos p2 = BlockPosHelper.readBlockPosFromNbt(nbt, name);
        return BlockPosHelper.blocksAreEqual(p1, p2);
    }

    public static boolean blocksAreEqual(BlockPos p1, List<BlockPos> bps) {
        for (BlockPos bp : bps) {
            if (BlockPosHelper.blocksAreEqual(bp, p1)) {
                return false;
            }
        }

        return true;
    }

    public static String getBlockPosString(BlockPos p) {
        return "" + p.getX() + ", " + p.getY() + ", " + p.getZ();
    }

    public static boolean hasKey(NBTTagCompound nbt, String name) {
        return nbt.hasKey(name + "X");
    }

    public static BlockPos readBlockPosFromNbt(NBTTagCompound nbt, String name) {
        int x = nbt.getInteger(name + "X");
        int y = nbt.getInteger(name + "Y");
        int z = nbt.getInteger(name + "Z");

        return new BlockPos(x, y, z);
    }

    public static void writeBlockPosToNbt(NBTTagCompound nbt, String name, BlockPos pos) {
        nbt.setInteger(name + "X", pos.getX());
        nbt.setInteger(name + "Y", pos.getY());
        nbt.setInteger(name + "Z", pos.getZ());
    }

    public static boolean isWithinDistance(BlockPos pi, BlockPos pd, double dist) {
        double dx = pi.getX() - pd.getX();
        double dy = pi.getY() - pd.getY();
        double dz = pi.getZ() - pd.getZ();

        return dx * dx + dy * dy + dz * dz <= dist * dist;

    }

    public static boolean isWithinDistance(BlockPos pi, BlockPos pd, double dist, boolean excludeY) {
        double dx = pi.getX() - pd.getX();
        double dy = pi.getY() - pd.getY();
        double dz = pi.getZ() - pd.getZ();

        if (excludeY) {
            dy = 0;
        }

        return dx * dx + dy * dy + dz * dz <= dist * dist;

    }

    public static boolean isWithinDistance(BlockPos pi, double pdx, double pdy, double pdz, double dist, boolean excludeY) {
        double dx = pi.getX() - pdx;
        double dy = pi.getY() - pdy;
        double dz = pi.getZ() - pdz;

        if (excludeY) {
            dy = 0;
        }

        return dx * dx + dy * dy + dz * dz <= dist * dist;

    }

    public static boolean isWithinDistance(double x1, double y1, double z1, double x2, double y2, double z2, double dist, boolean excludeY) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        double dz = z1 - z2;

        if (excludeY) {
            dy = 0;
        }

        return dx * dx + dy * dy + dz * dz <= dist * dist;

    }

    public static double distance(BlockPos p1, BlockPos p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        double dz = p1.getZ() - p2.getZ();

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double distance(double p1x, double p1y, double p1z, int p2x, int p2y, int p2z) {
        double dx = p1x - p2x;
        double dy = p1y - p2y;
        double dz = p1z - p2z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double distance(int p1x, int p1y, int p1z, int p2x, int p2y, int p2z) {
        double dx = p1x - p2x;
        double dy = p1y - p2y;
        double dz = p1z - p2z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public enum BlockPosConditions {ExcludeY, IncludeYPositiveOnly}
}
