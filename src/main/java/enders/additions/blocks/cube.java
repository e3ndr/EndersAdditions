package enders.additions.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class cube extends Block
{
    protected cube(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

	private static final String name = "cube";
 
    public cube()
    {
        super(Material.rock);
        GameRegistry.registerBlock(this, name);
        setBlockName("EndersAdditions_" + name);
        setBlockTextureName("endersadditions" + ":" + name);
        setCreativeTab(endersadditions.tabEnder);
        setHardness(0.5f);
        setLightLevel(1/16f);
    }
}
