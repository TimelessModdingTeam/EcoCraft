package net.ecocraft.ecocore.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class DoubleInventoryGUI extends GuiContainer {
    //Private Fields
    //private static final ResourceLocation field_147017_u = new ResourceLocation("textures/gui/container/generic_54.png");
    protected IInventory upperChestInventory;
    protected IInventory lowerChestInventory;
    protected Container container;
    /**
     * window heighResStart is calculated with these values; the more rows, the heigher
     */
    private int inventoryRows;

    public DoubleInventoryGUI(Container c, IInventory par1IInventory, IInventory par2IInventory) {
        super(c);
        this.container = c;
        this.upperChestInventory = par1IInventory;
        this.lowerChestInventory = par2IInventory;
        this.allowUserInput = false;
        //short short1 = 222;
        //int i = short1 - 108;
        this.inventoryRows = 9;
        this.xSize = 176;
        this.ySize = 222;
    }

    public abstract ResourceLocation getResourceLocation();

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        //this.fontRendererObj.drawString(this.playerInventory.hasCustomInventoryName() ? this.playerInventory.getInventoryName() : I18n.format(this.playerInventory.getInventoryName(), new Object[0]), 8, 6, 4210752);
        //this.fontRendererObj.drawString(this.upperChestInventory.hasCustomInventoryName() ? this.upperChestInventory.getInventoryName() : I18n.format(this.upperChestInventory.getInventoryName(), new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.getResourceLocation());
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
