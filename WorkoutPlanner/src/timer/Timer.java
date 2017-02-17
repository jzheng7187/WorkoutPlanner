package timer;

/**
 * 
 * @author Nikita Smirnov
 *
 */

import java.util.ArrayList;
import java.util.Objects;

import gui.components.Visible;
import gui.screens.ClickableScreen;

public class Timer extends ClickableScreen {

	public static boolean count;
	public static long startTime;
	public static long currentTimeM;
	public static long x;
	public static String newLapTime;
	public static long newLapTimeM;
	public static String currentTime;
	public static ArrayList<Long> ms;
	public static ArrayList<String> laps;
	
	private static TimeDisplay display;
	
	public Timer(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		startTimer();
		x = 1000;
		try {
			
			while (count == true) {
				Thread.sleep(x); // 1 Second timer (1000 milliseconds)
				x = x + 1000;
				
				System.out.println(showTime()); //Print currentTime
				
				addLap(); //Add a new lap to ArrayList laps
				System.out.println(ms); //Print ArrayList laps
				System.out.println(laps); //Print ArrayList laps
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void startTimer() {
		count = true; //Allow the timer to count
		
		startTime = System.currentTimeMillis(); //Start keeping track of startTime.
		laps = new ArrayList<String>(); //Instantiate ArrayList.
		ms = new ArrayList<Long>(); //Instantiate ArrayList.
	}
	
	public static void stopTimer() {
		count = false; //Stop the timer from counting
		
		currentTimeM(); // Set the time since the start of timer.
	}
	
	public static String showTime() {
		long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000; // Convert time (milliseconds) to seconds.
		
		long secondsDisplay = elapsedSeconds % 60; // Set the current amount of seconds.
		long minutesDisplay = elapsedSeconds / 60; // Set the current amount of minutes.
		
		if (secondsDisplay < 10){
			return minutesDisplay + ":0" + secondsDisplay; //Set currentTime to a standard clock string.
		} else {
			return minutesDisplay + ":" + secondsDisplay; //Set currentTime to a standard clock string.
		}
	}
	
	public static void currentTimeM() {
		currentTimeM = System.currentTimeMillis() - startTime; // Set the time since the start of timer.
	}
	
	public static void newLapTimeM() {
		newLapTimeM = System.currentTimeMillis() - ms.get(ms.size() - 1); // Set the time since the new lap of timer.
	}
	
	public static void addLap() {
		if (ms.size() == 0){
			ms.add(currentTimeM);
		}
		else {
			newLapTimeM();
			ms.add(newLapTimeM); // Makes the current time a string and adds it to ArrayList.
		}
		newLapTime = showTime();
		
		laps.add(newLapTime); // Makes the current time a string and adds it to ArrayList.
		
		//calculate the new longest lap
		//identify the index of that long lap
//		display.markLongestTime(i);
	}
	
	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
	}
}
