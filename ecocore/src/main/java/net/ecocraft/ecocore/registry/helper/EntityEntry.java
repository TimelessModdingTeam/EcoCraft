package net.ecocraft.ecocore.registry.helper;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityEntry<T extends Entity> {

	private static Map<Object, Integer> nextMobIdPerMod = new HashMap<>();

	private static int getNewId(Object mod) {
		int mobId = nextMobIdPerMod.getOrDefault(mod, new Integer(0));
		if (mobId == Integer.MAX_VALUE)
			throw new IllegalStateException("Registered too many mobs for a single mod");
		nextMobIdPerMod.put(mod, mobId + 1);
		return mobId;
	}

	public static <T extends Entity> void registerEntity(Object mod, EntityEntry<T> entry) {
		int id = getNewId(mod);
		EntityRegistry.registerModEntity(
				entry.classOfEntity,
				entry.entityName,
				id,
				mod,
				entry.trackingRange,
				entry.updateFrequency,
				entry.sendsVelocityUpdates,
				entry.eggPrimary,
				entry.eggSecondary);
	}

	private Class<T> classOfEntity;
	private IRenderFactory<T> renderFactory;
	private String entityName;
	private int trackingRange;
	private int updateFrequency;
	private boolean sendsVelocityUpdates;
	private int eggPrimary;
	private int eggSecondary;

	/**
	 * Initializes the EntityObject with the parameters and useful default values for the rest. These are: <br>
	 * <ul>
	 * <li>{@linkplain EntityEntry#trackingRange} = 30</li>
	 * <li>{@linkplain EntityEntry#updateFrequency} = 1</li>
	 * <li>{@linkplain EntityEntry#sendsVelocityUpdates} = true</li>
	 * <li>{@linkplain EntityEntry#eggPrimary} = name.hashCode()</li>
	 * <li>{@linkplain EntityEntry#eggSecondary} = (name+name).hashCode()</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @param name
	 * @param renderFactory
	 */
	public EntityEntry(Class<T> clazz, String name, IRenderFactory<T> renderFactory) {
		this.classOfEntity = clazz;
		this.entityName = name;
		this.renderFactory = renderFactory;
		this.trackingRange = 30;
		this.updateFrequency = 1;
		this.sendsVelocityUpdates = true;
		this.eggPrimary = name.hashCode();
		this.eggSecondary = (name + name).hashCode();
	}

	public EntityEntry(Class<T> clazz, String name) {
		this(clazz, name, (IRenderFactory<T>) null);
	}

	public EntityEntry(Class<T> clazz, String name, Render<T> renderer) {
		this(clazz, name, renderer == null ? null : (k) -> renderer);
	}

	public void registerRenderer() {
		if (renderFactory != null) {
			RenderManager manager = Minecraft.getMinecraft().getRenderManager();
			manager.entityRenderMap.put(classOfEntity, renderFactory.createRenderFor(manager));
		}
	}

	public void registerEntity(Object mod) {
		EntityEntry.registerEntity(mod, this);
	}

	public EntityEntry<T> setRenderFactory(IRenderFactory<T> renderFactory) {
		this.renderFactory = renderFactory;
		return this;
	}

	public EntityEntry<T> setTrackingRange(int trackingRange) {
		this.trackingRange = trackingRange;
		return this;
	}

	public EntityEntry<T> setUpdateFrequency(int updateFrequency) {
		this.updateFrequency = updateFrequency;
		return this;
	}

	public EntityEntry<T> setSendsVelocityUpdates(boolean sendsVelocityUpdates) {
		this.sendsVelocityUpdates = sendsVelocityUpdates;
		return this;
	}

	public EntityEntry<T> setEggColour(int eggPrimary, int eggSecondary) {
		this.eggPrimary = eggPrimary;
		this.eggSecondary = eggSecondary;
		return this;
	}
}
