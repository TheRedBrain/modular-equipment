package com.github.theredbrain.modularequipment.renderer.item;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.resources.model.ResolvableModel;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class ModularBladeComponentItemSpecialRenderer implements ItemModel {
	private String component_type;

	public ModularBladeComponentItemSpecialRenderer(String component_type) {
		this.component_type = component_type;
	}

	@Override
	public void update(
			ItemStackRenderState itemStackRenderState,
			ItemStack itemStack,
			ItemModelResolver itemModelResolver,
			ItemDisplayContext itemDisplayContext,
			@Nullable ClientLevel clientLevel,
			@Nullable ItemOwner itemOwner,
			int i
	) {
		itemStackRenderState.appendModelIdentityElement(this);

		ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = itemStack.get(ModularEquipment.MODULAR_BLADE_WEAPON);
		if (modularBladeWeaponDataComponent != null) {
			ItemStack itemStack1 = modularBladeWeaponDataComponent.getComponentItemStack(this.component_type);
			if (!itemStack1.isEmpty()) {
				itemModelResolver.appendItemLayers(itemStackRenderState, itemStack1, itemDisplayContext, clientLevel, itemOwner, i);
			}
		}
	}

	@Environment(EnvType.CLIENT)
	public record Unbaked(String component_type) implements ItemModel.Unbaked {

		public static final MapCodec<ModularBladeComponentItemSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
						instance.group(
										Codec.STRING.fieldOf("component_type").forGetter(ModularBladeComponentItemSpecialRenderer.Unbaked::component_type)
								)
								.apply(instance, ModularBladeComponentItemSpecialRenderer.Unbaked::new)
		);

		@Override
		public MapCodec<ModularBladeComponentItemSpecialRenderer.Unbaked> type() {
			return MAP_CODEC;
		}

		@Override
		public ItemModel bake(ItemModel.BakingContext bakingContext) {
			return new ModularBladeComponentItemSpecialRenderer(this.component_type);
		}

		@Override
		public void resolveDependencies(ResolvableModel.Resolver resolver) {
		}
	}
}
