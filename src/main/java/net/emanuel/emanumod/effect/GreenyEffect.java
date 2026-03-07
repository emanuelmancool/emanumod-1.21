package net.emanuel.emanumod.effect;

import net.emanuel.emanumod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;

public class GreenyEffect extends StatusEffect {
    public GreenyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player && entity.getWorld() instanceof ServerWorld world) {
            double radius = (amplifier + 1) * 10.0;
            Box searchBox = Box.of(player.getPos(), radius, radius, radius);
            world.getEntitiesByClass(ItemFrameEntity.class, searchBox, e -> true)
                    .forEach(frame -> {
                        if (!frame.getHeldItemStack().isOf(ModItems.GREEN_PAPER)) {
                            frame.setHeldItemStack(new ItemStack(ModItems.GREEN_PAPER));
                        }
                    });
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
