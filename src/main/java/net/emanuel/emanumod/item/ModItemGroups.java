package net.emanuel.emanumod.item;

import net.emanuel.emanumod.Emanumod;
import net.emanuel.emanumod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CARDBOARD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Emanumod.MOD_ID, "cardboard_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PAPER_ROLL))
                    .displayName(Text.translatable("itemgroup.emanumod.cardboard_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PAPER_ROLL);
                        entries.add(ModBlocks.GREEN_PAPER_ROLL);
                        entries.add(ModItems.CARDBOARD);
                        entries.add(ModItems.CARDBOARD_ROLL);
                    }).build());



    public static void registerItemGroups() {
        Emanumod.LOGGER.info("Registering item groups for " + Emanumod.MOD_ID);
    }
}
