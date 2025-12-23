package com.github.theredbrain.modularequipment.util;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.type.ModularShaftWeaponDataComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

public class ModularEquipmentHelper {

	public static void applyItemDamageToWeaponModules(ServerLevel serverLevel, @Nullable ServerPlayer serverPlayer, ItemStack itemStack, int damageAmount) {

		ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = itemStack.get(ModularEquipment.MODULAR_BLADE_WEAPON);
		ModularShaftWeaponDataComponent modularShaftWeaponDataComponent = itemStack.get(ModularEquipment.MODULAR_SHAFT_WEAPON);
		if (modularBladeWeaponDataComponent != null) {
			ItemStack blade_module = modularBladeWeaponDataComponent.modules().blade_component().copy();
			ItemStack cross_guard_component = modularBladeWeaponDataComponent.modules().cross_guard_component().copy();
			ItemStack pommel_component = modularBladeWeaponDataComponent.modules().pommel_component().copy();

			int firstThreshold = blade_module.getMaxDamage();
			int secondThreshold = cross_guard_component.getMaxDamage();
			int thirdThreshold = pommel_component.getMaxDamage();
			int appliedDamage = 0;
			while (damageAmount > 0) {
				int completeRange = firstThreshold + secondThreshold + thirdThreshold;
				if (completeRange < 1) {
					break;
				}
				int k = serverLevel.random.nextInt(completeRange);
				if (k < firstThreshold) {
					appliedDamage = Math.min(damageAmount, firstThreshold - blade_module.getDamageValue() - 1);
					blade_module.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, item -> {
					});
					damageAmount -= appliedDamage;
					if (damageAmount > 0) {
						firstThreshold = 0;
					}
				} else if (k < firstThreshold + secondThreshold) {
					appliedDamage = Math.min(damageAmount, secondThreshold - cross_guard_component.getDamageValue() - 1);
					cross_guard_component.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, item -> {
					});
					damageAmount -= appliedDamage;
					if (damageAmount > 0) {
						secondThreshold = 0;
					}
				} else if (k < firstThreshold + secondThreshold + thirdThreshold) {
					appliedDamage = Math.min(damageAmount, thirdThreshold - pommel_component.getDamageValue() - 1);
					pommel_component.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, item -> {
					});
					damageAmount -= appliedDamage;
					if (damageAmount > 0) {
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
			itemStack.set(ModularEquipment.MODULAR_BLADE_WEAPON, newModularBladeWeaponDataComponent);
			// TODO applyModuleDependentComponents()
		} else if (modularShaftWeaponDataComponent != null) {
			ItemStack head_module = modularShaftWeaponDataComponent.modules().head_component().copy();
			ItemStack pommel_component = modularShaftWeaponDataComponent.modules().pommel_component().copy();

			int firstThreshold = head_module.getMaxDamage();
			int secondThreshold = pommel_component.getMaxDamage();
			int appliedDamage = 0;
			while (damageAmount > 0) {
				int completeRange = firstThreshold + secondThreshold;
				if (completeRange < 1) {
					break;
				}
				int k = serverLevel.random.nextInt(completeRange);
				if (k < firstThreshold) {
					appliedDamage = Math.min(damageAmount, firstThreshold - head_module.getDamageValue() - 1);
					head_module.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, item -> {
					});
					damageAmount -= appliedDamage;
					if (damageAmount > 0) {
						firstThreshold = 0;
					}
				} else if (k < firstThreshold + secondThreshold) {
					appliedDamage = Math.min(damageAmount, secondThreshold - pommel_component.getDamageValue() - 1);
					pommel_component.hurtAndBreak(appliedDamage, serverLevel, serverPlayer, item -> {
					});
					damageAmount -= appliedDamage;
					if (damageAmount > 0) {
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
			itemStack.set(ModularEquipment.MODULAR_SHAFT_WEAPON, newModularShaftWeaponDataComponent);
			// TODO applyModuleDependentComponents()
		}
	}
}
