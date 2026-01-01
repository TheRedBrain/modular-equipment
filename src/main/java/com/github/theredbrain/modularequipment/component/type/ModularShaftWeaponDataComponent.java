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
import java.util.Optional;

public record ModularShaftWeaponDataComponent(
		Modules modules,
		Optional<TagKey<Item>> head_items,
		Optional<TagKey<Item>> pommel_items,
		int size // used in setting the data component of the modules to determine what item model they use
) {
	public static final ModularShaftWeaponDataComponent DEFAULT = new ModularShaftWeaponDataComponent(new Modules(ItemStack.EMPTY, ItemStack.EMPTY), null, null, 0);
	public static final Codec<ModularShaftWeaponDataComponent> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							Modules.CODEC.fieldOf("modules").forGetter(ModularShaftWeaponDataComponent::modules),
							TagKey.hashedCodec(Registries.ITEM).optionalFieldOf("head_items").forGetter(ModularShaftWeaponDataComponent::head_items),
							TagKey.hashedCodec(Registries.ITEM).optionalFieldOf("pommel_items").forGetter(ModularShaftWeaponDataComponent::pommel_items),
							Codec.INT.optionalFieldOf("size", 0).forGetter(ModularShaftWeaponDataComponent::size)
					)
					.apply(instance, ModularShaftWeaponDataComponent::new)
	);
	public static final StreamCodec<RegistryFriendlyByteBuf, ModularShaftWeaponDataComponent> STREAM_CODEC = StreamCodec.composite(
			Modules.STREAM_CODEC,
			component -> component.modules,
			TagKey.streamCodec(Registries.ITEM).apply(ByteBufCodecs::optional),
			ModularShaftWeaponDataComponent::head_items,
			TagKey.streamCodec(Registries.ITEM).apply(ByteBufCodecs::optional),
			ModularShaftWeaponDataComponent::pommel_items,
			ByteBufCodecs.INT,
			ModularShaftWeaponDataComponent::size,
			ModularShaftWeaponDataComponent::new
	);

	public ModularShaftWeaponDataComponent(
			Optional<TagKey<Item>> head_items,
			Optional<TagKey<Item>> pommel_items
	) {
		this(
				new Modules(
						ItemStack.EMPTY,
						ItemStack.EMPTY
				),
				head_items,
				pommel_items,
				0
		);
	}

	public boolean isUsable() {
		return true;
	}

	public ItemStack getComponentItemStack(String component_type) {
		if (Objects.equals(component_type, "head")) {
			return this.modules.head_component;
		} else if (Objects.equals(component_type, "pommel")) {
			return this.modules.pommel_component;
		} else {
			return ItemStack.EMPTY;
		}
	}

	public static ModularShaftWeaponDataComponent.Builder builder() {
		return new ModularShaftWeaponDataComponent.Builder(DEFAULT);
	}

	public static class Builder {
		Modules modules;
		Optional<TagKey<Item>> head_items;
		Optional<TagKey<Item>> pommel_items;
		int size;

		public Builder(ModularShaftWeaponDataComponent base) {
			this.modules = new Modules(base.modules.head_component(), base.modules.pommel_component());
			this.head_items = base.head_items();
			this.pommel_items = base.pommel_items();
			this.size = base.size();
		}

		public ModularShaftWeaponDataComponent.Builder withModules(Modules modules) {
			this.modules = new Modules(modules.head_component(), modules.pommel_component());
			return this;
		}

		public ModularShaftWeaponDataComponent.Builder withHeadItems(TagKey<Item> head_items) {
			this.head_items = Optional.of(head_items);
			return this;
		}

		public ModularShaftWeaponDataComponent.Builder withPommelItems(TagKey<Item> pommel_items) {
			this.pommel_items = Optional.of(pommel_items);
			return this;
		}

		public ModularShaftWeaponDataComponent.Builder withSize(int size) {
			this.size = size;
			return this;
		}

		public ModularShaftWeaponDataComponent build() {
			return new ModularShaftWeaponDataComponent(this.modules, this.head_items, this.pommel_items, this.size);
		}
	}

	public record Modules(
			ItemStack head_component,
			ItemStack pommel_component
	) {
		public static final Codec<Modules> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								ItemStack.OPTIONAL_CODEC.fieldOf("head_component").forGetter(Modules::head_component),
								ItemStack.OPTIONAL_CODEC.fieldOf("pommel_component").forGetter(Modules::pommel_component)
						)
						.apply(instance, Modules::new)
		);
		public static final StreamCodec<RegistryFriendlyByteBuf, Modules> STREAM_CODEC = StreamCodec.composite(
				ItemStack.OPTIONAL_STREAM_CODEC,
				Modules::head_component,
				ItemStack.OPTIONAL_STREAM_CODEC,
				Modules::pommel_component,
				Modules::new
		);

	}

}
