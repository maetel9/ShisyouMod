package com.github.maetel9.shisyoumod.datagen;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, ShisyouMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ShisyouModItems.SHISYOU, "師匠");
        addItem(ShisyouModItems.CURRY_RICE, "かれー");
        addItem(ShisyouModItems.CURRY_RUEX, "カレールー");

        add("creativetabs.shisyoumod_tab", "師匠Mod");

    }
}
