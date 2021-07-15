package io.github.consistencyplus.consistency_plus.core;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class ConsistencyPlusMaterial {
	private final AbstractBlock.Settings settings;
	private final String name;
	private final Block baseBlock;
	
	public ConsistencyPlusMaterial(String name, Block baseBlock) {
		this.name = name;
		this.baseBlock = baseBlock;
		this.settings = FabricBlockSettings.copy(baseBlock);
	}
	
	public AbstractBlock.Settings getSettings() {
		return settings;
	}
	
	public String getName() {
		return name;
	}
	
	public Block getBaseBlock() {
		return baseBlock;
	}
}
