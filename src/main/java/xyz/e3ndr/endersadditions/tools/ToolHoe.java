package xyz.e3ndr.endersadditions.tools;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemHoe;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class ToolHoe extends ItemHoe {

    public ToolHoe(ToolMaterial material, String name) {
        super(material);

        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName(name));
        this.setTextureName(EndersAdditions.generateTextureName(name));
        this.setCreativeTab(EndersAdditions.tabEnder);

        GameRegistry.registerItem(this, name);
    }

}
