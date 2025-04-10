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
        addItem(ShisyouModItems.CURRY_RICE, "Curry Rise");
        addItem(ShisyouModItems.CURRY_RUEX, "Curry Ruex");

        add("creativetabs.shisyoumod_tab", "ShisyouMod");

    }
}
