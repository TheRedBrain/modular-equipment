package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class Tags {
	public static final TagKey<Item> ONE_HANDED_BLADES = TagKey.create(Registries.ITEM, ModularEquipment.identifier("one_handed_blades"));
	public static final TagKey<Item> ONE_HANDED_CROSS_GUARDS = TagKey.create(Registries.ITEM, ModularEquipment.identifier("one_handed_cross_guards"));
	public static final TagKey<Item> ONE_HANDED_POMMELS = TagKey.create(Registries.ITEM, ModularEquipment.identifier("one_handed_pommels"));
	public static final TagKey<Item> SHORT_SHAFT_HEADS = TagKey.create(Registries.ITEM, ModularEquipment.identifier("short_shaft_heads"));
	public static final TagKey<Item> SHORT_SHAFT_POMMELS = TagKey.create(Registries.ITEM, ModularEquipment.identifier("short_shaft_pommels"));
}
