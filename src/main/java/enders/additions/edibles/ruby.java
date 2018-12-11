package enders.additions.edibles;

import enders.additions.endersadditions;
import net.minecraft.item.Item;

public class ruby extends Item {
	public ruby() {
		setUnlocalizedName("EndersAdditions" + "_" + "ruby").setMaxStackSize(64);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "ruby");
	}
}