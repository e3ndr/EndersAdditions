package xyz.e3ndr.endersadditions.items;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import xyz.e3ndr.endersadditions.EndersAdditions;

public class GenericOre extends Block {

    private Item mineResult;

    public GenericOre(Material material, String name, Item mineResult) {
        super(material);

        this.mineResult = mineResult;

        this.setBlockName(EndersAdditions.generateUnlocalizedName(name));
        this.setBlockTextureName(EndersAdditions.generateTextureName(name));
        this.setCreativeTab(EndersAdditions.tabEnder);

        GameRegistry.registerBlock(this, name);
    }

    @Override
    public Item getItemDropped(int par1, Random rand, int par2) {
        return this.mineResult;
    }

}
