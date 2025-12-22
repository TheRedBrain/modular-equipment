package com.github.theredbrain.modularequipment.component.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.ArrayList;
import java.util.List;

public record ModularWeaponModuleDataComponent(
		String weapon_attribute_identifier,
		List<String> spell_identifier_list,
		List<AttributeModifier> attribute_modifier_list
) {
	public static final ModularWeaponModuleDataComponent DEFAULT = new ModularWeaponModuleDataComponent(
			"",
			new ArrayList<>(),
			new ArrayList<>()
	);
	public static final Codec<ModularWeaponModuleDataComponent> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							Codec.STRING.fieldOf("weapon_attribute_identifier").forGetter(ModularWeaponModuleDataComponent::weapon_attribute_identifier),
							Codec.STRING.listOf().fieldOf("spell_identifier_list").forGetter(ModularWeaponModuleDataComponent::spell_identifier_list),
							AttributeModifier.CODEC.listOf().fieldOf("attribute_modifier_list").forGetter(ModularWeaponModuleDataComponent::attribute_modifier_list)
					)
					.apply(instance, ModularWeaponModuleDataComponent::new)
	);
	public static final StreamCodec<RegistryFriendlyByteBuf, ModularWeaponModuleDataComponent> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.STRING_UTF8,
			ModularWeaponModuleDataComponent::weapon_attribute_identifier,
			ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()),
			component -> component.spell_identifier_list,
			AttributeModifier.STREAM_CODEC.apply(ByteBufCodecs.list()),
			component -> component.attribute_modifier_list,
			ModularWeaponModuleDataComponent::new
	);

//	public ModularWeaponComponentDataComponent(
//			TagKey<Item> head_items,
//			TagKey<Item> cross_guard_items,
//			TagKey<Item> pommel_items
//	) {
//		this(
//				new BladeModules(
//						ItemStack.EMPTY,
//						ItemStack.EMPTY,
//						ItemStack.EMPTY
//				),
//				head_items,
//				cross_guard_items,
//				pommel_items,
//				0
//		);
//	}

//	public ItemStack getComponentItemStack(String component_type) {
//		if (Objects.equals(component_type, "blade")) {
//			return this.bladeModules.blade_component;
//		} else if (Objects.equals(component_type, "cross_guard")) {
//			return this.bladeModules.cross_guard_component;
//		} else if (Objects.equals(component_type, "pommel")) {
//			return this.bladeModules.pommel_component;
//		} else {
//			return ItemStack.EMPTY;
//		}
//	}

	public static ModularWeaponModuleDataComponent.Builder builder() {
		return new ModularWeaponModuleDataComponent.Builder(DEFAULT);
	}

	public static class Builder {
		String weapon_attribute_identifier;
		List<String> spell_identifier_list = new ArrayList<>();
		List<AttributeModifier> attribute_modifier_list = new ArrayList<>();

		public Builder(ModularWeaponModuleDataComponent base) {
			this.weapon_attribute_identifier = base.weapon_attribute_identifier();
			this.spell_identifier_list.addAll(base.spell_identifier_list());
			this.attribute_modifier_list.addAll(base.attribute_modifier_list());
		}

//		public ModularWeaponComponentDataComponent.Builder withBladeModules(ModularWeaponComponentDataComponent.BladeModules bladeModules) {
//			this.bladeModules = new ModularWeaponComponentDataComponent.BladeModules(bladeModules.blade_component(), bladeModules.cross_guard_component(), bladeModules.pommel_component());
//			return this;
//		}
//
//		public ModularWeaponComponentDataComponent.Builder withBladeItems(TagKey<Item> head_items) {
//			this.head_items = head_items;
//			return this;
//		}
//
//		public ModularWeaponComponentDataComponent.Builder withCrossGuardItems(TagKey<Item> cross_guard_items) {
//			this.cross_guard_items = cross_guard_items;
//			return this;
//		}
//
//		public ModularWeaponComponentDataComponent.Builder withPommelItems(TagKey<Item> pommel_items) {
//			this.pommel_items = pommel_items;
//			return this;
//		}
//
//		public ModularWeaponComponentDataComponent.Builder withSize(int size) {
//			this.size = size;
//			return this;
//		}

		public ModularWeaponModuleDataComponent build() {
			return new ModularWeaponModuleDataComponent(this.weapon_attribute_identifier, this.spell_identifier_list, this.attribute_modifier_list);
		}
	}

//	public record AttributeModifierList(
//			List<AttributeModifier> attribute_modifier_list
//	) {
//		public static final Codec<ModularWeaponComponentDataComponent.AttributeModifierList> CODEC = RecordCodecBuilder.create(
//				instance -> instance.group(
//								AttributeModifier.CODEC.listOf().fieldOf("attribute_modifier_list").forGetter(ModularWeaponComponentDataComponent.AttributeModifierList::attribute_modifier_list)
//						)
//						.apply(instance, ModularWeaponComponentDataComponent.AttributeModifierList::new)
//		);
//		public static final StreamCodec<RegistryFriendlyByteBuf, ModularWeaponComponentDataComponent.AttributeModifierList> STREAM_CODEC = StreamCodec.composite(
//				ItemStack.OPTIONAL_STREAM_CODEC,
//				ModularWeaponComponentDataComponent.BladeModules::blade_component,
//				ItemStack.OPTIONAL_STREAM_CODEC,
//				ModularWeaponComponentDataComponent.BladeModules::cross_guard_component,
//				ItemStack.OPTIONAL_STREAM_CODEC,
//				ModularWeaponComponentDataComponent.BladeModules::pommel_component,
//				ModularWeaponComponentDataComponent.AttributeModifierList::new
//		);
//
//	}

}
