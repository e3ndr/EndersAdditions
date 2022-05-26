package xyz.e3ndr.endersadditions.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import xyz.e3ndr.endersadditions.Registry;

public class OreDictionaryRecipes {

    public static void register() {
        ItemStack salt = OreDictionary.getOres("foodSalt").get(0);

        GameRegistry.addShapelessRecipe(
            new ItemStack(Registry.foodIceCream),
            salt, Items.milk_bucket, Blocks.ice, Items.sugar
        );

        GameRegistry.addShapelessRecipe(
            new ItemStack(Registry.foodBlorox),
            salt, Items.glass_bottle, Items.paper
        );

        GameRegistry.addShapelessRecipe(
            new ItemStack(Registry.itemSaltShaker),
            Items.glass_bottle, salt
        );
    }

}
