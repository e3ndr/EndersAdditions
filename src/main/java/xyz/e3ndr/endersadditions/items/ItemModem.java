package xyz.e3ndr.endersadditions.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemModem extends GenericItem {

    public ItemModem() {
        super("modem");

        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            world.playSoundAtEntity(player, "endersadditions:modem", 10f, 1.0f);
        }
        return itemStack;
    }

}
