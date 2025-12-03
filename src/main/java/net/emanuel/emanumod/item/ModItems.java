package net.emanuel.emanumod.item;

import net.emanuel.emanumod.Emanumod;
import net.emanuel.emanumod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CARDBOARD = registerItem("cardboard", new Item(new Item.Settings()));
    public static final Item CARDBOARD_ROLL = registerItem("cardboard_roll", new Item(new Item.Settings()));
    public static final Item GREEN_PAPER = registerItem("green_paper", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Emanumod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Emanumod.LOGGER.info("Registering items for " + Emanumod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {});
    }
}