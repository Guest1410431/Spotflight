package shaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public abstract class ShaderProgram
{
	private int vertexShaderID;
	private int fragmentShaderID;
	private int programID;
	
	private String fragmentShaderPath;
	private String vertexShaderPath;
	
	public ShaderProgram(String fragmentShaderPath, String vertexShaderPath)
	{
		this.fragmentShaderPath = fragmentShaderPath;
		this.vertexShaderPath = vertexShaderPath;
	}	
	
	public abstract void bindAllAttributes();
	
	public void create()
	{
		programID = GL20.glCreateProgram();
		
		vertexShaderID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		GL20.glShaderSource(vertexShaderID, readFile(vertexShaderPath));
		GL20.glCompileShader(vertexShaderID);
		
		if(GL20.glGetShaderi(vertexShaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE)
		{
			System.err.println("Error: Vertex Shader - " + GL20.glGetShaderInfoLog(vertexShaderID));
		}
		fragmentShaderID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
		GL20.glShaderSource(fragmentShaderID, readFile(fragmentShaderPath));
		GL20.glCompileShader(fragmentShaderID);
		
		if(GL20.glGetShaderi(fragmentShaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE)
		{
			System.err.println("Error: Fragment Shader - " + GL20.glGetShaderInfoLog(fragmentShaderID));
		}
		GL20.glAttachShader(programID, vertexShaderID);
		GL20.glAttachShader(programID, fragmentShaderID);
		
		GL20.glLinkProgram(programID);
		
		if(GL20.glGetProgrami(programID, GL20.GL_LINK_STATUS) == GL11.GL_FALSE)
		{
			System.err.println("Error: Program Linking - " + GL20.glGetShaderInfoLog(programID));
		}
		GL20.glValidateProgram(programID);
		
		if(GL20.glGetProgrami(programID, GL20.GL_VALIDATE_STATUS) == GL11.GL_FALSE)
		{
			System.err.println("Error: Program Validation - " + GL20.glGetShaderInfoLog(programID));
		}
	}
	public void bindAttribute(int index, String location)
	{
		GL20.glBindAttribLocation(programID, index, location);
	}
	public void bind()
	{
		GL20.glUseProgram(programID);
	}
	public void remove()
	{
		GL20.glDetachShader(programID, vertexShaderID);
		GL20.glDetachShader(programID, fragmentShaderID);
		GL20.glDeleteShader(vertexShaderID);
		GL20.glDeleteShader(fragmentShaderID);
		GL20.glDeleteProgram(programID);
	}
	private String readFile(String file)
	{
		BufferedReader reader = null;
		String builder = "";
		
		try
		{
			reader = new BufferedReader(new FileReader(file));
			String line;
			
			while((line = reader.readLine()) != null)
			{
				builder += line + "\n";
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return builder;
	}
}

















