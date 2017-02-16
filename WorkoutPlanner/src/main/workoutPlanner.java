/**
 * 
 */
package main;

import gui.GUIApplication;
import gui.Screen;
import gui.screens.CoordinateScreen;

/**
 * @author Jonathan Zheng
 *
 */
public class workoutPlanner extends GUIApplication {

	/**
	 * @param width
	 * @param height
	 */
	
	public static workoutPlanner app;
	
	public workoutPlanner(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gui.GUIApplication#initScreen()
	 */
	@Override
	public void initScreen() {
		workoutPlanner cs = new workoutPlanner(getWidth(), getHeight());
		setScreen(cs);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		app = new workoutPlanner(800, 700);
		Thread go = new Thread(app);
		go.start();

	}

}
