package net.vorrik.firstneomod.util.registries;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.vorrik.firstneomod.block.ModBlocks;
import net.vorrik.firstneomod.block.custom.MagicBlock;
import net.vorrik.firstneomod.item.ModItems;
import net.vorrik.firstneomod.util.types.BlockAttributes;

import java.util.function.Supplier;

public class BlockRegistry {

    // REGISTRY OBJECTS \\

    public static DeferredBlock<Block> simpleBlock(String name, Supplier<BlockAttributes> blockAttributesSupplier) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_block", () -> new Block(getBlockWithDrops(attributes)));
    }

    public static DeferredBlock<Block> simpleBlockWithoutDrops(String name, Supplier<BlockAttributes> blockAttributesSupplier) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_block", () -> new Block(getBlockWithoutDrops(attributes)));
    }

    public static DeferredBlock<Block> oreBlock(String name, Supplier<BlockAttributes> blockAttributesSupplier) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_ore", () -> new DropExperienceBlock(attributes.getExperience(), getBlockWithDrops(attributes)));
    }

    public static DeferredBlock<Block>  magicBlock(Supplier<BlockAttributes> blockAttributesSupplier) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock("magic_block", () -> new MagicBlock(getBlockWithDrops(attributes)));
    }

    public static DeferredBlock<Block>  magicBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name, () -> new MagicBlock(getBlockWithDrops(attributes)));
    }

    // HELPER FUNCTIONS \\

    private static BlockBehaviour.Properties getBlockWithDrops(BlockAttributes attributes) {
        return BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops().sound(attributes.getSound());
    }

    private static BlockBehaviour.Properties getBlockWithoutDrops(BlockAttributes attributes) {
        return BlockBehaviour.Properties.of().strength(attributes.getStrength()).sound(attributes.getSound());
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> returnBlock = ModBlocks.BLOCKS.register(name, block);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
