package enders.additions.items;

import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class itemJump_wand extends Item {
	{
	setUnlocalizedName("EndersAdditions" + "_" + "jump_wand").setMaxStackSize(1);	
	setCreativeTab(endersadditions.tabEnder);
	setTextureName("endersadditions" + ":" + "jump_wand");
	}

public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
	if (ConfigHandler.enableJumpWand) {
     if (entity instanceof EntityPlayer) {          
    	 EntityPlayer Player = (EntityPlayer) entity;
    	 if(Player.getCurrentEquippedItem() != null && Player.getCurrentEquippedItem().getItem() instanceof itemJump_wand) {
    		 Player.addPotionEffect((new PotionEffect(Potion.jump.getId(), 0, 1)));
    	 } else { 
    		 Player.curePotionEffects(itemstack);
         }
     }
	}
}
}
