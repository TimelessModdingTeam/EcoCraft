package net.ecocraft.ecoterra.server.item.tools;

import com.google.common.collect.Sets;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class HammerItem extends ItemTool {
    private static final Set field_150916_c = Sets.newHashSet(Blocks.cobblestone);/*/, Blocks.double_stone_slab,
            Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone,
            Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore,
            Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore,
            Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore);*/

    public HammerItem(ToolMaterial tm) {
        super(1f, tm, field_150916_c);
    }

}
