package com.github.maetel9.shisyoumod.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class InvisibleItemFrameItem extends Item {
    public InvisibleItemFrameItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide) return InteractionResult.SUCCESS;

        Direction clickedFace = context.getClickedFace();
        BlockPos clickedPos = context.getClickedPos();
        BlockPos placePos = clickedPos.relative(clickedFace);

        // プレイヤーが設置できるかどうか確認
        if (!context.getPlayer().mayUseItemAt(placePos, clickedFace, context.getItemInHand())) {
            return InteractionResult.FAIL;
        }



        // 額縁エンティティの作成
        ItemFrame frame = new ItemFrame(level, placePos, clickedFace);
        frame.setInvisible(true); // 透明化

        // 正常に設置できるかどうか確認
        if (!frame.survives()) {
            return InteractionResult.FAIL;
        }

        level.addFreshEntity(frame);

        if (!context.getPlayer().getAbilities().instabuild) {
            context.getItemInHand().shrink(1);
        }

        return InteractionResult.SUCCESS;
    }


}
