package workoutPlanner;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//import components.ThemedTextLabel;

import components.ThemedBorder;
import components.ThemedBorder2;
import components.ThemedTextLabel;
import gui.components.Action;
import gui.components.ClickableGraphic;
import gui.components.Graphic;
//import gui.Screen;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import timer.Timer;

public class InputDisplay extends ClickableScreen implements Runnable{
	public static final int indexColumn = 60;
	public static final int activityColumn = 140;
	public static final int statusColumn = 340;
	public static final int headerY = 250;
	private int currentRow ;
	public static final int rowHeight = 50;
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
		title.setSize(40);
		accentTitle = new ThemedTextLabel(150,60,300,40,"Your Routine", new Color(180,225,50));
		viewObjects.add(accentTitle);
		accentTitle.setSize(40);
		//subtitles
		topSub = new TextLabel(60, 160, 200, 50, "Total");
		viewObjects.add(topSub);
		sub = new ThemedTextLabel(110,160,200,50,"Activities:", new Color(180,225,50));
		viewObjects.add(sub);
		//next tiles
		selected = new TextLabel(60, 180, 200 , 50, "Selected");
		viewObjects.add(selected);
		activity = new ThemedTextLabel(145, 180, 200, 50, "Activity:", new Color(180,225,50));
		viewObjects.add(activity);
		//borders
		b1= new ThemedBorder(Color.black, null);
		viewObjects.add(b1);//horizontal
		b2= new ThemedBorder2(Color.black, null);
		viewObjects.add(b2);//vertical
		//pics
		p1 = new ClickableGraphic(400, 150, .75, "resources/treadmill.jpg",new Action(){
			@Override
			public void act() {
				NewExercise.clickTreadmill();
			}
		});
		viewObjects.add(p1);
		p2 = new ClickableGraphic(560, 150, .75, "resources/squat.png",new Action(){
			@Override
			public void act() {
				NewExercise.clickSquats();
			}
		});
		viewObjects.add(p2);
		p3 = new ClickableGraphic(700, 150, .75, "resources/crunch.jpg",new Action(){
			@Override
			public void act() {
				NewExercise.clickCrunches();
			}
		});
		viewObjects.add(p3);
		p4 = new ClickableGraphic(400, 300, .75, "resources/biking.jpeg",new Action(){
			@Override
			public void act() {
				NewExercise.clickCycling();
			}
		});
		viewObjects.add(p4);
		p5 = new ClickableGraphic(560, 300, .75, "resources/jumprope.png",new Action(){
			@Override
			public void act() {
				NewExercise.clickPushup();
			}
		});
		viewObjects.add(p5);
		p6 = new ClickableGraphic(660, 300, .75, "resources/pushup.jpg",new Action(){
			@Override
			public void act() {
				NewExercise.clickJumprope();
			}
		});
		viewObjects.add(p6);
//		for(int i=0; i<viewObjects.size(); i++){
//			if(viewObjects.get(i) instanceof TextLabel){
//				TextLabel t = (TextLabel)viewObjects.get(i);
//				t.setSize(25);
//			}
//		}
		ThemedTextLabel num = new ThemedTextLabel(indexColumn, headerY, 200, 50, "#", Color.black);
		viewObjects.add(num);
		ThemedTextLabel act = new ThemedTextLabel(activityColumn, headerY, 200, 50, "Activity", new Color(180,225,50));
		viewObjects.add(act);
		ThemedTextLabel status = new ThemedTextLabel(statusColumn, headerY, 200, 50, "Status", new Color(180,225,50));
		viewObjects.add(status);
		currentRow = 1;
	
	} 
	public void addActivity(String theExerciseName, String stat){
		ThemedTextLabel num = new ThemedTextLabel(indexColumn, headerY+rowHeight*currentRow, 200, 50, currentRow+"", Color.black);
		viewObjects.add(num);
		ThemedTextLabel act = new ThemedTextLabel(activityColumn, headerY+rowHeight*currentRow, 200, 50, theExerciseName, new Color(180,225,50));
		viewObjects.add(act);
		if (stat != null){
			ThemedTextLabel status = new ThemedTextLabel(statusColumn, headerY+rowHeight*currentRow, 200, 50, stat, new Color(180,225,50));
			viewObjects.add(status);
		}
		currentRow++;
	}
	
//	public void mouseClicked(MouseEvent e){
//		addActivity("another item","done");
//	}

}
