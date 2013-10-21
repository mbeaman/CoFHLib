package cofh.gui.element;

import net.minecraft.util.ResourceLocation;
import cofh.api.energy.IEnergyStorage;
import cofh.gui.GuiBase;
import cofh.gui.GuiBaseAdv;
import cofh.render.RenderHelper;
import cofh.util.MathHelper;

public class ElementEnergyStored extends ElementBase {

	public static final ResourceLocation DEFAULT_TEXTURE = new ResourceLocation(GuiBase.PATH_ELEMENTS + "Energy.png");
	public static final int DEFAULT_SCALE = 42;

	protected IEnergyStorage storage;

	public ElementEnergyStored(GuiBaseAdv gui, int posX, int posY, IEnergyStorage storage) {

		super(gui, posX, posY);
		this.storage = storage;

		this.texture = DEFAULT_TEXTURE;
		this.sizeX = 16;
		this.sizeY = DEFAULT_SCALE;

		this.texW = 32;
		this.texH = 64;
	}

	@Override
	public void draw() {

		if (!visible) {
			return;
		}
		RenderHelper.bindTexture(texture);
		drawTexturedModalRect(posX, posY, 0, 0, sizeX, sizeY);
		int qty = getScaled();
		drawTexturedModalRect(posX, posY + DEFAULT_SCALE - qty, 16, DEFAULT_SCALE - qty, sizeX, qty);
	}

	@Override
	public String getTooltip() {

		return "" + storage.getEnergyStored() + " / " + storage.getMaxEnergyStored() + " RF";
	}

	int getScaled() {

		return MathHelper.round(storage.getEnergyStored() * sizeY / storage.getMaxEnergyStored());
	}

}
