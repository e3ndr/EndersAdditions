package enders.additions.handlers;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    // Settings
    public static boolean enableFlyWand;
    public static boolean enableJumpWand;
    public static boolean enableFastWand;
    public static boolean enableShardOfReality_Kill;
    public static boolean enableStickODeath;
    public static boolean enableShardBall;
    public static boolean enableZoomiWand;

    


    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        String category;
        category = "Mod";
        enableFlyWand = config.getBoolean("enableFlyWand", category, true, "");
        enableJumpWand = config.getBoolean("enableJumpWand", category, true, "");
        enableZoomiWand = config.getBoolean("enableZoomiWand", category, true, "");
        enableFastWand = config.getBoolean("enableFastWand", category, true, "");
        enableShardOfReality_Kill = config.getBoolean("enableShardOfReality_Kill", category, true, "");
        enableStickODeath = config.getBoolean("enableStickODeath", category, true, "");
        enableShardBall = config.getBoolean("enableShardBall", category, true, "");
 
        config.save();
    }
}