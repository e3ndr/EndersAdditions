package enders.additions.register;

import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class oredictionaryRecipes {
    public static void salt() {
    	ItemStack salt = OreDictionary.getOres("itemSalt").get(0);

    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.ice_cream), salt, Items.milk_bucket, Blocks.ice, Items.sugar);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.blorox), salt, Items.glass_bottle, Items.paper);
    	GameRegistry.addShapelessRecipe(new ItemStack(enders.additions.register.items.salt_shaker), Items.glass_bottle, salt);
    }
    
    
    
}
