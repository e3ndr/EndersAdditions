package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.item.Item;

public class items {

	//items
	public static Item stick_o_death = new enders.additions.items.itemStick_o_death();
    public static Item magic_dust = new enders.additions.items.dustMagic_dust();
    public static Item zoomi_wand = new enders.additions.items.itemZoomi_wand();
    public static Item magic_ingot = new enders.additions.items.ingotMagic_ingot();
    public static Item ded_wand = new enders.additions.items.itemDed_wand();
    public static Item jump_wand = new enders.additions.items.itemJump_wand();
    public static Item fast_wand = new enders.additions.items.itemFast_wand();
    public static Item fly_wand = new enders.additions.items.itemFly_wand();
    public static Item salt_shaker = new enders.additions.items.itemSalt_shaker();
    public static Item cube_wand = new enders.additions.items.itemCube_wand();
    public static Item shard_of_reality = new enders.additions.items.itemShard_of_reality();
    public static Item modem = new enders.additions.items.itemModem();
    public static Item shard_ball = new enders.additions.edibles.shard_ball(0, 0, 0, false);
    public static Item ice_cream = new enders.additions.edibles.ice_cream(0, 0, 0, false);
    public static Item salt = new enders.additions.edibles.salt(0, 0, 0, false);
    public static Item blorox = new enders.additions.edibles.blorox(0, 0, 0, false);
    public static Item ruby = new enders.additions.items.ingotRuby();
    public static Item boof = new enders.additions.items.itemBoof();
    public static Item slime_wand = new enders.additions.items.itemSlime_wand();
    public static Item magic_compound = new enders.additions.items.itemMagic_compound();
    
    
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	endersadditions.logger.info("Registering items");
		//register
		GameRegistry.registerItem(shard_ball, "shard_ball");
		GameRegistry.registerItem(modem, "modem");
		GameRegistry.registerItem(cube_wand, "cube_wand");
		GameRegistry.registerItem(shard_of_reality, "shard_of_reality");
		GameRegistry.registerItem(fly_wand, "fly_wand");
		GameRegistry.registerItem(salt_shaker, "salt_shaker");
		GameRegistry.registerItem(ded_wand, "ded_wand");
		GameRegistry.registerItem(magic_dust, "magic_dust");
		GameRegistry.registerItem(magic_ingot, "magic_ingot");
		GameRegistry.registerItem(stick_o_death, "stick_o_death");
		GameRegistry.registerItem(fast_wand, "fast_wand");
		GameRegistry.registerItem(jump_wand, "jump_wand");
		GameRegistry.registerItem(zoomi_wand, "zoomi_wand");
		GameRegistry.registerItem(ice_cream, "ice_cream");
		GameRegistry.registerItem(salt, "Salt");
		GameRegistry.registerItem(blorox, "Blorox");
		GameRegistry.registerItem(ruby, "Ruby");
		GameRegistry.registerItem(boof, "Boof");
		GameRegistry.registerItem(slime_wand, "Slime Wand");
		GameRegistry.registerItem(magic_compound, "Magic Compund");
		
	 }
}
