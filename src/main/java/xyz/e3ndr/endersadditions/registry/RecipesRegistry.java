package xyz.e3ndr.endersadditions.registry;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import xyz.e3ndr.endersadditions.Registry;

public class RecipesRegistry {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        // @formatter:off
        // shaped
        GameRegistry.addRecipe(new ItemStack(Registry.itemWand), new Object[] {
                "  C",
                " B ",
                "A  ",
                
                'A', Items.stick,
                'B', Items.string,
                'C', Items.iron_ingot
        });

        GameRegistry.addRecipe(new ItemStack(Registry.toolRubyAxe), new Object[] {
                "AA ",
                "AB ",
                " B ",
                
                'A', Registry.itemRuby, 
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolRubyPickaxe), new Object[] {
                "AAA",
                " B ",
                " B ",
                
                'A', Registry.itemRuby,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolRubyShovel), new Object[] {
                " A ",
                " B ",
                " B ",
                
                'A', Registry.itemRuby,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolRubySword), new Object[] {
                " A ",
                " A ",
                " B ",
                'A', Registry.itemRuby,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolRubyHoe), new Object[] {
                "AA ",
                " B ",
                " B ",
                'A', Registry.itemRuby,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.itemBoof), new Object[] {
                " A ",
                "ABA",
                " A ",
                'A', Items.paper,
                'B', Blocks.tallgrass
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.itemMagicCompound), new Object[] {
                "AAA",
                "ABA",
                "AAA",
                'A', Registry.itemMagicDust,
                'B', Items.iron_ingot
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolMagicAxe), new Object[] {
                "AA ",
                "AB ",
                " B ",
                'A', Registry.itemMagicIngot,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolMagicPickaxe), new Object[] {
                "AAA",
                " B ",
                " B ",
                'A', Registry.itemMagicIngot,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolMagicShovel), new Object[] {
                " A ",
                " B ",
                " B ",
                'A', Registry.itemMagicIngot,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolMagicSword), new Object[] {
                " A ",
                " A ",
                " B ",
                'A', Registry.itemMagicIngot,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.toolMagicHoe), new Object[] {
                "AA ",
                " B ",
                " B ",
                'A', Registry.itemMagicIngot,
                'B', Items.stick
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.armorBouncyBoots), new Object[] {
                "   ",
                "A A",
                "A A",
                'A', Items.slime_ball,
        });
        
        GameRegistry.addRecipe(new ItemStack(Registry.itemSlimeWand), new Object[] {
                "  B",
                " A ",
                "   ",
                'A', Registry.itemWand,
                'B', Items.slime_ball
        });
        
        // shapeless
        GameRegistry.addShapelessRecipe(
            new ItemStack(Registry.blockMissingBlock),
            Blocks.wool, Blocks.wool, Blocks.cobblestone, Blocks.cobblestone
        );

        // oredictionary
        OreDictionaryRecipes.register();

        // smelting
        GameRegistry.addSmelting(
            Registry.blockMagicOre, 
            new ItemStack(Registry.itemMagicDust), 
            1.0F
        );
        
        GameRegistry.addSmelting(
            Registry.itemMagicCompound, 
            new ItemStack(Registry.itemMagicIngot), 
            0F
        );

        // @formatter:on

    }

}
