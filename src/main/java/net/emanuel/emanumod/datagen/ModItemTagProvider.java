package net.emanuel.emanumod.datagen;

import net.emanuel.emanumod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.GREEN_IRON_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.GREEN_IRON_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.GREEN_IRON_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.GREEN_IRON_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.GREEN_IRON_HOE);
    }
}
