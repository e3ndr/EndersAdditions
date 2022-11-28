package xyz.e3ndr.endersadditions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import xyz.e3ndr.endersadditions.handlers.TabEnder;
import xyz.e3ndr.endersadditions.proxies.CommonProxy;

@Mod(modid = EndersAdditions.MODID, name = EndersAdditions.NAME, version = EndersAdditions.VERSION)
public class EndersAdditions {
    public static final String MODID = "endersadditions";
    public static final String MODNAME = "Ender's Additions";
    public static final String NAME = "Ender's Additions";
    public static final String VERSION = "4.0R";
    public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.7.10]";

    @Mod.Instance("endersadditions")
    public static EndersAdditions instance;

    public static Logger logger = LogManager.getLogger(EndersAdditions.MODID);

    public static CreativeTabs tabEnder = new TabEnder(
        CreativeTabs.getNextID(),
        "Ender's Additions"
    );

    @SidedProxy(clientSide = "xyz.e3ndr.endersadditions.proxies.ClientProxy", serverSide = "xyz.e3ndr.endersadditions.proxies.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info(NAME + " Version " + VERSION + " for " + ACCEPTED_MINECRAFT_VERSIONS);

        proxy.preInit(event);
    }

    public static String generateUnlocalizedName(String name) {
        return "EndersAdditions_" + name;
    }

    public static String generateTextureName(String id) {
        return "endersadditions:" + id;
    }

    public static boolean isWearing(EntityPlayer player, ItemArmor armor) {
        ItemStack armorItem = null;

        // Ugh.
        switch (armor.armorType) {
            case 0:
                armorItem = player.getCurrentArmor(3);
                break;
            case 1:
                armorItem = player.getCurrentArmor(2);
                break;
            case 2:
                armorItem = player.getCurrentArmor(1);
                break;
            case 3:
                armorItem = player.getCurrentArmor(0);
                break;
        }

        return (armorItem != null) &&
            (armorItem.getItem() == armor); // The real check.
    }

}
