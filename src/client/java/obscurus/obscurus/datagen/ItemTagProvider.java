package obscurus.obscurus.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;
import obscurus.obscurus.ObscurusBlocks;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
            .add(ObscurusBlocks.OBSCURUS_LOG.asItem())
            .add(ObscurusBlocks.OBSCURUS_WOOD.asItem());


        getOrCreateTagBuilder(ItemTags.PLANKS)
            .add(ObscurusBlocks.OBSCURUS_PLANKS.asItem());
    }
    
}
