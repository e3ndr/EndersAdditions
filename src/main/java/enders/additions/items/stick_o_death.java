package enders.additions.items;

import enders.additions.endersadditions;
import enders.additions.handlers.ConfigHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class stick_o_death extends Item {
	public stick_o_death()
	{
		setUnlocalizedName("EndersAdditions" + "_" + "stick_o_death").setMaxStackSize(1);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "stick_o_death");
		
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
	    if (!world.isRemote) {
	        if(player.inventory.hasItem(endersadditions.stick_o_death)) {
	            world.createExplosion(player, player.posX, player.posY, player.posZ, 2.0F, true);
	            world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ)); 
	            ItemStack holder = player.inventory.getStackInSlot(getFirstHolder(player.inventory));
	            player.inventory.consumeInventoryItem(this);
	            if (ConfigHandler.enableStickODeath) {  
	            	player.attackEntityFrom(DamageSource.magic, 100f);
	            }
	            // Apply NBT to holder
	        }
	    }
	    return itemStack;
	}
	public int getFirstHolder(IInventory inventory) {
	    for (int slot = 0; slot < inventory.getSizeInventory(); ++slot)
	        if (inventory.getStackInSlot(slot).getItem() == endersadditions.stick_o_death)
	            return slot;
	    return -1;
	}
}
