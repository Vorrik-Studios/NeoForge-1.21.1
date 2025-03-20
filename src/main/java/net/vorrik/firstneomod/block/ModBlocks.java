package net.vorrik.firstneomod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vorrik.firstneomod.FirstNeoMod;
import net.vorrik.firstneomod.util.registries.BlockRegistry;
import net.vorrik.firstneomod.util.types.BlockAttributes;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FirstNeoMod.MOD_ID);
    public static final DeferredBlock<Block> BISMUTH_BLOCK = BlockRegistry.simpleBlock("bismuth", () -> new BlockAttributes().strength(4f).sound(SoundType.AMETHYST));
    public static final DeferredBlock<Block> BISMUTH_ORE = BlockRegistry.oreBlock("bismuth", () -> new BlockAttributes().strength(3f).experience(UniformInt.of(2, 4)));
    public static final DeferredBlock<Block> MAGIC_BLOCK = BlockRegistry.magicBlock(() -> new BlockAttributes().sound(SoundType.AMETHYST_CLUSTER));
    public static final DeferredBlock<StairBlock> BISMUTH_STAIRS = BlockRegistry.stairBlock(BlockAttributes::new, "bismuth", () -> ModBlocks.BISMUTH_BLOCK.get().defaultBlockState());
    public static final DeferredBlock<SlabBlock> BISMUTH_SLAB = BlockRegistry.slabBlock(BlockAttributes::new, "bismuth");
    public static final DeferredBlock<PressurePlateBlock> BISMUTH_PRESSURE_PLATE = BlockRegistry.pressurePlateBlock(BlockAttributes::new, "bismuth");
    public static final DeferredBlock<ButtonBlock> BISMUTH_BUTTON = BlockRegistry.buttonBlock(BlockAttributes::new, "bismuth");
    public static final DeferredBlock<FenceBlock> BISMUTH_FENCE = BlockRegistry.fenceBlock(BlockAttributes::new, "bismuth");
    public static final DeferredBlock<FenceGateBlock> BISMUTH_FENCE_GATE = BlockRegistry.fenceGateBlock(BlockAttributes::new, "bismuth");
    public static final DeferredBlock<WallBlock> BISMUTH_WALL = BlockRegistry.wallBlock(BlockAttributes::new, "bismuth");
    public static final DeferredBlock<DoorBlock> BISMUTH_DOOR = BlockRegistry.doorBlock(BlockAttributes::new, "bismuth");
    public static final DeferredBlock<TrapDoorBlock> BISMUTH_TRAPDOOR = BlockRegistry.trapdoorBlock(BlockAttributes::new, "bismuth");

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
