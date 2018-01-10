package com.wegrizz.littlemap.block;

import java.util.Random;

import com.wegrizz.littlemap.item.Wand;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TableBlock extends Block {
	
	
	public static Random gen;
	
	// The Bounding box for a single world-table pair
	public static int xBound = 8;
	public static int yBound = 8;
	public static int zBound = 8;
	
	// Check if table is built *(I don't think this is necessary)
	public static boolean tableBuilt = false;

	protected TableBlock(String unlocalizedName, Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName("littlemap:tableblock");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHarvestLevel("axe", 0);
		this.setResistance(2000.0F);
		this.setHardness(1.5F);
		this.setLightLevel(1.0F);
		this.isBlockContainer = true;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		if( !world.isRemote) {
			ModBlocks.tableBlock.pos.isSet = false;
		}
	}
	
	public static void checkForSetup(World world, EntityPlayer player) {
		if( ModBlocks.worldBlock.pos.isSet && ModBlocks.tableBlock.pos.isSet ) {
			BuildTable();
		} else {
			return;
		}
	}
	
	public static void BuildTable() {
		
		ModBlocks.player.addChatMessage(new ChatComponentText("You're Table is being built now!"));
		
		// Cycle through the surrounding blocks and copy them from the World Block area to the
		// 		Table Block area
		for(int i = 0; i < xBound; i++) {
			for(int j = 0; j < yBound; j++) {
				for(int k = 0; k < zBound; k++) {
					// Don't include the Table Block or World Block
					if(i + j + k == 0 ) {
						continue;
					}
					
					// Source block from around the World Block
					Block source = Wand.world.getBlock(
							ModBlocks.worldBlock.pos.XPos + i, 
							ModBlocks.worldBlock.pos.YPos + j,
							ModBlocks.worldBlock.pos.ZPos + k
							);
					
					System.out.println(source.getUnlocalizedName());
					
					// Set Block from around the tableblock
					ModBlocks.world.setBlock(
							ModBlocks.tableBlock.pos.XPos + i,
							ModBlocks.tableBlock.pos.YPos + j,
							ModBlocks.tableBlock.pos.ZPos + k,
							source
							);
					
					
				}
			}
		}
		
		Wand.world.updateEntities();
		
		tableBuilt = true;
		Wand.player.addChatMessage(new ChatComponentText("You're Table is finished!"));
	}

}
