package com.github.maetel9.shisyoumod.event;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ShisyouMod.MOD_ID)
public class ShisyouModWorldEvents {

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        if (!(player instanceof ServerPlayer serverPlayer)) return;

        CompoundTag persistentData = serverPlayer.getPersistentData();
        CompoundTag data = persistentData.getCompound(Player.PERSISTED_NBT_TAG);

        if (!data.getBoolean("shisyoumod_items_given")) {
            data.putBoolean("shisyoumod_items_given", true);
            persistentData.put(Player.PERSISTED_NBT_TAG, data);

            // ▶ shisyoumodアイテム
            serverPlayer.getInventory().add(new ItemStack(ShisyouModItems.SHISYOU.get(), 2));
            serverPlayer.getInventory().add(new ItemStack(ShisyouModItems.CURRY_RISE.get(), 64));
            serverPlayer.getInventory().add(new ItemStack(ShisyouModItems.CURRY_RUEX.get(), 64));

            // ▶ littlemaidrebirthのスポーンエッグ（他MOD）
            serverPlayer.getInventory().add(new ItemStack(
                    ForgeRegistries.ITEMS.getValue(new ResourceLocation("littlemaidrebirth", "little_maid_spawn_egg"))
            ));

            // ▶ バニラの防具
            serverPlayer.getInventory().add(new ItemStack(Items.IRON_HELMET));
            serverPlayer.getInventory().add(new ItemStack(Items.IRON_CHESTPLATE));
            serverPlayer.getInventory().add(new ItemStack(Items.IRON_LEGGINGS));
            serverPlayer.getInventory().add(new ItemStack(Items.IRON_BOOTS));
        }
    }
}