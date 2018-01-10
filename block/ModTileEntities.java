package com.wegrizz.littlemap.block;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModTileEntities {
	
	public static void init() {
		GameRegistry.registerTileEntity(ModTileEntity.class, "newBlockEntity");
	}
}
