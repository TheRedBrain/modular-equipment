package com.github.theredbrain.modularequipment;

import com.github.theredbrain.modularequipment.component.type.OneHandedBladeModulesComponent;
import com.github.theredbrain.modularequipment.registry.ItemComponentRegistry;
import com.github.theredbrain.modularequipment.registry.ItemGroupRegistry;
import com.github.theredbrain.modularequipment.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.component.ComponentType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModularEquipment implements ModInitializer {
	public static final String MOD_ID = "modularequipment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ComponentType<OneHandedBladeModulesComponent> ONE_HANDED_BLADE_MODULES;

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Modular Equipment!");

		// Registry
		ItemComponentRegistry.init();
		ItemRegistry.init();
		ItemGroupRegistry.init();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static void info(String message) {
		LOGGER.info("[" + MOD_ID + "] [info]: " + message);
	}

}