package net.vorrik.firstneomod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vorrik.firstneomod.FirstNeoMod;
import net.vorrik.firstneomod.util.registries.BlockRegistry;
import net.vorrik.firstneomod.util.types.BlockAttributes;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FirstNeoMod.MOD_ID);

    // the BlockRegistry.oreBlock appends _block to all names provided so if name was "bismuth_block" it would end up "bismuth_block_block"
    public static final DeferredBlock<Block> BISMUTH_BLOCK = BlockRegistry.simpleBlock("bismuth",
            () -> new BlockAttributes().strength(4f).sound(SoundType.AMETHYST));

    // the BlockRegistry.oreBlock appends _ore to all names provided so if name was "bismuth_ore" it would end up "bismuth_ore_ore"
    public static final DeferredBlock<Block> BISMUTH_ORE = BlockRegistry.oreBlock("bismuth",
            () -> new BlockAttributes().strength(3f).experience(UniformInt.of(2, 4)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = BlockRegistry.magicBlock(
            () -> new BlockAttributes().strength(2f).sound(SoundType.AMETHYST_CLUSTER));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
