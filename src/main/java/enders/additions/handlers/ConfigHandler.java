package enders.additions.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    // Settings
    public static boolean enableFlyWand;
    public static boolean enableJumpWand;
    public static boolean enableFastWand;
    public static boolean enableZoomiWand;

    


    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        String category;
        category = "Wands";
        enableFlyWand = config.getBoolean("enableFlyWand", category, true, "Allows use of the item. Set to false to disable the usage of the item");
        enableJumpWand = config.getBoolean("enableJumpWand", category, true, "");
        enableZoomiWand = config.getBoolean("enableZoomiWand", category, true, "");
        enableFastWand = config.getBoolean("enableFastWand", category, true, "");

        config.save();
    }
}