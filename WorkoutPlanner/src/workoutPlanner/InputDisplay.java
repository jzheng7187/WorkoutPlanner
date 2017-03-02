package workoutPlanner;

import java.awt.Color;
import java.util.ArrayList;
//import components.ThemedTextLabel;

import components.ThemedTextLabel;
import gui.components.Graphic;
//import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class InputDisplay extends ClickableScreen implements Runnable{
	private ThemedTextLabel accentTitle;
	private TextLabel title;
	private TextLabel topSub;
	private ThemedTextLabel sub;
	private Graphic ex;

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
		//ThemedTextLabel(50,10,50,30, "Plan", 10);
		
		accentTitle = new ThemedTextLabel(140,100,300,40,"Your Routine", new Color(180,225,50));
		title = new TextLabel(100,100,300,40,"Plan");
		viewObjects.add(title);
		viewObjects.add(accentTitle); 
		
		topSub = new TextLabel(100, 200, 200, 50, "Total");
		viewObjects.add(topSub);
		
		sub = new ThemedTextLabel(300,300,400,60,"Activities", new Color(180,225,50));
		viewObjects.add(sub);
		//ex = new Graphic(300, 200, .5, "resources/Capture.PNG");
		//viewObjects.add(ex);
	}

}
