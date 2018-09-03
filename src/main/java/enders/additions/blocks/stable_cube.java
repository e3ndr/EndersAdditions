package enders.additions.blocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import enders.additions.endersadditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class stable_cube extends Block {
    protected stable_cube(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

	private static final String name = "stable_cube";
	private static final boolean cubeAwakened = false;
 
    public stable_cube() {
        super(Material.rock);
        GameRegistry.registerBlock(this, name);
        setBlockName("EndersAdditions_" + name);
        setBlockTextureName("endersadditions" + ":" + name);
        setCreativeTab(endersadditions.tabEnder);
        setHardness(5f);
        setLightLevel(16/16f);
    }
}
