package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.OneHandedBladeModulesComponent;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemComponentRegistry {
	static {
		ModularEquipment.ONE_HANDED_BLADE_MODULES = Registry.register(
				Registries.DATA_COMPONENT_TYPE,
				ModularEquipment.identifier("one_handed_blade_modules"),
				ComponentType.<OneHandedBladeModulesComponent>builder().codec(OneHandedBladeModulesComponent.CODEC).build()
		);
	}

	public static void init() {
	}
}
