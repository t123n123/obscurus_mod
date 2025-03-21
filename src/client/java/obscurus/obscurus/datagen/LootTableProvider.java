package obscurus.obscurus.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import obscurus.obscurus.ObscurusBlocks;

public class LootTableProvider extends FabricBlockLootTableProvider {

    public LootTableProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ObscurusBlocks.OBSCURUS_LOG);
        addDrop(ObscurusBlocks.OBSCURUS_PLANKS);
        addDrop(ObscurusBlocks.OBSCURUS_WOOD);
        addDrop(ObscurusBlocks.OBSCURUS_SAPLING);

        addDrop(ObscurusBlocks.OBSCURUS_LEAVES, leavesDrops(ObscurusBlocks.OBSCURUS_LEAVES, ObscurusBlocks.OBSCURUS_SAPLING, 0.05f));
    }
    
}
