package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Pacu - ma_rio11 Created using Tabula 5.1.0
 */
public class Pacu extends ModelBase {
	public ModelRenderer Body1;
	public ModelRenderer Mouth;
	public ModelRenderer Body2;
	public ModelRenderer Body3;
	public ModelRenderer Body4;
	public ModelRenderer RightPectoralFin;
	public ModelRenderer LeftPectoralFin;
	public ModelRenderer Head1;
	public ModelRenderer Tail1;
	public ModelRenderer shape26;
	public ModelRenderer shape31;
	public ModelRenderer shape32;
	public ModelRenderer shape33;
	public ModelRenderer shape34;
	public ModelRenderer shape35;
	public ModelRenderer shape38;
	public ModelRenderer shape39;
	public ModelRenderer DorsalFin;
	public ModelRenderer shape36;
	public ModelRenderer shape37;
	public ModelRenderer Head2;
	public ModelRenderer Tail2;
	public ModelRenderer AnalFin;
	public ModelRenderer Tail3;
	public ModelRenderer shape27;
	public ModelRenderer shape30;

	public Pacu() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.shape34 = new ModelRenderer(this, 0, 78);
		this.shape34.setRotationPoint(0.0F, 0.0F, 0.6F);
		this.shape34.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
		this.setRotateAngle(shape34, -0.091106186954104F, 0.0F, 0.0F);
		this.Body2 = new ModelRenderer(this, 2, 42);
		this.Body2.setRotationPoint(0.0F, -2.2F, 0.6F);
		this.Body2.addBox(-2.0F, -4.0F, -5.0F, 4, 5, 2, 0.0F);
		this.setRotateAngle(Body2, 0.40980330836826856F, -0.0F, 0.0F);
		this.shape31 = new ModelRenderer(this, 0, 52);
		this.shape31.setRotationPoint(0.0F, -4.0F, -3.0F);
		this.shape31.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 1, 0.0F);
		this.setRotateAngle(shape31, -0.091106186954104F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 39, 38);
		this.Tail1.setRotationPoint(0.0F, -1.3F, 9.0F);
		this.Tail1.addBox(-1.5F, -2.53F, 0.0F, 3, 5, 4, 0.0F);
		this.shape36 = new ModelRenderer(this, 0, 93);
		this.shape36.setRotationPoint(0.5F, -2.0F, 1.0F);
		this.shape36.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
		this.setRotateAngle(shape36, -0.091106186954104F, 0.0F, 0.0F);
		this.Head2 = new ModelRenderer(this, 0, 12);
		this.Head2.setRotationPoint(-0.5F, 0.1F, -1.4F);
		this.Head2.addBox(-1.5F, 0.0F, -4.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(Head2, -0.8651597102135892F, -0.0F, 0.0F);
		this.AnalFin = new ModelRenderer(this, 64, 48);
		this.AnalFin.setRotationPoint(0.0F, 2.3F, 3.5F);
		this.AnalFin.addBox(0.0F, -1.0F, -1.0F, 0, 7, 4, 0.0F);
		this.setRotateAngle(AnalFin, -1.1383037381507017F, -0.0F, 0.0F);
		this.DorsalFin = new ModelRenderer(this, 67, 16);
		this.DorsalFin.setRotationPoint(0.5F, -4.0F, -1.1F);
		this.DorsalFin.addBox(0.0F, -2.0F, 0.0F, 0, 4, 5, 0.0F);
		this.setRotateAngle(DorsalFin, -0.27314402793711257F, -0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 67, 39);
		this.Tail2.setRotationPoint(0.0F, -1.0F, 3.5F);
		this.Tail2.addBox(-1.0F, -1.0F, 0.0F, 2, 4, 3, 0.0F);
		this.Body1 = new ModelRenderer(this, 23, 8);
		this.Body1.setRotationPoint(-0.1F, 17.8F, -2.0F);
		this.Body1.addBox(-2.5F, -4.2F, -2.0F, 5, 6, 12, 0.0F);
		this.RightPectoralFin = new ModelRenderer(this, 30, 36);
		this.RightPectoralFin.setRotationPoint(-2.4F, 1.0F, -1.0F);
		this.RightPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F);
		this.setRotateAngle(RightPectoralFin, 0.296705972839036F, -0.12217304763960307F, 0.0F);
		this.shape37 = new ModelRenderer(this, 0, 101);
		this.shape37.setRotationPoint(0.0F, 0.0F, 1.6F);
		this.shape37.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
		this.setRotateAngle(shape37, -0.136659280431156F, 0.0F, 0.0F);
		this.shape26 = new ModelRenderer(this, 58, 3);
		this.shape26.setRotationPoint(-0.1F, 1.0F, 1.1F);
		this.shape26.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 7, 0.0F);
		this.Body3 = new ModelRenderer(this, 52, 28);
		this.Body3.setRotationPoint(0.0F, 0.5F, 0.3F);
		this.Body3.addBox(-1.5F, 0.33F, -5.6F, 3, 4, 3, 0.0F);
		this.setRotateAngle(Body3, -0.4553564018453205F, -0.0F, 0.0F);
		this.shape38 = new ModelRenderer(this, 25, 49);
		this.shape38.setRotationPoint(0.0F, 0.4F, -3.2F);
		this.shape38.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 2, 0.0F);
		this.setRotateAngle(shape38, 0.136659280431156F, 0.0F, 0.0F);
		this.Tail3 = new ModelRenderer(this, 74, 48);
		this.Tail3.setRotationPoint(0.0F, 0.7F, 2.3F);
		this.Tail3.addBox(0.0F, -3.0F, 0.0F, 0, 7, 6, 0.0F);
		this.shape27 = new ModelRenderer(this, 84, 6);
		this.shape27.setRotationPoint(-1.5F, 0.9F, 4.1F);
		this.shape27.addBox(0.0F, 0.0F, 0.0F, 3, 2, 8, 0.0F);
		this.setRotateAngle(shape27, 0.31869712141416456F, 0.0F, 0.0F);
		this.shape30 = new ModelRenderer(this, 0, 0);
		this.shape30.setRotationPoint(1.0F, -0.9F, 1.0F);
		this.shape30.addBox(-1.1F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
		this.setRotateAngle(shape30, -0.18203784098300857F, 0.0F, 0.0F);
		this.shape39 = new ModelRenderer(this, 25, 57);
		this.shape39.setRotationPoint(0.0F, 1.1F, 0.7F);
		this.shape39.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
		this.setRotateAngle(shape39, 0.18203784098300857F, 0.0F, 0.0F);
		this.shape32 = new ModelRenderer(this, 0, 61);
		this.shape32.setRotationPoint(0.0F, 0.0F, 0.7F);
		this.shape32.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 2, 0.0F);
		this.setRotateAngle(shape32, 0.091106186954104F, 0.0F, 0.0F);
		this.shape33 = new ModelRenderer(this, 0, 72);
		this.shape33.setRotationPoint(0.0F, 0.0F, 1.8F);
		this.shape33.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
		this.setRotateAngle(shape33, -0.136659280431156F, 0.0F, 0.0F);
		this.shape35 = new ModelRenderer(this, 0, 85);
		this.shape35.setRotationPoint(0.0F, 0.0F, 1.4F);
		this.shape35.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
		this.setRotateAngle(shape35, -0.091106186954104F, 0.0F, 0.0F);
		this.LeftPectoralFin = new ModelRenderer(this, 30, 36);
		this.LeftPectoralFin.setRotationPoint(2.5F, 1.0F, -1.0F);
		this.LeftPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F);
		this.setRotateAngle(LeftPectoralFin, 0.296705972839036F, 0.12217304763960307F, 0.0F);
		this.Body4 = new ModelRenderer(this, 30, 28);
		this.Body4.setRotationPoint(-0.5F, -3.9F, 4.0F);
		this.Body4.addBox(-1.5F, -2.0F, -2.0F, 4, 2, 3, 0.0F);
		this.setRotateAngle(Body4, -0.136659280431156F, -0.0F, 0.0F);
		this.Mouth = new ModelRenderer(this, 18, 0);
		this.Mouth.setRotationPoint(-1.1F, 18.2F, -10.6F);
		this.Mouth.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4, 0.0F);
		this.setRotateAngle(Mouth, -0.136659280431156F, 0.0F, 0.0F);
		this.Head1 = new ModelRenderer(this, 0, 0);
		this.Head1.setRotationPoint(0.0F, -1.8F, -3.4F);
		this.Head1.addBox(-2.0F, -3.0F, -4.0F, 4, 3, 4, 0.0F);
		this.setRotateAngle(Head1, 0.7740535232594852F, -0.0F, 0.0F);
		this.shape33.addChild(this.shape34);
		this.Body1.addChild(this.Body2);
		this.Body2.addChild(this.shape31);
		this.Body1.addChild(this.Tail1);
		this.Body4.addChild(this.shape36);
		this.Head1.addChild(this.Head2);
		this.Tail1.addChild(this.AnalFin);
		this.Body4.addChild(this.DorsalFin);
		this.Tail1.addChild(this.Tail2);
		this.Body1.addChild(this.RightPectoralFin);
		this.shape36.addChild(this.shape37);
		this.Body1.addChild(this.shape26);
		this.Body1.addChild(this.Body3);
		this.Body3.addChild(this.shape38);
		this.Tail2.addChild(this.Tail3);
		this.shape26.addChild(this.shape27);
		this.Mouth.addChild(this.shape30);
		this.shape38.addChild(this.shape39);
		this.shape31.addChild(this.shape32);
		this.shape32.addChild(this.shape33);
		this.shape34.addChild(this.shape35);
		this.Body1.addChild(this.LeftPectoralFin);
		this.Body1.addChild(this.Body4);
		this.Body1.addChild(this.Head1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.Body1.render(f5);
		this.Mouth.render(f5);
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
