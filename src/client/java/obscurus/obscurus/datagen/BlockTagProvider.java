package obscurus.obscurus.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;
import obscurus.obscurus.ObscurusBlocks;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(ObscurusBlocks.OBSCURUS_LOG)
            .add(ObscurusBlocks.OBSCURUS_PLANKS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
            .add(ObscurusBlocks.OBSCURUS_LOG)
            .add(ObscurusBlocks.OBSCURUS_WOOD);

        getOrCreateTagBuilder(BlockTags.LEAVES)
            .add(ObscurusBlocks.OBSCURUS_LEAVES);
        
        getOrCreateTagBuilder(BlockTags.SAPLINGS)
            .add(ObscurusBlocks.OBSCURUS_SAPLING);
    }
    
}
