package xyz.e3ndr.endersadditions.handlers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xyz.e3ndr.endersadditions.Registry;

public class TabEnder extends CreativeTabs {

    public TabEnder(int id, String name) {
        super(id, name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() {
        return new ItemStack(Registry.itemWand, 1, 0);
    }

    @Override
    public String getTranslatedTabLabel() {
        return "Ender's Additions";
    }

    @Override
    public Item getTabIconItem() {
        // TODO Auto-generated method stub
        return null;
    }

}
