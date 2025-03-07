package obscurus.obscurus.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import obscurus.obscurus.ObscurusBlocks;
import obscurus.obscurus.ObscurusItems;

public class RecipeProvider extends FabricRecipeProvider {

    public RecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "obscurus";
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                offer2x2CompactingRecipe(RecipeCategory.MISC, ObscurusItems.amongus , ObscurusItems.amongus);
                offerShapelessRecipe(ObscurusItems.amongus, ObscurusBlocks.CONDENSED_DIRT, "amongus", 4);
                offerShapelessRecipe(ObscurusBlocks.OBSCURUS_PLANKS, ObscurusBlocks.OBSCURUS_LOG, "obscurus", 4);
                offerShapelessRecipe(ObscurusBlocks.OBSCURUS_PLANKS, ObscurusBlocks.OBSCURUS_WOOD, "obscurus", 4);
                // offerShapelessRecipe(ObscurusBlocks.OBSCURUS_WOOD, ObscurusBlocks.OBSCURUS_PLANKS, "obscurus", 4);
                offer2x2CompactingRecipe(RecipeCategory.MISC, ObscurusBlocks.OBSCURUS_LOG, ObscurusBlocks.OBSCURUS_WOOD);
            }
        };
        
    }
    
}
