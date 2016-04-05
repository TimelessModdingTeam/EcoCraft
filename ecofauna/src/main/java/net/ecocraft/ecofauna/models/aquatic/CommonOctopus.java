package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Common Octopus - Cuchololol Created using Tabula 5.1.0
 */
public class CommonOctopus extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer arm1_1;
	public ModelRenderer arm2_1;
	public ModelRenderer arm3_1;
	public ModelRenderer arm4_1;
	public ModelRenderer arm5_1;
	public ModelRenderer arm6_1;
	public ModelRenderer arm7_1;
	public ModelRenderer arm8_1;
	public ModelRenderer Head2;
	public ModelRenderer Head1;
	public ModelRenderer Head3;
	public ModelRenderer RightEye;
	public ModelRenderer LeftEye;
	public ModelRenderer Head4;
	public ModelRenderer Head5;

	public ModelRenderer arm1_2;
	public ModelRenderer arm1_3;
	public ModelRenderer arm2_2;
	public ModelRenderer arm2_3;
	public ModelRenderer arm3_2;
	public ModelRenderer arm3_3;
	public ModelRenderer arm4_2;
	public ModelRenderer arm4_3;
	public ModelRenderer arm5_2;
	public ModelRenderer arm5_3;
	public ModelRenderer arm6_2;
	public ModelRenderer arm6_3;
	public ModelRenderer arm7_2;
	public ModelRenderer arm7_3;
	public ModelRenderer arm8_2;
	public ModelRenderer arm8_3;

	public CommonOctopus() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.arm2_2 = new ModelRenderer(this, 50, 10);
		this.arm2_2.setRotationPoint(0.0F, 1.0F, -6.0F);
		this.arm2_2.addBox(-1.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
		this.arm4_2 = new ModelRenderer(this, 50, 10);
		this.arm4_2.setRotationPoint(0.0F, 1.0F, 6.0F);
		this.arm4_2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8, 0.0F);
		this.Head5 = new ModelRenderer(this, 0, 32);
		this.Head5.mirror = true;
		this.Head5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Head5.addBox(2.5F, 0.8F, 1.0F, 1, 1, 1, 0.0F);
		this.arm2_1 = new ModelRenderer(this, 50, 0);
		this.arm2_1.setRotationPoint(1.2F, 22.0F, -2.0F);
		this.arm2_1.addBox(-1.5F, -1.0F, -6.0F, 3, 3, 6, 0.0F);
		this.setRotateAngle(this.arm2_1, 0.0F, -0.39269908169872414F, 0.0F);
		this.Head3 = new ModelRenderer(this, 0, 44);
		this.Head3.setRotationPoint(0.0F, 0.1F, 0.5F);
		this.Head3.addBox(-2.5F, -1.6F, 6.5F, 5, 4, 1, 0.0F);
		this.arm8_2 = new ModelRenderer(this, 80, 10);
		this.arm8_2.setRotationPoint(5.0F, 1.0F, 0.0F);
		this.arm8_2.addBox(0.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.Head1 = new ModelRenderer(this, 0, 50);
		this.Head1.setRotationPoint(0.0F, 0.6F, 1.3F);
		this.Head1.addBox(-3.0F, -2.0F, -0.5F, 6, 5, 8, 0.0F);
		this.setRotateAngle(Head1, -0.4553564018453205F, -0.0F, 0.0F);
		this.arm2_3 = new ModelRenderer(this, 50, 20);
		this.arm2_3.setRotationPoint(0.0F, 0.0F, -8.0F);
		this.arm2_3.addBox(-1.0F, 0.0F, -6.0F, 2, 1, 6, 0.0F);
		this.arm6_1 = new ModelRenderer(this, 80, 0);
		this.arm6_1.setRotationPoint(-2.4F, 22.0F, 1.2F);
		this.arm6_1.addBox(-6.0F, -1.0F, -1.5F, 6, 3, 3, 0.0F);
		this.setRotateAngle(this.arm6_1, 0.0F, 0.39269908169872414F, 0.0F);
		this.arm3_3 = new ModelRenderer(this, 50, 20);
		this.arm3_3.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.arm3_3.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 6, 0.0F);
		this.Head4 = new ModelRenderer(this, 0, 32);
		this.Head4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Head4.addBox(-3.5F, 0.8F, 1.0F, 1, 1, 1, 0.0F);
		this.arm4_1 = new ModelRenderer(this, 50, 0);
		this.arm4_1.setRotationPoint(1.2F, 22.0F, 2.0F);
		this.arm4_1.addBox(-1.5F, -1.0F, 0.0F, 3, 3, 6, 0.0F);
		this.setRotateAngle(this.arm4_1, 0.0F, 0.39269908169872414F, 0.0F);
		this.arm7_3 = new ModelRenderer(this, 80, 20);
		this.arm7_3.setRotationPoint(8.0F, 0.0F, 0.0F);
		this.arm7_3.addBox(0.0F, 0.0F, -1.0F, 6, 1, 2, 0.0F);
		this.arm6_2 = new ModelRenderer(this, 80, 10);
		this.arm6_2.setRotationPoint(-6.0F, 1.0F, 0.0F);
		this.arm6_2.addBox(-8.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.arm7_2 = new ModelRenderer(this, 80, 10);
		this.arm7_2.setRotationPoint(5.0F, 1.0F, 0.0F);
		this.arm7_2.addBox(0.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.arm8_1 = new ModelRenderer(this, 80, 0);
		this.arm8_1.setRotationPoint(3.5F, 22.0F, 1.2F);
		this.arm8_1.addBox(-1.0F, -1.0F, -1.5F, 6, 3, 3, 0.0F);
		this.setRotateAngle(this.arm8_1, 0.0F, -0.39269908169872414F, 0.0F);
		this.Head2 = new ModelRenderer(this, 0, 36);
		this.Head2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Head2.addBox(-2.0F, -1.2F, -3.0F, 4, 3, 5, 0.0F);
		this.setRotateAngle(Head2, 0.7330382858376184F, -0.0F, 0.0F);
		this.arm6_3 = new ModelRenderer(this, 80, 20);
		this.arm6_3.setRotationPoint(-8.0F, 0.0F, 0.0F);
		this.arm6_3.addBox(-6.0F, 0.0F, -1.0F, 6, 1, 2, 0.0F);
		this.arm5_1 = new ModelRenderer(this, 80, 0);
		this.arm5_1.setRotationPoint(-2.4F, 22.0F, -1.2F);
		this.arm5_1.addBox(-6.0F, -1.0F, -1.5F, 6, 3, 3, 0.0F);
		this.setRotateAngle(this.arm5_1, 0.0F, -0.39269908169872414F, 0.0F);
		this.Body = new ModelRenderer(this, 28, 53);
		this.Body.setRotationPoint(0.0F, 19.5F, 0.0F);
		this.Body.addBox(-3.5F, 1.0F, -3.5F, 7, 3, 7, 0.0F);
		this.arm7_1 = new ModelRenderer(this, 80, 0);
		this.arm7_1.setRotationPoint(3.5F, 22.0F, -1.2F);
		this.arm7_1.addBox(-1.0F, -1.0F, -1.5F, 6, 3, 3, 0.0F);
		this.setRotateAngle(this.arm7_1, 0.0F, 0.39269908169872414F, 0.0F);
		this.arm3_2 = new ModelRenderer(this, 50, 10);
		this.arm3_2.setRotationPoint(0.0F, 1.0F, 6.0F);
		this.arm3_2.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 8, 0.0F);
		this.arm1_2 = new ModelRenderer(this, 50, 10);
		this.arm1_2.setRotationPoint(0.0F, 1.0F, -6.0F);
		this.arm1_2.addBox(-1.0F, -1.0F, -8.0F, 2, 2, 8, 0.0F);
		this.arm3_1 = new ModelRenderer(this, 50, 0);
		this.arm3_1.setRotationPoint(-1.2F, 22.0F, 2.0F);
		this.arm3_1.addBox(-1.5F, -1.0F, 0.0F, 3, 3, 6, 0.0F);
		this.setRotateAngle(this.arm3_1, 0.0F, -0.39269908169872414F, 0.0F);
		this.arm5_3 = new ModelRenderer(this, 80, 20);
		this.arm5_3.setRotationPoint(-8.0F, 0.0F, 0.0F);
		this.arm5_3.addBox(-6.0F, 0.0F, -1.0F, 6, 1, 2, 0.0F);
		this.RightEye = new ModelRenderer(this, 14, 44);
		this.RightEye.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.RightEye.addBox(-3.5F, -2.2F, -1.0F, 2, 2, 2, 0.0F);
		this.arm8_3 = new ModelRenderer(this, 80, 20);
		this.arm8_3.setRotationPoint(8.0F, 0.0F, 0.0F);
		this.arm8_3.addBox(0.0F, 0.0F, -1.0F, 6, 1, 2, 0.0F);
		this.arm1_1 = new ModelRenderer(this, 50, 0);
		this.arm1_1.setRotationPoint(-1.2F, 22.0F, -2.0F);
		this.arm1_1.addBox(-1.5F, -1.0F, -6.0F, 3, 3, 6, 0.0F);
		this.setRotateAngle(this.arm1_1, 0.0F, 0.39269908169872414F, 0.0F);
		this.arm4_3 = new ModelRenderer(this, 50, 20);
		this.arm4_3.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.arm4_3.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 6, 0.0F);
		this.LeftEye = new ModelRenderer(this, 23, 44);
		this.LeftEye.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LeftEye.addBox(1.5F, -2.2F, -1.0F, 2, 2, 2, 0.0F);
		this.arm1_3 = new ModelRenderer(this, 50, 20);
		this.arm1_3.setRotationPoint(0.0F, 0.0F, -8.0F);
		this.arm1_3.addBox(-1.0F, 0.0F, -6.0F, 2, 1, 6, 0.0F);
		this.arm5_2 = new ModelRenderer(this, 80, 10);
		this.arm5_2.setRotationPoint(-6.0F, 1.0F, -0.0F);
		this.arm5_2.addBox(-8.0F, -1.0F, -1.0F, 8, 2, 2, 0.0F);
		this.arm2_1.addChild(this.arm2_2);
		this.arm4_1.addChild(this.arm4_2);
		this.Head1.addChild(this.Head5);
		this.Head1.addChild(this.Head3);
		this.arm8_1.addChild(this.arm8_2);
		this.Head2.addChild(this.Head1);
		this.arm2_2.addChild(this.arm2_3);
		this.arm3_2.addChild(this.arm3_3);
		this.Head1.addChild(this.Head4);
		this.arm7_2.addChild(this.arm7_3);
		this.arm6_1.addChild(this.arm6_2);
		this.arm7_1.addChild(this.arm7_2);
		this.Body.addChild(this.Head2);
		this.arm6_2.addChild(this.arm6_3);
		this.arm3_1.addChild(this.arm3_2);
		this.arm1_1.addChild(this.arm1_2);
		this.arm5_2.addChild(this.arm5_3);
		this.Head1.addChild(this.RightEye);
		this.arm8_2.addChild(this.arm8_3);
		this.arm4_2.addChild(this.arm4_3);
		this.Head1.addChild(this.LeftEye);
		this.arm1_2.addChild(this.arm1_3);
		this.arm5_1.addChild(this.arm5_2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.arm2_1.render(f5);
		this.arm6_1.render(f5);
		this.arm4_1.render(f5);
		this.arm8_1.render(f5);
		this.arm5_1.render(f5);
		this.Body.render(f5);
		this.arm7_1.render(f5);
		this.arm3_1.render(f5);
		this.arm1_1.render(f5);
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
