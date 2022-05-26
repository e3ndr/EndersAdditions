package xyz.e3ndr.endersadditions.proxies;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import xyz.e3ndr.endersadditions.Registry;
import xyz.e3ndr.endersadditions.handlers.FuelHandler;
import xyz.e3ndr.endersadditions.registry.RecipesRegistry;
import xyz.e3ndr.endersadditions.world.Oregen;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        // Register
        Registry.preInit(event);
        RecipesRegistry.preInit(event);
        GameRegistry.registerFuelHandler(new FuelHandler());

        // Oregen
        Oregen ore_gen = new Oregen();
        GameRegistry.registerWorldGenerator(ore_gen, 0);
    }

}
