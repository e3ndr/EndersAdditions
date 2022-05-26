package xyz.e3ndr.endersadditions.proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        // for armor
        RenderingRegistry.addNewArmourRendererPrefix("5");
    }

}
