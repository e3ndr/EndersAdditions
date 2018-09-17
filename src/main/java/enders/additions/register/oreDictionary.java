package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class oreDictionary {
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
	OreDictionary.registerOre("salt", new ItemStack(enders.additions.register.items.salt, 1, 0));
    }
}
