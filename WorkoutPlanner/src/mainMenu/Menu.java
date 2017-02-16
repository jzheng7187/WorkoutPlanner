package mainMenu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import interfaces.Timer;
import main.workoutPlanner;

public class Menu extends ClickableScreen implements Runnable {
	private Timer timerInt;
	private CustomButton timer;
	private CustomButton exercises;
	private CustomButton stop;
	private CustomTextLabel stopwatch;
	private CustomButton stopwatchbut;
	private CustomButton border1;
	private CustomButton border2;
	private CustomTextLabel label;
	private CustomTextLabel label2;
	public static final int MARGINX = 500;
	public static final int MARGINY = 200;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 120;
	public static final int SPACE = 160;
	public static final Color BUTTON_COLOR = new Color(255, 255, 255);

	public Menu(int width, int height) {
		super(width, height);
		// jframe.setBackground(Color.RED);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		// TODO Auto-generated method stub
		stopwatch = new CustomTextLabel(650, 90, 100, 50, "0.0", Color.black);
		label = new CustomTextLabel(50, 50, 100, 50, "Workout", Color.white);
		view.add(label);
		label2 = new CustomTextLabel(150, 50, 100, 50, "Planner", Color.black);
		view.add(label2);
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
		border1 = new CustomButton(20, 20, 20, 900, "", BUTTON_COLOR, new Action() {
			@Override
			public void act() {

			}
		}, Color.BLACK);
		view.add(border1);
		border2 = new CustomButton(0, 40, 900, 20, "", BUTTON_COLOR, new Action() {
			@Override
			public void act() {

			}
		}, Color.BLACK);
		view.add(border2);
		stop = new CustomButton(MARGINX, MARGINY + SPACE + SPACE, WIDTH, HEIGHT, "Stop", BUTTON_COLOR, new Action() {

			@Override
			public void act() {
				// workoutPlanner.timerScreen.stopTimer();
			}
		}, Color.BLACK);
		view.add(stop);
		view.add(stopwatch);
	}

	@Override
	public void run() {
		stopwatch.setText("999");
		startTimer();
	}

	private void startTimer() {
		changeText("!!!");
		stopwatch.setText("");
	}

	private void changeText(String string) {
		stopwatch.setText(string);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void drawBackground(Graphics2D g) {
		Color c = new Color(180, 225, 50);
		g.setColor(c);
		g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
	}

	public void update() {
		Graphics2D g = getImage().createGraphics();
		// smooth the graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawBackground(g);
		g.setColor(Color.black);
		for (int i = 0; i < viewObjects.size(); i++) {
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
	}

}
