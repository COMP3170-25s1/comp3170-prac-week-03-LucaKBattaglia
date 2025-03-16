//package comp3170.week3;
//
//import static org.lwjgl.opengl.GL11.glViewport;
//import static org.lwjgl.opengl.GL41.*;
//
//import java.io.File;
//import java.io.IOException;
//
//import comp3170.OpenGLException;
//import comp3170.IWindowListener;
//import comp3170.Shader;
//import comp3170.ShaderLibrary;
//import comp3170.Window;
//
//public class Week3 implements IWindowListener {
//
//	private Window window;
//	private Shader shader;
//	
//	final private File DIRECTORY = new File("src/comp3170/week3"); 
//	
//	private int width = 800;
//	private int height = 800;
//	private Scene scene;
//	
//	public Week3() throws OpenGLException  {
//		
//		// create window with title, size, and a listener (this)
//		window = new Window("Week 3 prac", width, height, this);
//		
//		// sets the window as resizable
//		window.setResizable(true);
//		// start running the window
//		window.run();
//	}
//	
//	@Override
//	public void init() {
//		
//		new ShaderLibrary(DIRECTORY);
//		// set the background colour to white
//		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);	
//		
//		// create the scene
//		scene = new Scene();
//		
//	}
//
//
//	@Override
//	public void draw() {
//
//        // clear the colour buffer
//		glClear(GL_COLOR_BUFFER_BIT);	
//		
//		scene.draw();
//	    
//	}
//
//	@Override
//	public void resize(int width, int height) {
//		this.width = width;
//		this.height = height;
//		glViewport(0,0,width,height);
//		
//	}
//	
//	@Override
//	public void close() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public static void main(String[] args) throws IOException, OpenGLException{
//		new Week3();
//	}
//
//	
//	
//}

package comp3170.week3;

import static org.lwjgl.opengl.GL15.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL15.glClear;
import static org.lwjgl.opengl.GL15.glClearColor;
import static org.lwjgl.opengl.GL15.glViewport;

import java.io.File;
import java.io.IOException;

import org.joml.Vector4f;

import comp3170.IWindowListener;
import comp3170.OpenGLException;
import comp3170.ShaderLibrary;
import comp3170.Window;

public class Week3 implements IWindowListener{
	
	private int screenWidth = 800;
	private int screenHeight = 800;
	private Vector4f clearColour = new Vector4f(0.0f, 0.0f, 0.5f, 1.0f);
	
	final private File DIRECTORY = new File("src/comp3170/week3/shaders");
	
	private Scene scene;
	private long oldTime;
	
	public Week3() throws OpenGLException {
		
		// Create a window with a title, a size and a listener (this)
		Window window = new Window("Week 3", screenWidth, screenHeight, this);
		
		// Start running the window
		window.run();
	}

	public static void main(String[] args) throws OpenGLException {
		new Week3();

	}

	@Override
	public void init() {
		new ShaderLibrary(DIRECTORY);
		
		glClearColor(clearColour.x, clearColour.y, clearColour.z, clearColour.w);
		
		scene = new Scene();
		
		oldTime = System.currentTimeMillis();
	}

	@Override
	public void draw() {
		update();
		glClear(GL_COLOR_BUFFER_BIT);
		scene.draw();
	}
	
	public void update() {
		long time = System.currentTimeMillis();
		float deltaTime = (time - oldTime) / 1000f;
		oldTime = time;
		scene.update(deltaTime);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void close() {
		
	}

}
