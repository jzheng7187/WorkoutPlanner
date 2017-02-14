package workoutPlanner;

import java.util.ArrayList;

import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;

public class InputDisplay extends Screen{
	private TextLabel title;

public InputDisplay(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		title = new TextLabel(130,230,300,40,"Plan Your Routine");
		viewObjects.add(title); 
	}

}
