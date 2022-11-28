package xyz.e3ndr.endersadditions.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class ArmorBouncyChestplate extends ArmorBouncyBase {

    public ArmorBouncyChestplate() {
        super(1);

        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName("bouncy_chestplate"));
        this.setTextureName(EndersAdditions.generateTextureName("bouncy_chestplate"));

        GameRegistry.registerItem(this, "bouncy_chestplate");

        MinecraftForge.EVENT_BUS.register(this);
    }

}
