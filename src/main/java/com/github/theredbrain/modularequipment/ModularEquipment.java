package com.github.theredbrain.modularequipment;

import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.type.ModularShaftWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.temp.ModularWeaponComponentDataComponent;
import com.github.theredbrain.modularequipment.registry.BlockRegistry;
import com.github.theredbrain.modularequipment.registry.DataComponentTypeRegistry;
import com.github.theredbrain.modularequipment.registry.CreativeModeTabRegistry;
import com.github.theredbrain.modularequipment.registry.ItemRegistry;
import com.github.theredbrain.modularequipment.registry.MenuTypeRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModularEquipment implements ModInitializer {
	public static final String MOD_ID = "modularequipment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static DataComponentType<ModularBladeWeaponDataComponent> MODULAR_BLADE_WEAPON;

	public static DataComponentType<ModularShaftWeaponDataComponent> MODULAR_SHAFT_WEAPON;

	public static DataComponentType<ModularWeaponComponentDataComponent> MODULAR_WEAPON_COMPONENT;

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Modular Equipment!");

		// Registry
		BlockRegistry.init();
		DataComponentTypeRegistry.init();
		ItemRegistry.init();
		CreativeModeTabRegistry.init();
		MenuTypeRegistry.registerAll();
	}

	public static Identifier identifier(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static void info(String message) {
		LOGGER.info("[" + MOD_ID + "] [info]: " + message);
	}

}