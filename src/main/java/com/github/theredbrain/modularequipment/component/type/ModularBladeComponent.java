package com.github.theredbrain.modularequipment.component.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public record ModularBladeComponent(
		BladeModules bladeModules,
		TagKey<Item> blade_items,
		TagKey<Item> cross_guard_items,
		TagKey<Item> grip_items,
		TagKey<Item> pommel_items,
		int size
) {
	public static final ModularBladeComponent DEFAULT = new ModularBladeComponent(new BladeModules(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY), null, null, null, null, 0);
	public static final Codec<ModularBladeComponent> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							BladeModules.CODEC.fieldOf("bladeModules").forGetter(ModularBladeComponent::bladeModules),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("blade_items").forGetter(ModularBladeComponent::blade_items),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("cross_guard_items").forGetter(ModularBladeComponent::cross_guard_items),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("grip_items").forGetter(ModularBladeComponent::grip_items),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("pommel_items").forGetter(ModularBladeComponent::pommel_items),
							Codec.INT.optionalFieldOf("size", 0).forGetter(ModularBladeComponent::size)
					)
					.apply(instance, ModularBladeComponent::new)
	);
	public static final StreamCodec<RegistryFriendlyByteBuf, ModularBladeComponent> STREAM_CODEC = StreamCodec.composite(
			ModularBladeComponent.BladeModules.STREAM_CODEC,
			component -> component.bladeModules,
			TagKey.streamCodec(Registries.ITEM),
			ModularBladeComponent::blade_items,
			TagKey.streamCodec(Registries.ITEM),
			ModularBladeComponent::cross_guard_items,
			TagKey.streamCodec(Registries.ITEM),
			ModularBladeComponent::grip_items,
			TagKey.streamCodec(Registries.ITEM),
			ModularBladeComponent::pommel_items,
			ByteBufCodecs.INT,
			ModularBladeComponent::size,
			ModularBladeComponent::new
	);

	public ModularBladeComponent(
			TagKey<Item> blade_items,
			TagKey<Item> cross_guard_items,
			TagKey<Item> grip_items,
			TagKey<Item> pommel_items
	) {
		this(
				new BladeModules(
						ItemStack.EMPTY,
						ItemStack.EMPTY,
						ItemStack.EMPTY,
						ItemStack.EMPTY
				),
				blade_items,
				cross_guard_items,
				grip_items,
				pommel_items,
				0
		);
	}

	public ItemStack getComponentItemStack(String component_type) {
		if (Objects.equals(component_type, "blade")) {
			return this.bladeModules.blade_component;
		} else if (Objects.equals(component_type, "cross_guard")) {
			return this.bladeModules.cross_guard_component;
		} else if (Objects.equals(component_type, "grip")) {
			return this.bladeModules.grip_component;
		} else if (Objects.equals(component_type, "pommel")) {
			return this.bladeModules.pommel_component;
		} else {
			return ItemStack.EMPTY;
		}
	}

	public static ModularBladeComponent.Builder builder() {
		return new ModularBladeComponent.Builder(DEFAULT);
	}

	public static class Builder {
		ModularBladeComponent.BladeModules bladeModules;
		TagKey<Item> blade_items;
		TagKey<Item> cross_guard_items;
		TagKey<Item> grip_items;
		TagKey<Item> pommel_items;
		int size;

		public Builder(ModularBladeComponent base) {
			this.bladeModules = new ModularBladeComponent.BladeModules(base.bladeModules.blade_component(), base.bladeModules.cross_guard_component(), base.bladeModules.grip_component(), base.bladeModules.pommel_component());
			this.blade_items = base.blade_items();
			this.cross_guard_items = base.cross_guard_items();
			this.grip_items = base.grip_items();
			this.pommel_items = base.pommel_items();
			this.size = base.size();
		}

		public ModularBladeComponent.Builder withBladeModules(ModularBladeComponent.BladeModules bladeModules) {
			this.bladeModules = new ModularBladeComponent.BladeModules(bladeModules.blade_component(), bladeModules.cross_guard_component(), bladeModules.grip_component(), bladeModules.pommel_component());
			return this;
		}

		public ModularBladeComponent.Builder withBladeItems(TagKey<Item> blade_items) {
			this.blade_items = blade_items;
			return this;
		}

		public ModularBladeComponent.Builder withCrossGuardItems(TagKey<Item> cross_guard_items) {
			this.cross_guard_items = cross_guard_items;
			return this;
		}

		public ModularBladeComponent.Builder withGripItems(TagKey<Item> grip_items) {
			this.grip_items = grip_items;
			return this;
		}

		public ModularBladeComponent.Builder withPommelItems(TagKey<Item> pommel_items) {
			this.pommel_items = pommel_items;
			return this;
		}

		public ModularBladeComponent.Builder withSize(int size) {
			this.size = size;
			return this;
		}

		public ModularBladeComponent build() {
			return new ModularBladeComponent(this.bladeModules, this.blade_items, this.cross_guard_items, this.grip_items, this.pommel_items, this.size);
		}
	}

	public record BladeModules(
			ItemStack blade_component,
			ItemStack cross_guard_component,
			ItemStack grip_component,
			ItemStack pommel_component
	) {
		public static final Codec<ModularBladeComponent.BladeModules> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								ItemStack.OPTIONAL_CODEC.fieldOf("blade_component").forGetter(ModularBladeComponent.BladeModules::blade_component),
								ItemStack.OPTIONAL_CODEC.fieldOf("cross_guard_component").forGetter(ModularBladeComponent.BladeModules::cross_guard_component),
								ItemStack.OPTIONAL_CODEC.fieldOf("grip_component").forGetter(ModularBladeComponent.BladeModules::grip_component),
								ItemStack.OPTIONAL_CODEC.fieldOf("pommel_component").forGetter(ModularBladeComponent.BladeModules::pommel_component)
						)
						.apply(instance, ModularBladeComponent.BladeModules::new)
		);
		public static final StreamCodec<RegistryFriendlyByteBuf, ModularBladeComponent.BladeModules> STREAM_CODEC = StreamCodec.composite(
				ItemStack.OPTIONAL_STREAM_CODEC,
				ModularBladeComponent.BladeModules::blade_component,
				ItemStack.OPTIONAL_STREAM_CODEC,
				ModularBladeComponent.BladeModules::cross_guard_component,
				ItemStack.OPTIONAL_STREAM_CODEC,
				ModularBladeComponent.BladeModules::grip_component,
				ItemStack.OPTIONAL_STREAM_CODEC,
				ModularBladeComponent.BladeModules::pommel_component,
				ModularBladeComponent.BladeModules::new
		);

	}

}
