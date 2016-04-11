package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityArapaima;
import net.ecocraft.ecofauna.entity.aquatic.EntitySockeyeSalmon;
import net.ecocraft.ecofauna.models.aquatic.Arapaima;
import net.ecocraft.ecofauna.models.aquatic.SockeyeSalmon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSockeyeSalmon extends RenderLiving<EntitySockeyeSalmon> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/SockeyeSalmon.png");
    public static final ModelBase model = new SockeyeSalmon();
    public static final float shadowSize = 0.8f;

    public RenderSockeyeSalmon(RenderManager p_i46153_1_) {
        super(p_i46153_1_, model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySockeyeSalmon entity) {
        return TEXTURE;
    }
}
