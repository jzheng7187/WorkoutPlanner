package timer;


import java.util.ArrayList;
import java.util.Objects;

import java.awt.Graphics2D;

import gui.components.Visible;
import gui.screens.ClickableScreen;

public class Timer extends ClickableScreen {

	public static long startTime;
	public static long currentTime;
	public static ArrayList<String> laps;
	
	public Timer(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static void startTimer() {
		//Start keeping track of startTime
		startTime = System.currentTimeMillis();
		
		//Instantiate ArrayList
		laps = new ArrayList<String>();
	}
	
	public static void addLap() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		long elapsedSeconds = elapsedTime / 1000;
		
		long secondsDisplay = elapsedSeconds % 60;
		long elapsedMinutes = elapsedSeconds / 60;
		String seconds = Objects.toString(secondsDisplay, null);
		String minutes = Objects.toString(elapsedMinutes, null);
		
		laps.add(minutes + ":" + seconds);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String args){
		
	}
	
	
	public void update(Graphics2D g){
		
	}
}
