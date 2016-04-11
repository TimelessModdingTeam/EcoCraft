package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityCommonOctopus;
import net.ecocraft.ecofauna.models.aquatic.CommonOctopus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCommonOctopus extends RenderLiving<EntityCommonOctopus> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(
			EcoFauna.MODID + ":textures/CommonOctopus.png");
	private static final ModelBase modelbase = new CommonOctopus();
	private static final float shadowsize = 2.0f;

	public RenderCommonOctopus(RenderManager renderManager) {
		super(renderManager, modelbase, shadowsize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCommonOctopus entity) {
		return TEXTURE;
	}
}
