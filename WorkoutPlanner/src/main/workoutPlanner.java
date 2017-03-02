/**
 * 
 */
package main;

import gui.GUIApplication;
import gui.Screen;
<<<<<<< HEAD
import gui.screens.CoordinateScreen;
=======
import mainMenu.Menu;
import timer.TimerApplication;
import timer.TimerStarter;
>>>>>>> refs/heads/develop

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
	public static TimerApplication timerScreen;
	public static Screen exerciseScreen;
	public static Screen stopwatchScreen;
	public static Screen ws;
	
	public workoutPlanner(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gui.GUIApplication#initScreen()
	 */
	@Override
	public void initScreen() {
<<<<<<< HEAD
		workoutPlanner cs = new workoutPlanner(getWidth(), getHeight());
		setScreen(cs);
=======
		timerScreen = new TimerApplication(getWidth(), getHeight());
		ws = new Menu(getWidth(),getHeight());
		setScreen(ws);
>>>>>>> refs/heads/develop
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
