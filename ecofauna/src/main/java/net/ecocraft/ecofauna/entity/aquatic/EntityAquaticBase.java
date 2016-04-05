package net.ecocraft.ecofauna.entity.aquatic;

import net.ecocraft.ecofauna.entity.EntityFlauraBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAquaticBase extends EntityFlauraBase {

	protected int maximumAirSupply;
	protected int suffocationInterval;
	protected float drownDamage;

	public EntityAquaticBase(World worldIn) {
		super(worldIn);
		this.maximumAirSupply = 300;
		this.suffocationInterval = 20;
		this.drownDamage = 2.0f;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public void onEntityUpdate() {
		int air = this.getAir();
		super.onEntityUpdate();
		if (this.isEntityAlive() && !this.isInWater()) {
			if (air <= 0) {
				this.attackEntityFrom(DamageSource.drown, drownDamage);
				this.setAir(suffocationInterval);
			} else {
				this.setAir(air - 1);
			}
		} else {
			this.setAir(maximumAirSupply);
		}
	}
}
