package obscurus.obscurus.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import obscurus.obscurus.Obscurus;
import obscurus.obscurus.ObscurusBlocks;

import java.util.OptionalInt;

public class ObscurusConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> OBSCURUS_TREE_KEY = registerKey("obscurus_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, OBSCURUS_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ObscurusBlocks.OBSCURUS_LOG),
                new DarkOakTrunkPlacer(8, 2, 2),
                BlockStateProvider.of(ObscurusBlocks.OBSCURUS_LEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
        ).build());

//        register(context, OBSCURUS_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
//                BlockStateProvider.of(ObscurusBlocks.OBSCURUS_LOG),
//                new StraightTrunkPlacer(3, 5, 2),
//                BlockStateProvider.of(ObscurusBlocks.OBSCURUS_LEAVES),
//                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 4),
//                new TwoLayersFeatureSize(1, 0, 2)
//            )
//            .build());
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Obscurus.MOD_ID, name));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    
}
