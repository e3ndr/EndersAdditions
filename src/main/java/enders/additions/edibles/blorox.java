package enders.additions.edibles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import enders.additions.handlers.damageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class blorox extends ItemFood {
    public blorox(int par1, int par2, float par3, boolean par4) {
    	super(par1, par2, par4);
        this.setAlwaysEdible();
		setUnlocalizedName("EndersAdditions" + "_" + "blorox").setMaxStackSize(64);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "blorox");
    }
   
    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        super.onFoodEaten(itemStack, world, player);
        if (!world.isRemote) {
        	player.addPotionEffect(new PotionEffect(Potion.wither.id, 10000, 100));
        	player.addPotionEffect(new PotionEffect(Potion.blindness.id, 10000, 100));
        	player.addPotionEffect(new PotionEffect(Potion.hunger.id, 10000, 100));
        	player.attackEntityFrom(damageSource.bleach, Float.MAX_VALUE);
        }
    }
}