package obscurus.obscurus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import obscurus.obscurus.world.gen.ObscurusWorldGeneration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Obscurus implements ModInitializer {
	public static final String MOD_ID = "obscurus";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ObscurusItems.initialize();
		ObscurusBlocks.initialize();

		FlammableBlockRegistry.getDefaultInstance().add(ObscurusBlocks.OBSCURUS_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ObscurusBlocks.OBSCURUS_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ObscurusBlocks.OBSCURUS_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ObscurusBlocks.OBSCURUS_LEAVES, 30, 60);

		ObscurusWorldGeneration.generateWorldGen();

		LOGGER.info("Hello Fabric world!");

	}




}