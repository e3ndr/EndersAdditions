package enders.additions.items;

import java.awt.TextComponent;

import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemFly_wand extends Item {
	{
	setUnlocalizedName("EndersAdditions" + "_" + "fly_wand").setMaxStackSize(1);	
	setCreativeTab(endersadditions.tabEnder);
	setTextureName("endersadditions" + ":" + "fly_wand");
	}

public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
	int noFly = 0;
	if (ConfigHandler.enableFlyWand) {
     if (entity instanceof EntityPlayer) {
    	 EntityPlayer Player = (EntityPlayer) entity;
         if(Player.getCurrentEquippedItem() != null && Player.getCurrentEquippedItem().getItem() instanceof itemFly_wand) {
       	  Player.capabilities.allowFlying = true;
       	  noFly = 0;
         } else {
       	  if (Player.capabilities.isCreativeMode == false) {
       		  if (noFly == 0) {
       		  noFly = 1;
       		  Player.capabilities.allowFlying = false;
       		  Player.capabilities.isFlying = false;
       		  }
       	  } 
         }	
     }
	}
}
}
