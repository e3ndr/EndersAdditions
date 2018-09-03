package enders.additions.items;

import java.util.Random;

import enders.additions.endersadditions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class modem extends Item {
	public modem() {
		setUnlocalizedName("EndersAdditions" + "_" + "modem").setMaxStackSize(8);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "modem");
    }
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			world.playSoundAtEntity(player, "endersadditions:modem", 10f, 1.0f);
            player.addChatMessage(new ChatComponentText("Dialing..."));  
            Random rand = new Random();
	    	int cubeWandRand = rand.nextInt(100) + 1;
	    	if (cubeWandRand == 1) {
	    		player.inventory.addItemStackToInventory(new ItemStack(endersadditions.shadow_modem, 1));
	    		player.addChatMessage(new ChatComponentText("The modem has transformed!"));
	    		player.inventory.consumeInventoryItem(this);
		    	
	    	}
            
            
	    }
		return itemStack;
	}
}
