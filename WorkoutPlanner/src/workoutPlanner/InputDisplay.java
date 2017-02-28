package workoutPlanner;

import java.util.ArrayList;

//import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class InputDisplay extends ClickableScreen implements Runnable{
	private TextLabel title;
	private TextLabel sub;

public InputDisplay(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		title = new TextLabel(100,100,300,40,"Plan Your Routine");
		viewObjects.add(title); 
		sub = new TextLabel(300,300,400,60,"Activities");
		viewObjects.add(sub);
	}

}
