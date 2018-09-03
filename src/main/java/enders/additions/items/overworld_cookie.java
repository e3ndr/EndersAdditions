package enders.additions.items;

import enders.additions.endersadditions;
import net.minecraft.item.Item;

public class overworld_cookie extends Item {
	public overworld_cookie() {
		setUnlocalizedName("EndersAdditions" + "_" + "overworld_cookie").setMaxStackSize(8);	
		setCreativeTab(endersadditions.tabEnder);
		setTextureName("endersadditions" + ":" + "overworld_cookie");
    }
}
