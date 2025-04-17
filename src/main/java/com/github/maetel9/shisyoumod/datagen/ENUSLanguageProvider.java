package com.github.maetel9.shisyoumod.datagen;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, ShisyouMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ShisyouModItems.SHISYOU, "Shisyou");
        addItem(ShisyouModItems.CURRY_RISE, "Curry Rise");
        addItem(ShisyouModItems.CURRY_RUEX, "Curry Ruex");
        addItem(ShisyouModItems.CURRY_RISE_1, "Curry Rise1");
        addItem(ShisyouModItems.CURRY_RISE_2, "Curry Rise2");
        addItem(ShisyouModItems.PANCAKES, "pancakes");
        addItem(ShisyouModItems.PANCAKES_1, "pancakes1");
        addItem(ShisyouModItems.INVISIBLE_ITEM_FRAME, "Invisible Item Frame");

        add("creativetabs.shisyoumod_tab", "ShisyouMod");

    }
}
