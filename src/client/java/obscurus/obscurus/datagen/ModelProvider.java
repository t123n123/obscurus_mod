package obscurus.obscurus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import obscurus.obscurus.ObscurusBlocks;
import obscurus.obscurus.ObscurusItems;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ObscurusBlocks.OBSCURUS_PLANKS);
        blockStateModelGenerator.registerLog(ObscurusBlocks.OBSCURUS_LOG).log(ObscurusBlocks.OBSCURUS_LOG).wood(ObscurusBlocks.OBSCURUS_WOOD);
        blockStateModelGenerator.registerSingleton(ObscurusBlocks.OBSCURUS_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ObscurusBlocks.OBSCURUS_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ObscurusItems.amongus, Models.GENERATED);
        itemModelGenerator.register(ObscurusBlocks.OBSCURUS_SAPLING.asItem(), Models.GENERATED);
    }
    
}
