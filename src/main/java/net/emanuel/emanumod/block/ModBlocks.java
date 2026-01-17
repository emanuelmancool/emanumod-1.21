package net.emanuel.emanumod.block;

import net.emanuel.emanumod.Emanumod;
import net.emanuel.emanumod.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PAPER_ROLL = registerBlock("paper_roll",
            new Block(AbstractBlock.Settings.create().strength(0.8f).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block GREEN_PAPER_ROLL = registerBlock("green_paper_roll",
            new Block(AbstractBlock.Settings.create().strength(0.8f).sounds(BlockSoundGroup.WOOL).burnable()));

    public static final Block GREEN_PAPER_ORE = registerBlock("green_paper_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block GREEN_IRON_BLOCK = registerBlock("green_iron_block",
            new Block(AbstractBlock.Settings.create().strength(6F, 7F).requiresTool().sounds(BlockSoundGroup.METAL)));


    public static final Block GREEN_IRON_STAIRS = registerBlock("green_iron_stairs",
            new StairsBlock(ModBlocks.GREEN_IRON_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(6F, 7F).requiresTool()));
    public static final Block GREEN_IRON_SLAB = registerBlock("green_iron_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(6F, 7F).requiresTool()));

    public static final Block GREEN_IRON_PRESSURE_PLATE = registerBlock("green_iron_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(6F, 7F).requiresTool()));

    public static final Block GREEN_IRON_FENCE = registerBlock("green_iron_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(6F, 7F).requiresTool().noCollision()));
    public static final Block GREEN_IRON_FENCE_GATE = registerBlock("green_iron_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(6F, 7F).requiresTool()));
    public static final Block GREEN_IRON_WALL = registerBlock("green_iron_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(6F, 7F).requiresTool()));

    public static final Block GREEN_IRON_DOOR = registerBlock("green_iron_door",
            new DoorBlock(BlockSetType.ACACIA, DoorBlock.Settings.create().strength(6F, 7F).requiresTool().nonOpaque().sounds(BlockSoundGroup.METAL)));
    public static final Block GREEN_IRON_TRAPDOOR = registerBlock("green_iron_trapdoor",
            new TrapdoorBlock(BlockSetType.ACACIA, TrapdoorBlock.Settings.create().strength(6F, 7F).requiresTool().nonOpaque().sounds(BlockSoundGroup.METAL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Emanumod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Emanumod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        Emanumod.LOGGER.info("Registering mod blocks for " + Emanumod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {});
    }
}
