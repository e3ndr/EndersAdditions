package xyz.e3ndr.endersadditions.armor;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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

    @SuppressWarnings({
            "rawtypes",
            "unchecked"
    })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean p_77624_4_) {
        if (lines == null) return;
        lines.add("Repels enemies every time they hit you.");
    }

}
