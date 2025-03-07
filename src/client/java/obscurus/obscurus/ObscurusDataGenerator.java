package obscurus.obscurus;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import obscurus.obscurus.datagen.BlockTagProvider;
import obscurus.obscurus.datagen.LootTableProvider;
import obscurus.obscurus.datagen.ModelProvider;
import obscurus.obscurus.datagen.RecipeProvider;

public class ObscurusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(LootTableProvider::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(RecipeProvider::new);

	}
}
