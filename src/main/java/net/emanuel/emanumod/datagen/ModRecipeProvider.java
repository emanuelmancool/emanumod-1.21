package net.emanuel.emanumod.datagen;

import net.emanuel.emanumod.Emanumod;
import net.emanuel.emanumod.block.ModBlocks;
import net.emanuel.emanumod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CARDBOARD_ROLL)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .input('#', ModItems.CARDBOARD)
                .criterion(hasItem(ModItems.CARDBOARD), conditionsFromItem(ModItems.CARDBOARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PAPER_ROLL)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .input('#', Items.PAPER)
                .input('@', ModItems.CARDBOARD_ROLL)
                .criterion(hasItem(ModItems.CARDBOARD_ROLL), conditionsFromItem(ModItems.CARDBOARD_ROLL))
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GREEN_PAPER_ROLL)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .input('#', ModItems.GREEN_PAPER)
                .input('@', ModItems.CARDBOARD_ROLL)
                .criterion(hasItem(ModItems.CARDBOARD_ROLL), conditionsFromItem(ModItems.CARDBOARD_ROLL))
                .criterion(hasItem(ModItems.GREEN_PAPER), conditionsFromItem(ModItems.GREEN_PAPER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .input('#', ModItems.GREEN_PAPER)
                .input('@', Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(ModItems.GREEN_PAPER), conditionsFromItem(ModItems.GREEN_PAPER))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CARDBOARD, 1)
                .input(Items.PAPER)
                .input(Items.PAPER)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL, 1)
                .input(ModItems.GREEN_PAPER)
                .input(Items.STICK)
                .criterion(hasItem(ModItems.GREEN_PAPER), conditionsFromItem(ModItems.GREEN_PAPER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GREEN_SANDWICH, 1)
                .input(ModItems.GREEN_PAPER)
                .input(Items.BREAD)
                .input(Items.BREAD)
                .criterion(hasItem(ModItems.GREEN_PAPER), conditionsFromItem(ModItems.GREEN_PAPER))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GREEN_PAPER_ROLL, 1)
                .input(ModBlocks.PAPER_ROLL)
                .input(Items.GREEN_DYE)
                .criterion(hasItem(ModBlocks.PAPER_ROLL), conditionsFromItem(ModBlocks.PAPER_ROLL))
                .criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE))
                .offerTo(recipeExporter, Identifier.of(Emanumod.MOD_ID, "green_paper_roll_alt"));
    }
}
