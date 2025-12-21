package spired.spiredsextramaterials;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spired.spiredsextramaterials.blocks.ModBlocks;
import spired.spiredsextramaterials.item.ModItems;
import spired.spiredsextramaterials.util.ModTags;
import spired.spiredsextramaterials.world.gen.ModWorldGeneration;

public class SpiredsExtraMaterials implements ModInitializer {
	public static final String MOD_ID = "spireds-extra-materials";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final RegistryKey<PlacedFeature> MITHRIL_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SpiredsExtraMaterials.MOD_ID, "mithril_ore"));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		LOGGER.info("Hello Fabric world!");
		ModTags.initialize();
		ModBlocks.initialize();
		ModItems.initialize();
		ModWorldGeneration.generateModWorldGen();

		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, MITHRIL_ORE_PLACED_KEY);
	}
}