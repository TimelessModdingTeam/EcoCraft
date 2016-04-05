package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityArapaima;
import net.ecocraft.ecofauna.models.aquatic.Arapaima;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArapaima extends RenderLiving<EntityArapaima> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Arapaima.png");
	public static final ModelBase model = new Arapaima();
	public static final float shadowSize = 0.8f;

	public RenderArapaima(RenderManager p_i46153_1_) {
		super(p_i46153_1_, model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityArapaima entity) {
		return TEXTURE;
	}

}
