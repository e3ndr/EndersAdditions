package enders.additions.edibles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class shard_ball extends ItemFood {
    public shard_ball(int par1, int par2, float par3, boolean par4) {
    	super(par1, par2, par4);
        this.setAlwaysEdible();
		setUnlocalizedName("EndersAdditions" + "_" + "shard_ball").setMaxStackSize(64);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "shard_ball");
    }
   
    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        super.onFoodEaten(itemStack, world, player);
        if (!world.isRemote) {
        	if (ConfigHandler.enableFastWand) {
        		player.addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 10));
        		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10, 100));
        	} else {
        		player.inventory.addItemStackToInventory(new ItemStack(endersadditions.shard_ball, 1));
        		player.addChatMessage(new ChatComponentText("This Item has been disabled via config."));
        	}
        }
    }
}