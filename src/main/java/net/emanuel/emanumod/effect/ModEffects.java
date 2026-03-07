package net.emanuel.emanumod.effect;

import net.emanuel.emanumod.Emanumod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> GREENY = registerStatusEffect("greeny",
            new GreenyEffect(StatusEffectCategory.NEUTRAL, 0x00ff21)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Emanumod.MOD_ID, "greeny"), -0.25f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Emanumod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Emanumod.LOGGER.info("Registering mod effects for " + Emanumod.MOD_ID);
    }
}
