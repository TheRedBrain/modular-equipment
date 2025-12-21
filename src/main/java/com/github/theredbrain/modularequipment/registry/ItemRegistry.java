package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

public class ItemRegistry {

	public static final Item ONE_HANDED_BLADE_WEAPON = registerItem("one_handed_blade_weapon", new Item(new Item.Settings().maxCount(1)), ItemGroupRegistry.MODULAR_EQUIPMENT);

	private static Item registerItem(String name, Item item, @Nullable RegistryKey<ItemGroup> itemGroup) {

		if (itemGroup != null) {
			ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
				content.add(item);
			});
		}
		return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), ModularEquipment.identifier(name)), item);
	}

	public static void init() {
	}
}
