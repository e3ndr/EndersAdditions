package enders.additions.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class blockMissing_block extends Block {
	private static final String name = "missing_block";
	 
    public blockMissing_block()
    {
        super(Material.cloth);
        GameRegistry.registerBlock(this, name);
        setBlockName("EndersAdditions_" + name);
        setBlockTextureName("endersadditions" + ":" + name);
        setCreativeTab(endersadditions.tabEnder);
        setHardness(0.25f);
    }
}
