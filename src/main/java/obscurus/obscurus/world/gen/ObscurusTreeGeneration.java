package obscurus.obscurus.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import obscurus.obscurus.world.ObscurusPlacedFeatures;

public class ObscurusTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.SNOWY_TAIGA,
                        BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ObscurusPlacedFeatures.OBSCURUS_PLACED_TREE_KEY);
    }

}
