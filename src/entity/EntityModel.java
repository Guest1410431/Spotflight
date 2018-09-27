package entity;

import models.TexturedModel;
import tools.Matrix4f;
import tools.MatrixMath;
import tools.Vector3f;

public class EntityModel
{
	private TexturedModel texturedModel;

	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;

	public EntityModel(TexturedModel texturedModel, Vector3f position, Vector3f rotation, Vector3f scale)
	{
		this.texturedModel = texturedModel;
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}

	public Matrix4f getTransformationMatrix()
	{
		return MatrixMath.createTransformationMatrix(position, rotation, scale);
	}

	public TexturedModel getTexturedModel()
	{
		return texturedModel;
	}

	public void setTexturedModel(TexturedModel texturedModel)
	{
		this.texturedModel = texturedModel;
	}

	public Vector3f getPosition()
	{
		return position;
	}

	public void setPosition(Vector3f position)
	{
		this.position = position;
	}

	public Vector3f getRotation()
	{
		return rotation;
	}

	public void setRotation(Vector3f rotation)
	{
		this.rotation = rotation;
	}

	public Vector3f getScale()
	{
		return scale;
	}

	public void setScale(Vector3f scale)
	{
		this.scale = scale;
	}

	public void increasePosition(Vector3f increase)
	{
		this.position.setX(this.position.getX() + increase.getX());
		this.position.setY(this.position.getY() + increase.getY());
		this.position.setZ(this.position.getZ() + increase.getZ());
	}

	public void increaseRotation(Vector3f increase)
	{
		this.rotation.setX(this.rotation.getX() + increase.getX());
		this.rotation.setY(this.rotation.getY() + increase.getY());
		this.rotation.setZ(this.rotation.getZ() + increase.getZ());
	}
	
	public void increaseScale(Vector3f increase)
	{
		this.scale.setX(this.scale.getX() + increase.getX());
		this.scale.setY(this.scale.getY() + increase.getY());
		this.scale.setZ(this.scale.getZ() + increase.getZ());
	}

	public String toString()
	{
		return "Pos: " + position.toString() + " | Rot: " + rotation.toString();
	}
}
