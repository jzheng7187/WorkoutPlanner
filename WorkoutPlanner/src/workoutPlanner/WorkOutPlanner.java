package workoutPlanner;

//import gui.Screen;
import gui.GUIApplication;

public class WorkOutPlanner extends GUIApplication{
	
	public WorkOutPlanner(int width, int height) {
		super(width, height);
	}
	
	public void initScreen() {
		InputDisplay wo = new InputDisplay (getWidth(), getHeight());
		setScreen(wo);
	}

	
	public static void main(String[] args) {
		InputDisplay ID = new InputDisplay(800,500);
		Thread planner = new Thread(ID);
		planner.start();
	}

	
}
