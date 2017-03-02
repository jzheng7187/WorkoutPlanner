package workoutPlanner;

import java.awt.Color;
import java.util.ArrayList;
//import components.ThemedTextLabel;

import components.ThemedBorder;
import components.ThemedBorder2;
import components.ThemedTextLabel;
import gui.components.Graphic;
//import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class InputDisplay extends ClickableScreen implements Runnable{
	private TextLabel title;
	private ThemedTextLabel accentTitle;
	private TextLabel topSub;
	private ThemedTextLabel sub;
	private TextLabel selected;
	private ThemedTextLabel activity;
	private ThemedBorder b1;
	private ThemedBorder2 b2;
	private Graphic p1;
	private Graphic p2;
	private Graphic p3;
	private Graphic p4;
	private Graphic p5;
	private Graphic p6;

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
		//tiles
		title = new TextLabel(60,60,300,40,"Plan");
		viewObjects.add(title); 
		accentTitle = new ThemedTextLabel(100,60,300,40,"Your Routine", new Color(180,225,50));
		viewObjects.add(accentTitle);
		//subtitles
		topSub = new TextLabel(60, 160, 200, 50, "Total");
		viewObjects.add(topSub);
		sub = new ThemedTextLabel(110,160,200,50,"Activities:", new Color(180,225,50));
		viewObjects.add(sub);
		//next tiles
		selected = new TextLabel(60, 200, 200 , 50, "Selected");
		viewObjects.add(selected);
		activity = new ThemedTextLabel(145, 200, 200, 50, "Activity:", new Color(180,225,50));
		viewObjects.add(activity);
		//borders
		b1= new ThemedBorder(Color.black, null);
		viewObjects.add(b1);//horizontal
		b2= new ThemedBorder2(Color.black, null);
		viewObjects.add(b2);//vertical
		//pics
		p1 = new Graphic(400, 150, .75, "resources/treadmill.jpg");
		viewObjects.add(p1);
		p2 = new Graphic(560, 150, .75, "resources/squat.png");
		viewObjects.add(p2);
		p3 = new Graphic(700, 150, .75, "resources/crunch.jpg");
		viewObjects.add(p3);
		p4 = new Graphic(400, 300, .75, "resources/biking.jpeg");
		viewObjects.add(p4);
		p5 = new Graphic(560, 300, .75, "resources/jumprope.png");
		viewObjects.add(p5);
		p6 = new Graphic(660, 300, .75, "resources/pushup.jpg");
		viewObjects.add(p6);
	}

}
