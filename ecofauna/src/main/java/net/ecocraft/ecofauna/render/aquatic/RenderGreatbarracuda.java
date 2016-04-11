package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityGreatBarracuda;
import net.ecocraft.ecofauna.models.aquatic.GreatBarracuda;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGreatbarracuda extends RenderLiving<EntityGreatBarracuda> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Greatbarracuda.png");
    public static final ModelBase model = new GreatBarracuda();
    public static final float shadowSize = 0.8f;

    public RenderGreatbarracuda(RenderManager p_i46153_1_) {
        super(p_i46153_1_, model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGreatBarracuda entity) {
        return TEXTURE;
    }
}
