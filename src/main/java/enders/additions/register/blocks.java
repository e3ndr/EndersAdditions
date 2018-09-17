package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class blocks {
	
	
	public static Block magic_ore;
    public static Block missing_block;
    public static Block cube;
    public static Block stable_cube;
    public static Block salt_ore;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	System.out.println("Registering blocks");
    	stable_cube = new enders.additions.blocks.stable_cube();
    	cube = new enders.additions.blocks.cube();
		magic_ore = new enders.additions.blocks.magic_ore();
		missing_block = new enders.additions.blocks.missing_block();
		salt_ore = new enders.additions.blocks.salt_ore();
		
		
    }
}