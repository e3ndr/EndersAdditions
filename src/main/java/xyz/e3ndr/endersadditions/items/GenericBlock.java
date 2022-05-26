package xyz.e3ndr.endersadditions.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class GenericBlock extends Block {

    public GenericBlock(Material material, String name) {
        super(material);

        this.setBlockName(EndersAdditions.generateUnlocalizedName(name));
        this.setBlockTextureName(EndersAdditions.generateTextureName(name));
        this.setCreativeTab(EndersAdditions.tabEnder);

        GameRegistry.registerBlock(this, name);
    }

}
