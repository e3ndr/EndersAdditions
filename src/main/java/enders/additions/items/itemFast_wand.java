package enders.additions.items;

import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class itemFast_wand extends Item {
	{
	setUnlocalizedName("EndersAdditions" + "_" + "fast_wand").setMaxStackSize(1);	
	setCreativeTab(endersadditions.tabEnder);
	setTextureName("endersadditions" + ":" + "fast_wand");
	}

public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
	if (ConfigHandler.enableFastWand) {
     if (entity instanceof EntityPlayer) {          
    	 EntityPlayer Player = (EntityPlayer) entity;
         if(Player.getCurrentEquippedItem() != null && Player.getCurrentEquippedItem().getItem() instanceof itemFast_wand) {
       	  Player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 0, 7)));
         } else { 
       	  Player.curePotionEffects(itemstack);
         }
     }
	}
}
}
