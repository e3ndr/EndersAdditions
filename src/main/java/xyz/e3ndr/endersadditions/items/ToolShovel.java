package xyz.e3ndr.endersadditions.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemSpade;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class ToolShovel extends ItemSpade {

    public ToolShovel(ToolMaterial material, String name) {
        super(material);

        this.setUnlocalizedName(EndersAdditions.generateUnlocalizedName(name));
        this.setTextureName(EndersAdditions.generateTextureName(name));
        this.setCreativeTab(EndersAdditions.tabEnder);

        GameRegistry.registerItem(this, name);
    }

}
