package com.github.maetel9.shisyoumod.datagen;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Map;
import java.util.function.Consumer;

public class ShisyouModRecipeProvider extends RecipeProvider {

    public ShisyouModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        Map<String, Item> meatVariants = Map.ofEntries(
                Map.entry("beef", Items.BEEF),
                Map.entry("cooked_beef", Items.COOKED_BEEF),
                Map.entry("porkchop", Items.PORKCHOP),
                Map.entry("cooked_porkchop", Items.COOKED_PORKCHOP),
                Map.entry("mutton", Items.MUTTON),
                Map.entry("cooked_mutton", Items.COOKED_MUTTON),
                Map.entry("chicken", Items.CHICKEN),
                Map.entry("cooked_chicken", Items.COOKED_CHICKEN),
                Map.entry("rabbit", Items.RABBIT),
                Map.entry("cooked_rabbit", Items.COOKED_RABBIT)
        );

        for (Map.Entry<String, Item> entry : meatVariants.entrySet()) {
            String meatName = entry.getKey();
            Item meatItem = entry.getValue();

            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ShisyouModItems.CURRY_RISE.get(), 4)
                    .requires(ShisyouModItems.CURRY_RUEX.get(), 2)
                    .requires(Items.WHEAT, 2)
                    .requires(Items.POTATO)
                    .requires(Items.CARROT)
                    .requires(meatItem)
                    .unlockedBy("has_" + ShisyouModItems.CURRY_RUEX.getId().getPath(), has(ShisyouModItems.CURRY_RUEX.get()))
                    .save(consumer, new ResourceLocation(ShisyouMod.MOD_ID, "curry_rice_" + meatName));
        }

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ShisyouModItems.INVISIBLE_ITEM_FRAME.get())
                .requires(Items.ITEM_FRAME)
                .unlockedBy("has_item_frame", has(Items.ITEM_FRAME))
                .save(consumer, new ResourceLocation(ShisyouMod.MOD_ID, "invisible_item_frame"));
//curry_rise_1 → curry_rise_2
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ShisyouModItems.CURRY_RISE_1.get())
                .requires(ShisyouModItems.CURRY_RISE.get())
                .unlockedBy("has_curry_rise", has(ShisyouModItems.CURRY_RISE.get()))
                .save(consumer, new ResourceLocation(ShisyouMod.MOD_ID, "curry_rise_to_1"));
//curry_rise_1 → curry_rise_2
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ShisyouModItems.CURRY_RISE_2.get())
                .requires(ShisyouModItems.CURRY_RISE_1.get())
                .unlockedBy("has_curry_rise_1", has(ShisyouModItems.CURRY_RISE_1.get()))
                .save(consumer, new ResourceLocation(ShisyouMod.MOD_ID, "curry_rise_1_to_2"));
//curry_rise_2 → curry_rise
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ShisyouModItems.CURRY_RISE.get())
                .requires(ShisyouModItems.CURRY_RISE_2.get())
                .unlockedBy("has_curry_rise_2", has(ShisyouModItems.CURRY_RISE_2.get()))
                .save(consumer, new ResourceLocation(ShisyouMod.MOD_ID, "curry_rise_2_to_base"));

    }
}
