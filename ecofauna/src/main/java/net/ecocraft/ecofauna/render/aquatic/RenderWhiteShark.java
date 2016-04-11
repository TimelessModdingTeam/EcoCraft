package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityArapaima;
import net.ecocraft.ecofauna.entity.aquatic.EntityWhiteShark;
import net.ecocraft.ecofauna.models.aquatic.Arapaima;
import net.ecocraft.ecofauna.models.aquatic.WhiteShark;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWhiteShark extends RenderLiving<EntityWhiteShark> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/WhiteShark.png");
    public static final ModelBase model = new WhiteShark();
    public static final float shadowSize = 0.8f;

    public RenderWhiteShark(RenderManager p_i46153_1_) {
        super(p_i46153_1_, model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWhiteShark entity) {
        return TEXTURE;
    }
}
