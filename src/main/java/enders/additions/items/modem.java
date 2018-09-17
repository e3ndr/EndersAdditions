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
	    }
		return itemStack;
	}
}
