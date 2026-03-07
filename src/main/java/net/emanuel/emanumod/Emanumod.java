package net.emanuel.emanumod;

import net.emanuel.emanumod.block.ModBlocks;
import net.emanuel.emanumod.component.ModDataComponentTypes;
import net.emanuel.emanumod.effect.ModEffects;
import net.emanuel.emanumod.item.ModItemGroups;
import net.emanuel.emanumod.item.ModItems;
import net.emanuel.emanumod.potion.ModPotions;
import net.emanuel.emanumod.sound.ModSounds;
import net.emanuel.emanumod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
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
        ModSounds.registerSounds();
        ModEffects.registerEffects();
        ModPotions.registerPotions();

        FuelRegistry.INSTANCE.add(ModItems.GREEN_PAPER, 5000);

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            if (!player.isSpectator() && !player.isCreative()) {
                if (!world.isClient && !(player.getStackInHand(hand).getItem() instanceof BlockItem)) {
                    if (world.getBlockState(pos).isOf(ModBlocks.GREEN_PAPER_ROLL)) {

                        world.removeBlock(pos, false);

                        Block.dropStack(world, pos, new ItemStack(ModItems.GREEN_PAPER));

                        return ActionResult.SUCCESS;
                    }
                }
            }

            return ActionResult.PASS;
        });

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.GREEN_PAPER, ModPotions.GREENY_POTION);
        });
    }
}