package com.github.theredbrain.modularequipment.mixin.world.item;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.type.ModularShaftWeaponDataComponent;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements DataComponentHolder {

	@Shadow
	@Nullable
	public abstract <T> T set(DataComponentType<T> dataComponentType, @Nullable T object);

	@Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;applyDamage(ILnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V"))
	public void modularequipment$hurtAndBreak(int i, ServerLevel serverLevel, @Nullable ServerPlayer serverPlayer, Consumer<Item> consumer, CallbackInfo ci, @Local(ordinal = 1) int j) {
		ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = this.get(ModularEquipment.MODULAR_BLADE_WEAPON);
		ModularShaftWeaponDataComponent modularShaftWeaponDataComponent = this.get(ModularEquipment.MODULAR_SHAFT_WEAPON);
		if (modularBladeWeaponDataComponent != null) {
			ItemStack blade_module = modularBladeWeaponDataComponent.modules().blade_component().copy();
			ItemStack cross_guard_component = modularBladeWeaponDataComponent.modules().cross_guard_component().copy();
			ItemStack pommel_component = modularBladeWeaponDataComponent.modules().pommel_component().copy();

			int firstThreshold = blade_module.getMaxDamage();
			int secondThreshold = cross_guard_component.getMaxDamage();
			int thirdThreshold = pommel_component.getMaxDamage();
			int appliedDamage = 0;
			while (j > 0) {
				int completeRange = firstThreshold + secondThreshold + thirdThreshold;
				if (completeRange < 1) {
					break;
				}
				int k = serverLevel.random.nextInt(completeRange);
				if (k < firstThreshold) {
					appliedDamage = Math.min(j, firstThreshold - blade_module.getDamageValue() - 1);
					blade_module.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, consumer);
					j -= appliedDamage;
					if (j > 0) {
						firstThreshold = 0;
					}
				} else if (k < firstThreshold + secondThreshold) {
					appliedDamage = Math.min(j, secondThreshold - cross_guard_component.getDamageValue() - 1);
					cross_guard_component.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, consumer);
					j -= appliedDamage;
					if (j > 0) {
						secondThreshold = 0;
					}
				} else if (k < firstThreshold + secondThreshold + thirdThreshold) {
					appliedDamage = Math.min(j, thirdThreshold - pommel_component.getDamageValue() - 1);
					pommel_component.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, consumer);
					j -= appliedDamage;
					if (j > 0) {
						thirdThreshold = 0;
					}
				}
			}
			ModularBladeWeaponDataComponent newModularBladeWeaponDataComponent = new ModularBladeWeaponDataComponent.Builder(modularBladeWeaponDataComponent).withBladeModules(
					new ModularBladeWeaponDataComponent.Modules(
							blade_module,
							cross_guard_component,
							pommel_component
					)
			).build();
			boolean isModularWeaponUsable = newModularBladeWeaponDataComponent.isUsable();
			this.set(ModularEquipment.MODULAR_BLADE_WEAPON, newModularBladeWeaponDataComponent);
//			this.set(RPGInventory.IS_USABLE, isModularWeaponUsable);
		} else if (modularShaftWeaponDataComponent != null) {
			ItemStack head_module = modularShaftWeaponDataComponent.modules().head_component().copy();
			ItemStack pommel_component = modularShaftWeaponDataComponent.modules().pommel_component().copy();

			int firstThreshold = head_module.getMaxDamage();
			int secondThreshold = pommel_component.getMaxDamage();
			int appliedDamage = 0;
			while (j > 0) {
				int completeRange = firstThreshold + secondThreshold;
				if (completeRange < 1) {
					break;
				}
				int k = serverLevel.random.nextInt(completeRange);
				if (k < firstThreshold) {
					appliedDamage = Math.min(j, firstThreshold - head_module.getDamageValue() - 1);
					head_module.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, consumer);
					j -= appliedDamage;
					if (j > 0) {
						firstThreshold = 0;
					}
				} else if (k < firstThreshold + secondThreshold) {
					appliedDamage = Math.min(j, secondThreshold - pommel_component.getDamageValue() - 1);
					pommel_component.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, consumer);
					j -= appliedDamage;
					if (j > 0) {
						secondThreshold = 0;
					}
				}
			}
			ModularShaftWeaponDataComponent newModularShaftWeaponDataComponent = new ModularShaftWeaponDataComponent.Builder(modularShaftWeaponDataComponent).withModules(
					new ModularShaftWeaponDataComponent.Modules(
							head_module,
							pommel_component
					)
			).build();
			boolean isModularWeaponUsable = newModularShaftWeaponDataComponent.isUsable();
			this.set(ModularEquipment.MODULAR_SHAFT_WEAPON, newModularShaftWeaponDataComponent);
//			this.set(RPGInventory.IS_USABLE, isModularWeaponUsable);
		}
	}

}
