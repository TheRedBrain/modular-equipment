package com.github.theredbrain.modularequipment.component.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;

public record OneHandedBladeModulesComponent(
		ItemStack blade_component,
		ItemStack cross_guard_component,
		ItemStack pommel_component
) {
	public static final Codec<OneHandedBladeModulesComponent> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							ItemStack.CODEC.optionalFieldOf("blade_component", ItemStack.EMPTY).forGetter(OneHandedBladeModulesComponent::blade_component),
							ItemStack.CODEC.optionalFieldOf("cross_guard_component", ItemStack.EMPTY).forGetter(OneHandedBladeModulesComponent::cross_guard_component),
							ItemStack.CODEC.optionalFieldOf("pommel_component", ItemStack.EMPTY).forGetter(OneHandedBladeModulesComponent::pommel_component)
					)
					.apply(instance, OneHandedBladeModulesComponent::new)
	);

}
