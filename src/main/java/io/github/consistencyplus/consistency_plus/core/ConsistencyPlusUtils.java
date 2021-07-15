package io.github.consistencyplus.consistency_plus.core;

import com.tterrag.registrarrp.util.Utils;
import com.tterrag.registrarrp.util.nullness.NonNullFunction;
import io.github.consistencyplus.consistency_plus.core.blocks.BaseConsistencyStairBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConsistencyPlusUtils {
	public static String humanReadableNt(String input) {
		return input.toLowerCase(Locale.ROOT).replace(" ", "_");
	}
	
	public static NonNullFunction<FabricBlockSettings, ? extends Block> getConstructor(String type, ConsistencyPlusMaterial material) {
		return switch (type) {
			case "Slab" -> SlabBlock::new;
			case "Stairs" -> settings -> new BaseConsistencyStairBlock(material.getBaseBlock().getDefaultState(), settings);
			case "Wall" -> WallBlock::new;
			case "Fence" -> FenceBlock::new;
			case "Gate" -> FenceGateBlock::new;
			default -> Block::new;
		};
	}
	
	public static List<Tag.Identified<Block>> getBlockTags(String type, String variant, ConsistencyPlusMaterial material) {
		List<Tag.Identified<Block>> tags = new ArrayList<>();
		switch (type) {
			case "Slab" -> tags.add(BlockTags.SLABS);
			case "Stairs" -> tags.add(BlockTags.STAIRS);
			case "Wall" -> tags.add(BlockTags.WALLS);
			case "Fence" -> tags.add(BlockTags.FENCES);
			case "Gate" -> tags.add(BlockTags.FENCE_GATES);
		}
		
		switch (material.getName()) {
			
		}
		
		return tags;
	}
}
