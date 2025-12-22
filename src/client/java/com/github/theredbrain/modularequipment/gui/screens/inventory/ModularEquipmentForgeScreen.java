package com.github.theredbrain.modularequipment.gui.screens.inventory;

import com.github.theredbrain.modularequipment.world.inventory.ModularEquipmentForgeMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ModularEquipmentForgeScreen extends AbstractContainerScreen<ModularEquipmentForgeMenu> {
	public ModularEquipmentForgeScreen(ModularEquipmentForgeMenu abstractContainerMenu, Inventory inventory, Component component) {
		super(abstractContainerMenu, inventory, component);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {

	}
}
