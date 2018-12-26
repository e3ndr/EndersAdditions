package enders.additions.items;

import java.util.Vector;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enders.additions.endersadditions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class itemSlime_wand extends Item {
	public itemSlime_wand() {
		setUnlocalizedName("EndersAdditions" + "_" + "slime_wand").setMaxStackSize(1);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "slime_wand");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
	    if (world.isRemote) {
	    	// Launch the player if they're on the ground
        	if(player.onGround) {
	        	float pitch = player.rotationPitch;
	        	float yaw = player.rotationYaw;
	        	// number to multiply by for final motion
	        	float f = 4.0f;
	        	double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
	        	double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
	        	double motionY = (double)(-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * f);
	        	player.setVelocity(motionX, motionY, motionZ);
	        	player.velocityChanged = true; // required for some strange reason
	        }
	    }
	    return itemStack;
	}
}
