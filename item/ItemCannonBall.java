package com.wegrizz.littlemap.item;

import com.wegrizz.littlemap.Main;
import com.wegrizz.littlemap.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCannonBall extends Item {

	public boolean instanceAlive = false;
	
	public ItemCannonBall() {
		super();
		
		System.out.println("A cannonBall has been created");
		
		this.setMaxStackSize(16);
		this.setUnlocalizedName("cannonball");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName(Main.MODID + ":cannonball");
	}
	
	public boolean hasEffect(ItemStack stack, int pass) {
		return false;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		if( !world.isRemote) {
			System.out.println("CannonBall has been used");
			
			Block usedOn = world.getBlock(x, y, z);
			
			if (Block.isEqualTo(usedOn, ModBlocks.cannonBlock)) {

//				if( !EntityCannonBall.isAlive ) {
//					world.spawnEntityInWorld( new EntityCannonBall(world));
//					EntityCannonBall.isAlive = true;
////					System.out.println("Hi im alive now!");
//				}
			}
		}
		
		
		return true;
	}
	
	
	
	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
//		System.out.println("A cannonBall has been Right Clicked");
		

		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}
		
		//world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	
		if (!world.isRemote) {
			if( !EntityCannonBall.isAlive ) {
				world.spawnEntityInWorld( new EntityCannonBall(world, player));
				EntityCannonBall.isAlive = true;
//				System.out.println("Hi im alive now!");
			}
			
		}
		return stack;
	}
	
	
	// IconRegister renamed to IIconRegister
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void registerIcons(IIconRegister iconRegister) {
//		itemIcon = iconRegister.registerIcon(Main.MODID + getUnlocalizedName().substring(5).toLowerCase());
//	}
	
}
