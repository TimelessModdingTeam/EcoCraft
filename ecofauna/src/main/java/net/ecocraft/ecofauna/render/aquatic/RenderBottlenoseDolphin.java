package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityBottlenoseDolphin;
import net.ecocraft.ecofauna.models.aquatic.BottlenoseDolphin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBottlenoseDolphin extends RenderLiving<EntityBottlenoseDolphin> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(
			EcoFauna.MODID + ":textures/BottlenoseDolphin.png");
	private static final ModelBase modelbase = new BottlenoseDolphin();
	private static final float shadowsize = 2.0f;

	public RenderBottlenoseDolphin(RenderManager rendermanagerIn) {
		super(rendermanagerIn, modelbase, shadowsize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBottlenoseDolphin entity) {
		return TEXTURE;
	}

}
