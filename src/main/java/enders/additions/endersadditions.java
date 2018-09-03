package enders.additions;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
    public static Item shadow_modem;
   

    
   
    //blocks
    public static Block magic_ore;
    public static Block missing_block;
    public static Block cube;
    public static Block stable_cube;
    
    
    //edibles
    public static Item ItemSalt;
	public static Block BlockSalt = new enders.additions.edibles.BlockSalt();
	public static Item shard_ball;

    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	System.out.println(NAME + " Version " + VERSION + " for " + ACCEPTED_MINECRAFT_VERSIONS);

    	//config code below

        File configDir = new File(event.getModConfigurationDirectory() + "/");
        configDir.mkdirs();
        ConfigHandler.init(new File(configDir.getPath(), MODID + ".cfg"));
    	
        
        //dimensions
        
    	//recipes and classes below
        
        //Salt
        BlockSalt = new enders.additions.edibles.BlockSalt();
        ItemSalt = new enders.additions.edibles.ItemSalt();
        GameRegistry.registerBlock(BlockSalt, "Salty Bois");
        GameRegistry.registerItem(ItemSalt, "Salt");
        GameRegistry.addRecipe(new ItemStack(ItemSalt), new Object[]{
    	    	"ABA",
    	    	"BCB",
    	    	"ABA",
    	    	'A', Items.blaze_rod, 'B', Items.wheat_seeds, 'C', Items.nether_star
    	});
    	
        //end
   
        //magic_ore
    	magic_ore = new enders.additions.blocks.magic_ore();
    	//end

        //salt_shaker
    	salt_shaker = new enders.additions.items.salt_shaker();
    	GameRegistry.registerItem(salt_shaker, "salt_shaker");
    	GameRegistry.addShapelessRecipe(new ItemStack(salt_shaker), Items.glass_bottle, endersadditions.ItemSalt);
    	//end
    	
    	//ded_wand
    	ded_wand = new enders.additions.items.ded_wand();
    	GameRegistry.registerItem(ded_wand, "ded_wand");
    	GameRegistry.addRecipe(new ItemStack(ded_wand), new Object[]{
    	    	"  C",
    	    	" B ",
    	    	"A  ",
    	    	'A', Items.stick, 'B', Items.string, 'C', Items.iron_ingot
    	});
    	//end
    	
    	//strange_powder
    	strange_powder = new enders.additions.items.strange_powder();
    	GameRegistry.registerItem(strange_powder, "strange_powder");
    	GameRegistry.addSmelting(endersadditions.magic_ore, new ItemStack(endersadditions.strange_powder), 1.0F);
    	GameRegistry.addRecipe(new ItemStack(strange_powder), new Object[]{
    	    	" A ",
    	    	"ABC",
    	    	" A ",
    	    	'A', Items.gunpowder, 'B', Items.gold_nugget, 'C', Items.redstone
    	});
    	//end
    	
    	//missing_block
    	missing_block = new enders.additions.blocks.missing_block();
    	GameRegistry.addShapelessRecipe(new ItemStack(missing_block), Blocks.wool, Blocks.wool, Blocks.cobblestone, Blocks.cobblestone);
    	//end
    	
    	//strange_diamond
    	strange_diamond = new enders.additions.items.strange_diamond();
    	GameRegistry.registerItem(strange_diamond, "strange_diamond");
    	GameRegistry.addShapelessRecipe(new ItemStack(strange_diamond), Items.gunpowder, endersadditions.strange_powder, Items.cookie, Items.diamond, Items.redstone);
    	//end
    	
    	//stick_o_death
    	stick_o_death = new enders.additions.items.stick_o_death();
    	GameRegistry.registerItem(stick_o_death, "stick_o_death");
    	GameRegistry.addRecipe(new ItemStack(stick_o_death), new Object[]{
    	    	" C ",
    	    	" B ",
    	    	" A ",
    	    	'A', endersadditions.ded_wand, 'B', Blocks.tnt, 'C', endersadditions.strange_diamond
    	});
    	//end
    	
    	//zoomi_wand
    	zoomi_wand = new enders.additions.items.zoomi_wand();
    	GameRegistry.registerItem(zoomi_wand, "zoomi_wand");
    	GameRegistry.addShapelessRecipe(new ItemStack(zoomi_wand), endersadditions.ded_wand, endersadditions.strange_powder, Items.sugar);
    	//end

    	//jump_wand
    	jump_wand = new enders.additions.items.jump_wand();
    	GameRegistry.registerItem(jump_wand, "jump_wand");
    	GameRegistry.addShapelessRecipe(new ItemStack(jump_wand), endersadditions.ded_wand, endersadditions.strange_powder, Items.slime_ball);
    	//end
    	
    	//fast_wand
    	fast_wand = new enders.additions.items.fast_wand();
    	GameRegistry.registerItem(fast_wand, "fast_wand");
    	GameRegistry.addShapelessRecipe(new ItemStack(fast_wand), endersadditions.stick_o_death, endersadditions.strange_powder, Blocks.packed_ice, Blocks.ice);
    	//end
    	
    	//fly_wand
    	fly_wand = new enders.additions.items.fly_wand();
    	GameRegistry.registerItem(fly_wand, "fly_wand");
    	GameRegistry.addShapelessRecipe(new ItemStack(fly_wand), endersadditions.stick_o_death, endersadditions.strange_powder, Items.blaze_rod, Items.feather, Items.bow);
    	//end

        //cube
    	cube = new enders.additions.blocks.cube();
    	GameRegistry.addRecipe(new ItemStack(cube), new Object[]{
    	    	"AAA",
    	    	"ABA",
    	    	"AAA",
    	    	'A', Items.nether_star, 'B', endersadditions.salt_shaker
    	});
    	//end
    	
    	//fly_wand
    	shard_of_reality = new enders.additions.items.shard_of_reality();
    	GameRegistry.registerItem(shard_of_reality, "shard_of_reality");
    	//end
    	
        //stable_cube
    	stable_cube = new enders.additions.blocks.stable_cube();
    	GameRegistry.addRecipe(new ItemStack(stable_cube), new Object[]{
    	    	"AAA",
    	    	"ABA",
     	    	"AAA",
     	    	'B', endersadditions.cube, 'A', endersadditions.shard_of_reality
      	});
    	//end
    	
        //cube_wand
    	cube_wand = new enders.additions.items.cube_wand();
    	GameRegistry.registerItem(cube_wand, "cube_wand");
    	GameRegistry.addRecipe(new ItemStack(cube_wand), new Object[]{
    	    	" C ",
    	    	" B ",
    	    	" A ",
    	    	'A', endersadditions.ded_wand, 'B', Blocks.noteblock, 'C', endersadditions.cube
    	});
    	//end
    	
        //modem
    	modem = new enders.additions.items.modem();
    	GameRegistry.registerItem(modem, "modem");
    	//end  
    	
        //shard_ball
    	shard_ball = new enders.additions.edibles.shard_ball(0, 0, 0, false);
    	GameRegistry.registerItem(shard_ball, "shard_ball");
    	GameRegistry.addRecipe(new ItemStack(shard_ball), new Object[]{
    	    	" A ",
    	    	"ABA",
    	    	" A ",
    	    	'A', endersadditions.shard_ball, 'B', Items.slime_ball
    	});
    	//end
    	
    	//shadow_modem
    	shadow_modem = new enders.additions.items.shadow_modem();
    	GameRegistry.registerItem(shadow_modem, "shadow_modem");
    	//end  
    	
   
    	}
    	


	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {}
 
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

}