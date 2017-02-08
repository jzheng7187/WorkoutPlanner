package mainMenu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.TextLabel;
import mainMenu.CustomTextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import interfaces.Timer;
import main.workoutPlanner;
public class Menu extends ClickableScreen {
	private Timer timerInt;
	private Button timer;
	private Button exercises;
	private Button stop;
	private CustomTextLabel label;
	private TextLabel label2;
	public static final int MARGINX=500;
	public static final int MARGINY=100;
	public static final int WIDTH=100;
	public static final int HEIGHT=60;
	public static final int SPACE=80;
	public static final Color BUTTON_COLOR=  new Color(255,255,255);

	public Menu(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		// TODO Auto-generated method stub
		label = new CustomTextLabel(50,50,100,50,"Workout");
		label2 = new TextLabel(150,50,100,50,"Planner");
		view.add(label);
		view.add(label2);
		
		timer = new Button(MARGINX, MARGINY, WIDTH, HEIGHT, "Timer",BUTTON_COLOR ,new Action(){
			
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.timerScreen);
			}
		});
		view.add(timer);
		exercises = new Button(MARGINX, MARGINY+80, WIDTH, HEIGHT, "Exercises",BUTTON_COLOR , new Action(){
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.exerciseScreen);
			}
		});
		view.add(exercises);
		stop = new Button(MARGINX, MARGINY+160, WIDTH, HEIGHT, "Stop",BUTTON_COLOR , new Action(){
			
			@Override
			public void act() {
			//	workoutPlanner.timerScreen.stopTimer();
			}
		});
			view.add(stop);
		}
	}



