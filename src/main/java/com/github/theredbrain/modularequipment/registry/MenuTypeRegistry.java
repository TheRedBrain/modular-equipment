package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.world.inventory.ModularEquipmentForgeMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class MenuTypeRegistry {
	public static final MenuType<ModularEquipmentForgeMenu> MODULAR_EQUIPMENT_FORGE_MENU = new MenuType<>(ModularEquipmentForgeMenu::new, FeatureFlags.VANILLA_SET);

	public static void registerAll() {
		Registry.register(BuiltInRegistries.MENU, ModularEquipment.identifier("modular_equipment_forge"), MODULAR_EQUIPMENT_FORGE_MENU);
	}
}
