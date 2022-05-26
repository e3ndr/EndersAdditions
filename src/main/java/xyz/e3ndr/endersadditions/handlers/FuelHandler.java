package xyz.e3ndr.endersadditions.handlers;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.e3ndr.endersadditions.Registry;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        Item itemFuel = fuel.getItem();

        if (itemFuel == Registry.itemMagicDust) {
            return 2400; // ammount of time
        } else {
            return 0; // if not listed it returns 0 burn time
        }
    }
}
