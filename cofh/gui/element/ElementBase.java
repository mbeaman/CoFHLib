
package cofh.gui.element;

import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.gui.FontRenderer;
import cofh.gui.GuiBase;
import cpw.mods.fml.client.FMLClientHandler;

public abstract class ElementBase {

    public static final SoundManager elementSoundManager = FMLClientHandler.instance().getClient().sndManager;
    public static final FontRenderer elementFontRenderer = FMLClientHandler.instance().getClient().fontRenderer;

    protected GuiBase gui;
    protected String texture;

    protected int posX;
    protected int posY;

    protected int sizeX;
    protected int sizeY;

    public int texW = 256;
    public int texH = 256;

    protected boolean visible = true;

    public ElementBase(GuiBase gui, int posX, int posY) {

        this.gui = gui;
        this.posX = gui.guiLeft + posX;
        this.posY = gui.guiTop + posY;
    }

    public ElementBase setTexture(String texture, int texW, int texH) {

        this.texture = texture;
        this.texW = texW;
        this.texH = texH;
        return this;
    }

    public ElementBase setPosition(int posX, int posY) {

        this.posX = gui.guiLeft + posX;
        this.posY = gui.guiTop + posY;
        return this;
    }

    public ElementBase setSize(int sizeX, int sizeY) {

        this.sizeX = sizeX;
        this.sizeY = sizeY;
        return this;
    }

    public ElementBase setVisible(boolean visible) {

        this.visible = visible;
        return this;
    }

    public boolean isVisible() {

        return visible;
    }

    public void update() {

    }

    public abstract void draw();

    public void draw(int x, int y) {

        this.posX = x;
        this.posY = y;
        draw();
    }

    public abstract String getTooltip();

    public boolean intersectsWith(int mouseX, int mouseY) {

        mouseX += gui.guiLeft;
        mouseY += gui.guiTop;

        if (mouseX >= this.posX && mouseX <= this.posX + this.sizeX && mouseY >= this.posY && mouseY <= this.posY + this.sizeY) {
            return true;
        }
        return false;
    }

    public boolean handleMouseClicked(int x, int y, int mouseButton) {

        return false;
    }

    public void drawTexturedModalRect(int x, int y, int u, int v, int width, int height) {

        gui.drawSizedTexturedModalRect(x, y, u, v, width, height, texW, texH);
    }

}
