package com.wegrizz.littlemap.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class BaseModItem extends Item {
	// no more IDs
	public BaseModItem() {
		super();
	}

	// IconRegister renamed to IIconRegister
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("tutorial:" + getUnlocalizedName().substring(5).toLowerCase());
	}
}