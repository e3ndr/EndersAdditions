package xyz.e3ndr.endersadditions.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorBouncyBase extends ItemArmor {
    private static final int renderId = 5;
    private static final ArmorMaterial armorMaterial = EnumHelper.addArmorMaterial(
        "bouncy",
        45,
        new int[] {
                2,
                5,
                4,
                1
        },
        0
    );

    public ArmorBouncyBase(int type) {
        super(armorMaterial, renderId, type);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
        if (slot == 2) { // Leggings.
            return "endersadditions:textures/models/armor/bouncy_layer_2.png";
        } else {
            return "endersadditions:textures/models/armor/bouncy_layer_1.png";
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (!world.isRemote) return;

        // Make the player sink in water.
        if (player.isInWater()) {
            final double SINK_RATE = -0.2f;
            player.motionY = SINK_RATE;
            player.velocityChanged = true;
        }
    }

}
