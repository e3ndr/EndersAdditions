package xyz.e3ndr.endersadditions.proxies;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        isServerSide = true;
        super.preInit(event);
    }

}
