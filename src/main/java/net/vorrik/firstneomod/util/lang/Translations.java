package net.vorrik.firstneomod.util.lang;

import net.vorrik.firstneomod.FirstNeoMod;

public class Translations {
    public static String blockTranslation(String blockName) {
        return "block." + FirstNeoMod.MOD_ID + "." + blockName + "_block";
    }
    public static String oreTranslation(String blockName) {
        return "block." + FirstNeoMod.MOD_ID + "." + blockName + "_ore";
    }
    public static String itemTranslation(String itemName) {
        return "item." + FirstNeoMod.MOD_ID + "." + itemName;
    }
    public static String creativeTabTranslation(String tabName) {
        return "creativetab." + FirstNeoMod.MOD_ID + "." + tabName;
    }
}
