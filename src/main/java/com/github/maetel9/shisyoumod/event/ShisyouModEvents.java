package com.github.maetel9.shisyoumod.event;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = ShisyouMod.MOD_ID)
public class ShisyouModEvents {

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        // メインハンドとオフハンドのアイテムをチェック
        ItemStack mainHandItem = entity.getItemBySlot(EquipmentSlot.MAINHAND);
        ItemStack offHandItem = entity.getItemBySlot(EquipmentSlot.OFFHAND);

        // メインハンドまたはオフハンドに「師匠の剣」が装備されている場合
        if (mainHandItem.getItem() == ShisyouModItems.SHISYOU.get() || offHandItem.getItem() == ShisyouModItems.SHISYOU.get()) {
            applyEffectIfNeeded(entity, MobEffects.DAMAGE_RESISTANCE, 2, 200);
            applyEffectIfNeeded(entity, MobEffects.DAMAGE_BOOST, 2, 200);
            applyEffectIfNeeded(entity, MobEffects.REGENERATION, 5, 200);
        }
    }

    private static void applyEffectIfNeededForResurrection(LivingEntity entity, MobEffect effect, int level, int duration) {
        MobEffectInstance current = entity.getEffect(effect);

        if (current == null || current.getAmplifier() < level - 1 || current.getDuration() < duration / 2) {
            entity.addEffect(new MobEffectInstance(effect, duration, level - 1, true, false));
        }
    }


    // 効果が付いていなければ、またはレベルが低ければ再付与
    private static void applyEffectIfNeeded(LivingEntity entity, MobEffect effect, int level, int duration) {
        MobEffectInstance current = entity.getEffect(effect);

        if (current == null || current.getAmplifier() < level - 1 || current.getDuration() < duration / 2) {
            entity.addEffect(new MobEffectInstance(effect, duration, level - 1, true, false));
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        LivingEntity entity = event.getEntity();

        // メインハンドまたはオフハンドに「師匠の剣」が装備されている場合、落下ダメージを無効化
        ItemStack mainHandItem = entity.getItemBySlot(EquipmentSlot.MAINHAND);
        ItemStack offHandItem = entity.getItemBySlot(EquipmentSlot.OFFHAND);

        // メインハンドまたはオフハンドに「師匠の剣」が装備されている場合
        if (mainHandItem.getItem() == ShisyouModItems.SHISYOU.get() || offHandItem.getItem() == ShisyouModItems.SHISYOU.get()) {
            event.setCanceled(true); // 落下ダメージをキャンセル
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();

        // プレイヤーやMOBが「師匠の剣」を装備している場合（メインハンドまたはオフハンド）
        ItemStack mainHandItem = entity.getItemBySlot(EquipmentSlot.MAINHAND);
        ItemStack offHandItem = entity.getItemBySlot(EquipmentSlot.OFFHAND);

        // メインハンドまたはオフハンドに「師匠の剣」が装備されている場合に蘇生効果を発動
        if ((mainHandItem.getItem() == ShisyouModItems.SHISYOU.get()) ||
                (offHandItem.getItem() == ShisyouModItems.SHISYOU.get())) {

            // 致死ダメージを受けた場合に回復処理
            if (event.getAmount() >= entity.getHealth()) {
                // ダメージをキャンセルして回復させる
                event.setCanceled(true);
                entity.setHealth(entity.getMaxHealth()); // 最大HPまで回復

            }
        }
    }
}
