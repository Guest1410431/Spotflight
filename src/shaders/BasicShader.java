package shaders;

public class BasicShader extends ShaderProgram
{
	private final static String VERTEX_SHADER_FILE = "./res/shaders/vertexShader.vs";
	private final static String FRAGMENT_SHADER_FILE = "./res/shaders/fragmentShader.fs";
	
	public BasicShader()
	{
		super(FRAGMENT_SHADER_FILE, VERTEX_SHADER_FILE);
	}

	public void bindAllAttributes()
	{
		
	}
}
