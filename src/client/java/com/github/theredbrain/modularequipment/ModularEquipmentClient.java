package com.github.theredbrain.modularequipment;

import com.github.theredbrain.modularequipment.renderer.item.ModularBladeComponentItemSpecialRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.item.ItemModels;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModularEquipmentClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		ItemModels.ID_MAPPER.put(ModularEquipment.identifier("modular_blade_component"), ModularBladeComponentItemSpecialRenderer.Unbaked.MAP_CODEC);
	}
}