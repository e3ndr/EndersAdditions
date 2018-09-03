package enders.additions.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class magic_ore extends Block {
	private static final String name = "magic_ore";
    public magic_ore() {
        super(Material.rock);
        GameRegistry.registerBlock(this, name);
        setBlockName("EndersAdditions_" + name);
        setBlockTextureName("endersadditions" + ":" + name);
        setCreativeTab(endersadditions.tabEnder);
        setHardness(1.5f);
        setLightLevel(5/16f);
    }
}
