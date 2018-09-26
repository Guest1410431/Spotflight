package shaders;

import org.joml.Matrix4f;

public class BasicShader extends ShaderProgram {
	private final static String VERTEX_SHADER_FILE = "./res/shaders/vertexShader.vs";
	private final static String FRAGMENT_SHADER_FILE = "./res/shaders/fragmentShader.fs";

	private int transformationMatrixLocation;

	public BasicShader() {
		super(FRAGMENT_SHADER_FILE, VERTEX_SHADER_FILE);
	}

	public void bindAllAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textCoords");
	}

	protected void getAllUniforms() {
		transformationMatrixLocation = super.getUniform("transformation");
	}
	public void loadTransformationMatrix(Matrix4f matrix)
	{
		super.loadMatrixUniform(transformationMatrixLocation, matrix);
	}
}
