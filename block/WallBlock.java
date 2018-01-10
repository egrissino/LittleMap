package com.wegrizz.littlemap.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class WallBlock extends Block {

	private int wallHeight;

	protected WallBlock(String unlocalizedName, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName("littlemap:wallblock");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHarvestLevel("pickaxe", 1);
		this.setResistance(2000.0F);
		this.setHardness(1.5F);
		this.setLightLevel(1.0F);
		this.isBlockContainer = true;
		this.wallHeight = 5;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(!world.isRemote) {
			System.out.println("Activated Wall Block!");
			if (ModBlocks.wallBlockPair.isEmpty() ) {
				ModBlocks.wallBlockPair.add( new BlockPos(x, y, z) );
				return true;
			}
			
			BlockPos block1 = ModBlocks.wallBlockPair.get(0);
			
			int y_start = y;
			int y_end = block1.YPos + this.wallHeight;
			
			if (block1.YPos < y) {
				y_start = ModBlocks.wallBlockPair.get(0).YPos;
				y_end = y + this.wallHeight;
			}
			
			int template[][] = generateTemplate(ModBlocks.wallBlockPair.get(0), new BlockPos(x, y, z));
			
			for(int i = y_start; i < y_end; i++) {
				for( int j = 0; j < template.length; j++) {
					Block block = Block.getBlockById(4);
					if(i == wallHeight - 1) {
						if(j % 2 == 0 && j < template.length - 2) {
							block = Block.getBlockById(50);
						}
					}
					world.setBlock(x + template[j][0], i, z + template[j][1], block);
				}
			}
			
			ModBlocks.wallBlockPair.clear();
			return true;
		}
		return true;
	}
	
	public static int[][] generateTemplate(BlockPos pos1, BlockPos pos2) {
		

		int dx = pos1.XPos - pos2.XPos;
		int dz = pos1.ZPos - pos2.ZPos;
		
		int template[][] = new int[Math.abs(dx) + Math.abs(dz) + 1][2];
		
		int i = 0;
		int inc_x = 1;
		int inc_z = 1;
		
		if(Math.abs(dx) > 0) {
			inc_x = dx / Math.abs(dx);
		}
		if( Math.abs(dz) > 0) {
			inc_z = dz / Math.abs(dz);
		}
		
		for( i = 0; i < Math.abs(dx); i++) {
			template[i][0] = i * inc_x;
			template[i][1] = 0;
		}	
		for ( int j = 0; j <= Math.abs(dz); j++) {
			template[i + j][0] = dx;
			template[i + j][1] = inc_z * j;
		}
		
		return template;
	}

}
