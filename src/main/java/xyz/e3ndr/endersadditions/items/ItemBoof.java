package xyz.e3ndr.endersadditions.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBoof extends GenericItem {

    public ItemBoof() {
        super("boof");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.hunger.id, 10000, 10));
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 10000, 100));
            player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10000, 100));
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 10000, 100));

            itemStack.damageItem(1, player);

            if (itemStack.getItemDamage() == 20) {
                player.inventory.consumeInventoryItem(this);
            }
        }

        return itemStack;
    }

}
