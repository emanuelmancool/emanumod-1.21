package net.emanuel.emanumod;

import net.emanuel.emanumod.block.ModBlocks;
import net.emanuel.emanumod.component.ModDataComponentTypes;
import net.emanuel.emanumod.item.ModItemGroups;
import net.emanuel.emanumod.item.ModItems;
import net.emanuel.emanumod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Emanumod implements ModInitializer {
    public static final String MOD_ID = "emanumod";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModDataComponentTypes.registerDataComponentTypes();

        FuelRegistry.INSTANCE.add(ModItems.GREEN_PAPER, 5000);

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
    }
}