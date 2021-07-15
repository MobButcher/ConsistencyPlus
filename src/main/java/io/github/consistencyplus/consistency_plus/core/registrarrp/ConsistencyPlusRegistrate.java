package io.github.consistencyplus.consistency_plus.core.registrarrp;

import com.tterrag.registrarrp.AbstractRegistrate;
import com.tterrag.registrarrp.Registrate;

public class ConsistencyPlusRegistrate extends AbstractRegistrate<ConsistencyPlusRegistrate> {
	protected ConsistencyPlusRegistrate(String modid) {
		super(modid);
	}
	
	public static ConsistencyPlusRegistrate create(String modid) {
		return new ConsistencyPlusRegistrate(modid);
	}
}
