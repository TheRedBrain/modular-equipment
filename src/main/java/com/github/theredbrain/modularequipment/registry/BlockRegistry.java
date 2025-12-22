package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.block.ModularEquipmentForgeBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.List;

public class BlockRegistry {
	public static ResourceKey<Block> MODULAR_EQUIPMENT_FORGE_BLOCK_KEY = ResourceKey.create(Registries.BLOCK, ModularEquipment.identifier("modular_equipment_forge"));
	public static ResourceKey<Item> MODULAR_EQUIPMENT_FORGE_ITEM_KEY = ResourceKey.create(Registries.ITEM, ModularEquipment.identifier("modular_equipment_forge"));
	public static final Block MODULAR_EQUIPMENT_FORGE = registerBlock(
			MODULAR_EQUIPMENT_FORGE_BLOCK_KEY,
			MODULAR_EQUIPMENT_FORGE_ITEM_KEY,
			new ModularEquipmentForgeBlock(
					BlockBehaviour.Properties.of()
							.setId(MODULAR_EQUIPMENT_FORGE_BLOCK_KEY)
							.mapColor(MapColor.METAL)
							.requiresCorrectToolForDrops()
							.strength(5.0F, 1200.0F)
							.sound(SoundType.ANVIL)
							.pushReaction(PushReaction.BLOCK)
			), List.of(CreativeModeTabRegistry.MODULAR_EQUIPMENT_KEY));

	private static Block registerBlock(ResourceKey<Block> block_key, ResourceKey<Item> item_key, Block block, List<ResourceKey<CreativeModeTab>> creativeModeTabList) {
		for (ResourceKey<CreativeModeTab> creativeModeTab : creativeModeTabList) {
			ItemGroupEvents.modifyEntriesEvent(creativeModeTab).register(content -> content.accept(block));
		}
		Registry.register(BuiltInRegistries.ITEM, item_key, new BlockItem(block, new Item.Properties().setId(item_key)));
		return Registry.register(BuiltInRegistries.BLOCK, block_key, block);
	}

	public static void init() {
	}
}
