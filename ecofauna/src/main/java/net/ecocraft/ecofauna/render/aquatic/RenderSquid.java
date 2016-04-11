package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntitySquid;
import net.ecocraft.ecofauna.models.aquatic.Squid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSquid extends RenderLiving<EntitySquid> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Squid.png");
    private static final ModelBase modelbase = new Squid();
    private static final float shadowsize = 1.0f;

    public RenderSquid(RenderManager rendermanagerIn) {
        super(rendermanagerIn, modelbase, shadowsize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySquid entity) {
        return TEXTURE;
    }
}