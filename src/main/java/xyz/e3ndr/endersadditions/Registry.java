package xyz.e3ndr.endersadditions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import xyz.e3ndr.endersadditions.items.ArmorBouncyBoots;
import xyz.e3ndr.endersadditions.items.FoodBlorox;
import xyz.e3ndr.endersadditions.items.FoodIceCream;
import xyz.e3ndr.endersadditions.items.FoodSalt;
import xyz.e3ndr.endersadditions.items.GenericBlock;
import xyz.e3ndr.endersadditions.items.GenericItem;
import xyz.e3ndr.endersadditions.items.GenericOre;
import xyz.e3ndr.endersadditions.items.ItemBoof;
import xyz.e3ndr.endersadditions.items.ItemModem;
import xyz.e3ndr.endersadditions.items.ItemSaltShaker;
import xyz.e3ndr.endersadditions.items.ItemWand;
import xyz.e3ndr.endersadditions.items.ToolAxe;
import xyz.e3ndr.endersadditions.items.ToolHoe;
import xyz.e3ndr.endersadditions.items.ToolPickaxe;
import xyz.e3ndr.endersadditions.items.ToolShovel;
import xyz.e3ndr.endersadditions.items.ToolSword;

public class Registry {

    /*
     * @param name
     * @param durability
     * @param reduction
     * @param enchantability
     */
    private static final ArmorMaterial dummyArmorMaterial = EnumHelper.addArmorMaterial(
        "dummy",
        10,
        new int[] {
                1,
                1,
                1,
                1
        },
        0
    );

    /*
     * name
     * level          (0-3)
     * uses
     * strength       (wood = 2.0F, stone = 4.0F, iron = 6.0F, diamond = 8.0F, gold 12.0F)
     * damage 
     * enchantability (wood = 15, stone = 5, iron = 14, diamond = 10, gold  22)
     */
    private static final Item.ToolMaterial toolMaterialRuby = EnumHelper.addToolMaterial("Ruby", 2, 224, 6.0F, 1F, 5);
    private static final Item.ToolMaterial toolMaterialMagic = EnumHelper.addToolMaterial("Magic", 4, 2000, 12.0F, 1F, 0);

    public static final DamageSource damageSourceBleach = new DamageSource("bleach").setDamageBypassesArmor();
    public static final DamageSource damageSourceSalt = new DamageSource("salt").setDamageBypassesArmor();

    public static final ResourceLocation soundModem = new ResourceLocation("endersadditions", "modem");

    /* ------------ */
    /* Armor        */
    /* ------------ */
    public static Item armorBouncyBoots = new ArmorBouncyBoots(dummyArmorMaterial, 5);

    /* ------------ */
    /* Blocks       */
    /* ------------ */
    public static Block blockSaltOre = new GenericOre(Material.rock, "salt_ore", Registry.foodSalt)
        .setHardness(.5f);

    public static Block blockRubyOre = new GenericOre(Material.rock, "ruby_ore", Registry.itemRuby)
        .setHardness(.5f);

    public static Block blockMagicOre = new GenericBlock(Material.rock, "magic_ore")
        .setHardness(1.5f)
        .setLightLevel(5 / 16f);

    public static Block blockMissingBlock = new GenericBlock(Material.cloth, "missing_block")
        .setHardness(.25f);

    /* ------------ */
    /* Food         */
    /* ------------ */
    public static Item foodIceCream = new FoodIceCream();
    public static Item foodSalt = new FoodSalt();
    public static Item foodBlorox = new FoodBlorox();

    /* ------------ */
    /* Items        */
    /* ------------ */
    public static Item itemBoof = new ItemBoof();
    public static Item itemMagicCompound = new GenericItem("magic_compound");
    public static Item itemMagicDust = new GenericItem("magic_dust");
    public static Item itemMagicIngot = new GenericItem("magic_ingot");
    public static Item itemRuby = new GenericItem("ruby");
    public static Item itemModem = new ItemModem();
    public static Item itemSaltShaker = new ItemSaltShaker();

    public static Item itemWand = new ItemWand();

    /* ------------ */
    /* Tools        */
    /* ------------ */
    public static Item toolRubyAxe = new ToolAxe(toolMaterialRuby, "ruby_axe");
    public static Item toolRubyPickaxe = new ToolPickaxe(toolMaterialRuby, "ruby_pickaxe");
    public static Item toolRubyShovel = new ToolShovel(toolMaterialRuby, "ruby_shovel");
    public static Item toolRubySword = new ToolSword(toolMaterialRuby, "ruby_sword");
    public static Item toolRubyHoe = new ToolHoe(toolMaterialRuby, "ruby_hoe");

    public static Item toolMagicAxe = new ToolAxe(toolMaterialMagic, "magic_axe");
    public static Item toolMagicPickaxe = new ToolPickaxe(toolMaterialMagic, "magic_pickaxe");
    public static Item toolMagicShovel = new ToolShovel(toolMaterialMagic, "magic_shovel");
    public static Item toolMagicSword = new ToolSword(toolMaterialMagic, "magic_sword");
    public static Item toolMagicHoe = new ToolHoe(toolMaterialMagic, "magic_hoe");

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        // OreDictionary
        OreDictionary.registerOre("foodSalt", new ItemStack(Registry.foodSalt, 1, 0));
        OreDictionary.registerOre("ingotRuby", new ItemStack(Registry.itemRuby, 1, 0));
    }

}
