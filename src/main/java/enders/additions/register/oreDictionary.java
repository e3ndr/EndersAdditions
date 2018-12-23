package enders.additions.register;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import enders.additions.endersadditions;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class oreDictionary {
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	endersadditions.logger.info("Registering OreDictionary");
    	OreDictionary.registerOre("foodSalt", new ItemStack(enders.additions.register.items.salt, 1, 0));
    	OreDictionary.registerOre("ingotRuby", new ItemStack(enders.additions.register.items.ruby, 1, 0));
        
    }
}
