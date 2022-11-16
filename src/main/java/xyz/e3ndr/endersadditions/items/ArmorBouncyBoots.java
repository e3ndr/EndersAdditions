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

public class ArmorBouncyBoots extends ItemArmor {
    private static final float PI = (float) Math.PI; // Cache.
    private static final double LAUNCH_FORCE = 2.0;
    private static final int FOOD_COST = 4;

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
        // Make the player sink in water.
        if (player.isInWater()) {
            player.velocityChanged = true;
            player.motionY = -.2f;
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onJump(LivingJumpEvent event) {
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
            launch(player);
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

        // Make the sound louder if the fall distance is > 4.
        float volume = event.distance > 4 ? 2f : .5f;
        event.entity.worldObj.playSound(player.posX, player.posY, player.posZ, "mob.slime.small", volume, 1.0f, false);

        // Happens on both sides.
        event.setCanceled(true);
        event.distance = 0;
        player.fallDistance = 0;
    }

    public static void launch(EntityPlayer player) {
        // Deduct food points.
        FoodStats food = player.getFoodStats();
        int foodLevel = food.getFoodLevel();

        if (foodLevel =< FOOD_COST) {
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
        player.velocityChanged = true; // required for some strange reason
    }

}
