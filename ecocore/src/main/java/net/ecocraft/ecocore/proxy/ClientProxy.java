package net.ecocraft.ecocore.proxy;

import java.util.List;
import java.util.Set;

import net.ecocraft.ecocore.registry.helper.ContentObject;
import net.ecocraft.ecocore.registry.helper.EntityEntry;
import net.ecocraft.ecocore.server.registry.EcoRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy {
	public RenderManager renderManager;
	public RenderItem renderItem;
	public ItemModelMesher itemModelMesher;

	@Override
	public void onPreInit() {
		super.onPreInit();

	}

	@Override
	public void onInit() {
		super.onInit();
	}

	@Override
	public void onPostInit() {
		super.onPostInit();

		renderManager = Minecraft.getMinecraft().getRenderManager();
		renderItem = Minecraft.getMinecraft().getRenderItem();
		itemModelMesher = renderItem.getItemModelMesher();

		this.registerEntityRenderers();
		this.registerObjRegRenderers();
	}

	// Protected Functions
	protected void registerObjRegRenderers() {
		Set<Object> regMods = EcoRegistry.instance.getRegMods();
		for (Object modObj : regMods) {
			List<ContentObject> contentRegistries = EcoRegistry.instance.getObjRegs(modObj);

			for (ContentObject contentObject : contentRegistries) {
				contentObject.registerRenderer(itemModelMesher);
				contentObject.registerSpecialClientRenderers();
			}

		}
	}

	protected void registerEntityRenderers() {
		Set<Object> regMods = EcoRegistry.instance.getRegMods();
		for (Object modObj : regMods) {
			List<EntityEntry<?>> entityList = EcoRegistry.instance.getEntityEntries(modObj);

			for (EntityEntry<?> entityEntry : entityList) {
				entityEntry.registerRenderer();
			}
		}
	}
}
