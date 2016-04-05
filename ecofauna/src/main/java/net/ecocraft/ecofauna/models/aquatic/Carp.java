package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * Carp - Professor Biceps Created using Tabula 5.1.0
 */
public class Carp extends ModelBase {
	public double[] modelScale = new double[] { 0.8D, 0.8D, 0.8D };
	public ModelRenderer Neck;
	public ModelRenderer Mainhead;
	public ModelRenderer BodySection1;
	public ModelRenderer Neckback1;
	public ModelRenderer RightFrontFlipper;
	public ModelRenderer LeftFrontFlipper;
	public ModelRenderer Lowerjawrear;
	public ModelRenderer Rightgill;
	public ModelRenderer Rightgill_1;
	public ModelRenderer Upperjaw;
	public ModelRenderer Lowerjaw;
	public ModelRenderer BodySection2;
	public ModelRenderer Dorsalfin;
	public ModelRenderer Leftbottomfin;
	public ModelRenderer BodySection3;
	public ModelRenderer Dorsalfin2;
	public ModelRenderer Dorsalfin3;
	public ModelRenderer Dorsalfin4;
	public ModelRenderer TailSection1;
	public ModelRenderer Assfin;
	public ModelRenderer Dorsalfin5;
	public ModelRenderer TailSection2;
	public ModelRenderer Dorsalfin5_1;
	public ModelRenderer TailSection3;
	public ModelRenderer Neckback2;

	public Carp() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Rightgill = new ModelRenderer(this, 22, 55);
		this.Rightgill.setRotationPoint(-1.7F, -2.2F, -0.3F);
		this.Rightgill.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(Rightgill, -0.3506366467256608F, 0.0F, 0.0F);
		this.Mainhead = new ModelRenderer(this, 22, 48);
		this.Mainhead.setRotationPoint(0.0F, 1.6F, -1.12F);
		this.Mainhead.addBox(-2.5F, -3.0F, -3.0F, 5, 3, 3, 0.0F);
		this.setRotateAngle(Mainhead, 0.7340854833888151F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 47, 34);
		this.Neck.setRotationPoint(0.0F, 4.2F, -2.4F);
		this.Neck.addBox(-2.0F, 1.0F, -1.0F, 4, 3, 4, 0.0F);
		this.BodySection2 = new ModelRenderer(this, 45, 18);
		this.BodySection2.setRotationPoint(0.0F, 0.5F, 4.0F);
		this.BodySection2.addBox(-2.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
		this.TailSection1 = new ModelRenderer(this, 17, 16);
		this.TailSection1.setRotationPoint(0.0F, 0.5F, 2.0F);
		this.TailSection1.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
		this.Neckback2 = new ModelRenderer(this, 28, 32);
		this.Neckback2.setRotationPoint(0.0F, -1.0F, 3.0F);
		this.Neckback2.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
		this.setRotateAngle(Neckback2, -0.4347615166717875F, -0.0F, 0.0F);
		this.Upperjaw = new ModelRenderer(this, 49, 50);
		this.Upperjaw.setRotationPoint(0.0F, 1.5F, -2.8F);
		this.Upperjaw.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(Upperjaw, -0.4399975044277705F, 0.0F, 0.0F);
		this.Dorsalfin2 = new ModelRenderer(this, 4, 0);
		this.Dorsalfin2.setRotationPoint(0.0F, 0.2F, 0.0F);
		this.Dorsalfin2.addBox(0.0F, -3.0F, 0.0F, 0, 3, 1, 0.0F);
		this.Rightgill_1 = new ModelRenderer(this, 22, 55);
		this.Rightgill_1.mirror = true;
		this.Rightgill_1.setRotationPoint(1.7F, -2.2F, -0.3F);
		this.Rightgill_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(Rightgill_1, -0.3506366467256608F, 0.0F, 0.0F);
		this.Lowerjawrear = new ModelRenderer(this, 45, 55);
		this.Lowerjawrear.setRotationPoint(0.0F, -0.2F, 0.7F);
		this.Lowerjawrear.addBox(-1.5F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
		this.setRotateAngle(Lowerjawrear, -0.7831292353698556F, 0.0F, 0.0F);
		this.BodySection3 = new ModelRenderer(this, 30, 17);
		this.BodySection3.setRotationPoint(0.0F, 0.5F, 3.0F);
		this.BodySection3.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
		this.Neckback1 = new ModelRenderer(this, 7, 48);
		this.Neckback1.setRotationPoint(0.0F, 0.6F, -3.0F);
		this.Neckback1.addBox(-2.0F, -1.0F, 0.0F, 4, 3, 3, 0.0F);
		this.setRotateAngle(Neckback1, 0.6068509809184284F, -0.0F, 0.0F);
		this.Dorsalfin = new ModelRenderer(this, 1, 0);
		this.Dorsalfin.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.Dorsalfin.addBox(0.0F, -3.0F, 0.0F, 0, 3, 1, 0.0F);
		this.BodySection1 = new ModelRenderer(this, 5, 29);
		this.BodySection1.setRotationPoint(0.0F, -2.7F, 2.7F);
		this.BodySection1.addBox(-2.5F, 0.0F, 0.0F, 5, 7, 5, 0.0F);
		this.Dorsalfin5 = new ModelRenderer(this, 13, -1);
		this.Dorsalfin5.setRotationPoint(0.0F, 1.1F, 0.0F);
		this.Dorsalfin5.addBox(0.0F, -3.0F, 0.0F, 0, 3, 2, 0.0F);
		this.Leftbottomfin = new ModelRenderer(this, 1, 5);
		this.Leftbottomfin.setRotationPoint(0.0F, 7.0F, 1.6F);
		this.Leftbottomfin.addBox(-1.0F, -3.0F, 0.0F, 2, 3, 4, 0.0F);
		this.setRotateAngle(Leftbottomfin, -0.9110618695410401F, 0.0F, 0.0F);
		this.Lowerjaw = new ModelRenderer(this, 49, 50);
		this.Lowerjaw.setRotationPoint(0.0F, 2.1F, -2.6F);
		this.Lowerjaw.addBox(-1.5F, 0.0F, -2.0F, 3, 1, 2, 0.0F);
		this.setRotateAngle(Lowerjaw, -0.2977192817112722F, 0.0F, 0.0F);
		this.TailSection2 = new ModelRenderer(this, 6, 19);
		this.TailSection2.setRotationPoint(0.0F, 0.5F, 2.0F);
		this.TailSection2.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
		this.setRotateAngle(TailSection2, 0.0015707963267948967F, -0.0F, 0.0F);
		this.Dorsalfin5_1 = new ModelRenderer(this, 18, -2);
		this.Dorsalfin5_1.setRotationPoint(0.0F, 1.1F, 0.0F);
		this.Dorsalfin5_1.addBox(0.0F, -3.0F, 0.0F, 0, 3, 3, 0.0F);
		this.Dorsalfin3 = new ModelRenderer(this, 7, 0);
		this.Dorsalfin3.setRotationPoint(0.0F, 0.9F, 1.0F);
		this.Dorsalfin3.addBox(0.0F, -3.0F, 0.0F, 0, 3, 1, 0.0F);
		this.RightFrontFlipper = new ModelRenderer(this, 14, 7);
		this.RightFrontFlipper.setRotationPoint(-2.0F, 2.8F, -1.4F);
		this.RightFrontFlipper.addBox(0.0F, 0.0F, 0.0F, 0, 4, 2, 0.0F);
		this.setRotateAngle(RightFrontFlipper, 0.39304814754912304F, 0.0F, 0.39985493163190083F);
		this.Dorsalfin4 = new ModelRenderer(this, 10, 0);
		this.Dorsalfin4.setRotationPoint(0.0F, 1.1F, 2.0F);
		this.Dorsalfin4.addBox(0.0F, -3.0F, 0.0F, 0, 3, 1, 0.0F);
		this.TailSection3 = new ModelRenderer(this, 53, 5);
		this.TailSection3.setRotationPoint(0.0F, 1.5F, 0.2F);
		this.TailSection3.addBox(0.0F, 0.0F, 0.0F, 0, 6, 6, 0.0F);
		this.setRotateAngle(TailSection3, 0.7853981633974483F, -0.0F, 0.0F);
		this.Assfin = new ModelRenderer(this, 14, 2);
		this.Assfin.setRotationPoint(0.0F, 5.0F, 1.5F);
		this.Assfin.addBox(0.0F, -3.0F, 0.0F, 0, 3, 3, 0.0F);
		this.setRotateAngle(Assfin, -1.0274753306490618F, 0.0F, 0.0F);
		this.LeftFrontFlipper = new ModelRenderer(this, 14, 7);
		this.LeftFrontFlipper.setRotationPoint(2.0F, 2.8F, -1.4F);
		this.LeftFrontFlipper.addBox(0.0F, 0.0F, 0.0F, 0, 4, 2, 0.0F);
		this.setRotateAngle(LeftFrontFlipper, 0.39304814754912304F, 0.0F, -0.39985493163190083F);
		this.Mainhead.addChild(this.Rightgill);
		this.Neck.addChild(this.Mainhead);
		this.BodySection1.addChild(this.BodySection2);
		this.BodySection3.addChild(this.TailSection1);
		this.Neckback1.addChild(this.Neckback2);
		this.Lowerjawrear.addChild(this.Upperjaw);
		this.BodySection2.addChild(this.Dorsalfin2);
		this.Mainhead.addChild(this.Rightgill_1);
		this.Mainhead.addChild(this.Lowerjawrear);
		this.BodySection2.addChild(this.BodySection3);
		this.Neck.addChild(this.Neckback1);
		this.BodySection1.addChild(this.Dorsalfin);
		this.Neck.addChild(this.BodySection1);
		this.BodySection3.addChild(this.Dorsalfin5);
		this.BodySection1.addChild(this.Leftbottomfin);
		this.Lowerjawrear.addChild(this.Lowerjaw);
		this.TailSection1.addChild(this.TailSection2);
		this.TailSection1.addChild(this.Dorsalfin5_1);
		this.BodySection2.addChild(this.Dorsalfin3);
		this.Neck.addChild(this.RightFrontFlipper);
		this.BodySection2.addChild(this.Dorsalfin4);
		this.TailSection2.addChild(this.TailSection3);
		this.BodySection3.addChild(this.Assfin);
		this.Neck.addChild(this.LeftFrontFlipper);
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
