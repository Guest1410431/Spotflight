package window;

import java.nio.DoubleBuffer;

import org.joml.Vector3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window
{
	private int width;
	private int height;
	
	private String title;
	
	private double fps;
	private double time;
	private double processedTime;
	
	private long window;
	
	private Vector3f backgroundColor;
	
	private boolean[]keys = new boolean[GLFW.GLFW_KEY_LAST];
	private boolean[]mouseButtons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
	
	public Window(int width, int height, int fps, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		this.fps = fps;
		
		backgroundColor = new Vector3f(0.0f, 0.0f, 0.0f);
	}
	
	public void create()
	{
		if(!GLFW.glfwInit())
		{
			System.err.println("Error: Couldn't instantiate GLFW");
			System.exit(-1);
		}
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		
		if(window == 0)
		{
			System.err.println("Error: Window failed to create");
			System.exit(-1);
		}
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, (videoMode.width()-width)/2, (videoMode.height()-height)/2);
		
		GLFW.glfwShowWindow(window);
	}
	public boolean closed()
	{
		return GLFW.glfwWindowShouldClose(window);
	}
	public void update()
	{
		for(int i=0; i<GLFW.GLFW_KEY_LAST; i++)
		{
			keys[i] = isKeyPressed(i);
		}
		for(int i=0; i<GLFW.GLFW_MOUSE_BUTTON_LAST; i++)
		{
			mouseButtons[i] = isMouseDown(i);
		}
		GL11.glClearColor(backgroundColor.x, backgroundColor.y, backgroundColor.z, 1.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		GLFW.glfwPollEvents();
	}
	public boolean isUpdating()
	{
		double nextTime = getTime();
		double passedTime = nextTime - time;
		processedTime += passedTime;
		time = nextTime;
		
		if(processedTime > 1.0/fps)
		{
			processedTime -= 1.0/fps;
			return true;
		}
		return false;
	}
	public void swapBuffers()
	{
		GLFW.glfwSwapBuffers(window);
	}
	public boolean isKeyPressed(int keyCode)
	{
		return GLFW.glfwGetKey(window, keyCode) == 1;
	}
	public boolean isKeyReleased(int keyCode)
	{
		return (!isKeyPressed(keyCode) && keys[keyCode]);
	}
	public boolean isKeyTyped(int keyCode)
	{
		return (isKeyPressed(keyCode) && !keys[keyCode]);
	}
	public boolean isMouseDown(int mouseButton)
	{
		return GLFW.glfwGetMouseButton(window, mouseButton) == 1;
	}
	public boolean isMouseReleased(int mouseButton)
	{
		return (!isMouseDown(mouseButton) && mouseButtons[mouseButton]);
	}
	public boolean isMouseClicked(int mouseButton)
	{
		return (isMouseDown(mouseButton) && !mouseButtons[mouseButton]);
	}
	
	public double getMouseXPos()
	{
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(1);
		GLFW.glfwGetCursorPos(window, buffer, null);
		return buffer.get(0);
	}
	public double getMouseYPos()
	{
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(1);
		GLFW.glfwGetCursorPos(window, null, buffer);
		return buffer.get(0);
	}

	public double getTime()
	{
		return (double)System.nanoTime() / (double)1000000000;
	}
	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public String getTitle()
	{
		return title;
	}

	public long getWindow()
	{
		return window;
	}

	public void setBackgroundColor(Vector3f backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	public void setBackgroundColor(float x, float y, float z)
	{
		setBackgroundColor(new Vector3f(x, y, z));
	}	
	public void close()
	{
		GLFW.glfwTerminate();
	}
}


































