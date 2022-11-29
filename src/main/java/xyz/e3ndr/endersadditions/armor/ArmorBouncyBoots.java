package xyz.e3ndr.endersadditions.armor;

import java.util.List;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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

        this.addInformation(null, null, null, bFull3D);
    }

    @SuppressWarnings({
            "rawtypes",
            "unchecked"
    })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean p_77624_4_) {
        if (lines == null) return;
        lines.add("Makes you bounce when you land on the ground!");
//        lines.add("Also produces a slopping sound when you walk.");
    }

//    @Override
//    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//        super.onArmorTick(world, player, itemStack); // Make sure that the sink code is called!
//
//        if (world.isRemote) return; // Run this code on the server.
//
//        final long SOUND_EVERY = 5/*ticks*/;
//
//        boolean isOnGround = player.onGround;
//        boolean isMoving = TODO;
//        boolean isSoundTick = world.getTotalWorldTime() % SOUND_EVERY == 0;
//
//        System.out.println("isOnGround=" + isOnGround + " isMoving=" + isMoving + " isSoundTick=" + isSoundTick);
//
//        if (!isOnGround || !isMoving || !isSoundTick) return;
//
//        world.playSoundAtEntity(player, "mob.slime.small", 2f, 1.0f);
//    }

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
            player.motionY = velocity * BOUNCE_DECAY;
            player.motionX *= BOUNCE_TRANSLATION_MULTIPLIER;
            player.motionZ *= BOUNCE_TRANSLATION_MULTIPLIER;
            player.isAirBorne = true;
            player.velocityChanged = true;
        }
    }

}
