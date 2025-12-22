package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabRegistry {

	public static final ResourceKey<CreativeModeTab> MODULAR_EQUIPMENT_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ModularEquipment.identifier("modular_equipment"));
	public static CreativeModeTab MODULAR_EQUIPMENT;

	public static void init() {
		ItemStack creativeModeTabDisplay = new ItemStack(ItemRegistry.REGULAR_ONE_HANDED_BLADE_WEAPON);
		creativeModeTabDisplay.set(ModularEquipment.MODULAR_BLADE_WEAPON,
				new ModularBladeWeaponDataComponent(
						new ModularBladeWeaponDataComponent.Modules(
								ItemRegistry.IRON_SHORT_SWORD_BLADE.getDefaultInstance(),
								ItemRegistry.COPPER_STRAIGHT_CROSS_GUARD.getDefaultInstance(),
								ItemRegistry.DIAMOND_ROUND_POMMEL.getDefaultInstance()
								),
						null,
						null,
						null,
						0
				));

		MODULAR_EQUIPMENT = FabricItemGroup.builder()
				.icon(() -> creativeModeTabDisplay)
				.title(Component.translatable("itemGroup.modularequipment.modular_equipment"))
				.build();

		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				MODULAR_EQUIPMENT_KEY,
				MODULAR_EQUIPMENT
		);
	}
}
