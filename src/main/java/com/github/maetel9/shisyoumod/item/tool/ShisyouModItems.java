package com.github.maetel9.shisyoumod.item.tool;

import com.github.maetel9.shisyoumod.ShisyouMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ShisyouModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ShisyouMod.MOD_ID);

    // 師匠を追加　剣の定義：ネザライトより攻撃力+3（合計11）、攻撃速度を若干高速（-2.0F → -1.8F）
    public static final RegistryObject<Item> SHISYOU = ITEMS.register("shisyou",
            () -> new ShisyouItem(ShisyouModTiers.SHISYOU_TIER, 8, -1.8F, new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //カレーを追加
    public static final RegistryObject<Item> CURRY_RICE = ITEMS.register("curry_rise",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8) //満腹度（ステーキと同じ）
                    .saturationMod(1.2f) //隠し満腹度(金にんじんと同じ)
                    .build())));

    //カレールーを追加
    public static final RegistryObject<Item> CURRY_RUEX = ITEMS.register("curry_ruex",
            () -> new Item(new Item.Properties()));

}
