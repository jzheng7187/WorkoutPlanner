package mainMenu;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;

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
	private CustomButton timer;
	private CustomButton exercises;
	private CustomButton stop;
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
		//jframe.setBackground(Color.RED);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> view) {
		// TODO Auto-generated method stub
		label = new CustomTextLabel(50,50,100,50,"Workout",Color.WHITE);
		label2 = new TextLabel(150,50,100,50,"Planner");
		view.add(label);
		view.add(label2);
		
		timer = new CustomButton(MARGINX, MARGINY, WIDTH, HEIGHT, "Timer",BUTTON_COLOR ,new Action(){
			
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.timerScreen);
			}
		},Color.BLACK);
		view.add(timer);
		exercises = new CustomButton(MARGINX, MARGINY+80, WIDTH, HEIGHT, "Exercises",BUTTON_COLOR , new Action(){
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.exerciseScreen);
			}
		},Color.BLACK);
		view.add(exercises);
		stop = new CustomButton(MARGINX, MARGINY+160, WIDTH, HEIGHT, "Stop",BUTTON_COLOR , new Action(){
			
			@Override
			public void act() {
			//	workoutPlanner.timerScreen.stopTimer();
			}
		},Color.BLACK);
			view.add(stop);
		}
}



