package com.wegrizz.littlemap.recipe;

import com.wegrizz.littlemap.block.ModBlocks;
import com.wegrizz.littlemap.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public final class Crafting {
	public static final void init() {
		GameRegistry.addRecipe(new ItemStack(ModItems.wand, 1),
				" CB",
				" AC",
				"A  ",
				'A', Block.getBlockById(5),
				'B', Block.getBlockById(331),
				'C', Block.getBlockById(20));
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.worldBlock.block, 1),
				"CBC",
				"BAB",
				"CBC",
				'A', ModItems.wand,
				'B', Block.getBlockById(5),
				'C', Block.getBlockById(4));
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tableBlock.block, 1),
				"CBC",
				"BAB",
				"CBC",
				'A', ModItems.wand,
				'B', Block.getBlockById(5),
				'C', Block.getBlockById(20));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.theextractore, 1),
				" BC",
				" AB",
				"A  ",
				'A', Block.getBlockById(265),
				'B', Block.getBlockById(152),
				'C', Block.getBlockById(264));
		
	}
}
