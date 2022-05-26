package xyz.e3ndr.endersadditions.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class FoodSalt extends ItemFood {

    public FoodSalt() {
        super(0, 0, false);

        this.setAlwaysEdible();
        this.setMaxStackSize(64);
        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("salt"));
        this.setTextureName(EndersAdditions.generateTextureName("salt"));

        GameRegistry.registerItem(this, "salt");
    }

    @Override
    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        super.onFoodEaten(itemStack, world, player);

        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.weakness.id, 10, 100));
            player.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 100));
        }
    }

}
