package pl.pabilo8.immersiveintelligence.common.items.ammunition;

import blusunrize.immersiveengineering.client.ClientUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pl.pabilo8.immersiveintelligence.api.bullets.BulletRegistry.EnumCoreTypes;
import pl.pabilo8.immersiveintelligence.client.fx.ParticleExplosion;
import pl.pabilo8.immersiveintelligence.client.fx.ParticleUtils;
import pl.pabilo8.immersiveintelligence.client.model.IBulletModel;
import pl.pabilo8.immersiveintelligence.client.model.bullet.ModelBullet8bCal;
import pl.pabilo8.immersiveintelligence.common.entity.bullets.EntityBullet;

import javax.annotation.Nonnull;

/**
 * @author Pabilo8
 * @since 30-08-2019
 */
public class ItemIIAmmoLightArtillery extends ItemIIBulletBase
{
	public ItemIIAmmoLightArtillery()
	{
		super("artillery_6bCal", 1);
	}

	@Override
	public float getComponentCapacity()
	{
		return 0.65f;
	}

	@Override
	public int getGunpowderNeeded()
	{
		return 4;
	}

	@Override
	public int getCoreMaterialNeeded()
	{
		return 3;
	}

	@Override
	public float getInitialMass()
	{
		return 0.85f;
	}

	@Override
	public float getCaliber()
	{
		return 0.375f;
	}

	@Override
	public @Nonnull Class<? extends IBulletModel> getModel()
	{
		return ModelBullet8bCal.class;
	}

	@Override
	public float getDamage()
	{
		return 30;
	}

	@Override
	public EnumCoreTypes[] getAllowedCoreTypes()
	{
		return new EnumCoreTypes[]{EnumCoreTypes.SHAPED, EnumCoreTypes.CANISTER, EnumCoreTypes.DOUBLE_CANISTER};
	}

	@Override
	public float getSupressionRadius()
	{
		return 3;
	}

	@Override
	public int getSuppressionPower()
	{
		return 20;
	}

	@Override
	public boolean shouldLoadChunks()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void doPuff(EntityBullet bullet)
	{
		for(int i = 0; i < 20; i += 1)
		{
			Vec3d v = bullet.getBaseMotion().rotatePitch(-90f).rotateYaw(i/20f*360f);
			ParticleExplosion particle = new ParticleExplosion(ClientUtils.mc().world, bullet.posX, bullet.posY, bullet.posZ, v.x*0.125, v.y*0.0125, v.z*0.125, 3.25f);
			ParticleUtils.particleRenderer.addEffect(particle);
		}
	}
}
