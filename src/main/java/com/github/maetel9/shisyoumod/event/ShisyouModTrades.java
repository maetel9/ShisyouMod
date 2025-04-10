package com.github.maetel9.shisyoumod.event;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ShisyouMod.MOD_ID)
    public class ShisyouModTrades {

            //村人（農民）のトレードに追加
        @SubscribeEvent
        public static void onVillagerTrades(VillagerTradesEvent event) {
            if (event.getType() == VillagerProfession.FARMER) {
                // 取引レベル1に追加（レベルは1〜5）
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                trades.get(1).add((entity, random) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),              // 支払うアイテム
                        new ItemStack(ShisyouModItems.CURRY_RUEX.get(), 8), // もらえるアイテム
                        32, 2, 0.05F   // 最大取引回数、経験値、価格増加率
                ));
            }
        }

        //行商人のトレードに追加
    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        // 通常枠の取引に追加
        event.getGenericTrades().add((entity, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(ShisyouModItems.CURRY_RUEX.get(), 8),
                64, 2, 0.05F));

        // 追加したい取引（2回目、ちょっと高い）
        event.getGenericTrades().add(new BasicItemListing(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ShisyouModItems.CURRY_RUEX.get(), 10),
                    64, 2, 0.05F));

        // 追加したい取引（3回目、さらに高い）
        event.getGenericTrades().add(new BasicItemListing(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ShisyouModItems.CURRY_RUEX.get(), 12),
                    64, 2, 0.05F));
    }
}
