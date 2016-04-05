package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Clownfish - Whaleboi Created using Tabula 5.1.0
 */
public class Clownfish extends ModelBase {
	public ModelRenderer BodySection1;
	public ModelRenderer BodySection2;
	public ModelRenderer DorsalFin1;
	public ModelRenderer PectoralFinLeft;
	public ModelRenderer PectoralFinRight;
	public ModelRenderer PelvicFinLeft;
	public ModelRenderer PelvicFinRight;
	public ModelRenderer Neck;
	public ModelRenderer BodySection3;
	public ModelRenderer DorsalFin2;
	public ModelRenderer TailSection1;
	public ModelRenderer DorsalFin3;
	public ModelRenderer AnalFin1;
	public ModelRenderer TailSection2;
	public ModelRenderer DorsalFin4;
	public ModelRenderer AnalFin2;
	public ModelRenderer TailSection3;
	public ModelRenderer TailFin;
	public ModelRenderer Mainhead;
	public ModelRenderer Neckback1;
	public ModelRenderer Lowerjawrear;
	public ModelRenderer Lowerjawfront;
	public ModelRenderer Neckback2;

	public Clownfish() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.PelvicFinRight = new ModelRenderer(this, 30, 44);
		this.PelvicFinRight.setRotationPoint(0.0F, 5.0F, -0.9F);
		this.PelvicFinRight.addBox(-5.0F, 0.0F, -2.0F, 5, 0, 4, 0.0F);
		this.setRotateAngle(PelvicFinRight, 0.0F, 0.0F, -0.6627015169822469F);
		this.Mainhead = new ModelRenderer(this, 100, 48);
		this.Mainhead.setRotationPoint(0.0F, -2.5F, -4.45F);
		this.Mainhead.addBox(-2.5F, -2.0F, -4.0F, 5, 4, 4, 0.0F);
		this.setRotateAngle(Mainhead, 0.9848892969004002F, 0.0F, 0.0F);
		this.AnalFin1 = new ModelRenderer(this, 36, 14);
		this.AnalFin1.setRotationPoint(0.0F, 6.9F, -1.4F);
		this.AnalFin1.addBox(0.0F, -1.0F, 0.0F, 0, 4, 5, 0.0F);
		this.setRotateAngle(AnalFin1, -0.182212373908208F, 0.0F, 0.0F);
		this.AnalFin2 = new ModelRenderer(this, 55, 14);
		this.AnalFin2.setRotationPoint(0.0F, 7.2F, 0.2F);
		this.AnalFin2.addBox(0.0F, -1.0F, 0.0F, 0, 4, 5, 0.0F);
		this.setRotateAngle(AnalFin2, 0.16336281798666924F, 0.0F, 0.0F);
		this.BodySection1 = new ModelRenderer(this, 0, 0);
		this.BodySection1.setRotationPoint(0.0F, 15.8F, -2.7F);
		this.BodySection1.addBox(-3.0F, -5.0F, -3.5F, 6, 10, 7, 0.0F);
		this.TailSection2 = new ModelRenderer(this, 0, 86);
		this.TailSection2.setRotationPoint(0.0F, 1.1F, 2.4F);
		this.TailSection2.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 4, 0.0F);
		this.setRotateAngle(TailSection2, 0.0015707963267948967F, -0.0F, 0.0F);
		this.PectoralFinLeft = new ModelRenderer(this, 30, 30);
		this.PectoralFinLeft.setRotationPoint(3.0F, 1.2F, -2.1F);
		this.PectoralFinLeft.addBox(0.0F, 0.0F, -2.5F, 6, 0, 5, 0.0F);
		this.setRotateAngle(PectoralFinLeft, 1.5707963267948966F, -1.3203415791337103F, 0.0F);
		this.DorsalFin3 = new ModelRenderer(this, 76, 2);
		this.DorsalFin3.setRotationPoint(0.0F, -0.3F, 0.0F);
		this.DorsalFin3.addBox(0.0F, -4.0F, 0.0F, 0, 5, 5, 0.0F);
		this.Lowerjawfront = new ModelRenderer(this, 104, 79);
		this.Lowerjawfront.setRotationPoint(0.0F, 2.5F, -3.0F);
		this.Lowerjawfront.addBox(-2.0F, -0.5F, -2.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(Lowerjawfront, -0.00645771823237902F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 100, 34);
		this.Neck.setRotationPoint(0.0F, 2.0F, -3.4F);
		this.Neck.addBox(-2.0F, -3.0F, -4.0F, 4, 6, 4, 0.0F);
		this.PelvicFinLeft = new ModelRenderer(this, 49, 44);
		this.PelvicFinLeft.setRotationPoint(0.0F, 5.0F, -0.9F);
		this.PelvicFinLeft.addBox(0.0F, 0.0F, -2.0F, 5, 0, 4, 0.0F);
		this.setRotateAngle(PelvicFinLeft, 0.0F, 0.0F, 0.6689847022894265F);
		this.Neckback2 = new ModelRenderer(this, 74, 43);
		this.Neckback2.setRotationPoint(0.0F, -1.1F, 2.8F);
		this.Neckback2.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 5, 0.0F);
		this.setRotateAngle(Neckback2, -0.4347615166717875F, -0.0F, 0.0F);
		this.DorsalFin1 = new ModelRenderer(this, 34, 0);
		this.DorsalFin1.setRotationPoint(0.0F, -4.1F, -2.5F);
		this.DorsalFin1.addBox(0.0F, -4.0F, 0.0F, 0, 5, 6, 0.0F);
		this.Neckback1 = new ModelRenderer(this, 76, 62);
		this.Neckback1.setRotationPoint(0.0F, -2.7F, -5.6F);
		this.Neckback1.addBox(-2.5F, -1.0F, 0.0F, 5, 4, 3, 0.0F);
		this.setRotateAngle(Neckback1, 0.7478735844795703F, -0.0F, 0.0F);
		this.DorsalFin2 = new ModelRenderer(this, 56, 1);
		this.DorsalFin2.setRotationPoint(0.0F, 0.2F, 0.0F);
		this.DorsalFin2.addBox(0.0F, -2.0F, 0.0F, 0, 2, 5, 0.0F);
		this.TailSection1 = new ModelRenderer(this, 0, 66);
		this.TailSection1.setRotationPoint(0.0F, 0.6F, 2.3F);
		this.TailSection1.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 5, 0.0F);
		this.BodySection2 = new ModelRenderer(this, 0, 22);
		this.BodySection2.setRotationPoint(0.0F, -4.7F, 2.4F);
		this.BodySection2.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 5, 0.0F);
		this.Lowerjawrear = new ModelRenderer(this, 101, 63);
		this.Lowerjawrear.setRotationPoint(0.0F, 3.2F, -0.85F);
		this.Lowerjawrear.addBox(-2.0F, 0.0F, -4.0F, 4, 3, 4, 0.0F);
		this.setRotateAngle(Lowerjawrear, -1.2747884856566583F, 0.0F, 0.0F);
		this.DorsalFin4 = new ModelRenderer(this, 94, 2);
		this.DorsalFin4.setRotationPoint(0.0F, 0.1F, 0.0F);
		this.DorsalFin4.addBox(0.0F, -5.0F, 0.0F, 0, 5, 5, 0.0F);
		this.TailSection3 = new ModelRenderer(this, 0, 103);
		this.TailSection3.setRotationPoint(0.0F, 0.6F, 3.2F);
		this.TailSection3.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
		this.PectoralFinRight = new ModelRenderer(this, 50, 31);
		this.PectoralFinRight.setRotationPoint(-2.7F, 1.2F, -3.2F);
		this.PectoralFinRight.addBox(-7.0F, 0.0F, -2.5F, 6, 0, 5, 0.0F);
		this.setRotateAngle(PectoralFinRight, 1.5707963267948966F, 1.3203415791337103F, 0.0F);
		this.TailFin = new ModelRenderer(this, 72, 6);
		this.TailFin.setRotationPoint(0.0F, 2.0F, 1.0F);
		this.TailFin.addBox(0.0F, -5.0F, 0.0F, 0, 10, 10, 0.0F);
		this.BodySection3 = new ModelRenderer(this, 0, 43);
		this.BodySection3.setRotationPoint(0.0F, 0.5F, 2.8F);
		this.BodySection3.addBox(-2.0F, 0.0F, 0.0F, 4, 8, 5, 0.0F);
		this.BodySection1.addChild(this.PelvicFinRight);
		this.Neck.addChild(this.Mainhead);
		this.BodySection3.addChild(this.AnalFin1);
		this.TailSection1.addChild(this.AnalFin2);
		this.TailSection1.addChild(this.TailSection2);
		this.BodySection1.addChild(this.PectoralFinLeft);
		this.BodySection3.addChild(this.DorsalFin3);
		this.Lowerjawrear.addChild(this.Lowerjawfront);
		this.BodySection1.addChild(this.Neck);
		this.BodySection1.addChild(this.PelvicFinLeft);
		this.Neckback1.addChild(this.Neckback2);
		this.BodySection1.addChild(this.DorsalFin1);
		this.Neck.addChild(this.Neckback1);
		this.BodySection2.addChild(this.DorsalFin2);
		this.BodySection3.addChild(this.TailSection1);
		this.BodySection1.addChild(this.BodySection2);
		this.Mainhead.addChild(this.Lowerjawrear);
		this.TailSection1.addChild(this.DorsalFin4);
		this.TailSection2.addChild(this.TailSection3);
		this.BodySection1.addChild(this.PectoralFinRight);
		this.TailSection3.addChild(this.TailFin);
		this.BodySection2.addChild(this.BodySection3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.BodySection1.render(f5);
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
