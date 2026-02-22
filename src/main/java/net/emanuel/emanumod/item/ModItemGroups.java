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
                        // PAPER ITEMS AND BLOCKS
                        entries.add(ModBlocks.PAPER_ROLL);
                        entries.add(ModBlocks.GREEN_PAPER_ROLL);
                        entries.add(ModBlocks.GREEN_PAPER_ORE);
                        entries.add(ModItems.CARDBOARD);
                        entries.add(ModItems.CARDBOARD_ROLL);
                        entries.add(ModItems.GREEN_PAPER);
                        entries.add(ModItems.GREEN_IRON_INGOT);

                        // TOOLS
                        entries.add(ModItems.GREEN_IRON_SWORD);
                        entries.add(ModItems.GREEN_IRON_PICKAXE);
                        entries.add(ModItems.GREEN_IRON_SHOVEL);
                        entries.add(ModItems.GREEN_IRON_AXE);
                        entries.add(ModItems.GREEN_IRON_HOE);
                        entries.add(ModItems.GREEN_IRON_HAMMER);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.GREEN_SANDWICH);

                        // ARMOR
                        entries.add(ModItems.GREEN_IRON_HELMET);
                        entries.add(ModItems.GREEN_IRON_CHESTPLATE);
                        entries.add(ModItems.GREEN_IRON_BOOTS);
                        entries.add(ModItems.GREEN_IRON_LEGGINGS);
                        entries.add(ModItems.GREEN_IRON_HORSE_ARMOR);
                        entries.add(ModItems.E_SMITHING_TEMPLATE);

                        // BLOCKS
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.GREEN_IRON_LAMP);
                        entries.add(ModBlocks.GREEN_IRON_STAIRS);
                        entries.add(ModBlocks.GREEN_IRON_SLAB);
                        entries.add(ModBlocks.GREEN_IRON_FENCE);
                        entries.add(ModBlocks.GREEN_IRON_FENCE_GATE);
                        entries.add(ModBlocks.GREEN_IRON_DOOR);
                        entries.add(ModBlocks.GREEN_IRON_TRAPDOOR);
                        entries.add(ModBlocks.GREEN_IRON_PRESSURE_PLATE);
                        entries.add(ModBlocks.GREEN_IRON_WALL);
                        entries.add(ModBlocks.GREEN_IRON_BLOCK);
                    }).build());



    public static void registerItemGroups() {
        Emanumod.LOGGER.info("Registering item groups for " + Emanumod.MOD_ID);
    }
}
