package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class recipes {
	
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	endersadditions.logger.info("Registering recipes");
    	//shaped
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.shard_ball), new Object[]{
    			" A ",
    			"ABA",
    			" A ",
    			'A', enders.additions.register.items.shard_of_reality, 'B', Items.slime_ball
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.cube_wand), new Object[]{
    			" C ",
    			" B ",
    			" A ",
    			'A', enders.additions.register.items.ded_wand, 'B', Blocks.noteblock, 'C', enders.additions.register.blocks.cube
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.stick_o_death), new Object[]{
    			" C ",
    			" B ",
    			" A ",
    			'A', enders.additions.register.items.ded_wand, 'B', Blocks.tnt, 'C', enders.additions.register.items.magic_ingot
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.ded_wand), new Object[]{
    			"  C",
    			" B ",
    			"A  ",
    			'A', Items.stick, 'B', Items.string, 'C', Items.iron_ingot
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.blocks.stable_cube), new Object[]{
    			"AAA",
    			"ABA",
    			"AAA",
    			'B', enders.additions.register.blocks.cube, 'A', enders.additions.register.items.shard_of_reality
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.blocks.cube), new Object[]{
    			"AAA",
    			"ABA",
	    		"AAA",
	    		'A', Items.nether_star, 'B', enders.additions.register.items.salt_shaker
    	});
    	
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.rubyAxe), new Object[]{
    			"AA ",
    			"AB ",
	    		" B ",
	    		'A', enders.additions.register.items.ruby, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.rubyPickaxe), new Object[]{
    			"AAA",
    			" B ",
	    		" B ",
	    		'A', enders.additions.register.items.ruby, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.rubyShovel), new Object[]{
    			" A ",
    			" B ",
	    		" B ",
	    		'A', enders.additions.register.items.ruby, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.rubySword), new Object[]{
    			" A ",
    			" A ",
	    		" B ",
	    		'A', enders.additions.register.items.ruby, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.rubyHoe), new Object[]{
    			"AA ",
    			" B ",
	    		" B ",
	    		'A', enders.additions.register.items.ruby, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.boof), new Object[]{
    			" A ",
    			"ABA",
	    		" A ",
	    		'A', Items.paper, 'B', Blocks.tallgrass
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.magic_compound), new Object[]{
    			"AAA",
    			"ABA",
	    		"AAA",
	    		'A', enders.additions.register.items.magic_dust, 'B', Items.iron_ingot
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.magicAxe), new Object[]{
    			"AA ",
    			"AB ",
	    		" B ",
	    		'A', enders.additions.register.items.magic_ingot, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.magicPickaxe), new Object[]{
    			"AAA",
    			" B ",
	    		" B ",
	    		'A', enders.additions.register.items.magic_ingot, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.magicShovel), new Object[]{
    			" A ",
    			" B ",
	    		" B ",
	    		'A', enders.additions.register.items.magic_ingot, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.magicSword), new Object[]{
    			" A ",
    			" A ",
	    		" B ",
	    		'A', enders.additions.register.items.magic_ingot, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.tool.magicHoe), new Object[]{
    			"AA ",
    			" B ",
	    		" B ",
	    		'A', enders.additions.register.items.magic_ingot, 'B', Items.stick
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.armor.BouncyBoots), new Object[]{
    			"   ",
    			"A A",
	    		"A A",
	    		'A', Items.slime_ball,
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.slime_wand), new Object[]{
    			"  B",
    			" A ",
	    		"   ",
	    		'A', enders.additions.register.items.fly_wand, 'B', Items.slime_ball
    	});
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.armor.JetBoots), new Object[]{
    			" C ",
    			"BAB",
	    		"B B",
	    		'A', Items.iron_boots, 'B', enders.additions.register.items.magic_ingot, 'C', Blocks.furnace
    	});
    	
    	//shapeless
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.fly_wand), enders.additions.register.items.stick_o_death, enders.additions.register.items.magic_dust, Items.blaze_rod, Items.feather, Items.bow);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.zoomi_wand), enders.additions.register.items.ded_wand, enders.additions.register.items.magic_dust, Items.sugar);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.jump_wand), enders.additions.register.items.ded_wand, enders.additions.register.items.magic_dust, Items.slime_ball);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.fast_wand), enders.additions.register.items.stick_o_death, enders.additions.register.items.magic_dust, Blocks.packed_ice, Blocks.ice);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.blocks.missing_block), Blocks.wool, Blocks.wool, Blocks.cobblestone, Blocks.cobblestone);

    	//oredictionary
    	oredictionaryRecipes.salt();
    	
    	//smelting
    	GameRegistry.addSmelting(enders.additions.register.blocks.magic_ore, new ItemStack(enders.additions.register.items.magic_dust), 1.0F);
    	GameRegistry.addSmelting(enders.additions.register.items.magic_compound, new ItemStack(enders.additions.register.items.magic_ingot), 0F);
    	
    
    }
    

    
}