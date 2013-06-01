
package cofh.render;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureStitched;
import net.minecraft.client.texturepacks.ITexturePack;

/**
 * Allows for the creation of non-square textures.
 * 
 * @author King Lemming
 * 
 */
public class TextureCustom extends TextureStitched {

    protected TextureCustom(String name) {

        super(name);
    }

    @Override
    public boolean loadTexture(TextureManager manager, ITexturePack texturepack, String name, String fileName, BufferedImage image, ArrayList textures) {

        Texture texture = manager.makeTexture(name, 2, image.getWidth(), image.getHeight(), 10496, 6408, 9728, 9728, false, image);
        textures.add(texture);
        return true;
    }

}
