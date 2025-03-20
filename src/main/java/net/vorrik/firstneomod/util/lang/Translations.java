package net.vorrik.firstneomod.util.lang;

import net.vorrik.firstneomod.FirstNeoMod;

public class Translations {
    public static String blockTranslation(String blockName) {
        return getBlockTranslation(blockName) + "_block";
    }
    public static String oreTranslation(String oreName) {
        return getBlockTranslation(oreName) + "_ore";
    }
    public static String doorTranslation(String doorName) {
        return getBlockTranslation(doorName) + "_door";
    }
    public static String trapDoorTranslation(String trapdoorName) {
        return getBlockTranslation(trapdoorName) + "_trapdoor";
    }
    public static String wallTranslation(String wallName) {
        return getBlockTranslation(wallName) + "_wall";
    }
    public static String fenceTranslation(String fenceName) {
        return getBlockTranslation(fenceName) + "_fence";
    }
    public static String fenceGateTranslation(String fenceGateName) {
        return getBlockTranslation(fenceGateName) + "_fence_gate";
    }
    public static String pressurePlateTranslation(String pressurePlateName) {
        return getBlockTranslation(pressurePlateName) + "_pressurePlate";
    }
    public static String buttonTranslation(String buttonName) {
        return getBlockTranslation(buttonName) + "_button";
    }
    public static String stairsTranslation(String stairsName) {
        return getBlockTranslation(stairsName) + "_stairs";
    }
    public static String slabTranslation(String slabName) {
        return getBlockTranslation(slabName) + "_slab";
    }
    public static String itemTranslation(String itemName) {
        return "item." + FirstNeoMod.MOD_ID + "." + itemName;
    }
    public static String creativeTabTranslation(String tabName) {
        return "creativetab." + FirstNeoMod.MOD_ID + "." + tabName;
    }

    private static String getBlockTranslation(String blockName) {
        return "block." + FirstNeoMod.MOD_ID + "." + blockName;
    }
}
