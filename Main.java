package com.wegrizz.littlemap;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

    public static final String MODID = "littlemap";
    public static final String MODNAME = "Little Map";
    public static final String VERSION = "1.7.10";
    public static final boolean useMetaData = true;
        
    @Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide="com.wegrizz.littlemap.ClientProxy", serverSide="com.wegrizz.littlemap.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    		System.out.println("Called method: preInit");
    		proxy.preInit(e);
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
    		System.out.println("Called method: Init"); 
    		proxy.Init(e);
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    		System.out.println("Called method: Init");
    		proxy.postInit(e);
    }
}