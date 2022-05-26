package xyz.e3ndr.endersadditions.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSlimeWand extends GenericItem {
    private static final float PI = (float) Math.PI; // Cache.

    public ItemSlimeWand() {
        super("slime_wand");

        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (world.isRemote) {
            // Launch the player if they're on the ground
            if (player.onGround) {
                final float pitch = player.rotationPitch;
                final float yaw = player.rotationYaw;

                final float force = 4.0f;

                float motionX = -MathHelper.sin(yaw / 180.0F * PI) * MathHelper.cos(pitch / 180.0F * PI) * force;
                float motionZ = +MathHelper.cos(yaw / 180.0F * PI) * MathHelper.cos(pitch / 180.0F * PI) * force;
                float motionY = -MathHelper.sin((pitch) / 180.0F * PI) * force;

                player.setVelocity(motionX, motionY, motionZ);
                player.velocityChanged = true; // required for some strange reason
            }
        }
        return itemStack;
    }
}
