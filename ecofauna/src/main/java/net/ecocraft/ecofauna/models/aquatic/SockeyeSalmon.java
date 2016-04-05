package net.ecocraft.ecofauna.models.aquatic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Sockeye-Salmon.tcn - TechneToTabulaImporter Created using Tabula 5.1.0
 */
public class SockeyeSalmon extends ModelBase {
	public ModelRenderer Body1;
	public ModelRenderer Body2;
	public ModelRenderer Body3;
	public ModelRenderer Body4;
	public ModelRenderer DorsalFin;
	public ModelRenderer RightPelvicFin;
	public ModelRenderer LeftPelvicFin;
	public ModelRenderer RightPectoralFin;
	public ModelRenderer LeftPectoralFin;
	public ModelRenderer Body5;
	public ModelRenderer Body6;
	public ModelRenderer Head;
	public ModelRenderer Tail1;
	public ModelRenderer UpperJaw1;
	public ModelRenderer LowerJaw1;
	public ModelRenderer UpperJaw2;
	public ModelRenderer UpperJaw3;
	public ModelRenderer UpperJaw4;
	public ModelRenderer LowerJaw2;
	public ModelRenderer LowerJaw3;
	public ModelRenderer Tail2;
	public ModelRenderer AdiposeFin;
	public ModelRenderer AnalFin;
	public ModelRenderer Tail3;

	public SockeyeSalmon() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.Tail1 = new ModelRenderer(this, 39, 38);
		this.Tail1.setRotationPoint(0.0F, -1.0F, 9.0F);
		this.Tail1.addBox(-1.5F, -2.53F, 0.0F, 3, 5, 5, 0.0F);
		this.Body2 = new ModelRenderer(this, 2, 42);
		this.Body2.setRotationPoint(0.0F, -0.5F, 0.7F);
		this.Body2.addBox(-1.5F, -4.0F, -5.0F, 3, 4, 8, 0.0F);
		this.setRotateAngle(Body2, 0.06981317007977318F, -0.0F, 0.0F);
		this.Body4 = new ModelRenderer(this, 30, 28);
		this.Body4.setRotationPoint(0.0F, -2.5F, 5.0F);
		this.Body4.addBox(-1.5F, -2.0F, -2.0F, 3, 2, 6, 0.0F);
		this.setRotateAngle(Body4, -0.08726646259971647F, -0.0F, 0.0F);
		this.UpperJaw4 = new ModelRenderer(this, 10, 34);
		this.UpperJaw4.setRotationPoint(0.0F, 0.6F, -1.3F);
		this.UpperJaw4.addBox(-1.0F, -1.0F, -2.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(UpperJaw4, 0.8203047484373349F, -0.0F, 0.0F);
		this.RightPectoralFin = new ModelRenderer(this, 30, 36);
		this.RightPectoralFin.setRotationPoint(-2.0F, 1.0F, -1.0F);
		this.RightPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F);
		this.setRotateAngle(RightPectoralFin, 0.296705972839036F, -0.12217304763960307F, 0.0F);
		this.AnalFin = new ModelRenderer(this, 64, 48);
		this.AnalFin.setRotationPoint(0.0F, 1.0F, 3.5F);
		this.AnalFin.addBox(0.0F, -1.0F, -1.0F, 0, 3, 4, 0.0F);
		this.setRotateAngle(AnalFin, -0.8203047484373349F, -0.0F, 0.0F);
		this.UpperJaw1 = new ModelRenderer(this, 0, 19);
		this.UpperJaw1.setRotationPoint(0.0F, -0.8F, -1.6F);
		this.UpperJaw1.addBox(-1.5F, -0.27F, -4.0F, 3, 2, 3, 0.0F);
		this.setRotateAngle(UpperJaw1, -1.0471975511965976F, -0.0F, 0.0F);
		this.Body1 = new ModelRenderer(this, 23, 8);
		this.Body1.setRotationPoint(0.0F, 18.0F, -2.0F);
		this.Body1.addBox(-2.0F, -4.0F, -2.0F, 4, 6, 12, 0.0F);
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.setRotationPoint(0.0F, -2.0F, -3.0F);
		this.Head.addBox(-2.0F, -3.0F, -4.0F, 4, 5, 4, 0.0F);
		this.setRotateAngle(Head, 0.593411945678072F, -0.0F, 0.0F);
		this.RightPelvicFin = new ModelRenderer(this, 49, 52);
		this.RightPelvicFin.setRotationPoint(-0.5F, 1.0F, 6.0F);
		this.RightPelvicFin.addBox(0.0F, 0.0F, -1.0F, 0, 3, 3, 0.0F);
		this.setRotateAngle(RightPelvicFin, 0.45378560551852565F, -0.2792526803190927F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 58, 39);
		this.Tail2.setRotationPoint(0.0F, -0.8F, 4.0F);
		this.Tail2.addBox(-1.0F, -1.0F, 0.0F, 2, 3, 5, 0.0F);
		this.UpperJaw3 = new ModelRenderer(this, 0, 25);
		this.UpperJaw3.setRotationPoint(0.0F, -1.2F, -0.8F);
		this.UpperJaw3.addBox(-1.0F, -1.0F, -4.83F, 2, 1, 5, 0.0F);
		this.setRotateAngle(UpperJaw3, 0.5585053606381855F, -0.0F, 0.0F);
		this.LowerJaw3 = new ModelRenderer(this, 25, 12);
		this.LowerJaw3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LowerJaw3.addBox(-1.0F, 1.27F, -7.27F, 2, 1, 2, 0.0F);
		this.setRotateAngle(LowerJaw3, -0.22689280275926282F, -0.0F, 0.0F);
		this.LowerJaw2 = new ModelRenderer(this, 15, 12);
		this.LowerJaw2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.LowerJaw2.addBox(-1.0F, 0.0F, -6.0F, 2, 1, 2, 0.0F);
		this.LowerJaw1 = new ModelRenderer(this, 0, 12);
		this.LowerJaw1.setRotationPoint(0.0F, 1.0F, -3.0F);
		this.LowerJaw1.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(LowerJaw1, -0.8651597102135892F, -0.0F, 0.0F);
		this.LeftPelvicFin = new ModelRenderer(this, 49, 52);
		this.LeftPelvicFin.setRotationPoint(0.53F, 1.0F, 6.0F);
		this.LeftPelvicFin.addBox(0.0F, 0.0F, -1.0F, 0, 3, 3, 0.0F);
		this.setRotateAngle(LeftPelvicFin, 0.45378560551852565F, 0.2792526803190927F, 0.0F);
		this.AdiposeFin = new ModelRenderer(this, 57, 16);
		this.AdiposeFin.setRotationPoint(0.0F, -1.0F, 3.0F);
		this.AdiposeFin.addBox(0.0F, -2.0F, -1.0F, 0, 1, 2, 0.0F);
		this.setRotateAngle(AdiposeFin, 0.4363323129985824F, -0.0F, 0.0F);
		this.DorsalFin = new ModelRenderer(this, 57, 16);
		this.DorsalFin.setRotationPoint(0.0F, -3.0F, 3.0F);
		this.DorsalFin.addBox(0.0F, -2.0F, 0.0F, 0, 2, 5, 0.0F);
		this.setRotateAngle(DorsalFin, 0.2617993877991494F, -0.0F, 0.0F);
		this.LeftPectoralFin = new ModelRenderer(this, 30, 36);
		this.LeftPectoralFin.setRotationPoint(2.0F, 1.0F, -1.0F);
		this.LeftPectoralFin.addBox(0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F);
		this.setRotateAngle(LeftPectoralFin, 0.296705972839036F, 0.12217304763960307F, 0.0F);
		this.Body6 = new ModelRenderer(this, 36, 55);
		this.Body6.setRotationPoint(0.0F, -0.5F, 0.7F);
		this.Body6.addBox(-1.0F, -5.53F, -0.4F, 2, 2, 6, 0.0F);
		this.setRotateAngle(Body6, -0.2792526803190927F, -0.0F, 0.0F);
		this.Body3 = new ModelRenderer(this, 52, 28);
		this.Body3.setRotationPoint(0.0F, -0.5F, 0.5F);
		this.Body3.addBox(-1.5F, 0.33F, -5.6F, 3, 2, 6, 0.0F);
		this.setRotateAngle(Body3, -0.017453292519943295F, -0.0F, 0.0F);
		this.Body5 = new ModelRenderer(this, 2, 55);
		this.Body5.setRotationPoint(0.0F, -0.5F, 0.7F);
		this.Body5.addBox(-1.0F, -5.0F, -4.6F, 2, 2, 7, 0.0F);
		this.setRotateAngle(Body5, 0.22689280275926282F, -0.0F, 0.0F);
		this.Tail3 = new ModelRenderer(this, 30, 48);
		this.Tail3.setRotationPoint(0.0F, 0.5F, 4.0F);
		this.Tail3.addBox(0.0F, -3.0F, 0.0F, 0, 6, 5, 0.0F);
		this.UpperJaw2 = new ModelRenderer(this, 0, 34);
		this.UpperJaw2.setRotationPoint(0.0F, 0.7F, -3.7F);
		this.UpperJaw2.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(UpperJaw2, -0.22689280275926282F, -0.0F, 0.0F);
		this.Body1.addChild(this.Tail1);
		this.Body1.addChild(this.Body2);
		this.Body1.addChild(this.Body4);
		this.UpperJaw2.addChild(this.UpperJaw4);
		this.Body1.addChild(this.RightPectoralFin);
		this.Tail1.addChild(this.AnalFin);
		this.Head.addChild(this.UpperJaw1);
		this.Body1.addChild(this.Head);
		this.Body1.addChild(this.RightPelvicFin);
		this.Tail1.addChild(this.Tail2);
		this.UpperJaw1.addChild(this.UpperJaw3);
		this.LowerJaw2.addChild(this.LowerJaw3);
		this.LowerJaw1.addChild(this.LowerJaw2);
		this.Head.addChild(this.LowerJaw1);
		this.Body1.addChild(this.LeftPelvicFin);
		this.Tail1.addChild(this.AdiposeFin);
		this.Body1.addChild(this.DorsalFin);
		this.Body1.addChild(this.LeftPectoralFin);
		this.Body1.addChild(this.Body6);
		this.Body1.addChild(this.Body3);
		this.Body1.addChild(this.Body5);
		this.Tail2.addChild(this.Tail3);
		this.UpperJaw1.addChild(this.UpperJaw2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.Body1.render(f5);
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
