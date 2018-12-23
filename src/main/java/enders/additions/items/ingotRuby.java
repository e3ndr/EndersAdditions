package enders.additions.items;

import enders.additions.endersadditions;
import net.minecraft.item.Item;

public class ingotRuby extends Item {
	public ingotRuby() {
		setUnlocalizedName("EndersAdditions" + "_" + "ruby").setMaxStackSize(64);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "ruby");
	}
}