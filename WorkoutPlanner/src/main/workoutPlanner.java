/**
 * 
 */
package main;

import gui.GUIApplication;
import gui.Screen;
import mainMenu.Menu;

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
	public static Screen stopwatchScreen;
	
	public workoutPlanner(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gui.GUIApplication#initScreen()
	 */
	@Override
	public void initScreen() {
		Menu ws = new Menu(getWidth(),getHeight());
		setScreen(ws);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		app = new workoutPlanner(800, 800);
		Thread go = new Thread(app);
		go.start();

	}

}
