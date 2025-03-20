package net.vorrik.firstneomod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vorrik.firstneomod.FirstNeoMod;
import net.vorrik.firstneomod.item.food.ModFoodProperties;
import net.vorrik.firstneomod.util.registries.ItemRegistry;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirstNeoMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ItemRegistry.simpleItem("bismuth");
    public static final DeferredItem<Item> RAW_BISMUTH = ItemRegistry.simpleItem("raw_bismuth");
    public static final DeferredItem<Item> CHISEL = ItemRegistry.chiselItem(32);
    public static final DeferredItem<Item> RADISH = ItemRegistry.foodItem("radish", ModFoodProperties.RADISH);
    public static final DeferredItem<Item> FROSTFIRE_ICE = ItemRegistry.fuelItem("frostfire_ice", 800);
    public static final DeferredItem<Item> STARTLIGHT_ASHES = ItemRegistry.fuelItem("starlight_ashes", 1200);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
