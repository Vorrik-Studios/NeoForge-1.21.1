package net.vorrik.firstneomod.util.registries;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.vorrik.firstneomod.item.ModItems;
import net.vorrik.firstneomod.item.custom.ChiselItem;
import net.vorrik.firstneomod.item.custom.FuelItem;

public class ItemRegistry {
    public static DeferredItem<Item> simpleItem(String name) {
        return ModItems.ITEMS.registerSimpleItem(name);
    }
    public static DeferredItem<Item> chiselItem(int durability) {
        return ModItems.ITEMS.register("chisel", () -> new ChiselItem(new Item.Properties().durability(durability)));
    }
    public static DeferredItem<Item> chiselItem(int durability, String name) {
        return ModItems.ITEMS.register(name, () -> new ChiselItem(new Item.Properties().durability(durability)));
    }
    public static DeferredItem<Item> foodItem(String name, FoodProperties properties) {
        return ModItems.ITEMS.register(name, () -> new Item(new Item.Properties().food(properties)));
    }
    public static DeferredItem<Item> fuelItem(String name, int burnTime) {
        return ModItems.ITEMS.register(name, () -> new FuelItem(new Item.Properties(), burnTime));
    }
}