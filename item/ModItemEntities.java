package com.wegrizz.littlemap.item;

import com.wegrizz.littlemap.Main;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModItemEntities {
	
	public static void init() {
		EntityRegistry.registerModEntity(EntityCannonBall.class, "cannonball", 0, Main.instance, 64, 10, true);	
	}
}
