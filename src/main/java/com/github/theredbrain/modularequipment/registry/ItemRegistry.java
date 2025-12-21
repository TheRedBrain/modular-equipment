package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class ItemRegistry {

	public static ResourceKey<Item> ONE_HANDED_BLADE_WEAPON_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("one_handed_blade_weapon"));
	public static final Item ONE_HANDED_BLADE_WEAPON = registerItem(ONE_HANDED_BLADE_WEAPON_KEY, new Item(new Item.Properties().setId(ONE_HANDED_BLADE_WEAPON_KEY).stacksTo(1)), ItemGroupRegistry.MODULAR_EQUIPMENT_KEY);

	private static Item registerItem(ResourceKey<Item> key, Item item, @Nullable ResourceKey<CreativeModeTab> itemGroup) {

		if (itemGroup != null) {
			ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
				content.accept(item);
			});
		}
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void init() {
	}
}
