package com.github.maetel9.shisyoumod.event;

import com.github.maetel9.shisyoumod.ShisyouMod;
import com.github.maetel9.shisyoumod.item.tool.ShisyouModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ShisyouMod.MOD_ID)
public class ShisyouModEvents {

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity(); // LivingEntity を取得

        ItemStack heldItem = entity.getItemBySlot(EquipmentSlot.MAINHAND);

        // プレイヤーが師匠を持っているか判定
        if (entity == null || entity.getMainHandItem().getItem() != ShisyouModItems.SHISYOU.get()) {
            return;
        }

        applyEffectIfNeeded(entity, MobEffects.DAMAGE_RESISTANCE, 2, 200);
        applyEffectIfNeeded(entity, MobEffects.DAMAGE_BOOST, 2, 200);
        applyEffectIfNeeded(entity, MobEffects.REGENERATION, 5, 200);
    }

    // 効果が付いていなければ、またはレベルが低ければ再付与
    private static void applyEffectIfNeeded(LivingEntity entity, MobEffect effect, int level, int duration) {
        MobEffectInstance current = entity.getEffect(effect);

        if (current == null || current.getAmplifier() < level - 1 || current.getDuration() < duration / 2) {
            entity.addEffect(new MobEffectInstance(effect, duration, level - 1, true, false));
        }
    }
}