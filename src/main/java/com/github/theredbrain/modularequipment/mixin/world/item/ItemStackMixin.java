package com.github.theredbrain.modularequipment.mixin.world.item;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.util.ModularEquipmentHelper;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements DataComponentHolder {

	@WrapOperation(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;applyDamage(ILnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V"))
	public void modularequipment$hurtAndBreak(ItemStack instance, int i, @Nullable ServerPlayer serverPlayer, Consumer<Item> consumer, Operation<Void> original, @Local(argsOnly = true) ServerLevel serverLevel, @Local(ordinal = 1) int j) {
		if (j > 0 && (this.has(ModularEquipment.MODULAR_BLADE_WEAPON) || this.has(ModularEquipment.MODULAR_SHAFT_WEAPON))) {
			ModularEquipmentHelper.applyItemDamageToWeaponModules(serverLevel, serverPlayer, ((ItemStack) (Object) this), j);
		} else {
			original.call(instance, i, serverPlayer, consumer);
		}
	}

}
