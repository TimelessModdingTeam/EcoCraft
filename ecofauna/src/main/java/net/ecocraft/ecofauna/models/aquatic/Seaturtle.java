package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Sea turtle - Totemaster Created using Tabula 5.1.0
 */
public class Seaturtle extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape4;
	public ModelRenderer shape10;
	public ModelRenderer shape11;
	public ModelRenderer shape12;
	public ModelRenderer shape13;
	public ModelRenderer shape3;
	public ModelRenderer shape16;
	public ModelRenderer shape17;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;
	public ModelRenderer shape9;
	public ModelRenderer shape8;
	public ModelRenderer shape14;
	public ModelRenderer shape15;

	public Seaturtle() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.shape4 = new ModelRenderer(this, 0, 0);
		this.shape4.setRotationPoint(0.0F, -1.0F, -10.5F);
		this.shape4.addBox(-4.0F, -3.0F, -7.5F, 8, 7, 9, 0.0F);
		this.shape12 = new ModelRenderer(this, 40, 74);
		this.shape12.setRotationPoint(5.5F, 0.5F, 14.0F);
		this.shape12.addBox(-3.5F, -2.0F, -3.0F, 7, 4, 13, 0.0F);
		this.setRotateAngle(shape12, -0.136659280431156F, 0.22759093446006054F, 0.4553564018453205F);
		this.shape16 = new ModelRenderer(this, 0, 40);
		this.shape16.setRotationPoint(0.0F, 1.0F, 13.1F);
		this.shape16.addBox(-0.9F, -1.0F, -0.5F, 2, 2, 7, 0.0F);
		this.setRotateAngle(shape16, -0.22759093446006054F, 0.0F, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 25);
		this.shape9.setRotationPoint(0.0F, 2.5F, -3.5F);
		this.shape9.addBox(-2.5F, -1.0F, -6.5F, 5, 2, 7, 0.0F);
		this.setRotateAngle(shape9, -0.091106186954104F, 0.0F, 0.0F);
		this.shape14 = new ModelRenderer(this, 0, 72);
		this.shape14.setRotationPoint(0.0F, -0.1F, -7.5F);
		this.shape14.addBox(-3.0F, -1.5F, -1.5F, 9, 3, 20, 0.0F);
		this.setRotateAngle(shape14, -0.18203784098300857F, -2.0943951023931953F, 0.0F);
		this.shape3 = new ModelRenderer(this, 70, 29);
		this.shape3.setRotationPoint(0.0F, -4.0F, -1.0F);
		this.shape3.addBox(-6.0F, -2.0F, -8.0F, 12, 14, 17, 0.0F);
		this.shape5 = new ModelRenderer(this, 90, 110);
		this.shape5.setRotationPoint(0.0F, -0.1F, -7.0F);
		this.shape5.addBox(-3.0F, -2.5F, -5.5F, 6, 6, 6, 0.0F);
		this.shape7 = new ModelRenderer(this, 90, 77);
		this.shape7.setRotationPoint(0.0F, -0.1F, -5.0F);
		this.shape7.addBox(-3.0F, -3.5F, -6.0F, 6, 5, 8, 0.0F);
		this.setRotateAngle(shape7, 0.18203784098300857F, 0.0F, 0.0F);
		this.shape10 = new ModelRenderer(this, 91, 0);
		this.shape10.setRotationPoint(-7.0F, 0.3F, -10.0F);
		this.shape10.addBox(-3.5F, -2.5F, -9.0F, 7, 5, 11, 0.0F);
		this.setRotateAngle(shape10, 0.0F, 0.5918411493512771F, 0.0F);
		this.shape13 = new ModelRenderer(this, 40, 98);
		this.shape13.setRotationPoint(-5.5F, 0.5F, 14.0F);
		this.shape13.addBox(-3.5F, -2.0F, -3.0F, 7, 4, 13, 0.0F);
		this.setRotateAngle(shape13, -0.136659280431156F, -0.22759093446006054F, -0.4553564018453205F);
		this.shape1 = new ModelRenderer(this, 20, 0);
		this.shape1.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.shape1.addBox(-12.5F, -4.0F, -10.0F, 25, 7, 20, 0.0F);
		this.shape8 = new ModelRenderer(this, 0, 50);
		this.shape8.setRotationPoint(0.0F, -2.0F, -1.4F);
		this.shape8.addBox(-4.5F, -2.0F, -2.0F, 9, 4, 4, 0.0F);
		this.setRotateAngle(shape8, 0.136659280431156F, 0.0F, 0.0F);
		this.shape6 = new ModelRenderer(this, 90, 92);
		this.shape6.setRotationPoint(0.0F, 0.6F, -5.5F);
		this.shape6.addBox(-4.0F, -4.0F, -6.0F, 8, 7, 7, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 35);
		this.shape2.setRotationPoint(0.0F, -2.7F, -0.5F);
		this.shape2.addBox(-9.5F, -4.0F, -12.0F, 19, 11, 26, 0.0F);
		this.shape11 = new ModelRenderer(this, 91, 0);
		this.shape11.setRotationPoint(7.0F, 0.3F, -10.0F);
		this.shape11.addBox(-3.5F, -2.5F, -9.0F, 7, 5, 11, 0.0F);
		this.setRotateAngle(shape11, 0.0F, -0.5918411493512771F, 0.0F);
		this.shape17 = new ModelRenderer(this, 85, 66);
		this.shape17.setRotationPoint(0.0F, -2.3F, 12.0F);
		this.shape17.addBox(-4.5F, -1.5F, -0.5F, 9, 3, 7, 0.0F);
		this.setRotateAngle(shape17, -0.31869712141416456F, 0.0F, 0.0F);
		this.shape15 = new ModelRenderer(this, 0, 96);
		this.shape15.setRotationPoint(0.0F, -0.1F, -7.5F);
		this.shape15.addBox(-6.0F, -1.5F, -1.5F, 9, 3, 20, 0.0F);
		this.setRotateAngle(shape15, -0.18203784098300857F, 2.0943951023931953F, 0.0F);
		this.shape1.addChild(this.shape4);
		this.shape1.addChild(this.shape12);
		this.shape2.addChild(this.shape16);
		this.shape6.addChild(this.shape9);
		this.shape10.addChild(this.shape14);
		this.shape2.addChild(this.shape3);
		this.shape4.addChild(this.shape5);
		this.shape6.addChild(this.shape7);
		this.shape1.addChild(this.shape10);
		this.shape1.addChild(this.shape13);
		this.shape7.addChild(this.shape8);
		this.shape5.addChild(this.shape6);
		this.shape1.addChild(this.shape2);
		this.shape1.addChild(this.shape11);
		this.shape2.addChild(this.shape17);
		this.shape11.addChild(this.shape15);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.shape1.render(f5);
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
