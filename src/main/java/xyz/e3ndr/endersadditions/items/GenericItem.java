package xyz.e3ndr.endersadditions.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class GenericItem extends Item {

    public GenericItem(String name) {
        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName(name));
        this.setCreativeTab(EndersAdditions.tabEnder);
        this.setTextureName(EndersAdditions.generateTextureName(name));

        GameRegistry.registerItem(this, name);
    }

}
