package mainMenu;

import java.awt.Color;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import interfaces.Timer;
import main.workoutPlanner;

public class Menu extends ClickableScreen implements Runnable {
	private Timer timerInt;
	private Button timer;
	private Button exercises;
	private Button stop;
	private TextLabel stopwatch;
	private Button stopwatchbut;
	private TextLabel label;
	private TextLabel label2;
	public static final int MARGINX=500;
	public static final int MARGINY=100;
	public static final int WIDTH=100;
	public static final int HEIGHT=60;
	public static final int SPACE=80;
	public static final Color BUTTON_COLOR=  new Color(255,255,255);

	public Menu(int width, int height) {
		super(width, height);
		//jframe.setBackground(Color.RED);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		// TODO Auto-generated method stub
		label = new TextLabel(50,50,100,50,"Workout",Color.white);
		view.add(label);
		label2 = new TextLabel(150,50,100,50,"Planner",Color.black);
		view.add(label2);
		stopwatchbut = new Button(650,25,200,100,"",BUTTON_COLOR,new Action(){
			@Override
			public void act() {
				
			}
		},Color.BLACK);
		view.add(stopwatchbut);
		
		timer = new Button(MARGINX, MARGINY, WIDTH, HEIGHT, "Timer",BUTTON_COLOR ,new Action(){
			
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.timerScreen);
			}
		},Color.BLACK);
		view.add(timer);
		exercises = new Button(MARGINX, MARGINY+80, WIDTH, HEIGHT, "Exercises",BUTTON_COLOR , new Action(){
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.exerciseScreen);
			}
		},Color.BLACK);
		view.add(exercises);
		stop = new Button(MARGINX, MARGINY+160, WIDTH, HEIGHT, "Stop",BUTTON_COLOR , new Action(){
			
			@Override
			public void act() {
			//	workoutPlanner.timerScreen.stopTimer();
			}
		},Color.BLACK);
		view.add(stop);
		stopwatch = new TextLabel(650,30,100,50,"0.0",Color.black);
		view.add(stopwatch);
		}
	
	@Override
	public void run(){
		stopwatch.setText("q");
		while(1 > 0){
			updateTimer();
		}
	}
	
	private void updateTimer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChangeText("q");
	}

	private void ChangeText(String string) {
		stopwatch.setText(string);
		try{
			Thread.sleep(100);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}



