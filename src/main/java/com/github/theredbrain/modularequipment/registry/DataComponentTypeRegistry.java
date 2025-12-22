package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.temp.ModularWeaponComponentDataComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;

public class DataComponentTypeRegistry {
	static {
		ModularEquipment.MODULAR_BLADE_WEAPON = Registry.register(
				BuiltInRegistries.DATA_COMPONENT_TYPE,
				ModularEquipment.identifier("modular_blade_weapon"),
				DataComponentType.<ModularBladeWeaponDataComponent>builder().persistent(ModularBladeWeaponDataComponent.CODEC).networkSynchronized(ModularBladeWeaponDataComponent.STREAM_CODEC).build()
		);
		ModularEquipment.MODULAR_SHAFT_WEAPON = Registry.register(
				BuiltInRegistries.DATA_COMPONENT_TYPE,
				ModularEquipment.identifier("modular_blade_weapon"),
				DataComponentType.<ModularBladeWeaponDataComponent>builder().persistent(ModularBladeWeaponDataComponent.CODEC).networkSynchronized(ModularBladeWeaponDataComponent.STREAM_CODEC).build()
		);
		ModularEquipment.MODULAR_WEAPON_COMPONENT = Registry.register(
				BuiltInRegistries.DATA_COMPONENT_TYPE,
				ModularEquipment.identifier("modular_weapon_component"),
				DataComponentType.<ModularWeaponComponentDataComponent>builder().persistent(ModularWeaponComponentDataComponent.CODEC).networkSynchronized(ModularWeaponComponentDataComponent.STREAM_CODEC).build()
		);
	}

	public static void init() {
	}
}
