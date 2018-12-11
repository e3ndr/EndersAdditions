package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.item.Item;

public class items {

	//items
	public static Item stick_o_death;
    public static Item strange_powder;
    public static Item zoomi_wand;
    public static Item strange_diamond;
    public static Item ded_wand;
    public static Item jump_wand;
    public static Item fast_wand;
    public static Item fly_wand;
    public static Item salt_shaker;
    public static Item cube_wand;
    public static Item shard_of_reality;
    public static Item modem;
    public static Item shard_ball;
    public static Item ice_cream;
    public static Item salt;
    public static Item blorox;
    public static Item ruby;
    
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	
    	endersadditions.logger.info("Registering items");
    	//variables n shi
    	salt_shaker = new enders.additions.items.salt_shaker();
    	ded_wand = new enders.additions.items.ded_wand();
    	strange_powder = new enders.additions.items.strange_powder();
    	strange_diamond = new enders.additions.items.strange_diamond();
    	stick_o_death = new enders.additions.items.stick_o_death();
    	zoomi_wand = new enders.additions.items.zoomi_wand();
    	jump_wand = new enders.additions.items.jump_wand();
    	fast_wand = new enders.additions.items.fast_wand();
		fly_wand = new enders.additions.items.fly_wand();
		shard_of_reality = new enders.additions.items.shard_of_reality();
		cube_wand = new enders.additions.items.cube_wand();
		shard_ball = new enders.additions.edibles.shard_ball(0, 0, 0, false);
		modem = new enders.additions.items.modem();
		ice_cream = new enders.additions.edibles.ice_cream(0, 0, 0, false);
		salt = new enders.additions.edibles.salt(0, 0, 0, false);
		blorox = new enders.additions.edibles.blorox(0, 0, 0, false);
		ruby = new enders.additions.edibles.ruby();
		
	
		//register
		GameRegistry.registerItem(shard_ball, "shard_ball");
		GameRegistry.registerItem(modem, "modem");
		GameRegistry.registerItem(cube_wand, "cube_wand");
		GameRegistry.registerItem(shard_of_reality, "shard_of_reality");
		GameRegistry.registerItem(fly_wand, "fly_wand");
		GameRegistry.registerItem(salt_shaker, "salt_shaker");
		GameRegistry.registerItem(ded_wand, "ded_wand");
		GameRegistry.registerItem(strange_powder, "strange_powder");
		GameRegistry.registerItem(strange_diamond, "strange_diamond");
		GameRegistry.registerItem(stick_o_death, "stick_o_death");
		GameRegistry.registerItem(fast_wand, "fast_wand");
		GameRegistry.registerItem(jump_wand, "jump_wand");
		GameRegistry.registerItem(zoomi_wand, "zoomi_wand");
		GameRegistry.registerItem(ice_cream, "ice_cream");
		GameRegistry.registerItem(salt, "Salt");
		GameRegistry.registerItem(blorox, "Blorox");
		GameRegistry.registerItem(ruby, "Ruby");
		
	 }
}
