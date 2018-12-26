package enders.additions.armor;

import enders.additions.endersadditions;
import enders.additions.handlers.damageSource;
import enders.additions.register.armor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BouncyBoots extends ItemArmor {
	public BouncyBoots(ArmorMaterial armormaterial, int renderID, int partID) {
		super(armormaterial, renderID, partID);
	}
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
		if((itemstack.getItem() == armor.BouncyBoots)) {
			return "endersadditions:textures/models/armor/slime.png";
		}
		return null;
	}
	
	public static boolean takenOff;
	public static double motionX;
	public static double motionY;
	public static double motionZ;
    @Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	    if (world.isRemote && itemStack.getItem() == armor.BouncyBoots) {
	    	if (!player.onGround && !takenOff && !player.isInWater()) {
	    		takenOff = true;
	    		motionX = player.motionX;
	    		motionY = player.motionY * .8;
	    		motionZ = player.motionZ;
	    		// makes your motionY not negative
	    		if (motionY < 0) {
	    			motionY = motionY * -1;
	    		}
	    	}
	    	// hard landing
	    	if(player.onGround && takenOff && player.isSneaking()) {
	    		// this is to makesure the player doesnt launch into the air if they die and requip the boots
	    		takenOff = false;
	    		motionX = 0;
	    		motionY = 0;
	    		motionZ = 0;
	    	}
	    	// bounce
	    	if(player.onGround && takenOff && !player.isSneaking()) {
	    		// this is to makesure the player doesnt launch into the air if they die and requip the boots
	    		takenOff = false;
	    		world.playSound(player.posX, player.posY, player.posZ, "mob.slime.small", 10f, 1.0f, false);
	    		if (motionY <= 0.1) {
	    			motionX = 0;
		    		motionY = 0;
		    		motionZ = 0;
	    			return;
	    		} else {
	    			player.setVelocity(motionX, motionY, motionZ);
	    	    	player.velocityChanged = true; // required for some strange reason
	    			motionX = 0;
		    		motionY = 0;
		    		motionZ = 0;
	    		}
        	}
	    	// keeps you from bouncing back after being in water
	    	if (player.isInWater() && takenOff) {
	    		motionX = 0;
	    		motionY = 0;
	    		motionZ = 0;
	    		takenOff = false;
	    	}
	    }
	}
}
