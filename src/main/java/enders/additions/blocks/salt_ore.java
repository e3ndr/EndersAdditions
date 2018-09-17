package enders.additions.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class salt_ore extends Block {
	private static final String name = "salt_ore";
    public salt_ore() {
        super(Material.rock);
        GameRegistry.registerBlock(this, name);
        setBlockName("EndersAdditions_" + name);
        setBlockTextureName("endersadditions" + ":" + name);
        setCreativeTab(endersadditions.tabEnder);
        setHardness(0.5f);
    }
    
    public Item getItemDropped(int par1, Random rand, int par2){
    return enders.additions.register.items.salt;
    }
}