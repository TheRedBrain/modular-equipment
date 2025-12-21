package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.OneHandedBladeModulesComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class ItemComponentRegistry {
	static {
		ModularEquipment.ONE_HANDED_BLADE_MODULES = Registry.register(
				BuiltInRegistries.DATA_COMPONENT_TYPE,
				ModularEquipment.identifier("one_handed_blade_modules"),
				DataComponentType.<OneHandedBladeModulesComponent>builder().persistent(OneHandedBladeModulesComponent.CODEC).build()
		);
	}

	public static void init() {
	}
}
