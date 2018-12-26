package enders.additions;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.handlers.ConfigHandler;
import enders.additions.world.worldgen.ores.Oregen;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = endersadditions.MODID, name = endersadditions.NAME, version = endersadditions.VERSION)
public class endersadditions {
	public static final String MODID = "endersadditions";
	public static final String MODNAME = "Ender's Additions";
	public static final String NAME = "Ender's Additions";
    public static final String VERSION = "3.0R";
	public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.7.10]";

	@Mod.Instance("endersadditions")
    public static endersadditions instance;
	
	public static Logger logger = LogManager.getLogger(endersadditions.MODID);
	public static CreativeTabs tabEnder = new enders.additions.handlers.tabEnder(CreativeTabs.getNextID(), "Ender's Additions");
    
	 @SidedProxy(clientSide="enders.additions.ClientProxy", serverSide="enders.additions.ServerProxy")
	 public static CommonProxy proxy;
	 
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger.info(NAME + " Version " + VERSION + " for " + ACCEPTED_MINECRAFT_VERSIONS);
    	
    	//proxy (for rendering prefix)
    	proxy.preInit(event);
    	}
}