package textures;

import java.io.FileInputStream;
import java.io.IOException;

import org.lwjglx.debug.opengl.GL11;
import org.newdawn.slick.opengl.TextureLoader;

public class Texture
{
	private int textureID;
	
	public Texture(String file)
	{
		textureID = -1;
		
		try
		{
			textureID = TextureLoader.getTexture("png", new FileInputStream("res/textures/" + file)).getTextureID();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void remove()
	{
		GL11.glDeleteTextures(textureID);
	}
	
	public int getTextureID()
	{
		return textureID;
	}
}
