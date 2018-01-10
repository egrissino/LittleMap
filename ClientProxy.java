package com.wegrizz.littlemap;

import com.wegrizz.littlemap.item.EntityCannonBall;
import com.wegrizz.littlemap.item.ModItems;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
		registerRenderers();
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.Init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}
	
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityCannonBall.class, new RenderSnowball(ModItems.cannonball));
	}
}
