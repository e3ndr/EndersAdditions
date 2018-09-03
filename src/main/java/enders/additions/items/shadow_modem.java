package enders.additions.items;

import java.util.concurrent.TimeUnit;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import enders.additions.endersadditions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class shadow_modem extends Item{
	public shadow_modem() {
		setUnlocalizedName("EndersAdditions" + "_" + "shadow_modem").setMaxStackSize(8);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "modem");
    }
	public static int tick = 0;
    
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			world.playSoundAtEntity(player, "endersadditions:modem", 10f, 1.0f);
			player.addChatMessage(new ChatComponentText("Dialing ShadowServers..."));    


			
	    	player.addChatMessage(new ChatComponentText("Connected to Shadow Servers...")); 
	    	
		}
		return itemstack;
	}
}
