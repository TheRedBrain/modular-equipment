package com.github.theredbrain.modularequipment.world.inventory;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.component.type.ModularBladeWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.type.ModularShaftWeaponDataComponent;
import com.github.theredbrain.modularequipment.component.type.ModularWeaponModuleDataComponent;
import com.github.theredbrain.modularequipment.registry.MenuTypeRegistry;
import com.github.theredbrain.slotcustomizationapi.api.SlotCustomization;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Weapon;

import java.util.ArrayList;
import java.util.List;

public class ModularEquipmentForgeMenu extends AbstractContainerMenu {

	static final Identifier EMPTY_SLOT_BLADE_COMPONENT = ModularEquipment.identifier("container/slot/blade_component");
	static final Identifier EMPTY_SLOT_CROSS_GUARD_COMPONENT = ModularEquipment.identifier("container/slot/cross_guard_component");
	static final Identifier EMPTY_SLOT_HEAD_COMPONENT = ModularEquipment.identifier("container/slot/head_component");
	static final Identifier EMPTY_SLOT_POMMEL_COMPONENT = ModularEquipment.identifier("container/slot/pommel_component");

	private final ContainerLevelAccess access;
	private final Container inputContainer;
	private final Container componentsContainer;
	private final Container resultContainer;

	public ModularEquipmentForgeMenu(int i, Inventory inventory) {
		this(i, inventory, ContainerLevelAccess.NULL);
	}

	public ModularEquipmentForgeMenu(int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
		super(MenuTypeRegistry.MODULAR_EQUIPMENT_FORGE_MENU, i);
		this.access = containerLevelAccess;
		this.inputContainer = createContainer(1);
		this.componentsContainer = createContainer(4);
		this.resultContainer = createContainer(1);

		this.addStandardInventorySlots(inventory, 8, 84);

		// input slot
		this.addSlot(new Slot(this.inputContainer, 0, 80, 17) {

			@Override
			public boolean mayPlace(ItemStack itemStack) {
				return itemStack.has(ModularEquipment.MODULAR_BLADE_WEAPON);
			}

			@Override
			public boolean mayPickup(Player player) {
				return false;
			}
		});

		// blades slot
		this.addSlot(new ComponentSlot(this.componentsContainer, 0, 134, 53, EMPTY_SLOT_BLADE_COMPONENT, List.of(Component.translatable("slot.tooltip.blade_weapon_blade"))) {

			@Override
			public boolean mayPlace(ItemStack itemStack) {
				ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = ModularEquipmentForgeMenu.this.getSlot(36).getItem().get(ModularEquipment.MODULAR_BLADE_WEAPON);

				if (modularBladeWeaponDataComponent != null && modularBladeWeaponDataComponent.blade_items() != null) {
					return itemStack.is(modularBladeWeaponDataComponent.blade_items());
				}
				return false;
			}

		});

		// cross guard slot
		this.addSlot(new ComponentSlot(this.componentsContainer, 1, 80, 53, EMPTY_SLOT_CROSS_GUARD_COMPONENT, List.of(Component.translatable("slot.tooltip.blade_weapon_cross_guard"))) {

			@Override
			public boolean mayPlace(ItemStack itemStack) {
				ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = ModularEquipmentForgeMenu.this.getSlot(36).getItem().get(ModularEquipment.MODULAR_BLADE_WEAPON);

				if (modularBladeWeaponDataComponent != null && modularBladeWeaponDataComponent.cross_guard_items() != null) {
					return itemStack.is(modularBladeWeaponDataComponent.cross_guard_items());
				}
				return false;
			}

		});

		// head slot
		this.addSlot(new ComponentSlot(this.componentsContainer, 2, 26, 53, EMPTY_SLOT_HEAD_COMPONENT, List.of(Component.translatable("slot.tooltip.shaft_weapon_head"))) {

			@Override
			public boolean mayPlace(ItemStack itemStack) {
				ModularShaftWeaponDataComponent modularShaftWeaponDataComponent = ModularEquipmentForgeMenu.this.getSlot(36).getItem().get(ModularEquipment.MODULAR_SHAFT_WEAPON);

				if (modularShaftWeaponDataComponent != null && modularShaftWeaponDataComponent.head_items() != null) {
					return itemStack.is(modularShaftWeaponDataComponent.head_items());
				}
				return false;
			}

		});

		// pommel slot
		this.addSlot(new ComponentSlot(this.componentsContainer, 3, 26, 53, EMPTY_SLOT_POMMEL_COMPONENT, List.of(Component.translatable("slot.tooltip.weapon_pommel"))) {

			@Override
			public boolean mayPlace(ItemStack itemStack) {
				ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = ModularEquipmentForgeMenu.this.getSlot(36).getItem().get(ModularEquipment.MODULAR_BLADE_WEAPON);
				ModularShaftWeaponDataComponent modularShaftWeaponDataComponent = ModularEquipmentForgeMenu.this.getSlot(36).getItem().get(ModularEquipment.MODULAR_SHAFT_WEAPON);

				if (modularBladeWeaponDataComponent != null && modularBladeWeaponDataComponent.pommel_items() != null) {
					return itemStack.is(modularBladeWeaponDataComponent.pommel_items());
				} else if (modularShaftWeaponDataComponent != null && modularShaftWeaponDataComponent.pommel_items() != null) {
					return itemStack.is(modularShaftWeaponDataComponent.pommel_items());
				}
				return false;
			}

		});

		// result slot
		this.addSlot(new Slot(this.resultContainer, 0, 80, 17) {

			@Override
			public boolean mayPlace(ItemStack itemStack) {
				return false;
			}

		});

		((SlotCustomization) this.slots.get(37)).slotcustomizationapi$setDisabledOverride(true);
		((SlotCustomization) this.slots.get(38)).slotcustomizationapi$setDisabledOverride(true);
		((SlotCustomization) this.slots.get(39)).slotcustomizationapi$setDisabledOverride(true);
		((SlotCustomization) this.slots.get(40)).slotcustomizationapi$setDisabledOverride(true);
		((SlotCustomization) this.slots.get(41)).slotcustomizationapi$setDisabledOverride(true);

	}

	private SimpleContainer createContainer(int i) {
		return new SimpleContainer(i) {
			@Override
			public void setChanged() {
				super.setChanged();
				ModularEquipmentForgeMenu.this.slotsChanged(this);
			}
		};
	}

	@Override
	public void removed(Player player) {
		super.removed(player);
		this.access.execute((level, blockPos) -> this.clearContainer(player, this.resultContainer));
	}

	@Override
	public void slotsChanged(Container container) {
		super.slotsChanged(container);
		if (container == this.inputContainer) {
			this.populateComponentSlots();
		} else if (container == this.componentsContainer) {
			this.createResult();
		} else if (container == this.resultContainer) {
			this.clearInputAndComponentSlots();
		}
	}

	private void populateComponentSlots() {
		ItemStack baseItemStack = this.inputContainer.getItem(0);

		int currentDamage = baseItemStack.getDamageValue();
		ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = baseItemStack.get(ModularEquipment.MODULAR_BLADE_WEAPON);
		ModularShaftWeaponDataComponent modularShaftWeaponDataComponent = baseItemStack.get(ModularEquipment.MODULAR_SHAFT_WEAPON);
		if (modularBladeWeaponDataComponent != null) {
			this.componentsContainer.setItem(0, modularBladeWeaponDataComponent.modules().blade_component().copy());
			this.componentsContainer.setItem(1, modularBladeWeaponDataComponent.modules().cross_guard_component().copy());
			this.componentsContainer.setItem(2, ItemStack.EMPTY);
			this.componentsContainer.setItem(3, modularBladeWeaponDataComponent.modules().pommel_component().copy());

			((SlotCustomization) this.slots.get(40)).slotcustomizationapi$setX(26);

			((SlotCustomization) this.slots.get(37)).slotcustomizationapi$setDisabledOverride(false);
			((SlotCustomization) this.slots.get(38)).slotcustomizationapi$setDisabledOverride(false);
			((SlotCustomization) this.slots.get(39)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(40)).slotcustomizationapi$setDisabledOverride(false);
		} else if (modularShaftWeaponDataComponent != null) {
			this.componentsContainer.setItem(0, ItemStack.EMPTY);
			this.componentsContainer.setItem(1, ItemStack.EMPTY);
			this.componentsContainer.setItem(2, modularShaftWeaponDataComponent.modules().head_component().copy());
			this.componentsContainer.setItem(3, modularShaftWeaponDataComponent.modules().pommel_component().copy());

			((SlotCustomization) this.slots.get(40)).slotcustomizationapi$setX(44);

			((SlotCustomization) this.slots.get(37)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(38)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(39)).slotcustomizationapi$setDisabledOverride(false);
			((SlotCustomization) this.slots.get(40)).slotcustomizationapi$setDisabledOverride(false);
		} else {
			if (!this.componentsContainer.getItem(0).isEmpty()) {
				this.componentsContainer.setItem(0, ItemStack.EMPTY);
			}
			if (!this.componentsContainer.getItem(1).isEmpty()) {
				this.componentsContainer.setItem(1, ItemStack.EMPTY);
			}
			if (!this.componentsContainer.getItem(2).isEmpty()) {
				this.componentsContainer.setItem(2, ItemStack.EMPTY);
			}
			((SlotCustomization) this.slots.get(37)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(38)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(39)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(40)).slotcustomizationapi$setDisabledOverride(true);
		}
	}

	private void createResult() {
		ItemStack resultStack = this.inputContainer.getItem(0).copy();
		ModularBladeWeaponDataComponent modularBladeWeaponDataComponent = resultStack.get(ModularEquipment.MODULAR_BLADE_WEAPON);
		ModularShaftWeaponDataComponent modularShaftWeaponDataComponent = resultStack.get(ModularEquipment.MODULAR_SHAFT_WEAPON);
		if (modularBladeWeaponDataComponent != null) {
			ModularBladeWeaponDataComponent.Builder builder = new ModularBladeWeaponDataComponent.Builder(modularBladeWeaponDataComponent);
			builder.withBladeModules(new ModularBladeWeaponDataComponent.Modules(
					this.componentsContainer.getItem(0).copy(),
					this.componentsContainer.getItem(1).copy(),
					this.componentsContainer.getItem(3).copy()
			));
			resultStack.set(ModularEquipment.MODULAR_BLADE_WEAPON, builder.build());
			resultStack = applyModuleDependentComponents(resultStack, List.of(this.componentsContainer.getItem(3).copy(), this.componentsContainer.getItem(1).copy(), this.componentsContainer.getItem(0).copy()));
		} else if (modularShaftWeaponDataComponent != null) {
			ModularShaftWeaponDataComponent.Builder builder = new ModularShaftWeaponDataComponent.Builder(modularShaftWeaponDataComponent);
			builder.withModules(new ModularShaftWeaponDataComponent.Modules(
					this.componentsContainer.getItem(2).copy(),
					this.componentsContainer.getItem(3).copy()
			));
			resultStack.set(ModularEquipment.MODULAR_SHAFT_WEAPON, builder.build());
			resultStack = applyModuleDependentComponents(resultStack, List.of(this.componentsContainer.getItem(3).copy(), this.componentsContainer.getItem(2).copy()));
		}
		ModularEquipment.info("resultStack: " + resultStack);
		this.resultContainer.setItem(0, resultStack);
		((SlotCustomization) this.slots.get(36)).slotcustomizationapi$setDisabledOverride(true);
		((SlotCustomization) this.slots.get(41)).slotcustomizationapi$setDisabledOverride(false);
	}

	private void clearInputAndComponentSlots() {
		if (this.resultContainer.getItem(0).isEmpty()) {
			if (!this.inputContainer.getItem(0).isEmpty()) {
				this.inputContainer.setItem(0, ItemStack.EMPTY);
			}
			if (!this.componentsContainer.getItem(0).isEmpty()) {
				this.componentsContainer.setItem(0, ItemStack.EMPTY);
			}
			if (!this.componentsContainer.getItem(1).isEmpty()) {
				this.componentsContainer.setItem(1, ItemStack.EMPTY);
			}
			if (!this.componentsContainer.getItem(2).isEmpty()) {
				this.componentsContainer.setItem(2, ItemStack.EMPTY);
			}
			if (!this.componentsContainer.getItem(3).isEmpty()) {
				this.componentsContainer.setItem(3, ItemStack.EMPTY);
			}
			((SlotCustomization) this.slots.get(36)).slotcustomizationapi$setDisabledOverride(false);
			((SlotCustomization) this.slots.get(37)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(38)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(39)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(40)).slotcustomizationapi$setDisabledOverride(true);
			((SlotCustomization) this.slots.get(41)).slotcustomizationapi$setDisabledOverride(true);
		}
	}

	private ItemStack applyModuleDependentComponents(ItemStack resultStack, List<ItemStack> moduleStackList) {
		List<AttributeModifier> attribute_modifier_list = new ArrayList<>();
		List<String> spell_identifier_list = new ArrayList<>();
		String weapon_attribute_identifier = "";
		int max_damage = 0;
		int damage = 0;
		int itemDamagePerAttack = 0;
		float disableBlockingForSeconds = 0.0F;
		for (ItemStack itemStack : moduleStackList) {
			ModularWeaponModuleDataComponent modularWeaponModuleDataComponent = itemStack.get(ModularEquipment.MODULAR_WEAPON_MODULE);
			if (modularWeaponModuleDataComponent != null) {
				if (!modularWeaponModuleDataComponent.weapon_attribute_identifier().isEmpty()) {
					weapon_attribute_identifier = modularWeaponModuleDataComponent.weapon_attribute_identifier();
				}
				if (!modularWeaponModuleDataComponent.spell_identifier_list().isEmpty()) {
					spell_identifier_list.addAll(modularWeaponModuleDataComponent.spell_identifier_list());
				}
				if (!modularWeaponModuleDataComponent.attribute_modifier_list().isEmpty()) {
					attribute_modifier_list.addAll(modularWeaponModuleDataComponent.attribute_modifier_list());
				}
				itemDamagePerAttack += modularWeaponModuleDataComponent.additional_item_damage_per_attack();
				disableBlockingForSeconds += modularWeaponModuleDataComponent.additional_seconds_to_disable_blocking();
			}
			if (itemStack.isDamageableItem()) {
				max_damage += itemStack.getMaxDamage();
				damage += itemStack.getDamageValue();
			}
		}
		// TODO EAMs
		// 	RPG Inventory compat (can item be used, "can_not_be_two_handed", "needs_to_be_two_handed")
		resultStack = ModularEquipment.applySpellContainer(resultStack, spell_identifier_list);
		resultStack = ModularEquipment.applyWeaponAttribute(resultStack, weapon_attribute_identifier);
		resultStack.set(DataComponents.MAX_DAMAGE, Math.max(1, max_damage));
		resultStack.set(DataComponents.WEAPON, new Weapon(itemDamagePerAttack, disableBlockingForSeconds));
		resultStack.setDamageValue(damage);
		return resultStack;
	}

	@Override
	public ItemStack quickMoveStack(Player player, int i) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}

	static class ComponentSlot extends Slot {
		Identifier emptySlotIcon;

		public ComponentSlot(Container container, int i, int x, int y, Identifier emptySlotIcon, List<Component> tooltip) {
			super(container, i, x, y);
			this.emptySlotIcon = emptySlotIcon;
			((SlotCustomization) this).slotcustomizationapi$setSlotTooltipText(tooltip);
		}

		@Override
		public Identifier getNoItemIcon() {
			return this.emptySlotIcon;
		}
	}

}
