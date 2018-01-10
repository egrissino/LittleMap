package com.wegrizz.littlemap.block;

import com.wegrizz.littlemap.item.EntityCannonBall;
import com.wegrizz.littlemap.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CannonBlock extends Block {
	
	public static float rotationPitch;
	public static float rotationYaw;
	public static int posX;
	public static int posY;
	public static int posZ;
	public static boolean loaded = false;
	
	private static EntityThrowable cannonBallEntity;
	
	protected CannonBlock(String unlocalizedName, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if( !world.isRemote) {
			System.out.println("Cannon Activated");
			world.getTileEntity(x, y, z);
			ItemStack playerStack = player.getCurrentEquippedItem();
			if( playerStack != null) {
				if( playerStack.getItem() == ModItems.cannonball) {
					if (!loaded ) {
						loaded = true;
						playerStack.stackSize--;
					} else {
						player.addChatComponentMessage(new ChatComponentText("That cannon is already loaded"));
					}
				} else if(loaded) {
					fire(world);
				}
			} else if(loaded) {
				fire(world);
			}
		}
		
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack) {
		posX = x;
		posY = y;
		posZ = z;
		
		
	}
	
	public void fire(World world) {
		System.out.println("fire function called");
		if( !EntityCannonBall.isAlive ) {
			System.out.println("Firing the cannon!");
			world.spawnEntityInWorld(cannonBallEntity = new EntityCannonBall(world));
			
//			cannonBallEntity.setSize(0.25F, 0.25F);
			cannonBallEntity.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
			cannonBallEntity.posX -= (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
			cannonBallEntity.posY -= 0.10000000149011612D;
			cannonBallEntity.posZ -= (double)(MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
			cannonBallEntity.setPosition(posX, posY, posZ);
			cannonBallEntity.yOffset = 0.0F;
	        float f = 0.4F;
	        cannonBallEntity.motionX = (double)(-MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI) * f);
	        cannonBallEntity.motionZ = (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI) * f);
	        cannonBallEntity.motionY = (double)(-MathHelper.sin((rotationPitch) / 180.0F * (float)Math.PI) * f);
	        cannonBallEntity.setThrowableHeading(cannonBallEntity.motionX, cannonBallEntity.motionY, cannonBallEntity.motionZ, 1.5F, 1.0F);
			System.out.println("Hi im alive now!");
		}
	}
}
