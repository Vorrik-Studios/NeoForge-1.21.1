package net.vorrik.firstneomod.datagen.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.vorrik.firstneomod.FirstNeoMod;
import net.vorrik.firstneomod.util.lang.Translations;

//{
//        "item.firstneomod.bismuth": "Bismuth",
//        "item.firstneomod.raw_bismuth": "Raw Bismuth",
//        "item.firstneomod.chisel": "Chisel",
//        "item.firstneomod.radish": "Radish",
//        "item.firstneomod.starlight_ashes": "Startlight Ashes",
//        "item.firstneomod.frostfire_ice": "Frostfire Ice",
//
//        "block.firstneomod.bismuth_block": "Block of Bismuth",
//        "block.firstneomod.bismuth_ore": "Bismuth Ore",
//
//        "block.firstneomod.magic_block": "Magic Block",
//
//        "creativetab.firstneomod.modded_items": "First Neo-Forge Mod"
//        }


public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, FirstNeoMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(Translations.blockTranslation("bismuth"), "Block of Bismuth");
        this.add(Translations.oreTranslation("bismuth"), "Bismuth Ore");
        this.add(Translations.blockTranslation("magic"), "Magic Block");
        this.add(Translations.creativeTabTranslation("modded_items"), "First Neo-Forge Mod");
        this.add(Translations.itemTranslation("bismuth"), "Bismuth");
        this.add(Translations.itemTranslation("raw_bismuth"), "Raw Bismuth");
        this.add(Translations.itemTranslation("chisel"), "Chisel");
        this.add(Translations.itemTranslation("radish"), "Radish");
        this.add(Translations.itemTranslation("starlight_ashes"), "Starlight Ashes");
        this.add(Translations.itemTranslation("frostfire_ice"), "Frostfire Ice");
    }
}
