package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class DataComponentTypeRegistry {
	static {
		ModularEquipment.MODULAR_BLADE = Registry.register(
				BuiltInRegistries.DATA_COMPONENT_TYPE,
				ModularEquipment.identifier("one_handed_blade_modules"),
				DataComponentType.<ModularBladeComponent>builder().persistent(ModularBladeComponent.CODEC).networkSynchronized(ModularBladeComponent.STREAM_CODEC).build()
		);
	}

	public static void init() {
	}
}
