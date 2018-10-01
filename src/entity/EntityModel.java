package entity;

import models.TexturedModel;
import tools.Matrix4f;
import tools.TransformationMatrix;
import tools.Vector3f;

public class EntityModel
{
	private TexturedModel texturedModel;

	TransformationMatrix transformationMatrix;

	public EntityModel(TexturedModel texturedModel, Vector3f position, Vector3f rotation, Vector3f scale)
	{
		this.texturedModel = texturedModel;
		transformationMatrix = new TransformationMatrix(position, rotation, scale);
	}

	public Matrix4f getTransformationMatrix()
	{
		return transformationMatrix.getTransformation();
	}

	public TexturedModel getTexturedModel()
	{
		return texturedModel;
	}

	public void setTexturedModel(TexturedModel texturedModel)
	{
		this.texturedModel = texturedModel;
	}

	public void addPosition(float x, float y, float z)
	{
		transformationMatrix.setTranslation(transformationMatrix.getTranslation().add(new Vector3f(x, y, z)));
	}

	public void addRotation(float x, float y, float z)
	{
		transformationMatrix.setRotation(transformationMatrix.getRotation().add(new Vector3f(x, y, z)));
	}

	public void addScale(float x, float y, float z)
	{
		transformationMatrix.setScale(transformationMatrix.getScale().add(new Vector3f(x, y, z)));
	}

	public TexturedModel getModel()
	{
		return texturedModel;
	}

	public void setModel(TexturedModel texturedModel)
	{
		this.texturedModel = texturedModel;
	}

	public Vector3f getRotation()
	{
		return transformationMatrix.getRotation();
	}

	public void setRotation(Vector3f vector)
	{
		transformationMatrix.setRotation(vector);
	}

	public Vector3f getPosition()
	{
		return transformationMatrix.getTranslation();
	}

	public void setPosition(Vector3f vector)
	{
		transformationMatrix.setTranslation(vector);
	}

	public Vector3f getScale()
	{
		return transformationMatrix.getScale();
	}

	public void setScale(Vector3f vector)
	{
		transformationMatrix.setScale(vector);
	}

	public String toString()
	{
		return transformationMatrix.toString();
	}
}
