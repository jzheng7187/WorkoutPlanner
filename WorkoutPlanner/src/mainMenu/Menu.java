package mainMenu;

import java.awt.Color;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import interfaces.Timer;
import main.workoutPlanner;

public class Menu extends ClickableScreen {
	private Timer timerInt;
	private Button timer;
	private Button exercises;
	private Button stop;
	private TextLabel label;
	public static final int MARGINX=500;
	public static final int MARGINY=100;
	public static final int WIDTH=100;
	public static final int HEIGHT=60;
	public static final int SPACE=80;
	public static final Color BUTTON_COLOR=  new Color(0,0,0);

	public Menu(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	
	
	public void initAllObjects(ArrayList<Visible> view) {
		// TODO Auto-generated method stub
		label = new TextLabel(50,50,100,50,"Workout");
		timer = new Button(MARGINX, MARGINY, WIDTH, HEIGHT, "Timer",BUTTON_COLOR , new Action(){
			
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.timerScreen);
			}
		});
		view.add(timer);
		exercises = new Button(MARGINX, MARGINY+20, WIDTH, HEIGHT, "Exercises",BUTTON_COLOR , new Action(){
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.exerciseScreen);
			}
		});
		}
	}



