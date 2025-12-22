package com.github.theredbrain.modularequipment;

import com.github.theredbrain.modularequipment.gui.screens.inventory.ModularEquipmentForgeScreen;
import com.github.theredbrain.modularequipment.registry.MenuTypeRegistry;
import com.github.theredbrain.modularequipment.renderer.item.ModularBladeComponentItemSpecialRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.item.ItemModels;

public class ModularEquipmentClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		MenuScreens.register(MenuTypeRegistry.MODULAR_EQUIPMENT_FORGE_MENU, ModularEquipmentForgeScreen::new);

		ItemModels.ID_MAPPER.put(ModularEquipment.identifier("modular_blade_component"), ModularBladeComponentItemSpecialRenderer.Unbaked.MAP_CODEC);
	}
}