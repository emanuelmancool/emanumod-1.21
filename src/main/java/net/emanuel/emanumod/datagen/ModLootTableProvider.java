package net.emanuel.emanumod.datagen;

import net.emanuel.emanumod.block.ModBlocks;
import net.emanuel.emanumod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.GREEN_IRON_BLOCK);

        addDrop(ModBlocks.GREEN_PAPER_ORE, oreDrops(ModBlocks.GREEN_PAPER_ORE, ModItems.GREEN_PAPER));

        addDrop(ModBlocks.PAPER_ROLL,
                paperRollHelper(Items.PAPER, ModItems.CARDBOARD_ROLL));

        addDrop(ModBlocks.GREEN_PAPER_ROLL,
                paperRollHelper(ModItems.GREEN_PAPER, ModItems.CARDBOARD_ROLL));

        addDrop(ModBlocks.GREEN_IRON_STAIRS);
        addDrop(ModBlocks.GREEN_IRON_PRESSURE_PLATE);
        addDrop(ModBlocks.GREEN_IRON_WALL);
        addDrop(ModBlocks.GREEN_IRON_FENCE);
        addDrop(ModBlocks.GREEN_IRON_FENCE_GATE);
        addDrop(ModBlocks.GREEN_IRON_DOOR, doorDrops(ModBlocks.GREEN_IRON_DOOR));
        addDrop(ModBlocks.GREEN_IRON_SLAB, slabDrops(ModBlocks.GREEN_IRON_SLAB));
        addDrop(ModBlocks.GREEN_IRON_TRAPDOOR);
        addDrop(ModBlocks.GREEN_IRON_LAMP);
    }


    private LootTable.Builder paperRollHelper(ItemConvertible item1, ItemConvertible item2) {
        return LootTable.builder()
                // 8 × item1
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(item1)
                                .apply(SetCountLootFunction.builder(
                                        ConstantLootNumberProvider.create(8)))
                                .apply(ExplosionDecayLootFunction.builder()))
                )
                // 1 × item2
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(item2)
                                .apply(SetCountLootFunction.builder(
                                        ConstantLootNumberProvider.create(1)))
                                .apply(ExplosionDecayLootFunction.builder()))
                );
    }

}