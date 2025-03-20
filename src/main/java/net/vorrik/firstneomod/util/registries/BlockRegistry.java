package net.vorrik.firstneomod.util.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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
    public static DeferredBlock<Block> magicBlock(Supplier<BlockAttributes> blockAttributesSupplier) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock("magic_block", () -> new MagicBlock(getBlockWithDrops(attributes)));
    }
    public static DeferredBlock<Block> magicBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name, () -> new MagicBlock(getBlockWithDrops(attributes)));
    }
    public static DeferredBlock<StairBlock> stairBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, Supplier<BlockState> blockStateSupplier) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        BlockState blockState = blockStateSupplier.get();
        return registerBlock(name + "_stairs", () -> new StairBlock(blockState, BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops()));
    }

    public static DeferredBlock<SlabBlock> slabBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops()));
    }
    public static DeferredBlock<PressurePlateBlock> pressurePlateBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType) {
        return getPressurePlateBlock(blockAttributesSupplier, name, setType);
    }
    public static DeferredBlock<PressurePlateBlock> pressurePlateBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        return getPressurePlateBlock(blockAttributesSupplier, name, BlockSetType.IRON);
    }
    public static DeferredBlock<ButtonBlock> buttonBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType, int ticksToStayPressed) {
        return getButtonBlock(blockAttributesSupplier, name, setType, ticksToStayPressed);
    }
    public static DeferredBlock<ButtonBlock> buttonBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType) {
        return getButtonBlock(blockAttributesSupplier, name, setType, 25);
    }
    public static DeferredBlock<ButtonBlock> buttonBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        return getButtonBlock(blockAttributesSupplier, name, BlockSetType.IRON, 25);
    }
    public static DeferredBlock<FenceBlock> fenceBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops()));
    }
    public static DeferredBlock<FenceGateBlock> fenceGateBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, WoodType woodType) {
        return getFenceGateBlock(blockAttributesSupplier, name, woodType);
    }
    public static DeferredBlock<FenceGateBlock> fenceGateBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        return getFenceGateBlock(blockAttributesSupplier, name, WoodType.ACACIA);
    }
    public static DeferredBlock<WallBlock> wallBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_wall", () -> new WallBlock(BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops()));
    }
    public static DeferredBlock<DoorBlock> doorBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType) {
        return getDoorBlock(blockAttributesSupplier, name, setType);
    }
    public static DeferredBlock<DoorBlock> doorBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        return getDoorBlock(blockAttributesSupplier, name, BlockSetType.IRON);
    }
    public static DeferredBlock<TrapDoorBlock> trapdoorBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType) {
        return getTrapdoorBlock(blockAttributesSupplier, name, setType);
    }
    public static DeferredBlock<TrapDoorBlock> trapdoorBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name) {
        return getTrapdoorBlock(blockAttributesSupplier, name, BlockSetType.IRON);
    }

    // HELPER METHODS \\
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
    private static DeferredBlock<ButtonBlock> getButtonBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType, int ticksToStayPressed) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_button", () -> new ButtonBlock(setType, ticksToStayPressed, BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops().noCollission()));
    }
    private static DeferredBlock<PressurePlateBlock> getPressurePlateBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_pressure_plate", () -> new PressurePlateBlock(setType, BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops()));
    }
    private static DeferredBlock<FenceGateBlock> getFenceGateBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, WoodType woodType) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_fence_gate", () -> new FenceGateBlock(woodType, BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops()));
    }
    private static DeferredBlock<DoorBlock> getDoorBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_door", () -> new DoorBlock(setType, BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops().noOcclusion()));
    }
    private static DeferredBlock<TrapDoorBlock> getTrapdoorBlock(Supplier<BlockAttributes> blockAttributesSupplier, String name, BlockSetType setType) {
        BlockAttributes attributes = blockAttributesSupplier.get();
        return registerBlock(name + "_trapdoor", () -> new TrapDoorBlock(setType, BlockBehaviour.Properties.of().strength(attributes.getStrength()).requiresCorrectToolForDrops().noOcclusion()));
    }
}
