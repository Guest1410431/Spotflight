package main;

import org.lwjgl.glfw.GLFW;

import models.RawModel;
import render.MasterRenderer;
import window.Window;

public class Main
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int FPS = 60;
	private static Window window = new Window(WIDTH, HEIGHT, FPS, "Spotflight");
	
	private static MasterRenderer renderer = new MasterRenderer();
	
	public static void main(String[] args)
	{
		window.create();
		window.setBackgroundColor((float)Math.random(), (float)Math.random(), (float)Math.random());
		
		RawModel model = new RawModel(new float[] {
			   -0.5f, 0.5f, 0.0f, 	//0
				0.5f, 0.5f, 0.0f, 	//1
			   -0.5f, -0.5f, 0.0f,	//2
				0.5f, -0.5f, 0.0f 	//3
				},new int[] {
						0, 1, 2,
						2, 3, 0
				});
		model.create();
		
		while(!window.closed())
		{
			if(window.isUpdating())
			{
				window.update();
				renderer.renderModel(model);
				
				if(window.isKeyPressed(GLFW.GLFW_KEY_ESCAPE))
				{
					break;
				}
				window.swapBuffers();
			}
		}
		model.remove();
		window.close();
	}
}



































