package com.github.maetel9.shisyoumod.item;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ShisyouModTabs {
    // レジストリを作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShisyouMod.MOD_ID);

    // レジストリにタブを登録
    public static final RegistryObject<CreativeModeTab> SHISYOU_TAB = TABS.register("shisyou_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.shisyou_tab"))
                    //タブのアイコン
                    .icon(ShisyouModItems.SHISYOU.get()::getDefaultInstance)
                    //アイテムを追加
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ShisyouModItems.SHISYOU.get());
                        pOutput.accept(ShisyouModItems.CURRY_RISE.get());
                        pOutput.accept(ShisyouModItems.CURRY_RUEX.get());
                        pOutput.accept(ShisyouModItems.CURRY_RISE_1.get());
                        pOutput.accept(ShisyouModItems.CURRY_RISE_2.get());
                        pOutput.accept(ShisyouModItems.INVISIBLE_ITEM_FRAME.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        // クリエイティブタブをイベントバスに登録
        TABS.register(eventBus);
    }
}
