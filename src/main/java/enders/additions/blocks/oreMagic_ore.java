package enders.additions.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class oreMagic_ore extends Block {
	private static final String name = "magic_ore";
    public oreMagic_ore() {
        super(Material.rock);
        GameRegistry.registerBlock(this, name);
        setBlockName("EndersAdditions_" + name);
        setBlockTextureName("endersadditions" + ":" + name);
        setCreativeTab(endersadditions.tabEnder);
        setHardness(1.5f);
        setLightLevel(5/16f);
    }
}