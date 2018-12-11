package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.materials.axe;
import enders.additions.materials.hoe;
import enders.additions.materials.pickaxe;
import enders.additions.materials.shovel;
import enders.additions.materials.sword;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class tool {
	public static final Item.ToolMaterial ruby = EnumHelper.addToolMaterial("Ruby", 2, 224, 6.0F, 1F, 5);

	/**
	 * @param name
	 * @param level (0-3)
	 * @param uses
	 * @param strength (wood = 2.0F, stone = 4.0F, iron = 6.0F, diamond = 8.0F, gold 12.0F)
	 * @param damage
	 * @param enchantability (wood = 15, stone = 5, iron = 14, diamond = 10, gold 22)
	 */

	public static Item rubyAxe;
	public static Item rubyPickaxe;
	public static Item rubyShovel;
	public static Item rubySword;
	public static Item rubyHoe;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	rubyAxe = new axe(ruby).setUnlocalizedName("rubyAxe").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyAxe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubyPickaxe = new pickaxe(ruby).setUnlocalizedName("rubyPickaxe").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyPickaxe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubyShovel = new shovel(ruby).setUnlocalizedName("rubyShovel").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyShovel").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubySword = new sword(ruby).setUnlocalizedName("rubySword").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubySword").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubyHoe = new hoe(ruby).setUnlocalizedName("rubyHoe").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyHoe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	

		
		
    	GameRegistry.registerItem(rubyAxe, "rubyAxe");
    	GameRegistry.registerItem(rubyPickaxe, "rubyPickaxe");
    	GameRegistry.registerItem(rubyShovel, "rubyShovel");
    	GameRegistry.registerItem(rubySword, "rubySword");
    	GameRegistry.registerItem(rubyHoe, "rubyHoe");
    	
	}
}
