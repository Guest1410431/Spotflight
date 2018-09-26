package entity;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import models.TexturedModel;
import tools.MatrixMath;

public class EntityModel {
	private TexturedModel texturedModel;

	private Vector3f position;
	private Vector3f rotation;
	private Vector3f scale;

	public EntityModel(TexturedModel texturedModel, Vector3f position, Vector3f angle, Vector3f scale) {
		this.texturedModel = texturedModel;
		this.position = position;
		this.rotation = angle;
		this.scale = scale;
	}

	public Matrix4f getTransformationMatrix()
	{
		return MatrixMath.createTransformationMatrix(position, rotation, scale);
	}
	
	public TexturedModel getTexturedModel() {
		return texturedModel;
	}

	public void setTexturedModel(TexturedModel texturedModel) {
		this.texturedModel = texturedModel;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getAngle() {
		return rotation;
	}

	public void setAngle(Vector3f angle) {
		this.rotation = angle;
	}

	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}
	public void increasePosition(Vector3f increase)
	{
		this.position.add(increase.x, increase.y, increase.z);
	}
	public void increaseRotation(Vector3f increase)
	{
		this.rotation.add(increase.x, increase.y, increase.z);
	}
	public String toString() {
		return "Pos: " + position.toString() + " | Rot: " + rotation.toString(); 
	}
}
