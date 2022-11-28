package xyz.e3ndr.endersadditions.armor;

import java.util.List;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import xyz.e3ndr.endersadditions.EndersAdditions;
import xyz.e3ndr.endersadditions.Registry;

public class ArmorBouncyLeggings extends ArmorBouncyBase {

    public ArmorBouncyLeggings() {
        super(2);

        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("bouncy_leggings"));
        this.setTextureName(EndersAdditions.generateTextureName("bouncy_leggings"));

        GameRegistry.registerItem(this, "bouncy_leggings");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings({
            "rawtypes",
            "unchecked"
    })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean p_77624_4_) {
        if (lines == null) return;
        lines.add("Allows you to launch yourself by holding SNEAK and then jumping.");
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onJump(LivingJumpEvent event) {
        // Make sure this is for a player.
        if (!(event.entityLiving instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.entityLiving;

        if (!EndersAdditions.isWearing(player, Registry.armorBouncyLeggings)) {
            return;
        }

        if (!player.worldObj.isRemote) {
            return;
        }

        if (!player.isSneaking()) {
            return; // Must be sneaking to slime jump.
        }

        final float PI = (float) Math.PI; // Cache.
        final double LAUNCH_FORCE = 2.15;
        final double MIN_Y = .5;

        // Calculate the launch direction.
        final float pitch = player.rotationPitch;
        final float yaw = player.rotationYaw;

        double motionX = -MathHelper.sin(yaw / 180.0F * PI) * MathHelper.cos(pitch / 180.0F * PI);
        double motionZ = +MathHelper.cos(yaw / 180.0F * PI) * MathHelper.cos(pitch / 180.0F * PI);
        double motionY = -MathHelper.sin((pitch) / 180.0F * PI);

        // Apply force.
        motionX *= LAUNCH_FORCE;
        motionY *= LAUNCH_FORCE;
        motionZ *= LAUNCH_FORCE;

        // Clamp the minimum Y.
        if (motionY < MIN_Y) {
            motionY = MIN_Y;
        }

        // Apply to player.
        player.setVelocity(motionX, motionY, motionZ);
        player.isAirBorne = true;
        player.velocityChanged = true; // required for some strange reason
    }

}
