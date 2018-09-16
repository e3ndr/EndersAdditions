package enders.additions;

import java.io.File;
import enders.additions.register.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = endersadditions.MODID, name = endersadditions.NAME, version = endersadditions.VERSION)
public class endersadditions {
	public static final String MODID = "endersadditions";
	public static final String MODNAME = "Ender's Additions";
	public static final String NAME = "Ender's Additions";
    public static final String VERSION = "2.0b";
	public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.7.10]";

	@Mod.Instance("endersadditions")
    public static endersadditions instance;
	
	public static CreativeTabs tabEnder = new enders.additions.handlers.tabEnder(CreativeTabs.getNextID(), "Ender's Additions");
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	System.out.println(NAME + " Version " + VERSION + " for " + ACCEPTED_MINECRAFT_VERSIONS);

    	//config code below

        File configDir = new File(event.getModConfigurationDirectory() + "/");
        configDir.mkdirs();
        ConfigHandler.init(new File(configDir.getPath(), MODID + ".cfg"));
    	
        
        items items = new enders.additions.register.items();
        items.preInit(event);
        
        blocks blocks = new enders.additions.register.blocks();
        blocks.preInit(event);
        
        recipes recipes = new enders.additions.register.recipes();
        recipes.preInit(event);
        
        
    	}
    
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {}
 
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

}