package net.emanuel.emanumod;

import net.emanuel.emanumod.block.ModBlocks;
import net.emanuel.emanumod.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EmanumodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_IRON_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_IRON_TRAPDOOR, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();
    }
}
