package enders.additions.items;

import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class itemBoof extends Item {
	public itemBoof() {
		setUnlocalizedName("EndersAdditions" + "_" + "boof").setMaxStackSize(1);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "boof");
		this.setMaxDamage(20);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
	    if (!world.isRemote) {
	        if(player.inventory.hasItem(enders.additions.register.items.boof)) {
	        	player.addPotionEffect(new PotionEffect(Potion.hunger.id, 10000, 10));
	        	player.addPotionEffect(new PotionEffect(Potion.confusion.id, 10000, 100));
	        	player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10000, 100));
	        	player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10000, 100));
	        	itemStack.damageItem(1, player);
	        	if (itemStack.getItemDamage() == 20) {
	        		player.inventory.consumeInventoryItem(this);
	        	}
	        }
	    }
	    return itemStack;
	}
}
