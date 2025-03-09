package obscurus.obscurus;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import obscurus.obscurus.datagen.BlockTagProvider;
import obscurus.obscurus.datagen.ItemTagProvider;
import obscurus.obscurus.datagen.LootTableProvider;
import obscurus.obscurus.datagen.ModelProvider;
import obscurus.obscurus.datagen.RecipeProvider;
import obscurus.obscurus.datagen.RegistryDataGenerator;
import obscurus.obscurus.world.ObscurusConfiguredFeatures;
import obscurus.obscurus.world.ObscurusPlacedFeatures;

public class ObscurusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(RecipeProvider::new);
		pack.addProvider(RegistryDataGenerator::new);

	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ObscurusConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ObscurusPlacedFeatures::bootstrap);
	}
}
