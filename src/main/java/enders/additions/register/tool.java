package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import enders.additions.materials.axe;
import enders.additions.materials.hoe;
import enders.additions.materials.pickaxe;
import enders.additions.materials.shovel;
import enders.additions.materials.sword;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class tool {
	public static final Item.ToolMaterial ruby = EnumHelper.addToolMaterial("Ruby", 2, 224, 6.0F, 1F, 5);
	public static final Item.ToolMaterial magic = EnumHelper.addToolMaterial("Magic", 4, 2000, 12.0F, 1F, 0);

	/**
	 * @param name
	 * @param level (0-3)
	 * @param uses
	 * @param strength (wood = 2.0F, stone = 4.0F, iron = 6.0F, diamond = 8.0F, gold 12.0F)
	 * @param damage
	 * @param enchantability (wood = 15, stone = 5, iron = 14, diamond = 10, gold 22)
	 */
	// vars for tools (seperated by type)
	public static Item rubyAxe;
	public static Item rubyPickaxe;
	public static Item rubyShovel;
	public static Item rubySword;
	public static Item rubyHoe;
	
	public static Item magicAxe;
	public static Item magicPickaxe;
	public static Item magicShovel;
	public static Item magicSword;
	public static Item magicHoe;
	

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	endersadditions.logger.info("Registering tools");
    	// tools (seperated by type)
    	rubyAxe = new axe(ruby).setUnlocalizedName("EndersAdditions" + "_" + "rubyAxe").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyAxe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubyPickaxe = new pickaxe(ruby).setUnlocalizedName("EndersAdditions" + "_" + "rubyPickaxe").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyPickaxe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubyShovel = new shovel(ruby).setUnlocalizedName("EndersAdditions" + "_" + "rubyShovel").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyShovel").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubySword = new sword(ruby).setUnlocalizedName("EndersAdditions" + "_" + "rubySword").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubySword").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	rubyHoe = new hoe(ruby).setUnlocalizedName("EndersAdditions" + "_" + "rubyHoe").setTextureName(enders.additions.endersadditions.MODID + ":" + "rubyHoe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	
    	magicAxe = new axe(magic).setUnlocalizedName("EndersAdditions" + "_" + "magicAxe").setTextureName(enders.additions.endersadditions.MODID + ":" + "magicAxe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	magicPickaxe = new pickaxe(magic).setUnlocalizedName("EndersAdditions" + "_" + "magicPickaxe").setTextureName(enders.additions.endersadditions.MODID + ":" + "magicPickaxe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	magicShovel = new shovel(magic).setUnlocalizedName("EndersAdditions" + "_" + "magicShovel").setTextureName(enders.additions.endersadditions.MODID + ":" + "magicShovel").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	magicSword = new sword(magic).setUnlocalizedName("EndersAdditions" + "_" + "magicSword").setTextureName(enders.additions.endersadditions.MODID + ":" + "magicSword").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	magicHoe = new hoe(magic).setUnlocalizedName("EndersAdditions" + "_" + "magicHoe").setTextureName(enders.additions.endersadditions.MODID + ":" + "magicHoe").setCreativeTab(enders.additions.endersadditions.tabEnder);
    	
    	// register (seperated by type)
    	GameRegistry.registerItem(rubyAxe, "rubyAxe");
    	GameRegistry.registerItem(rubyPickaxe, "rubyPickaxe");
    	GameRegistry.registerItem(rubyShovel, "rubyShovel");
    	GameRegistry.registerItem(rubySword, "rubySword");
    	GameRegistry.registerItem(rubyHoe, "rubyHoe");
    	
    	GameRegistry.registerItem(magicAxe, "magicAxe");
    	GameRegistry.registerItem(magicPickaxe, "magicPickaxe");
    	GameRegistry.registerItem(magicShovel, "magicShovel");
    	GameRegistry.registerItem(magicSword, "magicSword");
    	GameRegistry.registerItem(magicHoe, "magicHoe");
    	
	}
}
