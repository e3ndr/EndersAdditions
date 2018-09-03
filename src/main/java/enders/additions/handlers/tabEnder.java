package enders.additions.handlers;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enders.additions.endersadditions;

public class tabEnder extends CreativeTabs {

public tabEnder(int par1, String par2Str) {
super(par1, par2Str);

}

@Override
@SideOnly(Side.CLIENT)
public ItemStack getIconItemStack(){
// Here you make the Icon of the creative Tab
return new ItemStack(endersadditions.ded_wand, 1, 0);
}
public String getTranslatedTabLabel(){
// Here is the Name
return "Ender's Additions";
}

@Override
public Item getTabIconItem() {
	// TODO Auto-generated method stub
	return null;
}

}