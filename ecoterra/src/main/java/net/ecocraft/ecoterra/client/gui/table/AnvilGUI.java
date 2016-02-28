package net.ecocraft.ecoterra.client.gui.table;

import net.ecocraft.ecocore.client.gui.DoubleInventoryGUI;
import net.ecocraft.ecoterra.server.container.AnvilContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class AnvilGUI extends DoubleInventoryGUI {
    public static final ResourceLocation resourceLocation = new ResourceLocation("ecoterra:textures/gui/container/artisan_table.png");

    protected String tableName = "Artisan Table";

    public AnvilGUI(String tableName, IInventory table, EntityPlayer player) {
        this(tableName, table, player, false);
    }

    public AnvilGUI(String tableName, IInventory table, EntityPlayer player, boolean hasToolItems) {
        super(new AnvilContainer(table, player), table, player.inventory);

        this.xSize = 176;
        this.ySize = 199;

        if (tableName != null && tableName != "") {
            this.tableName = tableName;
        }

        if (tableName != null && tableName != "") {
            this.tableName = tableName;
        }
    }

    public AnvilGUI(IInventory table, EntityPlayer player) {
        this(null, table, player);
    }

    public ResourceLocation getResourceLocation() {
        return AnvilGUI.resourceLocation;
    }

    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        this.fontRendererObj.drawString(I18n.format(this.tableName), 8, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("Inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
}
