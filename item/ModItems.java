package com.wegrizz.littlemap.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;


public final class ModItems {
	
	// Tools and their materials
	public static Item wand;
	public static ToolMaterial wandMaterial = EnumHelper.addToolMaterial("WandMaterial", 0, 100, 8.0F, 1.0F, 25);
	
	public static Item theextractore;
	public static ToolMaterial theextractoreMaterial = EnumHelper.addToolMaterial("TheExtractOreMaterial", 0, 100, 8.0F, 1.0F, 25);
	
	public static Item cannonball;
	
	// Armor
	public static Item potatoChestPlate;
	public static Item potatoHelmet;
	public static Item potatoLeggings;
	public static Item potatoBoots;
	public static ArmorMaterial potatoArmorMaterial = EnumHelper.addArmorMaterial("PotatoArmor", 10, new int[] {2,5,4,1}, 20);
	
	public static final void init() {
		GameRegistry.registerItem(wand = new Wand("wand", wandMaterial), "wand");
		GameRegistry.registerItem(theextractore = new TheExtractOre("theextractore", theextractoreMaterial), "theextractore");
		GameRegistry.registerItem(cannonball = new ItemCannonBall(), "cannonball");
		
		GameRegistry.registerItem(potatoHelmet 		= new ItemModArmor("potatoHelmet", 		potatoArmorMaterial, "potato", 0), "potatoHelmet");
		GameRegistry.registerItem(potatoChestPlate 	= new ItemModArmor("potatoChestPlate", 	potatoArmorMaterial, "potato", 1), "potatoChestPlate");
		GameRegistry.registerItem(potatoLeggings 	= new ItemModArmor("potatoLeggings", 	potatoArmorMaterial, "potato", 2), "potatoLeggings");
		GameRegistry.registerItem(potatoBoots 		= new ItemModArmor("potatoBoots", 		potatoArmorMaterial, "potato", 3), "potatoBoots");
	}
}
