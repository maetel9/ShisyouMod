package com.github.maetel9.shisyoumod.datagen;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

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

            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ShisyouModItems.CURRY_RICE.get(), 4)
                    .requires(ShisyouModItems.CURRY_RUEX.get(), 2)
                    .requires(Items.WHEAT, 2)
                    .requires(Items.POTATO)
                    .requires(Items.CARROT)
                    .requires(meatItem)
                    .requires(Items.BOWL)
                    .unlockedBy("has_" + ShisyouModItems.CURRY_RUEX.getId().getPath(), has(ShisyouModItems.CURRY_RUEX.get()))
                    .save(consumer, new ResourceLocation(ShisyouMod.MOD_ID, "curry_rice_" + meatName));
        }
    }
}
