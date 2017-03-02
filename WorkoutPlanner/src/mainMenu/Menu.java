package mainMenu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import components.ThemedBorder;
import components.ThemedBorder2;
import gui.components.Action;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import interfaces.Timer;
import main.workoutPlanner;

public class Menu extends ClickableScreen implements Runnable {
	private Timer timerInterface;
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
	private CustomTextLabel finishedex;
	private CustomTextLabel exerci;
	private CustomTextLabel stat;
	private CustomTextLabel curr;
	private CustomTextLabel start;
	private CustomTextLabel progress;
	private CustomTextLabel[] act;
	private CustomTextLabel[] fin; 
	public static final int MARGINX = 550;
	public static final int MARGINY = 200;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 120;
	public static final int SPACE = 160;
	public static final Color BUTTON_COLOR = new Color(255, 255, 255);
	private double Timer;
	private boolean isTimerOn;
	private String[] Activity;
	private String[] Finished;
	private ArrayList<String> finishedList;
	private ArrayList<Long> timeFinished;
	private ArrayList<String> exerciseList;

	public Menu(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		Activity = new String[3];
		for(int i = 0; i < Activity.length; i++){
			Activity[i] = "";
		}
		
		
		act = new CustomTextLabel[3];
		fin = new CustomTextLabel[3];
		exerciseList = new ArrayList<String>();
		finishedList = new ArrayList<String>();
		timeFinished = new ArrayList<Long>();
		finishedex = new CustomTextLabel(50, 450, 300, 50, "Finished Excercises", Color.black);
		view.add(finishedex);
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
		
		
		act[0] = new CustomTextLabel(50, 300, 200, 50, Activity[0], Color.white);
		act[1] = new CustomTextLabel(50, 350, 200, 50, Activity[1], Color.white);
		act[2] = new CustomTextLabel(50, 400, 200, 50, Activity[2], Color.white);
		view.add(act[0]);
		view.add(act[1]);
		view.add(act[2]);
		fin[0] = new CustomTextLabel(50, 0, 200, 50, Activity[0], Color.white);
		fin[1] = new CustomTextLabel(50, 350, 200, 50, Activity[1], Color.white);
		fin[2] = new CustomTextLabel(50, 400, 200, 50, Activity[2], Color.white);
		view.add(fin[0]);
		view.add(fin[1]);
		view.add(fin[2]);
		stopwatchbut = new CustomButton(600, 55, 200, 100, "Elapsed Time", BUTTON_COLOR, new Action() {
			@Override
			public void act() {
				//updateFinished();
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
				isTimerOn = false;
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
		//Timer = timerInterface.getTimer();
		//isTimerOn = timerInterface.isTimerOn();
		Timer = 0.00;
		isTimerOn = false;
		updateExercises();
		while(isTimerOn){
			changeTime((""+(int)(Timer*100)/100.00));
			Timer += .01;
		}
	}
	private void updateFinished(){
		for(int i = 0; i < finishedList.size(); i++ ){
			finishedList.add(exerciseList.get(i));
			exerciseList.remove(i);
		};
		for(int i = 0; i < timeFinished.size(); i++ ){
			
//			double startTime = Timer;
//			
//			if(){
//				
//			}
		long startTime = System.nanoTime();
		run();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		timeFinished.add(duration);
		};
	}
	private void updateExercises() {
		if(exerciseList.size() < 3){
			exerciseList.add(0,"Exercise 1"
					//Exercises.clickedExercise()
					);
		}
		if(exerciseList.size() < 3){
			exerciseList.add(0,"Exercise 2"
					//Exercises.clickedExercise()
					);
		}
		if(exerciseList.size() < 3){
			exerciseList.add(0,"Exercise 3"
					//Exercises.clickedExercise()
					);
		}
		if(exerciseList.size() < 3){
			exerciseList.add(0,"Exercise 4"
					//Exercises.clickedExercise()
					);
		}else{
			exerciseList.remove(2);
			exerciseList.add(0,"Exercise 4"
					//Exercises.clickedExercise()
					);
		}
		for(int i = 0; i < exerciseList.size(); i++){
			Activity[i] = exerciseList.get(i);
			for(int j = 0; j < Activity.length; j++){
				act[j].setText(Activity[j]);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
