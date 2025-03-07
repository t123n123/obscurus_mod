package obscurus.obscurus.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import obscurus.obscurus.ObscurusBlocks;

public class LootTableProvider extends FabricBlockLootTableProvider {

    public LootTableProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ObscurusBlocks.CONDENSED_DIRT);
        addDrop(ObscurusBlocks.OBSCURUS_LOG);
        addDrop(ObscurusBlocks.OBSCURUS_PLANKS);
        addDrop(ObscurusBlocks.OBSCURUS_WOOD);
    }
    
}
