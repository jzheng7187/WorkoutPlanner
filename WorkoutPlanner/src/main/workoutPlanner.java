/**
 * 
 */
package main;

import gui.GUIApplication;
import gui.Screen;

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
	public static Screen timerScreen;
	public static Screen exerciseScreen;
	
	public workoutPlanner(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gui.GUIApplication#initScreen()
	 */
	@Override
	public void initScreen() {
		// TODO Auto-generated method stub

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
