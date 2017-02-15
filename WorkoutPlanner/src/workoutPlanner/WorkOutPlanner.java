package workoutPlanner;

import java.util.ArrayList;
//import gui.Screen;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import gui.GuiApplication;

public class WorkOutPlanner extends ClickableScreen{
	

	public WorkOutPlanner(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void initScreen() {
		InputDisplay ssa = new InputDisplay (getWidth(), getHeight());
		setScreen(ssa);
	}


	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		//title.setText("Plan Your Routine");
		
	}
	
	public static void main(String[] args) {
		InputDisplay sga = new InputDisplay(800,500);
		Thread game = new Thread(sga);
		game.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}

	
}
