package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.temp.ModularWeaponComponentDataComponent;
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

	public static ResourceKey<Item> GOLDEN_SHORT_SWORD_BLADE_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("golden_short_sword_blade"));
	public static final Item GOLDEN_SHORT_SWORD_BLADE = registerItem(GOLDEN_SHORT_SWORD_BLADE_KEY, new Item(
			new Item.Properties().setId(GOLDEN_SHORT_SWORD_BLADE_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> GOLDEN_STRAIGHT_CROSS_GUARD_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("golden_straight_cross_guard"));
	public static final Item GOLDEN_STRAIGHT_CROSS_GUARD = registerItem(GOLDEN_STRAIGHT_CROSS_GUARD_KEY, new Item(
			new Item.Properties().setId(GOLDEN_STRAIGHT_CROSS_GUARD_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> GOLDEN_ROUND_POMMEL_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("golden_round_pommel"));
	public static final Item GOLDEN_ROUND_POMMEL = registerItem(GOLDEN_ROUND_POMMEL_KEY, new Item(
			new Item.Properties().setId(GOLDEN_ROUND_POMMEL_KEY)
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

	public static ResourceKey<Item> NETHERITE_ONE_HANDED_BLADE_WEAPON_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("netherite_one_handed_blade_weapon"));
	public static final Item NETHERITE_ONE_HANDED_BLADE_WEAPON = registerItem(NETHERITE_ONE_HANDED_BLADE_WEAPON_KEY, new Item(
			new Item.Properties().setId(NETHERITE_ONE_HANDED_BLADE_WEAPON_KEY)
					.stacksTo(1)
					.component(ModularEquipment.MODULAR_BLADE_WEAPON,
							new ModularBladeWeaponDataComponent(
									new ModularBladeWeaponDataComponent.Modules(
											ItemStack.EMPTY,
											ItemStack.EMPTY,
											ItemStack.EMPTY
									),
									Tags.ONE_HANDED_BLADES,
									Tags.ONE_HANDED_CROSS_GUARDS,
									Tags.ONE_HANDED_POMMELS,
									0
							)
					)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> NETHERITE_SHORT_SWORD_BLADE_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("netherite_short_sword_blade"));
	public static final Item NETHERITE_SHORT_SWORD_BLADE = registerItem(NETHERITE_SHORT_SWORD_BLADE_KEY, new Item(
			new Item.Properties().setId(NETHERITE_SHORT_SWORD_BLADE_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> NETHERITE_STRAIGHT_CROSS_GUARD_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("netherite_straight_cross_guard"));
	public static final Item NETHERITE_STRAIGHT_CROSS_GUARD = registerItem(NETHERITE_STRAIGHT_CROSS_GUARD_KEY, new Item(
			new Item.Properties().setId(NETHERITE_STRAIGHT_CROSS_GUARD_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> NETHERITE_ROUND_POMMEL_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("netherite_round_pommel"));
	public static final Item NETHERITE_ROUND_POMMEL = registerItem(NETHERITE_ROUND_POMMEL_KEY, new Item(
			new Item.Properties().setId(NETHERITE_ROUND_POMMEL_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> REGULAR_ONE_HANDED_BLADE_WEAPON_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("regular_one_handed_blade_weapon"));
	public static final Item REGULAR_ONE_HANDED_BLADE_WEAPON = registerItem(REGULAR_ONE_HANDED_BLADE_WEAPON_KEY, new Item(
			new Item.Properties().setId(REGULAR_ONE_HANDED_BLADE_WEAPON_KEY)
					.stacksTo(1)
					.component(ModularEquipment.MODULAR_BLADE_WEAPON,
							new ModularBladeWeaponDataComponent(
									new ModularBladeWeaponDataComponent.Modules(
											ItemStack.EMPTY,
											ItemStack.EMPTY,
											ItemStack.EMPTY
									),
									Tags.ONE_HANDED_BLADES,
									Tags.ONE_HANDED_CROSS_GUARDS,
									Tags.ONE_HANDED_POMMELS,
									0
							)
					)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> STONE_SHORT_SWORD_BLADE_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("stone_short_sword_blade"));
	public static final Item STONE_SHORT_SWORD_BLADE = registerItem(STONE_SHORT_SWORD_BLADE_KEY, new Item(
			new Item.Properties().setId(STONE_SHORT_SWORD_BLADE_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> STONE_STRAIGHT_CROSS_GUARD_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("stone_straight_cross_guard"));
	public static final Item STONE_STRAIGHT_CROSS_GUARD = registerItem(STONE_STRAIGHT_CROSS_GUARD_KEY, new Item(
			new Item.Properties().setId(STONE_STRAIGHT_CROSS_GUARD_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> STONE_ROUND_POMMEL_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("stone_round_pommel"));
	public static final Item STONE_ROUND_POMMEL = registerItem(STONE_ROUND_POMMEL_KEY, new Item(
			new Item.Properties().setId(STONE_ROUND_POMMEL_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> WOODEN_SHORT_SWORD_BLADE_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("wooden_short_sword_blade"));
	public static final Item WOODEN_SHORT_SWORD_BLADE = registerItem(WOODEN_SHORT_SWORD_BLADE_KEY, new Item(
			new Item.Properties().setId(WOODEN_SHORT_SWORD_BLADE_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> WOODEN_STRAIGHT_CROSS_GUARD_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("wooden_straight_cross_guard"));
	public static final Item WOODEN_STRAIGHT_CROSS_GUARD = registerItem(WOODEN_STRAIGHT_CROSS_GUARD_KEY, new Item(
			new Item.Properties().setId(WOODEN_STRAIGHT_CROSS_GUARD_KEY)
					.stacksTo(1)
	), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	public static ResourceKey<Item> WOODEN_ROUND_POMMEL_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("wooden_round_pommel"));
	public static final Item WOODEN_ROUND_POMMEL = registerItem(WOODEN_ROUND_POMMEL_KEY, new Item(
			new Item.Properties().setId(WOODEN_ROUND_POMMEL_KEY)
					.stacksTo(1)
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
