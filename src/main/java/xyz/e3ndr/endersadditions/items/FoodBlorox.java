package xyz.e3ndr.endersadditions.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.e3ndr.endersadditions.EndersAdditions;
import xyz.e3ndr.endersadditions.Registry;

public class FoodBlorox extends ItemFood {

    public FoodBlorox() {
        super(0, 0, false);

        this.setAlwaysEdible();
        this.setMaxStackSize(64);
        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("blorox"));
        this.setTextureName(EndersAdditions.generateTextureName("blorox"));

        GameRegistry.registerItem(this, "blorox");
    }

    @Override
    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        super.onFoodEaten(itemStack, world, player);
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.wither.id, 10000, 100));
            player.addPotionEffect(new PotionEffect(Potion.blindness.id, 10000, 100));
            player.addPotionEffect(new PotionEffect(Potion.hunger.id, 10000, 100));
            player.attackEntityFrom(Registry.damageSourceBleach, Float.MAX_VALUE);
        }
    }

}
