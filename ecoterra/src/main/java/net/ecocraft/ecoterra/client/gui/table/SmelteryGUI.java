package net.ecocraft.ecoterra.client.gui.table;

import net.ecocraft.ecocore.client.gui.DoubleInventoryGUI;
import net.ecocraft.ecoterra.EcoTerra;
import net.ecocraft.ecoterra.server.container.SmelteryContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

public class SmelteryGUI extends DoubleInventoryGUI {
    public static final ResourceLocation resourceLocation = new ResourceLocation(EcoTerra.MODID, "textures/gui/container/smeltery.png");

    public IInventory tileFurnace, playerInventory;

    public SmelteryGUI(IInventory table, EntityPlayer player) {
        super(new SmelteryContainer(table, player), table, player.inventory);

        this.tileFurnace = table;
        this.playerInventory = player.inventory;

        this.xSize = 176;
        this.ySize = 166;
    }

    public ResourceLocation getResourceLocation() {
        return SmelteryGUI.resourceLocation;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = "Smeltery";
        this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resourceLocation);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (TileEntityFurnace.isBurning(this.tileFurnace)) {
            i1 = (int) this.func_175382_i(13);
            this.drawTexturedModalRect(k + 47, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
        }

        i1 = this.func_175381_h(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }

    private int func_175381_h(int p_175381_1_) {
        int j = this.tileFurnace.getField(2);
        int k = this.tileFurnace.getField(3);
        return k != 0 && j != 0 ? j * p_175381_1_ / k : 0;
    }

    private double func_175382_i(int p_175382_1_) {
        int j = this.tileFurnace.getField(1);

        if (j == 0) {
            j = 200;
        }

        return this.tileFurnace.getField(0) * (1.0 * p_175382_1_) / (1.0 * j);
    }
}
