package enders.additions.items;

import java.util.Random;

import enders.additions.endersadditions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class itemCube_wand extends Item {
	public itemCube_wand()
	{
		setUnlocalizedName("EndersAdditions" + "_" + "cube_wand").setMaxStackSize(1);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "cube_wand");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
	    if (!world.isRemote) {
	        if(player.inventory.hasItem(enders.additions.register.items.cube_wand)) {
	        	world.playSoundAtEntity(player, "endersadditions:cube", 10f, 1.0f);
	            player.attackEntityFrom(DamageSource.magic, 1f);
	            itemStack.setItemDamage(itemStack.getItemDamage() + 1);
				player.attackEntityFrom(DamageSource.magic, 2f);
				player.addChatMessage(new ChatComponentText("The cube has dissolved. The cube's Shards have attacked you in turn."));
	            Random rand = new Random();
		    	int cubeWandRand = rand.nextInt(10) + 1;
		    	if (cubeWandRand == 1) {
		    		player.inventory.addItemStackToInventory(new ItemStack(enders.additions.register.items.shard_of_reality, 1));
		    		player.addChatMessage(new ChatComponentText("You pick a shard out of your skin and discover it has strange properties..."));
		    	}
		    	player.inventory.consumeInventoryItem(this);
	        }
	    }
	    return itemStack;
	}
	public int getFirstHolder(IInventory inventory) {
	    for (int slot = 0; slot < inventory.getSizeInventory(); ++slot)
	        if (inventory.getStackInSlot(slot).getItem() == enders.additions.register.items.cube_wand)
	            return slot;
	    return -1;
	}
}
