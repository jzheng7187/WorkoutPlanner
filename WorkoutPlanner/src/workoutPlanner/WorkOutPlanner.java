package workoutPlanner;

import java.util.ArrayList;

import gui.Screen;
import gui.components.Visible;

public class WorkOutPlanner extends Screen{
	

	public WorkOutPlanner(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void initScreen() {
		InputDisplay ssa = new InputDisplay (getWidth(), getHeight());
		//setScreen(ssa);
	}


	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		//title.setText("Plan Your Routine");
		
	}
	
	
}
