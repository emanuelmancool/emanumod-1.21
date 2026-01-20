package net.emanuel.emanumod.datagen;

import net.emanuel.emanumod.Emanumod;
import net.emanuel.emanumod.block.ModBlocks;
import net.emanuel.emanumod.block.custom.GreenIronLampBlock;
import net.emanuel.emanumod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool greenIronPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GREEN_IRON_BLOCK);
        blockStateModelGenerator.registerSingleton(ModBlocks.MAGIC_BLOCK, textureMap3, Models.CUBE_TOP);
        blockStateModelGenerator.registerSingleton(ModBlocks.PAPER_ROLL, textureMap1, Models.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.GREEN_PAPER_ROLL, textureMap2, Models.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_PAPER_ORE);

        greenIronPool.stairs(ModBlocks.GREEN_IRON_STAIRS);
        greenIronPool.slab(ModBlocks.GREEN_IRON_SLAB);
        greenIronPool.pressurePlate(ModBlocks.GREEN_IRON_PRESSURE_PLATE);
        greenIronPool.fence(ModBlocks.GREEN_IRON_FENCE);
        greenIronPool.fenceGate(ModBlocks.GREEN_IRON_FENCE_GATE);
        greenIronPool.wall(ModBlocks.GREEN_IRON_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.GREEN_IRON_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.GREEN_IRON_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.GREEN_IRON_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.GREEN_IRON_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GREEN_IRON_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(GreenIronLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CARDBOARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_PAPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARDBOARD_ROLL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_SANDWICH, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_IRON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_IRON_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.GREEN_IRON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_IRON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_IRON_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_IRON_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GREEN_IRON_HOE, Models.HANDHELD);

    }

    TextureMap textureMap1 = new TextureMap()
            .put(TextureKey.SIDE, Identifier.of(Emanumod.MOD_ID, "block/paper_roll"))
            .put(TextureKey.END, Identifier.of(Emanumod.MOD_ID, "block/paper_roll_top"));

    TextureMap textureMap2 = new TextureMap()
            .put(TextureKey.SIDE, Identifier.of(Emanumod.MOD_ID, "block/green_paper_roll"))
            .put(TextureKey.END, Identifier.of(Emanumod.MOD_ID, "block/green_paper_roll_top"));

    TextureMap textureMap3 = new TextureMap()
            .put(TextureKey.SIDE, Identifier.of(Emanumod.MOD_ID, "block/magic_block"))
            .put(TextureKey.TOP, Identifier.of(Emanumod.MOD_ID, "block/magic_block_top"));
}
