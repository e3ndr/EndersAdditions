package xyz.e3ndr.endersadditions.armor;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import xyz.e3ndr.endersadditions.EndersAdditions;
import xyz.e3ndr.endersadditions.Registry;

public class ArmorBouncyBoots extends ArmorBouncyBase {

    public ArmorBouncyBoots() {
        super(3);

        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("bouncy_boots"));
        this.setTextureName(EndersAdditions.generateTextureName("bouncy_boots"));

        GameRegistry.registerItem(this, "bouncy_boots");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onFall(LivingFallEvent event) {
        // Make sure this is for a player.
        if (!(event.entityLiving instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.entityLiving;

        if (!EndersAdditions.isWearing(player, Registry.armorBouncyBoots)) {
            return;
        }

        final float DISTANCE_DIV = 100;
        final float VOLUME_DIV = 10;

        player.worldObj.playSoundAtEntity(player, "mob.slime.small", event.distance / VOLUME_DIV, 1.0f);

        // This'll reduce the damage taken while still preserving the value. There is no
        // way to cancel damage entirely while still preserving the distance due to how
        // Minecraft works, Oof.
        event.distance = event.distance / DISTANCE_DIV;

        // Cancel the bounce, but keep the damage scaler.
        if (player.isSneaking()) {
            return;
        }

        // We must first figure out the velocity of the player, since the motionY is
        // always wrong at this point, this is because the tick hasn't progressed far
        // enough. https://minecraft.fandom.com/wiki/Entity#Motion_of_entities
        final double GRAV_ACCELERATION = 0.08; // blocks/tick
        final double TERMINAL_VELOCITY = 3.92; // blocks/tick
        // vel = sqrt(2(ACC)(HEIGHT))

        float trueDistance = event.distance * DISTANCE_DIV;
        double velocity = Math.sqrt(2 * GRAV_ACCELERATION * trueDistance);
        if (velocity > TERMINAL_VELOCITY) {
            // Clamp.
            velocity = TERMINAL_VELOCITY;
        }

        final double MIN_VELOCITY = 0.3;
        if (velocity >= MIN_VELOCITY) {
            final double BOUNCE_DECAY = 0.55;
            final double BOUNCE_TRANSLATION_MULTIPLIER = 2.5;

            // Make the player "bounce"

            double bounceY = velocity * BOUNCE_DECAY;
            double bounceX = player.motionX * BOUNCE_TRANSLATION_MULTIPLIER;
            double bounceZ = player.motionZ * BOUNCE_TRANSLATION_MULTIPLIER;

//            System.out.println("isRemote:        " + player.worldObj.isRemote);
//            System.out.println("Fake distance:   " + event.distance);
//            System.out.println("Fall distance:   " + trueDistance);
//            System.out.println("Fall velocity:   " + velocity);
//            System.out.println("Fall Motion X:   " + player.motionX);
//            System.out.println("Fall Motion Z:   " + player.motionZ);
//            System.out.println("Bounce velocity: " + bounceY);
//            System.out.println("Bounce motion X: " + bounceX);
//            System.out.println("Bounce motion Z: " + bounceZ);
//            System.out.println();

            player.motionY = bounceY;
            player.motionX = bounceX;
            player.motionZ = bounceZ;
            player.isAirBorne = true;
            player.velocityChanged = true;
        }
    }

}
