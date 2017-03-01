package mainMenu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

import components.ThemedBorder;
import components.ThemedBorder2;
import gui.components.Action;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import interfaces.Exercises;
import interfaces.Timer;
import main.workoutPlanner;

public class Menu extends ClickableScreen implements Runnable {
	private Timer timerInt;
	private Exercises fg;
	private CustomButton timer;
	private CustomButton exercises;
	private CustomButton stop;
	private CustomTextLabel stopwatch;
	private CustomButton stopwatchbut;
	private CustomButton border1;
	private CustomButton border2;
	private CustomTitle label;
	private CustomTitle label2;
	private CustomTextLabel remain;
	private CustomTextLabel exerci;
	private CustomTextLabel stat;
	private CustomTextLabel curr;
	private CustomTextLabel start;
	private CustomTextLabel progress;
	private CustomTextLabel act1;
	private CustomTextLabel act2;
	private CustomTextLabel act3;
	private CustomTextLabel act4;
	private CustomTextLabel act5;
	public static final int MARGINX = 550;
	public static final int MARGINY = 200;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 120;
	public static final int SPACE = 160;
	public static final Color BUTTON_COLOR = new Color(255, 255, 255);
	private double Timer;
	private boolean timerOn;
	private String[] Activity;
	private ArrayList<String> exerciseList;

	public Menu(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
		// jframe.setBackground(Color.RED);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		exerciseList = new ArrayList<String>();
		stopwatch = new CustomTextLabel(650, 90, 100, 50, "0.00", Color.black);
		label = new CustomTitle(50, 50, 300, 50, "Workout", Color.white);
		view.add(label);
		label2 = new CustomTitle(280, 50, 300, 50, "Planner", Color.black);
		view.add(label2);
		remain = new CustomTextLabel(50, 200, 120, 50, "Remaining", Color.white);
		view.add(remain);
		exerci = new CustomTextLabel(175, 200, 100, 50, "Exercises", Color.black);
		view.add(exerci);
		stat = new CustomTextLabel(330, 300, 100, 50, "Status", Color.black);
		view.add(stat);
		curr = new CustomTextLabel(330, 350, 100, 50, "Current", Color.black);
		view.add(curr);
		start = new CustomTextLabel(330, 400, 100, 50, "Start", Color.black);
		view.add(start);
		progress = new CustomTextLabel(50, 250, 130, 50, "Inprogress", Color.white);
		view.add(progress);
		/*act1 = new CustomTextLabel(50, 300, 100, 50, Activity[0], Color.white);
		view.add(act1);
		act2 = new CustomTextLabel(50, 350, 100, 50, Activity[1], Color.white);
		view.add(act2);
		act3 = new CustomTextLabel(50, 400, 100, 50, Activity[2], Color.white);
		view.add(act3);
		act4 = new CustomTextLabel(50, 450, 100, 50, Activity[3], Color.white);
		view.add(act4);
		act5 = new CustomTextLabel(50, 500, 100, 50, Activity[4] , Color.white);
		view.add(act5);*/


		stopwatchbut = new CustomButton(600, 55, 200, 100, "Elapsed Time", BUTTON_COLOR, new Action() {
			@Override
			public void act() {

			}
		}, Color.BLACK);
		view.add(stopwatchbut);

		timer = new CustomButton(MARGINX, MARGINY, WIDTH, HEIGHT, "Timer", BUTTON_COLOR, new Action() {

			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.timerScreen);
			}
		}, Color.BLACK);
		view.add(timer);
		exercises = new CustomButton(MARGINX, MARGINY + SPACE, WIDTH, HEIGHT, "Exercises", BUTTON_COLOR, new Action() {
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.exerciseScreen);
			}
		}, Color.BLACK);
		view.add(exercises);
		border1 = new ThemedBorder(BUTTON_COLOR,new Action() {
			@Override
			public void act() {

			}
		});
		view.add(border1);
		border2 = new ThemedBorder2(BUTTON_COLOR, new Action() {
			@Override
			public void act() {

			}
		});
		view.add(border2);
		stop = new CustomButton(MARGINX, MARGINY + SPACE + SPACE, WIDTH, HEIGHT, "Stop", BUTTON_COLOR, new Action() {

			@Override
			public void act() {
				timerOn = false;
			}
		}, Color.BLACK);
		view.add(stop);
		view.add(stopwatch);
	}

	private void changeTime(String string) {
		stopwatch.setText(string);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void drawBackground(Graphics2D g) {
		Color c = new Color(102, 204, 0);
		g.setColor(c);
		g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
	}

	@Override
	public void run() {
		//Timer = timerInt.getTimer();
		Activity = new String[5];
		Timer = 0.00;
		timerOn = true;
		updateExercises();
		while(timerOn){
			changeTime((""+(int)(Timer*100)/100.00));
			Timer += .01;
		}
	}

	private void updateExercises() {
		exerciseList.add("Push Up"
				//Exercises.getExercise()
				);
		exerciseList.add("Push Up"
				//Exercises.getExercise()
				);
		exerciseList.add("Push Up"
				//Exercises.getExercise()
				);
		exerciseList.add("Push Up"
				//Exercises.getExercise()
				);
		exerciseList.add("Push Up"
				//Exercises.getExercise()
				);
		for(int i = 0; i < exerciseList.size(); i++){
			Activity[i] = exerciseList.get(i);
			//act1.setText(exerciseList.get(i));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
