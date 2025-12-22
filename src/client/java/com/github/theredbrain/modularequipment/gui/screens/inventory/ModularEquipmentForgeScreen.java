package com.github.theredbrain.modularequipment.gui.screens.inventory;

import com.github.theredbrain.modularequipment.ModularEquipment;
import com.github.theredbrain.modularequipment.world.inventory.ModularEquipmentForgeMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class ModularEquipmentForgeScreen extends AbstractContainerScreen<ModularEquipmentForgeMenu> {
	private static final Identifier MODULAR_EQUIPMENT_FORGE_BACKGROUND = ModularEquipment.identifier("textures/gui/container/modular_equipment_forge.png");
	private static final Identifier SLOT_TEXTURE = Identifier.withDefaultNamespace("textures/gui/sprites/container/slot.png");

	public ModularEquipmentForgeScreen(ModularEquipmentForgeMenu abstractContainerMenu, Inventory inventory, Component component) {
		super(abstractContainerMenu, inventory, component);
	}

	@Override
	public void render(GuiGraphics guiGraphics, int i, int j, float f) {
		super.render(guiGraphics, i, j, f);
		this.renderTooltip(guiGraphics, i, j);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
		int k = (this.width - this.imageWidth) / 2;
		int l = (this.height - this.imageHeight) / 2;
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, MODULAR_EQUIPMENT_FORGE_BACKGROUND, k, l, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		if (this.menu.slots.get(36).hasItem()) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SLOT_TEXTURE, k + 25, l + 52, 0.0F, 0.0F, 18, 18, 18, 18);
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SLOT_TEXTURE, k + 79, l + 52, 0.0F, 0.0F, 18, 18, 18, 18);
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SLOT_TEXTURE, k + 133, l + 52, 0.0F, 0.0F, 18, 18, 18, 18);
		}
	}
}
