package xyz.e3ndr.endersadditions.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.e3ndr.endersadditions.Registry;

public class ItemSaltShaker extends GenericItem {

    public ItemSaltShaker() {
        super("salt_shaker");

        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.attackEntityFrom(Registry.damageSourceSalt, 1f);
        }
        return itemStack;
    }

}
