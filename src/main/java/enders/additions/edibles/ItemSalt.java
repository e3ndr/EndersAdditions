package enders.additions.edibles;

import enders.additions.endersadditions;
import enders.additions.modClasses.RecipeItemSeedFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class ItemSalt extends RecipeItemSeedFood 
{

    public ItemSalt() 
    {
        super(1, 0.3F, endersadditions.BlockSalt, Blocks.farmland);
        setUnlocalizedName("EndersAdditions" + "_" + "salt").setMaxStackSize(16);	
        setTextureName("endersadditions:salt");
        setCreativeTab(endersadditions.tabEnder);
    }
}