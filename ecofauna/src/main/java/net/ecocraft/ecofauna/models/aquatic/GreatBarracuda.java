package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * GreatBarracuda - ToteMeistarinn Created using Tabula 5.1.0
 */
public class GreatBarracuda extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape6;
	public ModelRenderer shape10;
	public ModelRenderer shape11;
	public ModelRenderer shape15;
	public ModelRenderer shape16;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape7;
	public ModelRenderer shape8;
	public ModelRenderer shape12;
	public ModelRenderer shape13;
	public ModelRenderer shape9;
	public ModelRenderer shape14;

	public GreatBarracuda() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.shape6 = new ModelRenderer(this, 0, 47);
		this.shape6.setRotationPoint(0.0F, 0.0F, 9.7F);
		this.shape6.addBox(-4.5F, -5.5F, -1.8F, 9, 12, 17, 0.0F);
		this.shape11 = new ModelRenderer(this, 77, 90);
		this.shape11.setRotationPoint(0.0F, -5.9F, -0.5F);
		this.shape11.addBox(0.0F, -10.0F, -3.0F, 0, 11, 13, 0.0F);
		this.setRotateAngle(shape11, -0.18203784098300857F, 0.0F, 0.0F);
		this.shape8 = new ModelRenderer(this, 0, 104);
		this.shape8.setRotationPoint(0.0F, 0.0F, 9.5F);
		this.shape8.addBox(-2.5F, -4.0F, -2.0F, 5, 8, 15, 0.0F);
		this.shape13 = new ModelRenderer(this, 63, 101);
		this.shape13.setRotationPoint(0.0F, 5.0F, 1.7F);
		this.shape13.addBox(0.0F, -2.0F, -2.0F, 0, 12, 14, 0.0F);
		this.setRotateAngle(shape13, 0.31869712141416456F, 0.0F, 0.0F);
		this.shape7 = new ModelRenderer(this, 0, 80);
		this.shape7.setRotationPoint(0.0F, 0.5F, 15.0F);
		this.shape7.addBox(-3.5F, -5.0F, -2.2F, 7, 10, 13, 0.0F);
		this.shape4 = new ModelRenderer(this, 36, 59);
		this.shape4.setRotationPoint(0.0F, 4.1F, -8.3F);
		this.shape4.addBox(-3.5F, -1.5F, -18.0F, 7, 3, 19, 0.0F);
		this.setRotateAngle(shape4, -0.18203784098300857F, 0.0F, 0.0F);
		this.shape9 = new ModelRenderer(this, 41, 110);
		this.shape9.setRotationPoint(0.0F, 0.0F, 11.5F);
		this.shape9.addBox(-1.5F, -5.0F, -1.0F, 3, 10, 7, 0.0F);
		this.shape12 = new ModelRenderer(this, 98, 101);
		this.shape12.setRotationPoint(0.0F, -6.0F, 1.0F);
		this.shape12.addBox(0.0F, -9.0F, -3.0F, 0, 12, 14, 0.0F);
		this.setRotateAngle(shape12, -0.27314402793711257F, 0.0F, 0.0F);
		this.shape2 = new ModelRenderer(this, 85, 0);
		this.shape2.setRotationPoint(0.0F, -0.7F, -11.0F);
		this.shape2.addBox(-4.5F, -5.0F, -10.0F, 9, 11, 12, 0.0F);
		this.setRotateAngle(shape2, 0.091106186954104F, 0.0F, 0.0F);
		this.shape14 = new ModelRenderer(this, 41, 65);
		this.shape14.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.shape14.addBox(0.0F, -13.0F, -3.5F, 0, 26, 17, 0.0F);
		this.shape16 = new ModelRenderer(this, -14, 15);
		this.shape16.setRotationPoint(0.0F, 6.5F, -4.8F);
		this.shape16.addBox(-10.0F, 0.0F, -1.0F, 20, 0, 15, 0.0F);
		this.setRotateAngle(shape16, -0.6829473363053812F, 0.0F, 0.0F);
		this.shape10 = new ModelRenderer(this, 90, 50);
		this.shape10.setRotationPoint(0.0F, 5.0F, -10.0F);
		this.shape10.addBox(-4.0F, -2.0F, -10.0F, 8, 4, 11, 0.0F);
		this.setRotateAngle(shape10, -0.091106186954104F, 0.0F, 0.0F);
		this.shape5 = new ModelRenderer(this, 87, 87);
		this.shape5.setRotationPoint(0.0F, 0.4F, -8.3F);
		this.shape5.addBox(-4.0F, -1.5F, -12.5F, 8, 3, 12, 0.0F);
		this.setRotateAngle(shape5, -0.18203784098300857F, 0.0F, 0.0F);
		this.shape15 = new ModelRenderer(this, -11, 1);
		this.shape15.setRotationPoint(0.0F, 2.5F, -7.3F);
		this.shape15.addBox(-15.0F, 0.0F, -1.0F, 30, 0, 12, 0.0F);
		this.setRotateAngle(shape15, 0.136659280431156F, 0.0F, 0.0F);
		this.shape1 = new ModelRenderer(this, 41, 8);
		this.shape1.setRotationPoint(0.0F, 0.0F, -7.0F);
		this.shape1.addBox(-5.0F, -6.0F, -11.0F, 10, 13, 22, 0.0F);
		this.shape3 = new ModelRenderer(this, 84, 68);
		this.shape3.setRotationPoint(0.0F, -3.2F, -9.0F);
		this.shape3.addBox(-3.5F, -1.5F, -14.4F, 7, 3, 15, 0.0F);
		this.setRotateAngle(shape3, 0.091106186954104F, 0.0F, 0.0F);
		this.shape1.addChild(this.shape6);
		this.shape1.addChild(this.shape11);
		this.shape7.addChild(this.shape8);
		this.shape7.addChild(this.shape13);
		this.shape6.addChild(this.shape7);
		this.shape2.addChild(this.shape4);
		this.shape8.addChild(this.shape9);
		this.shape7.addChild(this.shape12);
		this.shape1.addChild(this.shape2);
		this.shape9.addChild(this.shape14);
		this.shape1.addChild(this.shape16);
		this.shape1.addChild(this.shape10);
		this.shape2.addChild(this.shape5);
		this.shape1.addChild(this.shape15);
		this.shape2.addChild(this.shape3);
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
