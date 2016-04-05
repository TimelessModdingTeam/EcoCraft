package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Squid - Whaleboi Created using Tabula 5.1.0
 */
public class Squid extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer HeadConection;
	public ModelRenderer Body2;
	public ModelRenderer Head;
	public ModelRenderer Eye1;
	public ModelRenderer Arm1;
	public ModelRenderer Arm3;
	public ModelRenderer Arm5;
	public ModelRenderer Arm7;
	public ModelRenderer Arm9;
	public ModelRenderer Arm11;
	public ModelRenderer Arm13;
	public ModelRenderer Arm15;
	public ModelRenderer Beak1;
	public ModelRenderer Eye2;
	public ModelRenderer Arm2;
	public ModelRenderer Arm4;
	public ModelRenderer Arm6;
	public ModelRenderer Arm8;
	public ModelRenderer Arm10;
	public ModelRenderer Arm12;
	public ModelRenderer Arm14;
	public ModelRenderer Arm16;
	public ModelRenderer Beak2;
	public ModelRenderer RhombasThing;

	public Squid() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Head = new ModelRenderer(this, 50, 111);
		this.Head.setRotationPoint(0.0F, 2.9F, 0.0F);
		this.Head.addBox(-5.5F, 0.0F, 0.0F, 11, 8, 9, 0.0F);
		this.Arm14 = new ModelRenderer(this, 88, 55);
		this.Arm14.setRotationPoint(0.2F, 6.9F, 1.0F);
		this.Arm14.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm14, -0.4745550236172582F, 1.0170033551370958F, -0.06771877497737998F);
		this.Arm7 = new ModelRenderer(this, 115, 68);
		this.Arm7.setRotationPoint(3.3F, 7.2F, 3.1F);
		this.Arm7.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(Arm7, 0.022514747350726852F, -0.022514747350726852F, -0.3389429407372988F);
		this.Arm2 = new ModelRenderer(this, 86, 81);
		this.Arm2.setRotationPoint(0.7F, 6.8F, 0.6F);
		this.Arm2.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm2, 0.0F, 0.0F, 0.24853488548399255F);
		this.Arm3 = new ModelRenderer(this, 116, 54);
		this.Arm3.setRotationPoint(0.0F, 6.7F, 6.0F);
		this.Arm3.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(Arm3, 0.2033308578573394F, 0.0F, 0.0F);
		this.Arm4 = new ModelRenderer(this, 108, 54);
		this.Arm4.setRotationPoint(0.7F, 6.8F, 0.6F);
		this.Arm4.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm4, -0.022514747350726852F, 0.0F, 0.0F);
		this.Arm12 = new ModelRenderer(this, 88, 43);
		this.Arm12.setRotationPoint(0.2F, 6.8F, 0.6F);
		this.Arm12.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm12, -0.2937389131106456F, 0.06771877497737998F, -0.15812683023068624F);
		this.Arm5 = new ModelRenderer(this, 115, 43);
		this.Arm5.setRotationPoint(-4.4F, 7.6F, 5.6F);
		this.Arm5.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(Arm5, 0.3389429407372988F, -0.15812683023068624F, 0.2033308578573394F);
		this.Arm8 = new ModelRenderer(this, 107, 68);
		this.Arm8.setRotationPoint(0.2F, 6.8F, 0.6F);
		this.Arm8.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm8, -0.06771877497737998F, -0.11292280260403312F, 0.3389429407372988F);
		this.HeadConection = new ModelRenderer(this, 1, 84);
		this.HeadConection.setRotationPoint(0.0F, 15.3F, 0.9F);
		this.HeadConection.addBox(-4.5F, 0.0F, 0.0F, 9, 5, 9, 0.0F);
		this.RhombasThing = new ModelRenderer(this, 36, 63);
		this.RhombasThing.setRotationPoint(0.0F, -11.9F, 3.4F);
		this.RhombasThing.addBox(0.0F, 0.0F, 0.0F, 14, 14, 1, 0.0F);
		this.setRotateAngle(RhombasThing, 0.0F, 0.0F, 0.7941248096574199F);
		this.Arm11 = new ModelRenderer(this, 95, 43);
		this.Arm11.setRotationPoint(-1.2F, 7.3F, 0.3F);
		this.Arm11.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.Body2 = new ModelRenderer(this, 84, 97);
		this.Body2.setRotationPoint(0.0F, -8.5F, 1.5F);
		this.Body2.addBox(-4.0F, 0.0F, 0.0F, 8, 12, 8, 0.0F);
		this.Eye2 = new ModelRenderer(this, 107, 120);
		this.Eye2.setRotationPoint(11.4F, 0.0F, 0.0F);
		this.Eye2.addBox(0.0F, 0.0F, -2.0F, 3, 4, 4, 0.0F);
		this.Arm15 = new ModelRenderer(this, 94, 68);
		this.Arm15.setRotationPoint(-5.0F, 6.6F, 3.3F);
		this.Arm15.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.Arm6 = new ModelRenderer(this, 108, 42);
		this.Arm6.setRotationPoint(0.2F, 6.8F, 0.6F);
		this.Arm6.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm6, -0.24853488548399255F, 0.0F, -0.11292280260403312F);
		this.Beak2 = new ModelRenderer(this, 0, 70);
		this.Beak2.setRotationPoint(2.2F, 2.7F, 0.6F);
		this.Beak2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(Beak2, 0.0F, 0.0F, 0.7005751617505239F);
		this.Arm10 = new ModelRenderer(this, 108, 81);
		this.Arm10.setRotationPoint(0.2F, 6.8F, 0.6F);
		this.Arm10.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm10, -0.24853488548399255F, 0.0F, -0.11292280260403312F);
		this.Beak1 = new ModelRenderer(this, 0, 74);
		this.Beak1.setRotationPoint(-1.9F, 6.6F, 2.5F);
		this.Beak1.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3, 0.0F);
		this.Body = new ModelRenderer(this, 0, 100);
		this.Body.setRotationPoint(0.0F, -17.9F, -5.2F);
		this.Body.addBox(-6.0F, 0.0F, 0.0F, 12, 17, 11, 0.0F);
		this.Arm9 = new ModelRenderer(this, 115, 80);
		this.Arm9.setRotationPoint(2.9F, 7.5F, 0.0F);
		this.Arm9.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(Arm9, -0.11292280260403312F, -0.022514747350726852F, -0.15812683023068624F);
		this.Arm16 = new ModelRenderer(this, 87, 68);
		this.Arm16.setRotationPoint(0.2F, 6.9F, 1.0F);
		this.Arm16.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
		this.setRotateAngle(Arm16, -0.2937389131106456F, 1.5142476590302805F, -0.06771877497737998F);
		this.Eye1 = new ModelRenderer(this, 91, 120);
		this.Eye1.setRotationPoint(-7.0F, 1.5F, 4.5F);
		this.Eye1.addBox(0.0F, 0.0F, -2.0F, 3, 4, 4, 0.0F);
		this.Arm13 = new ModelRenderer(this, 95, 55);
		this.Arm13.setRotationPoint(-4.7F, 7.1F, 0.2F);
		this.Arm13.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.Arm1 = new ModelRenderer(this, 95, 81);
		this.Arm1.setRotationPoint(2.5F, 8.1F, 5.8F);
		this.Arm1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(Arm1, 0.2937389131106456F, 0.15812683023068624F, -0.24853488548399255F);
		this.HeadConection.addChild(this.Head);
		this.Arm13.addChild(this.Arm14);
		this.Head.addChild(this.Arm7);
		this.Arm1.addChild(this.Arm2);
		this.Head.addChild(this.Arm3);
		this.Arm3.addChild(this.Arm4);
		this.Arm11.addChild(this.Arm12);
		this.Head.addChild(this.Arm5);
		this.Arm7.addChild(this.Arm8);
		this.Body.addChild(this.HeadConection);
		this.Body2.addChild(this.RhombasThing);
		this.Head.addChild(this.Arm11);
		this.Body.addChild(this.Body2);
		this.Eye1.addChild(this.Eye2);
		this.Head.addChild(this.Arm15);
		this.Arm5.addChild(this.Arm6);
		this.Beak1.addChild(this.Beak2);
		this.Arm9.addChild(this.Arm10);
		this.Head.addChild(this.Beak1);
		this.Head.addChild(this.Arm9);
		this.Arm15.addChild(this.Arm16);
		this.Head.addChild(this.Eye1);
		this.Head.addChild(this.Arm13);
		this.Head.addChild(this.Arm1);
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
