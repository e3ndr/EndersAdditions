package xyz.e3ndr.endersadditions.items;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import xyz.e3ndr.endersadditions.EndersAdditions;
import xyz.e3ndr.endersadditions.Registry;

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

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onFall(LivingFallEvent event) {
        World world = event.entity.worldObj;

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

        // Happen on both sides.

        if (!player.isSneaking()) {
            world.playSound(player.posX, player.posY, player.posZ, "mob.slime.small", 10f, 1.0f, false);
        }

        event.setCanceled(true);
        event.distance = 0;
        player.fallDistance = 0;
    }

}
