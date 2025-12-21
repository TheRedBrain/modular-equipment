package com.github.theredbrain.modularequipment.component.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public record BladeModulesComponent(
		BladeModules bladeModules,
		TagKey<Item> blade_items,
		TagKey<Item> cross_guard_items,
		TagKey<Item> pommel_items,
		int size
) {
	public static final Codec<BladeModulesComponent> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							BladeModules.CODEC.fieldOf("bladeModules").forGetter(BladeModulesComponent::bladeModules),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("blade_items").forGetter(BladeModulesComponent::blade_items),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("cross_guard_items").forGetter(BladeModulesComponent::cross_guard_items),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("pommel_items").forGetter(BladeModulesComponent::pommel_items),
							Codec.INT.optionalFieldOf("size", 0).forGetter(BladeModulesComponent::size)
					)
					.apply(instance, BladeModulesComponent::new)
	);

	public BladeModulesComponent(
			TagKey<Item> blade_items,
			TagKey<Item> cross_guard_items,
			TagKey<Item> pommel_items
	) {
		this(
				BladeModules.DEFAULT,
				blade_items,
				cross_guard_items,
				pommel_items,
				0
		);
	}

	public ItemStack getComponentItemStack(String component_type) {
		if (Objects.equals(component_type, "blade")) {
			return this.bladeModules.blade_component;
		} else if (Objects.equals(component_type, "cross_guard")) {
			return this.bladeModules.cross_guard_component;
		} else if (Objects.equals(component_type, "pommel")) {
			return this.bladeModules.pommel_component;
		} else {
			return ItemStack.EMPTY;
		}
	}

	public record BladeModules(
			ItemStack blade_component,
			ItemStack cross_guard_component,
			ItemStack pommel_component
	) {
		public static final BladeModules DEFAULT = new BladeModules(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		public static final Codec<BladeModulesComponent.BladeModules> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								ItemStack.CODEC.optionalFieldOf("blade_component", ItemStack.EMPTY).forGetter(BladeModulesComponent.BladeModules::blade_component),
								ItemStack.CODEC.optionalFieldOf("cross_guard_component", ItemStack.EMPTY).forGetter(BladeModulesComponent.BladeModules::cross_guard_component),
								ItemStack.CODEC.optionalFieldOf("pommel_component", ItemStack.EMPTY).forGetter(BladeModulesComponent.BladeModules::pommel_component)
						)
						.apply(instance, BladeModulesComponent.BladeModules::new)
		);

	}

}
