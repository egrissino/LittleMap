package com.wegrizz.littlemap.block;

import net.minecraft.block.Block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class WorldBlock extends Block {
	protected WorldBlock(String unlocalizedName, Material material) {
		super(material);
		
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName("littlemap:worldblock");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHarvestLevel("axe", 0);
		this.setResistance(2000.0F);
		this.setHardness(1.5F);
		this.setLightLevel(1.0F);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		if( !world.isRemote) {
			ModBlocks.worldBlock.pos.isSet = false;
		}
	}
}
