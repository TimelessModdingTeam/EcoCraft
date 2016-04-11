package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityPike;
import net.ecocraft.ecofauna.models.aquatic.Pike;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPike extends RenderLiving<EntityPike> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Pike.png");
    public static final ModelBase model = new Pike();
    public static final float shadowSize = 0.8f;

    public RenderPike(RenderManager p_i46153_1_) {
        super(p_i46153_1_, model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPike entity) {
        return TEXTURE;
    }
}
