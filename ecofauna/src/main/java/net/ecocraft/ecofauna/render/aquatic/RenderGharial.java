package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityGharial;
import net.ecocraft.ecofauna.models.aquatic.Gharial;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGharial extends RenderLiving<EntityGharial> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Gharial.png");
    private static final ModelBase modelbase = new Gharial();
    private static final float shadowsize = 1.0f;

    public RenderGharial(RenderManager rendermanagerIn) {
        super(rendermanagerIn, modelbase, shadowsize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGharial entity) {
        return TEXTURE;
    }
}