package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * Pike - Professor Biceps Created using Tabula 5.1.0
 */
public class Pike extends ModelBase {
	public double[] modelScale = new double[] { 0.8D, 0.8D, 0.8D };
	public ModelRenderer Neck;
	public ModelRenderer Mainhead;
	public ModelRenderer BodySection1;
	public ModelRenderer Lowerjawrear;
	public ModelRenderer Rightgill;
	public ModelRenderer Rightgill_1;
	public ModelRenderer Neckback1;
	public ModelRenderer Upperjaw;
	public ModelRenderer Lowerjaw;
	public ModelRenderer Lowerjawbottom;
	public ModelRenderer Upperjawtop;
	public ModelRenderer BodySection2;
	public ModelRenderer RightFrontFlipper;
	public ModelRenderer LeftFrontFlipper;
	public ModelRenderer BodySection3;
	public ModelRenderer BodySection4;
	public ModelRenderer Leftbottomfin;
	public ModelRenderer TailSection1;
	public ModelRenderer TailSection2;
	public ModelRenderer Dorsalfin5;
	public ModelRenderer Assfin;
	public ModelRenderer TailSection3;

	public Pike() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Neckback1 = new ModelRenderer(this, 1, 34);
		this.Neckback1.setRotationPoint(0.0F, 1.0F, -4.0F);
		this.Neckback1.addBox(-1.5F, -1.0F, 0.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(Neckback1, 0.05619960191421742F, -0.0F, 0.0F);
		this.Lowerjawrear = new ModelRenderer(this, 12, 49);
		this.Lowerjawrear.setRotationPoint(0.0F, 2.4F, -1.9F);
		this.Lowerjawrear.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 3, 0.0F);
		this.setRotateAngle(Lowerjawrear, -0.3844960342143508F, 0.0F, 0.0F);
		this.Upperjaw = new ModelRenderer(this, 23, 35);
		this.Upperjaw.setRotationPoint(0.0F, 0.6F, -4.8F);
		this.Upperjaw.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(Upperjaw, -0.17226399717184032F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 1, 49);
		this.Neck.setRotationPoint(0.0F, 4.2F, -2.4F);
		this.Neck.addBox(-1.5F, 0.0F, -1.0F, 3, 3, 2, 0.0F);
		this.Lowerjaw = new ModelRenderer(this, 25, 41);
		this.Lowerjaw.setRotationPoint(0.0F, 0.4F, -2.9F);
		this.Lowerjaw.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(Lowerjaw, 0.18631832043330543F, 0.0F, 0.0F);
		this.BodySection3 = new ModelRenderer(this, 1, 13);
		this.BodySection3.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.BodySection3.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 6, 0.0F);
		this.Dorsalfin5 = new ModelRenderer(this, 47, 40);
		this.Dorsalfin5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Dorsalfin5.addBox(0.0F, -4.0F, 0.0F, 0, 4, 3, 0.0F);
		this.setRotateAngle(Dorsalfin5, -0.5085889440311476F, 0.0F, 0.0F);
		this.TailSection1 = new ModelRenderer(this, 1, 25);
		this.TailSection1.setRotationPoint(0.0F, 0.5F, 5.0F);
		this.TailSection1.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 4, 0.0F);
		this.LeftFrontFlipper = new ModelRenderer(this, 42, 37);
		this.LeftFrontFlipper.setRotationPoint(2.0F, 4.3F, 0.0F);
		this.LeftFrontFlipper.addBox(0.0F, 0.0F, 0.0F, 0, 4, 2, 0.0F);
		this.setRotateAngle(LeftFrontFlipper, 0.39304814754912304F, 0.0F, -0.39985493163190083F);
		this.Mainhead = new ModelRenderer(this, 1, 40);
		this.Mainhead.setRotationPoint(0.0F, -1.7F, 0.88F);
		this.Mainhead.addBox(-2.0F, 0.0F, -5.0F, 4, 3, 5, 0.0F);
		this.setRotateAngle(Mainhead, 0.17226399717184032F, 0.0F, 0.0F);
		this.Lowerjawbottom = new ModelRenderer(this, 25, 47);
		this.Lowerjawbottom.setRotationPoint(0.0F, 0.6F, 0.1F);
		this.Lowerjawbottom.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 4, 0.0F);
		this.setRotateAngle(Lowerjawbottom, -0.1392772743091475F, 0.0F, 0.0F);
		this.Rightgill = new ModelRenderer(this, 1, 55);
		this.Rightgill.setRotationPoint(-1.2F, 0.1F, -1.3F);
		this.Rightgill.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
		this.setRotateAngle(Rightgill, -0.1986184688769547F, 0.0F, 0.0F);
		this.BodySection2 = new ModelRenderer(this, 22, 1);
		this.BodySection2.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.BodySection2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 6, 0.0F);
		this.Leftbottomfin = new ModelRenderer(this, 42, 31);
		this.Leftbottomfin.setRotationPoint(0.0F, 5.0F, 0.6F);
		this.Leftbottomfin.addBox(-1.5F, -2.0F, 0.0F, 3, 2, 4, 0.0F);
		this.setRotateAngle(Leftbottomfin, -0.9110618695410401F, 0.0F, 0.0F);
		this.BodySection1 = new ModelRenderer(this, 1, 1);
		this.BodySection1.setRotationPoint(0.0F, -1.9F, 0.7F);
		this.BodySection1.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 6, 0.0F);
		this.Upperjawtop = new ModelRenderer(this, 25, 29);
		this.Upperjawtop.setRotationPoint(0.0F, -0.6F, 0.2F);
		this.Upperjawtop.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 4, 0.0F);
		this.setRotateAngle(Upperjawtop, 0.14782938764391973F, 0.0F, 0.0F);
		this.TailSection2 = new ModelRenderer(this, 14, 26);
		this.TailSection2.setRotationPoint(0.0F, 0.5F, 3.0F);
		this.TailSection2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
		this.setRotateAngle(TailSection2, 0.0015707963267948967F, -0.0F, 0.0F);
		this.Rightgill_1 = new ModelRenderer(this, 8, 55);
		this.Rightgill_1.mirror = true;
		this.Rightgill_1.setRotationPoint(1.2F, 0.1F, -1.3F);
		this.Rightgill_1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
		this.setRotateAngle(Rightgill_1, -0.1986184688769547F, 0.0F, 0.0F);
		this.RightFrontFlipper = new ModelRenderer(this, 42, 37);
		this.RightFrontFlipper.setRotationPoint(-2.0F, 4.3F, 0.0F);
		this.RightFrontFlipper.addBox(0.0F, 0.0F, 0.0F, 0, 4, 2, 0.0F);
		this.setRotateAngle(RightFrontFlipper, 0.39304814754912304F, 0.0F, 0.39985493163190083F);
		this.BodySection4 = new ModelRenderer(this, 22, 13);
		this.BodySection4.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.BodySection4.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 6, 0.0F);
		this.Assfin = new ModelRenderer(this, 47, 35);
		this.Assfin.setRotationPoint(0.0F, 4.0F, 0.5F);
		this.Assfin.addBox(0.0F, -3.0F, 0.0F, 0, 3, 4, 0.0F);
		this.setRotateAngle(Assfin, -1.0274753306490618F, 0.0F, 0.0F);
		this.TailSection3 = new ModelRenderer(this, 47, 41);
		this.TailSection3.setRotationPoint(0.0F, 1.5F, 1.2F);
		this.TailSection3.addBox(0.0F, 0.0F, 0.0F, 0, 7, 7, 0.0F);
		this.setRotateAngle(TailSection3, 0.7853981633974483F, -0.0F, 0.0F);
		this.Mainhead.addChild(this.Neckback1);
		this.Mainhead.addChild(this.Lowerjawrear);
		this.Mainhead.addChild(this.Upperjaw);
		this.Lowerjawrear.addChild(this.Lowerjaw);
		this.BodySection2.addChild(this.BodySection3);
		this.TailSection1.addChild(this.Dorsalfin5);
		this.BodySection4.addChild(this.TailSection1);
		this.BodySection1.addChild(this.LeftFrontFlipper);
		this.Neck.addChild(this.Mainhead);
		this.Lowerjaw.addChild(this.Lowerjawbottom);
		this.Mainhead.addChild(this.Rightgill);
		this.BodySection1.addChild(this.BodySection2);
		this.BodySection3.addChild(this.Leftbottomfin);
		this.Neck.addChild(this.BodySection1);
		this.Upperjaw.addChild(this.Upperjawtop);
		this.TailSection1.addChild(this.TailSection2);
		this.Mainhead.addChild(this.Rightgill_1);
		this.BodySection1.addChild(this.RightFrontFlipper);
		this.BodySection3.addChild(this.BodySection4);
		this.TailSection1.addChild(this.Assfin);
		this.TailSection2.addChild(this.TailSection3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		GlStateManager.pushMatrix();
		GlStateManager.scale(1D / modelScale[0], 1D / modelScale[1], 1D / modelScale[2]);
		this.Neck.render(f5);
		GlStateManager.popMatrix();
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
