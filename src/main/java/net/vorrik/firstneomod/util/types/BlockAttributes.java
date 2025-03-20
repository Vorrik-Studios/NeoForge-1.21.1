package net.vorrik.firstneomod.util.types;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.SoundType;

import java.util.function.Consumer;

public class BlockAttributes  {
    private float BStrength;
    private SoundType BSoundType;
    private UniformInt BExperience;

    public BlockAttributes() {
        // Set the default values
        this.BStrength = 3;
        this.BSoundType = SoundType.STONE;
        this.BExperience = UniformInt.of(1, 1);
    }

    public BlockAttributes strength(float strength) {
        this.BStrength = strength;
        return this; // Provides method chaining
    }

    public BlockAttributes sound(SoundType soundType) {
        this.BSoundType = soundType;
        return this;
    }

    public BlockAttributes experience(UniformInt experience) {
        this.BExperience = experience;
        return this;
    }

    public BlockAttributes withAttributes(Consumer<BlockAttributes> callback) {
        callback.accept(this);
        return this;
    }

    // Getters
    public float getStrength() {
        return this.BStrength;
    }

    public SoundType getSound() {
        return this.BSoundType;
    }

    public UniformInt getExperience() {
        return this.BExperience;
    }
}