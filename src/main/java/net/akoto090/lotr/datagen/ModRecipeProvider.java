package net.akoto090.lotr.datagen;

import net.akoto090.lotr.LotrMod;
import net.akoto090.lotr.block.ModBlocks;
import net.akoto090.lotr.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> MITHRIL_SMELTABLE = List.of(ModItems.RAW_MITHRIL.get(),
            ModBlocks.MITHRIL_ORE.get(), ModBlocks.DEEPSLATE_MITHRIL_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MITHRIL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.MITHRIL.get())
                .unlockedBy("has_mithril", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.MITHRIL.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MITHRIL.get(), 9)
                .requires(ModBlocks.MITHRIL_BLOCK.get())
                .unlockedBy("has_mithril_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.MITHRIL_BLOCK.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_MITHRIL.get(), RecipeCategory.MISC, ModBlocks.RAW_MITHRIL_BLOCK.get(),
                "lotr:raw_mithril", "mithril","lotr:raw_mithril_block", "mithril");
        oreSmelting(pWriter, MITHRIL_SMELTABLE, RecipeCategory.MISC, ModItems.MITHRIL.get(), 0.25f, 200, "mithril");
        oreBlasting(pWriter, MITHRIL_SMELTABLE, RecipeCategory.MISC, ModItems.MITHRIL.get(), 0.25f, 100, "mithril");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.MUD)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.MUD_BALL.get())
                .unlockedBy("has_mithril", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.MUD_BALL.get()).build()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, LotrMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}