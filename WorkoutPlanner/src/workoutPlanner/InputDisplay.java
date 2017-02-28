package workoutPlanner;

import java.awt.Color;
import java.util.ArrayList;
import components.ThemedTextLabel;

//import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class InputDisplay extends ClickableScreen implements Runnable{
	private TextLabel title;
	private TextLabel sub;
	//public static final Color c = new Color (180,225,50);

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
		ThemedTextLabel(50,10,50,30, "Plan", 10);
		title = new TextLabel(100,100,300,40,"Plan Your Routine");
		viewObjects.add(title); 
		sub = new TextLabel(300,300,400,60,"Activities");
		viewObjects.add(sub);
	}

}
