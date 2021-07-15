package io.github.consistencyplus.consistency_plus;

import io.github.consistencyplus.consistency_plus.core.ConsistencyPlusMaterial;
import io.github.consistencyplus.consistency_plus.core.ConsistencyPlusUtils;
import io.github.consistencyplus.consistency_plus.core.registrarrp.ConsistencyPlusRegistrate;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tag.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.github.consistencyplus.consistency_plus.core.ConsistencyPlusUtils.humanReadableNt;

public class ConsistencyPlus implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("Consistency+");
	public static final ConsistencyPlusRegistrate REGISTRATE = ConsistencyPlusRegistrate.create("consistency_plus");
	public static final String[] VARIANTS = {"Smooth", "Polished", "Bricks", "Cut", "Tiles", "Carved", "Chiseled", "Pillar"};
	public static final String[] TYPES = {"Slab", "Stairs", "Wall", "Fence", "Gate"};
	public static final ConsistencyPlusMaterial[] MATERIALS = {
			new ConsistencyPlusMaterial("Stone", Blocks.STONE),
			new ConsistencyPlusMaterial("End Stone", Blocks.BLACKSTONE),
			new ConsistencyPlusMaterial("Deepslate", Blocks.DEEPSLATE),
			new ConsistencyPlusMaterial("Quartz", Blocks.QUARTZ_BLOCK),
			new ConsistencyPlusMaterial("Purpur", Blocks.PURPUR_BLOCK),
			new ConsistencyPlusMaterial("Prismarine", Blocks.PRISMARINE),
			new ConsistencyPlusMaterial("Dark Prismarine", Blocks.DARK_PRISMARINE),
			new ConsistencyPlusMaterial("Andesite", Blocks.ANDESITE),
			new ConsistencyPlusMaterial("Diorite", Blocks.DIORITE),
			new ConsistencyPlusMaterial("Granite", Blocks.GRANITE),
			new ConsistencyPlusMaterial("Calcite", Blocks.CALCITE),
			new ConsistencyPlusMaterial("Tuff", Blocks.TUFF),
			new ConsistencyPlusMaterial("Dripstone", Blocks.DRIPSTONE_BLOCK),
			new ConsistencyPlusMaterial("Concrete", Blocks.WHITE_CONCRETE),
			new ConsistencyPlusMaterial("Terracotta", Blocks.WHITE_TERRACOTTA),
			new ConsistencyPlusMaterial("Obsidian", Blocks.OBSIDIAN),
			new ConsistencyPlusMaterial("Crying Obsidian", Blocks.CRYING_OBSIDIAN),
			new ConsistencyPlusMaterial("Copper", Blocks.COPPER_BLOCK),
			new ConsistencyPlusMaterial("Netherrack", Blocks.NETHERRACK),
			new ConsistencyPlusMaterial("Warped Wart", Blocks.NETHER_WART_BLOCK), // h
			new ConsistencyPlusMaterial("Crimson Wart", Blocks.NETHER_WART_BLOCK), // h again
			new ConsistencyPlusMaterial("Sandstone", Blocks.SANDSTONE),
			new ConsistencyPlusMaterial("Red Sandstone", Blocks.RED_SANDSTONE),
			new ConsistencyPlusMaterial("Soul Sandstone", Blocks.SANDSTONE),
			
	};
	
	@Override
	public void onInitialize() {
		ModContainer mod = FabricLoader.getInstance()
						.getModContainer("consistency_plus")
						.orElseThrow(NullPointerException::new);

		String MOD_VERSION = mod.getMetadata()
						.getVersion()
						.getFriendlyString();

		LOGGER.info("Consistency+ Main - Version " + MOD_VERSION + " - Starting initialization");

		for (String variant : VARIANTS) {
			for (ConsistencyPlusMaterial material : MATERIALS) {
				for (String type : TYPES) {
					REGISTRATE.object(humanReadableNt(variant + " " + material.getName() + " " + type))
							.block(ConsistencyPlusUtils.getConstructor(type, material))
							.tag((Tag.Identified<Block>) ConsistencyPlusUtils.getBlockTags(type, variant, material))
							.register();
				}
			}
		}
		
//		// Loader and Environment sensing
//		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
//			LOGGER.debug("Consistency+ Main - Developer Environment");
//		} else {
//			LOGGER.debug("Consistency+ Main - Production Environment");
//		}
//		if (FabricLoader.getInstance().isModLoaded("quilt_loader")) {
//			LOGGER.debug("Consistency+ Main - Running on Quilt Loader with Fabric compat");
//		} else if (FabricLoader.getInstance().isModLoaded("fabricloader")) {
//			LOGGER.debug("Consistency+ Main - Running on Fabric Loader");
//		} else {
//			LOGGER.debug("Consistency+ Main - Running on an unknown loader, have to assume it's up to spec with Fabric.");
//		}
//
//		LOGGER.debug("Consistency+ Main - Beginning block initialization");
//		CPlusBlocks.init();
//		LOGGER.debug("Consistency+ Main - CPlusBlocks initialized");
//		LOGGER.debug("Consistency+ Main - Beginning item initialization");
//		CPlusItems.init();
//		LOGGER.debug("Consistency+ Main - CPlusItems initialized");
//		LOGGER.info("Consistency+ Main - Finished initialization");
	}
}
