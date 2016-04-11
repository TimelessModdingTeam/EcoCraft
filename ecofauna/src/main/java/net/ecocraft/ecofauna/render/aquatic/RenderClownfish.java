package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityClownfish;
import net.ecocraft.ecofauna.models.aquatic.Clownfish;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderClownfish extends RenderLiving<EntityClownfish> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Clownfish.png");
	private static final ModelBase modelbase = new Clownfish();
	private static final float shadowsize = 2.0f;

	public RenderClownfish(RenderManager rendermanagerIn) {
		super(rendermanagerIn, modelbase, shadowsize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityClownfish entity) {
		return TEXTURE;
	}
}
