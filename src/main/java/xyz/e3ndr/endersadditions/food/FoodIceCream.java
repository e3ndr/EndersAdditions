package xyz.e3ndr.endersadditions.food;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class FoodIceCream extends ItemFood {

    public FoodIceCream() {
        super(0, 0, false);

        this.setAlwaysEdible();
        this.setMaxStackSize(64);
        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("ice_cream"));
        this.setTextureName(EndersAdditions.generateTextureName("ice_cream"));

        GameRegistry.registerItem(this, "ice_cream");
    }

    @Override
    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        super.onFoodEaten(itemStack, world, player);

        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10, 100));
            player.addPotionEffect(new PotionEffect(23, 10, 100));
        }
    }

}
