package net.vorrik.firstneomod.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.vorrik.firstneomod.FirstNeoMod;
import net.vorrik.firstneomod.block.ModBlocks;
import net.vorrik.firstneomod.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        try {
            List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE);

            nineByNineStorage(recipeOutput, RecipeCategory.MISC, ModItems.BISMUTH.get(), "bismuth", RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK, "bismuth_block");
            nineByNineStorage(recipeOutput, RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get(), "bismuth_block", RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get(), "magic_block");
            shovel(recipeOutput, RecipeCategory.TOOLS, ModItems.CHISEL.get(), ModItems.BISMUTH.get());
            smeltables(recipeOutput, RecipeCategory.MISC, BISMUTH_SMELTABLES, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth");
            door(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), "bismuth");
            trapdoor(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), "bismuth");
            stairs(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), "bismuth");
            slabs(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), "bismuth");
            fence(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), Items.BREEZE_ROD, "bismuth");
            fenceGate(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), Items.BREEZE_ROD, "bismuth");
            button(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), "bismuth");
            pressurePlate(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), "bismuth");
            wallRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_DOOR.get(), ModItems.BISMUTH.get(), "bismuth");
        } catch (Exception e) {
            LOGGER.error("Error building recipes", e);
        }
    }


    // HELPER METHODS
    private void shovel(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike head, ItemLike handle) {
        ShapedRecipeBuilder.shaped(category, result).pattern(" # ").pattern(" | ").pattern(" | ").define('#', head).define('|', handle).unlockedBy(getHasName(head), has(head)).save(recipeOutput);
    }
    private void shovel(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike head) {
        ShapedRecipeBuilder.shaped(category, result).pattern(" # ").pattern(" | ").pattern(" | ").define('#', head).define('|', Items.STICK).unlockedBy(getHasName(head), has(head)).save(recipeOutput);
    }
    private void smeltables(RecipeOutput recipeOutput, RecipeCategory category, List<ItemLike> ingredients, ItemLike result, float experience, int smeltTime, int blastTime, String group) {
        oreSmelting(recipeOutput, ingredients, category, result, experience, smeltTime, group);
        oreBlasting(recipeOutput, ingredients, category, result, experience, blastTime, group);
    }
    private void smeltables(RecipeOutput recipeOutput, RecipeCategory category, List<ItemLike> ingredients, ItemLike result, float experience, int cookingTime, String group) {
        oreSmelting(recipeOutput, ingredients, category, result, experience, cookingTime, group);
        oreBlasting(recipeOutput, ingredients, category, result, experience, (cookingTime / 2), group);
    }
    private void nineByNineStorage(RecipeOutput recipeOutput, RecipeCategory unpackedCategory, ItemLike unpacked, String unpackedName, RecipeCategory packedCategory, ItemLike packed, String packedName) {
        ShapedRecipeBuilder.shaped(packedCategory, packed).pattern("###").pattern("###").pattern("###").define('#', unpacked).unlockedBy(getHasName(unpacked), has(unpacked)).save(recipeOutput, FirstNeoMod.MOD_ID + ":" + packedName + "_from_" + unpackedName);
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9).requires(packed).unlockedBy(getHasName(packed), has(packed)).save(recipeOutput, FirstNeoMod.MOD_ID + ":" + unpackedName + "_from_" + packedName);
    }
    private void door(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result, 3).pattern("##").pattern("##").pattern("##").define('#', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void trapdoor(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result).pattern("###").pattern("###").define('#', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void stairs(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result, 4).pattern("  #").pattern(" ##").pattern("###").define('#', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void slabs(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result, 6).pattern("###").define('#', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void pressurePlate(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result).pattern("##").define('#', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void button(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapelessRecipeBuilder.shapeless(category, result).requires(material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void fence(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, ItemLike secondaryMateial, String group) {
        ShapedRecipeBuilder.shaped(category, result, 3).pattern("#|#").pattern("#|#").define('#', material).define('|', secondaryMateial).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void fence(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result, 3).pattern("#|#").pattern("#|#").define('#', material).define('|', Items.STICK).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void fenceGate(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, ItemLike secondaryMaterial, String group) {
        ShapedRecipeBuilder.shaped(category, result).pattern("#|#").pattern("#|#").define('#', secondaryMaterial).define('|', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void fenceGate(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result).pattern("#|#").pattern("#|#").define('#', Items.STICK).define('|', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }
    private void wallRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(category, result, 6).pattern("###").pattern("###").define('#', material).unlockedBy(getHasName(material), has(material)).group(group).save(recipeOutput);
    }

    // These are just so that the modded smelting / blasting doesn't end up under the minecraft folder
    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTIme, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }
    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(recipeOutput, FirstNeoMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
