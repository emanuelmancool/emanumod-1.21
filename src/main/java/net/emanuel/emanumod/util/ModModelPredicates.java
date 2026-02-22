package net.emanuel.emanumod.util;

import net.emanuel.emanumod.Emanumod;
import net.emanuel.emanumod.component.ModDataComponentTypes;
import net.emanuel.emanumod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(Emanumod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);
    }
}
