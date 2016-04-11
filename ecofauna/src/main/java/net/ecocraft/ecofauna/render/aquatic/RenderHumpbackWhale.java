package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityHumpbackWhale;
import net.ecocraft.ecofauna.models.aquatic.HumpbackWhale;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHumpbackWhale extends RenderLiving<EntityHumpbackWhale> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/HumpbackWhale.png");
    public static final ModelBase model = new HumpbackWhale();
    public static final float shadowSize = 0.8f;

    public RenderHumpbackWhale(RenderManager p_i46153_1_) {
        super(p_i46153_1_, model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHumpbackWhale entity) {
        return TEXTURE;
    }
}
