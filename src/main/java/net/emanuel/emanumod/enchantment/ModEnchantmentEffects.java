package net.emanuel.emanumod.enchantment;

import com.mojang.serialization.MapCodec;
import net.emanuel.emanumod.Emanumod;
import net.emanuel.emanumod.enchantment.custom.DoubleWeightEnchantmentEffect;
import net.emanuel.emanumod.enchantment.custom.LightingStrikerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTING_STRIKER =
            registerEntityEffect("lighting_striker", LightingStrikerEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentEntityEffect> DOUBLE_WEIGHT =
            registerEntityEffect("lighting_striker", DoubleWeightEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Emanumod.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        Emanumod.LOGGER.info("Registering mod enchantment effects for " + Emanumod.MOD_ID);
    }
}
