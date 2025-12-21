package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ItemGroupRegistry {

	public static final ResourceKey<CreativeModeTab> MODULAR_EQUIPMENT_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ModularEquipment.identifier("modular_equipment"));
	public static final CreativeModeTab MODULAR_EQUIPMENT = FabricItemGroup.builder()
			.icon(() -> new ItemStack(Items.IRON_SWORD))
			.title(Component.translatable("itemGroup.modularequipment.modular_equipment"))
			.build();

	public static void init() {
		Registry.register(
				BuiltInRegistries.CREATIVE_MODE_TAB,
				MODULAR_EQUIPMENT_KEY,
				MODULAR_EQUIPMENT
		);
	}
}
