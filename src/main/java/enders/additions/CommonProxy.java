package enders.additions;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.handlers.ConfigHandler;
import enders.additions.world.worldgen.ores.Oregen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
    	
    	//config
        File configDir = new File(event.getModConfigurationDirectory() + "/");
        configDir.mkdirs();
        ConfigHandler.init(new File(configDir.getPath(), endersadditions.MODID + ".cfg"));
        
    	//register
        enders.additions.register.blocks.preInit(event);
        enders.additions.register.items.preInit(event);
        enders.additions.register.tool.preInit(event);
        enders.additions.register.armor.preInit(event);
        
        enders.additions.register.oreDictionary.preInit(event);
        enders.additions.register.recipes.preInit(event);
        GameRegistry.registerFuelHandler(new enders.additions.handlers.FuelHandler());
        
        //oregen
        Oregen ore_gen = new Oregen();
        GameRegistry.registerWorldGenerator(ore_gen, 0);
	}
}
