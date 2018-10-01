package main;

import org.lwjgl.glfw.GLFW;

import entity.EntityModel;
import models.TexturedModel;
import render.MasterRenderer;
import shaders.BasicShader;
import tools.Vector3f;
import window.Window;

public class Main
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int FPS = 60;

	private static Window window = new Window(WIDTH, HEIGHT, FPS, "Spotflight");

	private static MasterRenderer renderer;

	private static BasicShader basicShader;

	public static void main(String[] args)
	{
		basicShader = new BasicShader();
		renderer = new MasterRenderer(window, basicShader);

		window.create();
		window.setBackgroundColor((float) Math.random(), (float) Math.random(), (float) Math.random());

		basicShader.create();
		renderer.create();

		TexturedModel model = new TexturedModel(new float[] { 
				-0.5f, 0.5f, 0.0f, // 0
				0.5f, 0.5f, 0.0f, // 1
				0.5f, -0.5f, 0.0f, // 2
				-0.5f, -0.5f, 0.0f // 3
		}, 
				new float[] { 
						0, 0, 
						1, 0, 
						1, 1, 
						0, 1 }, 
				new int[] { 
						0, 1, 2, 
						2, 3, 0 }, 
				"Default_Texture.png");

		EntityModel entity = new EntityModel(model, new Vector3f(0, 0, 1), new Vector3f(0, 0, 0),
				new Vector3f(1, 1, 1));

		while (!window.closed())
		{
			if (window.isUpdating())
			{
				window.update();
			
				entity.addRotation(0, 0.02f, 0);
				
				if (window.isKeyPressed(GLFW.GLFW_KEY_ESCAPE))
				{
					break;
				}
				basicShader.bind();
				basicShader.useMatrices();
				renderer.renderEntityModel(entity);
				basicShader.unbind();
				
				window.swapBuffers();
			}
		}
		model.remove();
		basicShader.remove();
		window.close();
	}
}
