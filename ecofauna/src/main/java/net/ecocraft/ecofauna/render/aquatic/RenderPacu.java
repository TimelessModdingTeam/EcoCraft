package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityPacu;
import net.ecocraft.ecofauna.models.aquatic.Pacu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPacu extends RenderLiving<EntityPacu> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Pacu.png");
    public static final ModelBase model = new Pacu();
    public static final float shadowSize = 0.8f;

    public RenderPacu(RenderManager p_i46153_1_) {
        super(p_i46153_1_, model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPacu entity) {
        return TEXTURE;
    }
}
