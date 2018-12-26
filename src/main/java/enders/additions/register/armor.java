package enders.additions.register;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import enders.additions.armor.BouncyBoots;
import enders.additions.armor.JetBoots;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class armor {
	public static final ArmorMaterial dummy = EnumHelper.addArmorMaterial("dummy", 10, new int[]{1, 1, 1, 1}, 0);

	/**
	 * @param name
	 * @param durability
	 * @param reduction
	 * @param enchantability
	 */
	
	public static Item BouncyBoots;
	public static Item JetBoots;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	endersadditions.logger.info("Registering armor");
    	BouncyBoots = new BouncyBoots(dummy, 5, 3).setUnlocalizedName("EndersAdditions" + "_" + "bouncy_boots").setTextureName(enders.additions.endersadditions.MODID + ":" + "bouncyBoots").setCreativeTab(endersadditions.tabEnder);
    	JetBoots = new JetBoots(dummy, 5, 3).setUnlocalizedName("EndersAdditions" + "_" + "jet_boots").setTextureName(enders.additions.endersadditions.MODID + ":" + "jetBoots").setCreativeTab(endersadditions.tabEnder);
    	
    	
    	GameRegistry.registerItem(BouncyBoots, "Bouncy Boots");
    	GameRegistry.registerItem(JetBoots, "Jet Boots");
	}
}
