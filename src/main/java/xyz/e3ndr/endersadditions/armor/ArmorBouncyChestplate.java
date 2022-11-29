package xyz.e3ndr.endersadditions.armor;

import java.util.List;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import xyz.e3ndr.endersadditions.EndersAdditions;
import xyz.e3ndr.endersadditions.Registry;

public class ArmorBouncyChestplate extends ArmorBouncyBase {

    public ArmorBouncyChestplate() {
        super(1);

        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("bouncy_chestplate"));
        this.setTextureName(EndersAdditions.generateTextureName("bouncy_chestplate"));

        GameRegistry.registerItem(this, "bouncy_chestplate");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings({
            "rawtypes",
            "unchecked"
    })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean p_77624_4_) {
        if (lines == null) return;
        lines.add("Repels enemies every time they hit you.");
        lines.add("You're still vulnerable to projectiles!");
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onHurt(LivingHurtEvent event) {
        // Make sure this is for a player.
        if (!(event.entityLiving instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.entityLiving;

        if (!EndersAdditions.isWearing(player, Registry.armorBouncyChestplate)) {
            return;
        }

        // Must be executed on the server.
        if (player.worldObj.isRemote) return;

        // Must come from another entity.
        if (event.source.getEntity() == null) return;

        Entity attacker = event.source.getEntity();

        // Hit by a projectile, ignore.
        if (event.source.getSourceOfDamage() != attacker) return;

        final float PI = (float) Math.PI; // Cache.
        final double LAUNCH_FORCE = 1.55;

        final float yaw = attacker.rotationYaw;

        // Calculate the launch direction.
        double motionX = +MathHelper.sin(yaw / 180.0F * PI);
        double motionZ = -MathHelper.cos(yaw / 180.0F * PI);

        // Add force.
        motionX *= LAUNCH_FORCE;
        motionZ *= LAUNCH_FORCE;

        // Apply to attacker but keep motionY the same.
        attacker.motionX = motionX;
        attacker.motionZ = motionZ;
        attacker.isAirBorne = true;
        attacker.velocityChanged = true; // required for some strange reason

        // Damage reduction is already handled by the game.
    }

}
