package com.wegrizz.littlemap.item;

import java.util.ArrayList;
import java.util.List;

import com.wegrizz.littlemap.Main;
import com.wegrizz.littlemap.block.BlockPos;
import com.wegrizz.littlemap.block.BlockWrapper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TheExtractOre extends ItemPickaxe {
	
	public static int oreIds[] = {14, 15, 16, 21, 56, 73, 74, 129};
	
	public TheExtractOre(String unlocaizedName, ToolMaterial toolMaterial) {
		super(toolMaterial);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(unlocaizedName);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName(Main.MODID + ":theextractore");
		this.setMaxDamage(100);
		this.bFull3D = true;
	}
	
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			player.addChatMessage(new ChatComponentText("Hello!"));
		}
		return true; 
	}
	
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
        if (!world.isRemote) {
        		//((ICommandSender) entity).addChatMessage(new ChatComponentText("onBlockDestoyed begin"));
        		for(int i = 0; i < oreIds.length; i++) {
        			// Begin IF - 1
        			if(oreIds[i] == Block.getIdFromBlock(block)) {
        				List<BlockWrapper> vein = new ArrayList<BlockWrapper>();
                		vein.add(new BlockWrapper(block, new BlockPos(x, y, z)));
                		boolean hasChanged = true;
                		
                		// Begin Located all ore in vein
                		
                		while( hasChanged ) {
                    		hasChanged = false;
                    		for(int j = 0; j < vein.size(); j++) {
                    			BlockWrapper center = vein.get(j);
                    			
                    			// Condition to exit in the event of mishap
                    			if(vein.size() > 1000) {
                    				hasChanged = false;
                    				break;
                    			}
                    			
                    			for(int u = -1; u < 2; u++) {
                    				for( int v = -1; v < 2; v++) {
                    					for( int w = -1; w < 2; w++) {
                    						
                    						if( u == 0 && v == 0 && w == 0) {
                    							continue;
                    						}
                    						
                    						BlockWrapper near = center.getNearbyBlock(world, u, v, w);
                    						
                    						//System.out.println(  String.join(" ", near.block.getUnlocalizedName(), String.valueOf(u), String.valueOf(v), String.valueOf(w) ));
                    						
                    						
                    						if(Block.getIdFromBlock(near.block) == oreIds[i]) {
                    							//System.out.println(String.valueOf(Block.getIdFromBlock(near.block)));
                    							
                    							vein.add(near);
                    							hasChanged = true;
                    							//System.out.println(String.join(" ", "Vein Size: ", String.valueOf(vein.size())));
                    						}
                    					}
                    				}
                    			}	
                    		}
                    }// End Locate all ore
                    
                    // All ore in vein is located
                    for( int j = 0; j < vein.size(); j++) {
                    		BlockPos pos = vein.get(j).pos;
                    		world.func_147480_a(pos.XPos, pos.YPos, pos.ZPos, true);
                    }
                    //((ICommandSender) entity).addChatMessage(new ChatComponentText("Ore Vein Destoryed!"));
                    break;
        			}// End of IF - 1
        		}
        		//((ICommandSender) entity).addChatMessage(new ChatComponentText("onBlockDestoyed end"));
        }
        return false;
    }
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, int x, int y, int z, EntityPlayer player) {
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if(side == Side.SERVER) {
			//player.addChatMessage(new ChatComponentText("OOOOh Boy"));
		}
		
		
		return false;
	}
	
	
}
