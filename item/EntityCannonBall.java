package com.wegrizz.littlemap.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCannonBall extends EntityThrowable {
	
	public World worldImIn;
	public static boolean isAlive = false;
	
	private void init(World world) {
		worldImIn = world;
		isAlive = true;
	}
	
	public EntityCannonBall(World world) {
		super(world);
		// TODO Auto-generated constructor stub
		init(world);
	}
	
	public EntityCannonBall(World world, EntityLivingBase player) {
		super(world, player);
		// TODO Auto-generated constructor stub
		init(world);
	}
	
	public EntityCannonBall(World world, double par2, double par4, double par6) {
		super(world, par2, par4, par6);
		// TODO Auto-generated constructor stub
		init(world);
	}

	@Override
	protected void onImpact(MovingObjectPosition mop) {
		// TODO Auto-generated method stub
		System.out.println("Hit!");
		
		worldImIn.createExplosion(this, mop.blockX, mop.blockY, mop.blockZ, 5.0F, true);
//		worldImIn.removeEntity(this);
		isAlive = false;
		setDead();
	}

}
