package com.github.maetel9.shisyoumod.item.tool;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;

public class ShisyouModTiers {
    public static final Tier SHISYOU_TIER = new Tier() {
        @Override
        public int getUses() {
            return 2031; // ネザライトと同じ耐久
        }

        @Override
        public float getSpeed() {
            return 9.0F; // 採掘速度
        }

        @Override
        public float getAttackDamageBonus() {
            return 5.0F; // ネザライトが3.0、ここでは+2強化
        }

        @Override
        public int getLevel() {
            return 4; // 採掘レベル（ダイヤ=3、ネザライト=4）
        }

        @Override
        public int getEnchantmentValue() {
            return 15; // ネザライトと同等
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.NETHERITE_INGOT); // 修理素材
        }
    };
}
