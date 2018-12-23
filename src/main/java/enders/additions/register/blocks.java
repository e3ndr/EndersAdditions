package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.block.Block;

public class blocks {
	
	
	public static Block magic_ore;
    public static Block missing_block;
    public static Block cube;
    public static Block stable_cube;
    public static Block salt_ore;
    public static Block ruby_ore;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	endersadditions.logger.info("Registering blocks");
    	stable_cube = new enders.additions.blocks.blockStable_cube();
    	cube = new enders.additions.blocks.blockCube();
		magic_ore = new enders.additions.blocks.oreMagic_ore();
		missing_block = new enders.additions.blocks.blockMissing_block();
		salt_ore = new enders.additions.blocks.oreSalt_ore();
		ruby_ore = new enders.additions.blocks.oreRuby_ore();
		
		
    }
}
