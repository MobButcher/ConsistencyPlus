package io.github.consistencyplus.consistency_plus.core.registrarrp;

import com.tterrag.registrarrp.AbstractRegistrate;
import com.tterrag.registrarrp.builders.BlockBuilder;
import com.tterrag.registrarrp.builders.BuilderCallback;
import com.tterrag.registrarrp.util.nullness.NonNullFunction;
import com.tterrag.registrarrp.util.nullness.NonNullSupplier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

public class ConsistencyPlusBlockBuilder<T extends Block, P> extends BlockBuilder<T, P> {
	protected ConsistencyPlusBlockBuilder(AbstractRegistrate<?> owner, P parent, String name, BuilderCallback callback, NonNullFunction<FabricBlockSettings, T> factory, NonNullSupplier<FabricBlockSettings> initialProperties) {
		super(owner, parent, name, callback, factory, initialProperties);
	}
}
