package enders.additions.items;

import java.util.Calendar;

import enders.additions.endersadditions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class shadow_modem extends Item{
	public shadow_modem() {
		setUnlocalizedName("EndersAdditions" + "_" + "shadow_modem").setMaxStackSize(8);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "shadow_modem");
    }

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			player.addChatMessage(new ChatComponentText("Dialing Shadow Servers..."));    
			player.addChatMessage(new ChatComponentText("Link Established, processing packets...")); 
			player.addChatMessage(new ChatComponentText("Discarding Packets...")); 
			player.addChatMessage(new ChatComponentText("Unknown error, printing known error...")); 
			player.addChatMessage(new ChatComponentText("0x7761697420666f7220322e302072656c65617365")); 
			player.addChatMessage(new ChatComponentText("located at address 0x3132")); 
			player.addChatMessage(new ChatComponentText("Disconnected.")); 
			}
		return itemstack;
	}



}
