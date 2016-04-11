package net.ecocraft.ecofauna.render.aquatic;

import net.ecocraft.ecofauna.EcoFauna;
import net.ecocraft.ecofauna.entity.aquatic.EntityCarp;
import net.ecocraft.ecofauna.models.aquatic.Carp;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

    public class RenderCarp extends RenderLiving<EntityCarp> {

        private static final ResourceLocation TEXTURE = new ResourceLocation(EcoFauna.MODID + ":textures/Carp.png");
        private static final ModelBase modelbase = new Carp();
        private static final float shadowsize = 1.0f;

        public RenderCarp(RenderManager rendermanagerIn) {
            super(rendermanagerIn, modelbase, shadowsize);
        }

        @Override
        protected ResourceLocation getEntityTexture(EntityCarp entity) {
            return TEXTURE;
        }
}
