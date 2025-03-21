package obscurus.obscurus;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import obscurus.obscurus.world.ObscurusConfiguredFeatures;

import java.util.Optional;
import java.util.function.Function;

public class ObscurusBlocks {

	public static final SaplingGenerator OBSCURUS_SAPLING_GENERATOR = new SaplingGenerator(
			Obscurus.MOD_ID + ":obscurus_tree",
			Optional.empty(), Optional.of(ObscurusConfiguredFeatures.OBSCURUS_TREE_KEY), Optional.empty());

	public static final Block OBSCURUS_WOOD = register("obscurus_wood", PillarBlock::new,
			AbstractBlock.Settings.copy(Blocks.OAK_LOG), true);
	public static final Block OBSCURUS_PLANKS = register("obscurus_planks", Block::new,
			AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), true);
	public static final Block OBSCURUS_LOG = register("obscurus_log", PillarBlock::new,
			AbstractBlock.Settings.copy(Blocks.OAK_LOG), true);
	public static final Block OBSCURUS_LEAVES = register("obscurus_leaves", LeavesBlock::new,
			AbstractBlock.Settings.copy(Blocks.OAK_LEAVES), true);
	public static final Block OBSCURUS_SAPLING = register("obscurus_sapling",
			(settings) -> new SaplingBlock(OBSCURUS_SAPLING_GENERATOR, settings),
			AbstractBlock.Settings.copy(Blocks.OAK_SAPLING), true);

	public static void initialize() {

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
			itemGroup.add(OBSCURUS_LOG);
			itemGroup.add(OBSCURUS_PLANKS);
			itemGroup.add(OBSCURUS_WOOD);
			itemGroup.add(OBSCURUS_LEAVES);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((itemGroup) -> {
			itemGroup.add(OBSCURUS_SAPLING);
		});

	}

	private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory,
			AbstractBlock.Settings settings, boolean shouldRegisterItem) {
		// Create a registry key for the block
		RegistryKey<Block> blockKey = keyOfBlock(name);
		// Create the block instance
		Block block = blockFactory.apply(settings.registryKey(blockKey));

		// Sometimes, you may not want to register an item for the block.
		// Eg: if it's a technical block like `minecraft:moving_piston` or
		// `minecraft:end_gateway`
		if (shouldRegisterItem) {
			// Items need to be registered with a different type of registry key, but the ID
			// can be the same.
			RegistryKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
			Registry.register(Registries.ITEM, itemKey, blockItem);
		}

		return Registry.register(Registries.BLOCK, blockKey, block);
	}

	private static RegistryKey<Block> keyOfBlock(String name) {
		return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Obscurus.MOD_ID, name));
	}

	private static RegistryKey<Item> keyOfItem(String name) {
		return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Obscurus.MOD_ID, name));
	}

}
