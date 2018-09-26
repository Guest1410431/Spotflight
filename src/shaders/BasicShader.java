package shaders;

import tools.Matrix4f;

public class BasicShader extends ShaderProgram
{
	private final static String VERTEX_SHADER_FILE = "./res/shaders/vertexShader.vs";
	private final static String FRAGMENT_SHADER_FILE = "./res/shaders/fragmentShader.fs";

	private int tvpMatrixLocation;

	private Matrix4f transformationMatrix = new Matrix4f().identity();

	public BasicShader()
	{
		super(FRAGMENT_SHADER_FILE, VERTEX_SHADER_FILE);
	}

	public void bindAllAttributes()
	{
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textCoords");
	}

	protected void getAllUniforms()
	{
		tvpMatrixLocation = super.getUniform("tvpMatrix");
	}

	public void useMatrices()
	{
		super.loadMatrixUniform(tvpMatrixLocation, transformationMatrix);
	}

	public void loadTransformationMatrix(Matrix4f matrix)
	{
		transformationMatrix = matrix;
	}
}
