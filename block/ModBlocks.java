package com.wegrizz.littlemap.block;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public final class ModBlocks {
	
	// The list of world-table pairs
	public static List<BlockPos> wallBlockPair;
	
	// Place Holders for worldblock and tableblock *(These may be removed in the future)
	public static BlockWrapper worldBlock;
	public static BlockWrapper tableBlock;
	public static Block towerBlock;
	public static Block wallBlock;
	public static Block cannonBlock;
	
	// The world and the player that interacts
	// NOTE Any player can activate the blocks, it does NOT have to be performed by a single player
	public static World world;
	public static EntityPlayer player;
	
	public static final void init() {
		// Create the objects and add the default(not set) block positions
		worldBlock = new BlockWrapper(new WorldBlock("worldBlock", Material.wood), new BlockPos(0, 0, 0, false), "World Block" );
		tableBlock = new BlockWrapper(new TableBlock("tableBlock", Material.wood), new BlockPos(0, 0, 0, false), "Table Block" );
		towerBlock = new TowerBlock("towerBlock", Material.rock);
		wallBlock  = new WallBlock("wallBlock", Material.rock);
		cannonBlock = new CannonBlock("cannonBlock", Material.rock);
		
		wallBlockPair = new ArrayList<BlockPos>();
		
		// Register the blocks
		GameRegistry.registerBlock(worldBlock.block, "worldblock");
		GameRegistry.registerBlock(tableBlock.block, "tableblock");
		GameRegistry.registerBlock(towerBlock, "towerBlock");
		GameRegistry.registerBlock(wallBlock, "wallBlock");
		GameRegistry.registerBlock(cannonBlock, "cannonBlock");
	}
	
	
	/*
	public static void checkForSetup(World world, EntityPlayer player) {
		if( worldBlock.pos.isSet && tableBlock.pos.isSet ) {
			BuildTable();
		} else {
			return;
		}
	}
	
	public static void BuildTable() {
		
		player.addChatMessage(new ChatComponentText("You're Table is being built now!"));
		
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
					Block source = world.getBlock(
							worldBlock.pos.XPos + i, 
							worldBlock.pos.YPos + j,
							worldBlock.pos.ZPos + k
							);
					
					System.out.println(source.getUnlocalizedName());
					
					// Set Block from around the tableblock
					world.setBlock(
							tableBlock.pos.XPos + i,
							tableBlock.pos.YPos + j,
							tableBlock.pos.ZPos + k,
							source
							);
					
					
				}
			}
		}
		
		world.updateEntities();
		
		tableBuilt = true;
		player.addChatMessage(new ChatComponentText("You're Table is finished!"));
	}
	*/
}
