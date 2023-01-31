package net.parsa.fuckingmod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.parsa.fuckingmod.block.custom.base.FuckBlock;

public class SlowFuck extends FuckBlock {
    public SlowFuck(Settings settings) {
        super(settings,"If you right click it or step on it, you're fucking slowed.");
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (hand == Hand.MAIN_HAND && !world.isClient()) {
            applyEffects(player);
            player.sendMessage(Text.literal("You slow fuck!"));
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity)
            applyEffects(livingEntity);
        super.onSteppedOn(world, pos, state, entity);
    }

    private void applyEffects(LivingEntity e) {
        e.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60,2, false, false));
    }

}
