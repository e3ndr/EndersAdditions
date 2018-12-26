package enders.additions.handlers;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item itemFuel = fuel.getItem();
		if (itemFuel == enders.additions.register.items.magic_dust) {
			return 2400; // ammount of time
		} else {
			return 0; // if not listed it returns 0 burn time
		}
	}
}