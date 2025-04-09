package com.github.maetel9.shisyoumod.item.tool;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ShisyouItem extends SwordItem {
    public ShisyouItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    // この剣はダメージを受けない（耐久値が減らない）
    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

}