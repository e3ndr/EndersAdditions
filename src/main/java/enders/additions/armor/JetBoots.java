package enders.additions.armor;

import java.util.concurrent.ThreadLocalRandom;

import enders.additions.endersadditions;
import enders.additions.register.armor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class JetBoots extends ItemArmor {
	public JetBoots(ArmorMaterial armormaterial, int renderID, int partID) {
		super(armormaterial, renderID, partID);
	}
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
		if((itemstack.getItem() == armor.JetBoots)) {
			return "endersadditions:textures/models/armor/jet_boots.png";
		}
		return null;
	}
	
	
	private static int time = 0;
    @Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	    if (world.isRemote && itemStack.getItem() == armor.JetBoots) {
	    	if (player.isSneaking() && !player.isInWater()) {
	    		if (player.inventory.hasItem(enders.additions.register.items.magic_dust) && time == 0) {
	    			player.inventory.consumeInventoryItem(enders.additions.register.items.magic_dust);
	    			time = 1200;
	    		} else if (player.inventory.hasItem(enders.additions.register.items.magic_dust) || time != 0) {
	    			double randomNum0 = ThreadLocalRandom.current().nextDouble(-0.03, 0.03); // creates wobble
	    			double randomNum1 = ThreadLocalRandom.current().nextDouble(-0.03, 0.03); // creates wobble
	    			player.setVelocity(randomNum0, 0.2, randomNum1);
	    	    	player.velocityChanged = true; // required for some strange reason
	    			player.fallDistance = 0;
	    			time--;
	    		}
	    	}
	    }
	}
}
