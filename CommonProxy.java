package com.wegrizz.littlemap;

import com.wegrizz.littlemap.block.ModBlocks;
import com.wegrizz.littlemap.block.ModTileEntities;
import com.wegrizz.littlemap.item.ModItemEntities;
import com.wegrizz.littlemap.item.ModItems;
import com.wegrizz.littlemap.recipe.Crafting;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.init();
		ModBlocks.init();
		ModTileEntities.init();
		ModItemEntities.init();
	}
	
	public void Init(FMLInitializationEvent e) {
		Crafting.init();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
	
	}
}
