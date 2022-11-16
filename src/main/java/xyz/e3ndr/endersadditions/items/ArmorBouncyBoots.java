package xyz.e3ndr.endersadditions.items;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.FoodStats;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import xyz.e3ndr.endersadditions.EndersAdditions;
import xyz.e3ndr.endersadditions.Registry;
import xyz.e3ndr.endersadditions.proxies.CommonProxy;

public class ArmorBouncyBoots extends ItemArmor {

    public ArmorBouncyBoots(ArmorMaterial armormaterial, int renderID) {
        super(armormaterial, renderID, 3);

        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("bouncy_boots"));
        this.setTextureName(EndersAdditions.generateTextureName("bouncy_boots"));
        this.setCreativeTab(EndersAdditions.tabEnder);

        GameRegistry.registerItem(this, "bouncy_boots");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String layer) {
        return "endersadditions:textures/models/armor/slime.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (CommonProxy.isServerSide()) return;

        // Make the player sink in water.
        if (player.isInWater()) {
            player.velocityChanged = true;
            player.motionY = -.2f;
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onJump(LivingJumpEvent event) {
        if (CommonProxy.isServerSide()) return;

        // Make sure this is for a player.
        if (!(event.entityLiving instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.entityLiving;
        ItemStack armorItem = player.getCurrentArmor(0);

        // Make sure the player is wearing the boots.
        if ((armorItem == null) || (armorItem.getItem() != Registry.armorBouncyBoots)) {
            return;
        }

        if (player.isSneaking()) {
            final float PI = (float) Math.PI; // Cache.
            final double LAUNCH_FORCE = 2.0;
            final int FOOD_COST = 4;

            // Deduct food points.
            FoodStats food = player.getFoodStats();
            int foodLevel = food.getFoodLevel();

            if (foodLevel <= FOOD_COST) {
                return;
            }

            foodLevel -= FOOD_COST;
            food.setFoodLevel(foodLevel);

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

            // Apply to player.
            player.motionX = motionX;
            player.motionY = motionY;
            player.motionZ = motionZ;
            player.isAirBorne = true;
            player.velocityChanged = true; // required for some strange reason
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onFall(LivingFallEvent event) {
        // Make sure this is for a player.
        if (!(event.entityLiving instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.entityLiving;
        ItemStack armorItem = player.getCurrentArmor(0);

        // Make sure the player is wearing the boots.
        if ((armorItem == null) || (armorItem.getItem() != Registry.armorBouncyBoots)) {
            return;
        }

        // Happens on both sides.
        event.setCanceled(true);

        if (CommonProxy.isServerSide()) return;

        // Make the sound louder if the fall distance is > 4.
        float volume = event.distance > 4 ? 2f : .5f;
        player.worldObj.playSoundAtEntity(player, "mob.slime.small", volume, 1.0f);

        if (!player.isSneaking()) {
            // We must first figure out the velocity of the player, since the motionY is
            // wrong. https://minecraft.fandom.com/wiki/Entity#Motion_of_entities
            final double GRAV_ACCELERATION = 0.08; // blocks/tick
            final double TERMINAL_VELOCITY = 3.92; // blocks/tick
            // vel = sqrt(2(ACC)(HEIGHT))

            double velocity = Math.sqrt(2 * GRAV_ACCELERATION * player.fallDistance);
            if (velocity > TERMINAL_VELOCITY) {
                // Clamp.
                velocity = TERMINAL_VELOCITY;
            }

            final double MIN_VELOCITY = 0.3;
            if (velocity >= MIN_VELOCITY) {
                final double BOUNCE_DECAY = 0.55;
                final double BOUNCE_TRANSLATION_MULTIPLIER = 2.2;

//                System.out.println("Fall distance:   " + player.fallDistance);
//                System.out.println("Fall velocity:   " + velocity);
//                System.out.println("Fall Motion X:   " + player.motionX);
//                System.out.println("Fall Motion Z:   " + player.motionZ);

                // Make the player "bounce"
                player.motionY = velocity * BOUNCE_DECAY;
                player.motionX *= BOUNCE_TRANSLATION_MULTIPLIER;
                player.motionZ *= BOUNCE_TRANSLATION_MULTIPLIER;
                player.isAirBorne = true;
                player.velocityChanged = true;

//                System.out.println("Bounce velocity: " + player.motionY);
//                System.out.println("Bounce motion X: " + player.motionX);
//                System.out.println("Bounce motion Z: " + player.motionZ);
//                System.out.println();
            }
        }
    }

}
