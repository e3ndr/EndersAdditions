package enders.additions.items;

import java.util.Random;

import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class shard_of_reality extends Item {
	public shard_of_reality() {
		setUnlocalizedName("EndersAdditions" + "_" + "shard_of_reality").setMaxStackSize(8);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "shard_of_reality");
    }
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
            Random rand = new Random();
	    	int shardRand = rand.nextInt(10) + 1;
	    	if (shardRand == 1) {
	    	world.playSoundAtEntity(player, "endersadditions:cube", 10f, 1.0f);
	    	player.inventory.addItemStackToInventory(new ItemStack(enders.additions.register.items.modem, 1));
	    	player.addChatMessage(new ChatComponentText("It seems that the shard has momentarily created a portal to another dimension... You now have a strange object in your hands..."));
	    	player.inventory.consumeInventoryItem(this);
	    	} else {
	    		if (ConfigHandler.enableShardOfReality_Kill) {
	    			player.attackEntityFrom(DamageSource.magic, 1000f);
	    		}
			player.addChatMessage(new ChatComponentText(" Remember, When eating a transdimensional shards of reality one should call poison control as you have now teleported to a random dimension where you cannot exist."));
			player.inventory.consumeInventoryItem(this);
	    	}
		}
		return itemStack;
	}
}
