package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityArapaima;
import net.ecocraft.ecofauna.entity.aquatic.EntityRedTailCatfish;
import net.ecocraft.ecofauna.models.aquatic.Arapaima;
import net.ecocraft.ecofauna.models.aquatic.RedTailCatfish;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRedTailCatfish extends RenderLiving<EntityRedTailCatfish> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/RedTailCatfish.png");
    public static final ModelBase model = new RedTailCatfish();
    public static final float shadowSize = 0.8f;

    public RenderRedTailCatfish(RenderManager p_i46153_1_) {
        super(p_i46153_1_, model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityRedTailCatfish entity) {
        return TEXTURE;
    }
}
