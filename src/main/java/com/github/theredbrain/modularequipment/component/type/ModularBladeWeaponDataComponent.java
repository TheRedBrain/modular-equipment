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

public record ModularBladeWeaponDataComponent(
		Modules modules,
		TagKey<Item> blade_items,
		TagKey<Item> cross_guard_items,
		TagKey<Item> pommel_items,
		int size // used in setting the data component of the modules to determine what item model they use
) {
	public static final ModularBladeWeaponDataComponent DEFAULT = new ModularBladeWeaponDataComponent(new Modules(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY), null, null, null, 0);
	public static final Codec<ModularBladeWeaponDataComponent> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							Modules.CODEC.fieldOf("modules").forGetter(ModularBladeWeaponDataComponent::modules),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("blade_items").forGetter(ModularBladeWeaponDataComponent::blade_items),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("cross_guard_items").forGetter(ModularBladeWeaponDataComponent::cross_guard_items),
							TagKey.hashedCodec(Registries.ITEM).fieldOf("pommel_items").forGetter(ModularBladeWeaponDataComponent::pommel_items),
							Codec.INT.optionalFieldOf("size", 0).forGetter(ModularBladeWeaponDataComponent::size)
					)
					.apply(instance, ModularBladeWeaponDataComponent::new)
	);
	public static final StreamCodec<RegistryFriendlyByteBuf, ModularBladeWeaponDataComponent> STREAM_CODEC = StreamCodec.composite(
			Modules.STREAM_CODEC,
			component -> component.modules,
			TagKey.streamCodec(Registries.ITEM),
			ModularBladeWeaponDataComponent::blade_items,
			TagKey.streamCodec(Registries.ITEM),
			ModularBladeWeaponDataComponent::cross_guard_items,
			TagKey.streamCodec(Registries.ITEM),
			ModularBladeWeaponDataComponent::pommel_items,
			ByteBufCodecs.INT,
			ModularBladeWeaponDataComponent::size,
			ModularBladeWeaponDataComponent::new
	);

	public ModularBladeWeaponDataComponent(
			TagKey<Item> blade_items,
			TagKey<Item> cross_guard_items,
			TagKey<Item> pommel_items
	) {
		this(
				new Modules(
						ItemStack.EMPTY,
						ItemStack.EMPTY,
						ItemStack.EMPTY
				),
				blade_items,
				cross_guard_items,
				pommel_items,
				0
		);
	}

	public boolean isUsable() {
		return !this.modules.blade_component.isEmpty();
	}

	public ItemStack getComponentItemStack(String component_type) {
		if (Objects.equals(component_type, "blade")) {
			return this.modules.blade_component;
		} else if (Objects.equals(component_type, "cross_guard")) {
			return this.modules.cross_guard_component;
		} else if (Objects.equals(component_type, "pommel")) {
			return this.modules.pommel_component;
		} else {
			return ItemStack.EMPTY;
		}
	}

	public static ModularBladeWeaponDataComponent.Builder builder() {
		return new ModularBladeWeaponDataComponent.Builder(DEFAULT);
	}

	public static class Builder {
		Modules modules;
		TagKey<Item> blade_items;
		TagKey<Item> cross_guard_items;
		TagKey<Item> pommel_items;
		int size;

		public Builder(ModularBladeWeaponDataComponent base) {
			this.modules = new Modules(base.modules.blade_component(), base.modules.cross_guard_component(), base.modules.pommel_component());
			this.blade_items = base.blade_items();
			this.cross_guard_items = base.cross_guard_items();
			this.pommel_items = base.pommel_items();
			this.size = base.size();
		}

		public ModularBladeWeaponDataComponent.Builder withBladeModules(Modules modules) {
			this.modules = new Modules(modules.blade_component(), modules.cross_guard_component(), modules.pommel_component());
			return this;
		}

		public ModularBladeWeaponDataComponent.Builder withBladeItems(TagKey<Item> blade_items) {
			this.blade_items = blade_items;
			return this;
		}

		public ModularBladeWeaponDataComponent.Builder withCrossGuardItems(TagKey<Item> cross_guard_items) {
			this.cross_guard_items = cross_guard_items;
			return this;
		}

		public ModularBladeWeaponDataComponent.Builder withPommelItems(TagKey<Item> pommel_items) {
			this.pommel_items = pommel_items;
			return this;
		}

		public ModularBladeWeaponDataComponent.Builder withSize(int size) {
			this.size = size;
			return this;
		}

		public ModularBladeWeaponDataComponent build() {
			return new ModularBladeWeaponDataComponent(this.modules, this.blade_items, this.cross_guard_items, this.pommel_items, this.size);
		}
	}

	public record Modules(
			ItemStack blade_component,
			ItemStack cross_guard_component,
			ItemStack pommel_component
	) {
		public static final Codec<Modules> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								ItemStack.OPTIONAL_CODEC.fieldOf("blade_component").forGetter(Modules::blade_component),
								ItemStack.OPTIONAL_CODEC.fieldOf("cross_guard_component").forGetter(Modules::cross_guard_component),
								ItemStack.OPTIONAL_CODEC.fieldOf("pommel_component").forGetter(Modules::pommel_component)
						)
						.apply(instance, Modules::new)
		);
		public static final StreamCodec<RegistryFriendlyByteBuf, Modules> STREAM_CODEC = StreamCodec.composite(
				ItemStack.OPTIONAL_STREAM_CODEC,
				Modules::blade_component,
				ItemStack.OPTIONAL_STREAM_CODEC,
				Modules::cross_guard_component,
				ItemStack.OPTIONAL_STREAM_CODEC,
				Modules::pommel_component,
				Modules::new
		);

	}

}
