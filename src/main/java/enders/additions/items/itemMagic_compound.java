package enders.additions.items;

import enders.additions.endersadditions;
import net.minecraft.item.Item;

public class itemMagic_compound extends Item {
	public itemMagic_compound() {
		setUnlocalizedName("EndersAdditions" + "_" + "magic_compound").setMaxStackSize(64);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "magic_compound");
	}
}
