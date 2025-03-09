package obscurus.obscurus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ObscurusClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		BlockRenderLayerMap.INSTANCE.putBlock(ObscurusBlocks.OBSCURUS_SAPLING, RenderLayer.getCutout());
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}