package enders.additions.edibles;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enders.additions.endersadditions;
import enders.additions.modClasses.RecipeBlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class BlockSalt extends RecipeBlockCrops
{

    public BlockSalt()
    {
        // Basic block setup
        setBlockName("EndersAdditions_salty_bois");
        setBlockTextureName("endersadditions:salt_stage_0");
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
    {
        return (parMetadata/2);
    }
    
    public Item getItemDropped(int par1, Random rand, int par2){
    return endersadditions.ItemSalt;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {
          iIcon = new IIcon[maxGrowthStage+1];
          // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
          // to make generic should loop to maxGrowthStage
          iIcon[0] = parIIconRegister.registerIcon("endersadditions:salt_stage_0");
          iIcon[1] = parIIconRegister.registerIcon("endersadditions:salt_stage_0");
          iIcon[2] = parIIconRegister.registerIcon("endersadditions:salt_stage_1");
          iIcon[3] = parIIconRegister.registerIcon("endersadditions:salt_stage_1");
          iIcon[4] = parIIconRegister.registerIcon("endersadditions:salt_stage_2");
          iIcon[5] = parIIconRegister.registerIcon("endersadditions:salt_stage_2");
          iIcon[6] = parIIconRegister.registerIcon("endersadditions:salt_stage_3");
          iIcon[7] = parIIconRegister.registerIcon("endersadditions:salt_stage_3");
    }
}