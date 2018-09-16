package enders.additions;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.handlers.ConfigHandler;
import enders.additions.register.blocks;
import enders.additions.register.items;
import enders.additions.register.recipes;
import enders.additions.world.worldgen.ores.Oregen;
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
    	
        enders.additions.register.blocks.preInit(event);
        enders.additions.register.items.preInit(event);
        enders.additions.register.recipes.preInit(event);

        Oregen ore_gen = new Oregen();
        GameRegistry.registerWorldGenerator(ore_gen, 0);
    	}
    
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {}
 
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

}