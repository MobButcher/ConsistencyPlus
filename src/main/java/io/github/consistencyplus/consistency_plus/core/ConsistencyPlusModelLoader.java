package io.github.consistencyplus.consistency_plus.core;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ConsistencyPlusModelLoader {
	public static final String CUBE_MODEL_STRING = """
			{
			  "parent": "minecraft:block/cube_all",
			  "textures": {
			    "all": "consistency_plus:block/template"
			  }
			}
			""";
	public static final String SLAB_MODEL_STRING = """
			{
			  "parent": "minecraft:block/slab",
			  "textures": {
			    "bottom": "consistency_plus:block/template",
			    "top": "consistency_plus:block/template",
			    "side": "consistency_plus:block/template"
			  }
			}
			""";
}
