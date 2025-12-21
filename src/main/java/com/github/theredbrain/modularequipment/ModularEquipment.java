package com.github.theredbrain.modularequipment;

import com.github.theredbrain.modularequipment.component.type.BladeModulesComponent;
import com.github.theredbrain.modularequipment.registry.DataComponentTypeRegistry;
import com.github.theredbrain.modularequipment.registry.CreativeModeTabRegistry;
import com.github.theredbrain.modularequipment.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModularEquipment implements ModInitializer {
	public static final String MOD_ID = "modularequipment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static DataComponentType<BladeModulesComponent> BLADE_MODULES;

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Modular Equipment!");

		// Registry
		DataComponentTypeRegistry.init();
		CreativeModeTabRegistry.init();
		ItemRegistry.init();
	}

	public static Identifier identifier(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static void info(String message) {
		LOGGER.info("[" + MOD_ID + "] [info]: " + message);
	}

}