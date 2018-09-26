package render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import entity.EntityModel;
import models.RawModel;
import models.TexturedModel;
import shaders.BasicShader;

public class MasterRenderer
{
	private BasicShader shader;
	
	public MasterRenderer(BasicShader shader)
	{
		this.shader = shader;
	}
	
	public void renderRawModel(RawModel model)
	{
		GL30.glBindVertexArray(model.getVertexArrayID());
		GL20.glEnableVertexAttribArray(0);
		GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}
	public void renderTexturedModel(TexturedModel model)
	{
		GL30.glBindVertexArray(model.getVertexArrayID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getTextureID());		
		GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);		
		GL30.glBindVertexArray(0);
	}
	public void renderEntityModel(EntityModel entity)
	{
		GL30.glBindVertexArray(entity.getTexturedModel().getVertexArrayID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		
		shader.loadTransformationMatrix(entity.getTransformationMatrix());
		
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, entity.getTexturedModel().getTexture().getTextureID());		
		GL11.glDrawElements(GL11.GL_TRIANGLES, entity.getTexturedModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);		
		GL30.glBindVertexArray(0);
	}
}
