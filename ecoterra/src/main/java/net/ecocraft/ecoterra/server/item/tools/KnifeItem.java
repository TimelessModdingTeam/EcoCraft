package net.ecocraft.ecoterra.server.item.tools;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class KnifeItem extends ItemTool {
    private static final Set field_150916_c = Sets.newHashSet(new Block[]{});// {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel,
    //Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    public KnifeItem(ToolMaterial tm) {
        super(3f, tm, field_150916_c);
    }
}
