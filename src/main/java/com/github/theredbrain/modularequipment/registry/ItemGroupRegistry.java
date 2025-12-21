package com.github.theredbrain.modularequipment.registry;

import com.github.theredbrain.modularequipment.ModularEquipment;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ItemGroupRegistry {
	public static final RegistryKey<ItemGroup> MODULAR_EQUIPMENT = RegistryKey.of(RegistryKeys.ITEM_GROUP, ModularEquipment.identifier("modular_equipment"));

	public static void init() {
		Registry.register(Registries.ITEM_GROUP, MODULAR_EQUIPMENT, FabricItemGroup.builder()
				.icon(() -> new ItemStack(Items.IRON_SWORD))
				.displayName(Text.translatable("itemGroup.modularequipment.modular_equipment"))
				.build());
	}
}
