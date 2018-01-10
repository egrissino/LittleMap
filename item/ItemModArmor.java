package com.wegrizz.littlemap.item;

import com.wegrizz.littlemap.Main;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemModArmor extends ItemArmor {
	private String textureName;

	public ItemModArmor(String unlocalizedName, ArmorMaterial armorMaterial, String textureName, int type) {
		super(armorMaterial, 0, type);
		// TODO Auto-generated constructor stub
		
		this.setUnlocalizedName(unlocalizedName);
		this.textureName = textureName;
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return Main.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}

}
