package io.github.consistencyplus.consistency_plus.mixin;

import io.github.consistencyplus.consistency_plus.ConsistencyPlus;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.consistencyplus.consistency_plus.core.ConsistencyPlusModelLoader.*;

@Environment(EnvType.CLIENT)
@Mixin(ModelLoader.class)
public class ModelLoaderMixin {
	
	@Inject(method = "loadModelFromJson", at = @At("HEAD"), cancellable = true)
	private void loadModelFromJson(Identifier id, CallbackInfoReturnable<JsonUnbakedModel> cir) {
		if (id.getNamespace().equals(ConsistencyPlus.ID)) {
			if (id.getPath().contains("block/")) {
				if (id.getPath().contains("slab")) {
					if (id.getPath().contains("top")) {
						// todo
					} else {
						JsonUnbakedModel model = JsonUnbakedModel.deserialize(
								SLAB_MODEL_STRING.replace("template", id.getPath()
										.replace("block/", "")
										.replace("_slab", ""))
						);
						model.id = id.toString();
						cir.setReturnValue(model);
					}
				}
			}
		}
	}
}
