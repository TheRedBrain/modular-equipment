package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeComponent;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ItemRegistry {

	public static ResourceKey<Item> COPPER_SHORT_SWORD_BLADE_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("copper_short_sword_blade"));
	public static final Item COPPER_SHORT_SWORD_BLADE = registerItem(COPPER_SHORT_SWORD_BLADE_KEY, new Item(
			new Item.Properties().setId(COPPER_SHORT_SWORD_BLADE_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> COPPER_STRAIGHT_CROSS_GUARD_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("copper_straight_cross_guard"));
	public static final Item COPPER_STRAIGHT_CROSS_GUARD = registerItem(COPPER_STRAIGHT_CROSS_GUARD_KEY, new Item(
			new Item.Properties().setId(COPPER_STRAIGHT_CROSS_GUARD_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> COPPER_ROUND_POMMEL_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("copper_round_pommel"));
	public static final Item COPPER_ROUND_POMMEL = registerItem(COPPER_ROUND_POMMEL_KEY, new Item(
			new Item.Properties().setId(COPPER_ROUND_POMMEL_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> DIAMOND_SHORT_SWORD_BLADE_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("diamond_short_sword_blade"));
	public static final Item DIAMOND_SHORT_SWORD_BLADE = registerItem(DIAMOND_SHORT_SWORD_BLADE_KEY, new Item(
			new Item.Properties().setId(DIAMOND_SHORT_SWORD_BLADE_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> DIAMOND_STRAIGHT_CROSS_GUARD_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("diamond_straight_cross_guard"));
	public static final Item DIAMOND_STRAIGHT_CROSS_GUARD = registerItem(DIAMOND_STRAIGHT_CROSS_GUARD_KEY, new Item(
			new Item.Properties().setId(DIAMOND_STRAIGHT_CROSS_GUARD_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> DIAMOND_ROUND_POMMEL_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("diamond_round_pommel"));
	public static final Item DIAMOND_ROUND_POMMEL = registerItem(DIAMOND_ROUND_POMMEL_KEY, new Item(
			new Item.Properties().setId(DIAMOND_ROUND_POMMEL_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> IRON_SHORT_SWORD_BLADE_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("iron_short_sword_blade"));
	public static final Item IRON_SHORT_SWORD_BLADE = registerItem(IRON_SHORT_SWORD_BLADE_KEY, new Item(
			new Item.Properties().setId(IRON_SHORT_SWORD_BLADE_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> IRON_STRAIGHT_CROSS_GUARD_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("iron_straight_cross_guard"));
	public static final Item IRON_STRAIGHT_CROSS_GUARD = registerItem(IRON_STRAIGHT_CROSS_GUARD_KEY, new Item(
			new Item.Properties().setId(IRON_STRAIGHT_CROSS_GUARD_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> IRON_ROUND_POMMEL_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("iron_round_pommel"));
	public static final Item IRON_ROUND_POMMEL = registerItem(IRON_ROUND_POMMEL_KEY, new Item(
			new Item.Properties().setId(IRON_ROUND_POMMEL_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> ONE_HANDED_BLADE_WEAPON_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("one_handed_blade_weapon"));
	public static final Item ONE_HANDED_BLADE_WEAPON = registerItem(ONE_HANDED_BLADE_WEAPON_KEY, new Item(
			new Item.Properties().setId(ONE_HANDED_BLADE_WEAPON_KEY)
					.stacksTo(1)
					.component(ModularEquipment.MODULAR_BLADE,
							new ModularBladeComponent(
									new ModularBladeComponent.BladeModules(
											ItemStack.EMPTY,
											ItemStack.EMPTY,
											ItemStack.EMPTY,
											ItemStack.EMPTY
											),
									Tags.ONE_HANDED_BLADES,
									Tags.ONE_HANDED_CROSS_GUARDS,
									Tags.ONE_HANDED_GRIPS,
									Tags.ONE_HANDED_POMMELS,
									0
							)
					)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	private static Item registerItem(ResourceKey<Item> key, Item item, List<ResourceKey<CreativeModeTab>> creativeModeTabList) {

		for (ResourceKey<CreativeModeTab> creativeModeTab : creativeModeTabList) {
			ItemGroupEvents.modifyEntriesEvent(creativeModeTab).register(content -> {
				content.accept(item);
			});
		}
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void init() {
	}
}
