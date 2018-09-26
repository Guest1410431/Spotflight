package models;

import org.lwjgl.opengl.GL30;
import org.lwjglx.debug.opengl.GL15;

import textures.Texture;

public class TexturedModel extends Model
{
	private int vertexArrayID;
	private int vertexBufferID;
	private int indicesBufferID;
	private int vertexCount;
	private int textureCoordinateBufferID;
	
	private Texture texture;
	
	public TexturedModel(float[]vertices, float[]textureCoordinates, int[]indices, String texturePath)
	{
		vertexArrayID = super.createVertexArray();
		indicesBufferID = super.bindIndicesBuffer(indices);
		vertexBufferID = super.storeData(0, 3, vertices);
		textureCoordinateBufferID = super.storeData(1, 2, textureCoordinates);
		vertexCount = indices.length;
		GL30.glBindVertexArray(0);
		
		texture = new Texture(texturePath);
	}
	
	public void remove()
	{
		GL30.glDeleteVertexArrays(vertexArrayID);
		GL15.glDeleteBuffers(vertexBufferID);
		GL15.glDeleteBuffers(indicesBufferID);
		GL15.glDeleteBuffers(textureCoordinateBufferID);
		
		texture.remove();
	}

	public int getVertexArrayID()
	{
		return vertexArrayID;
	}
	public int getVertexCount()
	{
		return vertexCount;
	}
	public Texture getTexture()
	{
		return texture;
	}
}
