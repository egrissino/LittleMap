package com.wegrizz.littlemap.item;

import com.wegrizz.littlemap.Main;
import com.wegrizz.littlemap.block.BlockPos;
import com.wegrizz.littlemap.block.BlockWrapper;
import com.wegrizz.littlemap.block.ModBlocks;
import com.wegrizz.littlemap.block.TableBlock;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;


public class Wand extends ItemSword {
	
	public static World world;
	public static EntityPlayer player;
	
	protected Wand(String unlocaizedName, ToolMaterial material) {
		super(material);
		
		this.setUnlocalizedName(unlocaizedName);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setTextureName(Main.MODID + ":wand");
		this.setMaxDamage(100);
	}
	
	
	
	private void checkSelected(BlockWrapper hit, BlockWrapper savedBlock ) {
		//  - Function to check if the player used the Wand on one of the littleMap Blocks
		//
		// If the player uses the wand on either `World Block` or `Table Block` this will save the
		// 		position of that block in the ModBlocks class for later use
		
		// The BlockWrapper for `hit` is the block that the player activated the wand on, this Block
		//		is a real object in the world
		// The BlockWrapper for `savedBlock` is the block in the ModBlocks class that hold the info
		// 		for either the worldBlock or the tableBlock
		
		// * Should implement multiple table-world pairs
		if( Block.isEqualTo(hit.block, savedBlock.block)) {
			if( BlockPos.isEqual( hit.pos, savedBlock.pos) && savedBlock.pos.isSet ) {
				savedBlock.pos.isSet = false;
				ModBlocks.player.addChatMessage(new ChatComponentText( String.join(" ", "You've deselected your", savedBlock.name) ) );
			} else {
				savedBlock.pos = hit.pos;
				ModBlocks.player.addChatMessage(new ChatComponentText( String.join(" ", "You've selected a", savedBlock.name) ) );
			}
			
			// Run routine to check if that was the last block need to build table
			TableBlock.checkForSetup(ModBlocks.world, ModBlocks.player);
		}
		
		
	}
	
	
	public boolean onItemUse(ItemStack stack, EntityPlayer _player, World _world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		
		if(!world.isRemote) {
			world = _world;
			player = _player;
			BlockWrapper hit = new BlockWrapper(world.getBlock( x, y, z ), new BlockPos(x, y, z, true) );
			
			checkSelected(hit, ModBlocks.worldBlock);
			checkSelected(hit, ModBlocks.tableBlock);
			
			if( Block.isEqualTo(hit.block, ModBlocks.tableBlock.block) ) {
				if( world.getBlock(x, y+1, z).hasTileEntity(0)) {
					player.addChatMessage(new ChatComponentText( String.join(" ", String.valueOf(x), String.valueOf(y), String.valueOf(z), world.getTileEntity(x, y+1, z).toString() )));
				}
				
			} else {
				player.addChatMessage(new ChatComponentText( String.join(" ", String.valueOf(x), String.valueOf(y), String.valueOf(z), hit.block.getClass().getName() )));
			}
		
		}
		
		return true; 
	}
}
