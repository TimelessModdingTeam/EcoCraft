package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Swordfish - Whaleboi Created using Tabula 5.1.0
 */
public class Swordfish extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer LowerJaw1;
	public ModelRenderer Tail1;
	public ModelRenderer Head1;
	public ModelRenderer Pectoral1;
	public ModelRenderer DorsalFin1;
	public ModelRenderer LowerJaw2;
	public ModelRenderer Tail2;
	public ModelRenderer FinThing;
	public ModelRenderer DorsalFin2;
	public ModelRenderer Tail3;
	public ModelRenderer BackFinThing;
	public ModelRenderer Head3;
	public ModelRenderer Head4;
	public ModelRenderer Head5;
	public ModelRenderer Head6;
	public ModelRenderer Pectoral2;

	public Swordfish() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.DorsalFin2 = new ModelRenderer(this, 0, 0);
		this.DorsalFin2.setRotationPoint(0.0F, -1.2F, 6.4F);
		this.DorsalFin2.addBox(0.0F, 0.0F, 0.0F, 0, 2, 1, 0.0F);
		this.setRotateAngle(DorsalFin2, -0.3204424506661589F, 0.0F, 0.0F);
		this.Pectoral2 = new ModelRenderer(this, 15, 10);
		this.Pectoral2.setRotationPoint(-2.4F, 2.7F, 0.9F);
		this.Pectoral2.addBox(-7.7F, 0.0F, -2.5F, 8, 0, 5, 0.0F);
		this.setRotateAngle(Pectoral2, -0.36425021489121656F, 0.31869712141416456F, -1.730144887501979F);
		this.Head1 = new ModelRenderer(this, 0, 72);
		this.Head1.setRotationPoint(0.1F, 2.1F, -4.5F);
		this.Head1.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
		this.setRotateAngle(Head1, 0.36425021489121656F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 0, 82);
		this.Tail1.setRotationPoint(0.0F, 0.6F, 14.2F);
		this.Tail1.addBox(-2.5F, 0.0F, 0.0F, 5, 7, 9, 0.0F);
		this.Tail2 = new ModelRenderer(this, 31, 88);
		this.Tail2.setRotationPoint(0.0F, 0.8F, 8.8F);
		this.Tail2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 6, 0.0F);
		this.Head5 = new ModelRenderer(this, 0, 59);
		this.Head5.setRotationPoint(0.5F, -0.4F, -6.8F);
		this.Head5.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 7, 0.0F);
		this.setRotateAngle(Head5, -0.091106186954104F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 104);
		this.Body.setRotationPoint(0.0F, 14.7F, -8.6F);
		this.Body.addBox(-3.0F, 0.0F, 0.0F, 6, 8, 16, 0.0F);
		this.Pectoral1 = new ModelRenderer(this, -4, 9);
		this.Pectoral1.setRotationPoint(1.9F, 6.0F, 2.1F);
		this.Pectoral1.addBox(0.0F, 0.0F, -2.5F, 8, 0, 5, 0.0F);
		this.setRotateAngle(Pectoral1, -0.136659280431156F, -0.27314402793711257F, 0.8196066167365371F);
		this.Head4 = new ModelRenderer(this, 90, 102);
		this.Head4.setRotationPoint(-0.2F, 0.0F, -1.8F);
		this.Head4.addBox(-2.3F, 0.0F, 0.0F, 5, 3, 13, 0.0F);
		this.BackFinThing = new ModelRenderer(this, 60, 89);
		this.BackFinThing.setRotationPoint(0.0F, 1.5F, 9.6F);
		this.BackFinThing.addBox(0.0F, -7.5F, 0.0F, 0, 15, 9, 0.0F);
		this.Head6 = new ModelRenderer(this, 0, 45);
		this.Head6.setRotationPoint(-0.5F, 0.0F, -9.2F);
		this.Head6.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 11, 0.0F);
		this.setRotateAngle(Head6, -0.045553093477052F, 0.0F, 0.0F);
		this.LowerJaw1 = new ModelRenderer(this, 45, 118);
		this.LowerJaw1.setRotationPoint(0.0F, 3.9F, -2.7F);
		this.LowerJaw1.addBox(-3.0F, 0.0F, -3.0F, 6, 3, 6, 0.0F);
		this.setRotateAngle(LowerJaw1, 0.045553093477052F, 0.0F, 0.0F);
		this.FinThing = new ModelRenderer(this, 5, 102);
		this.FinThing.setRotationPoint(0.0F, 6.6F, 0.8F);
		this.FinThing.addBox(0.0F, 0.0F, 0.0F, 0, 5, 3, 0.0F);
		this.setRotateAngle(FinThing, 0.36425021489121656F, 0.0F, 0.0F);
		this.LowerJaw2 = new ModelRenderer(this, 71, 123);
		this.LowerJaw2.setRotationPoint(0.0F, 1.4F, -2.9F);
		this.LowerJaw2.addBox(-2.0F, 0.0F, -4.0F, 4, 1, 4, 0.0F);
		this.setRotateAngle(LowerJaw2, 0.16493361431346412F, 0.0F, 0.0F);
		this.Tail3 = new ModelRenderer(this, 30, 101);
		this.Tail3.setRotationPoint(0.0F, 0.5F, 0.0F);
		this.Tail3.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 12, 0.0F);
		this.Head3 = new ModelRenderer(this, 0, 22);
		this.Head3.setRotationPoint(0.0F, -1.6F, -4.4F);
		this.Head3.addBox(-1.5F, 0.0F, 0.0F, 3, 1, 5, 0.0F);
		this.setRotateAngle(Head3, -0.24015730507441974F, -0.0F, 0.0F);
		this.DorsalFin1 = new ModelRenderer(this, 0, 26);
		this.DorsalFin1.setRotationPoint(0.0F, 0.0F, 2.3F);
		this.DorsalFin1.addBox(0.0F, -8.0F, 0.0F, 0, 8, 6, 0.0F);
		this.setRotateAngle(DorsalFin1, -0.22759093446006054F, 0.0F, 0.0F);
		this.Tail1.addChild(this.DorsalFin2);
		this.Pectoral1.addChild(this.Pectoral2);
		this.Body.addChild(this.Head1);
		this.Body.addChild(this.Tail1);
		this.Tail1.addChild(this.Tail2);
		this.Head4.addChild(this.Head5);
		this.Body.addChild(this.Pectoral1);
		this.Head3.addChild(this.Head4);
		this.Tail3.addChild(this.BackFinThing);
		this.Head5.addChild(this.Head6);
		this.Body.addChild(this.LowerJaw1);
		this.Tail1.addChild(this.FinThing);
		this.LowerJaw1.addChild(this.LowerJaw2);
		this.Tail2.addChild(this.Tail3);
		this.Head1.addChild(this.Head3);
		this.Body.addChild(this.DorsalFin1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.Body.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
