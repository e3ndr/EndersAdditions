package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class recipes {
	
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	System.out.println("Registering recipes");
    	//shaped
    	GameRegistry.addRecipe(new ItemStack(enders.additions.register.items.shard_ball), new Object[]{
    			" A ",
    			"ABA",
    			" A ",
    			'A', enders.additions.register.items.shard_ball, 'B', Items.slime_ball
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
    			'A', enders.additions.register.items.ded_wand, 'B', Blocks.tnt, 'C', enders.additions.register.items.strange_diamond
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

    	//shapeless
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.fly_wand), enders.additions.register.items.stick_o_death, enders.additions.register.items.strange_powder, Items.blaze_rod, Items.feather, Items.bow);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.salt_shaker), Items.glass_bottle, enders.additions.register.items.salt);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.strange_diamond), Items.gunpowder, enders.additions.register.items.strange_powder, Items.cookie, Items.diamond, Items.redstone);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.zoomi_wand), enders.additions.register.items.ded_wand, enders.additions.register.items.strange_powder, Items.sugar);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.jump_wand), enders.additions.register.items.ded_wand, enders.additions.register.items.strange_powder, Items.slime_ball);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.fast_wand), enders.additions.register.items.stick_o_death, enders.additions.register.items.strange_powder, Blocks.packed_ice, Blocks.ice);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.ice_cream), enders.additions.register.items.salt, Items.milk_bucket, Blocks.ice, Items.sugar);
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.blocks.missing_block), Blocks.wool, Blocks.wool, Blocks.cobblestone, Blocks.cobblestone);
	
    	//smelting
    	GameRegistry.addSmelting(enders.additions.register.blocks.magic_ore, new ItemStack(enders.additions.register.items.strange_powder), 1.0F);
    
    }
}