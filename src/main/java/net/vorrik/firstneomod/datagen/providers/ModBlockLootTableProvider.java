package net.vorrik.firstneomod.datagen.providers;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.vorrik.firstneomod.block.ModBlocks;
import net.vorrik.firstneomod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        this.dropSelf(ModBlocks.MAGIC_BLOCK.get());
        this.dropSelf(ModBlocks.BISMUTH_STAIRS.get());
        this.dropSelf(ModBlocks.BISMUTH_FENCE.get());
        this.dropSelf(ModBlocks.BISMUTH_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BISMUTH_WALL.get());
        this.dropSelf(ModBlocks.BISMUTH_TRAPDOOR.get());
        this.dropSelf(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BISMUTH_BUTTON.get());

        this.add(ModBlocks.BISMUTH_SLAB.get(), block -> createSlabItemTable(ModBlocks.BISMUTH_SLAB.get()));
        this.add(ModBlocks.BISMUTH_DOOR.get(), block -> createDoorTable(ModBlocks.BISMUTH_DOOR.get()));

        this.add(ModBlocks.BISMUTH_ORE.get(), block -> createMultipleOreDrops(ModBlocks.BISMUTH_ORE.get(), ModItems.RAW_BISMUTH.get(), 1, 3));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    // This is kinda ugly just know that it is a helper method to make ores that drop multiple items
    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
        // Like I said UGLY
    }
}
