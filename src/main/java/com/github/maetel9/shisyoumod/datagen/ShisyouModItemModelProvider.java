package com.github.maetel9.shisyoumod.datagen;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ShisyouModItemModelProvider extends ItemModelProvider {
    public ShisyouModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ShisyouMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ShisyouModItems.CURRY_RISE.get());
        basicItem(ShisyouModItems.CURRY_RUEX.get());
        basicItem(ShisyouModItems.PANCAKES.get());
    }
}
