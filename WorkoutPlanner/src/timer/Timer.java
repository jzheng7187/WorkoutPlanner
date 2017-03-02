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

public class Timer extends ClickableScreen implements TimeDisplay{

	public static boolean count;
	public static long startTime;
	public static long pauseTime;
	public static long currentTimeM;
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
//		startTime();
//		try {
//			
//			while (count == true) {
//				Thread.sleep(1000); // 1 Second timer (1000 milliseconds)
//				
//				System.out.println(showTime()); //Print currentTime
//				
//				addLap(); //Add a new lap to ArrayList laps
//				System.out.println(ms); //Print ArrayList laps
//				System.out.println(laps); //Print ArrayList laps
//			}
//			
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	public static void startTime() {
//		count = true; //Allow the timer to count
		
		startTime = System.currentTimeMillis(); //Start keeping track of startTime.
		laps = new ArrayList<String>(); //Instantiate ArrayList.
		ms = new ArrayList<Long>(); //Instantiate ArrayList.
	}
	
//	public static void pauseTime() {
////		count = false; //Stop the timer from counting
//		
//		currentTimeM(); // Set the time since the start of timer.
//	}
	
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
	
	public static String showTimeSinceLap(long time) {
		long elapsedSeconds = time / 1000; // Convert time (milliseconds) to seconds.
		
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
			currentTimeM();
			ms.add(System.currentTimeMillis());
			laps.add(showTimeSinceLap(currentTimeM));
		}
		else {
			newLapTimeM();
			ms.add(System.currentTimeMillis()); // Makes the current time a string and adds it to ArrayList.
			laps.add(showTimeSinceLap(newLapTimeM));
		}
		
		//calculate the new longest lap
		//identify the index of that long lap
//		display.markLongestTime(findLongestTime());
//		display.markShortestTime(findShortestTime());
//		display.markAverageTime(showTimeSinceLap(findAverageTime() - startTime));
//		display.time(showTime());
//		display.currentLap(laps.get(laps.size()));
	}
	
	public static String findLongestTime() {
		int longestTime = 0;
		long x = ms.get(0);
		
		for (int i = 1; i < ms.size(); i++) {
			if (ms.get(i) > x) {
				longestTime = i;
			}
 		}
		
		return laps.get(longestTime);
	}
	
	public static String findShortestTime() {
		int shortestTime = 0;
		long x = ms.get(0);
		
		for (int i = 1; i < ms.size(); i++) {
			if (ms.get(i) < x) {
				shortestTime = i;
			}
 		}
		
		return laps.get(shortestTime);
	}
	
	public static long findAverageTime() {
		long x = ms.get(0);
		
		for (int i = 1; i < ms.size(); i++) {
			x = x + ms.get(i);
 		}
		
		long averageTime = x / ms.size();
		
		return averageTime;
	}
	
	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
	}
	
	
//====================================================================================================================
	//-------Interface Methods----------------------------------------------------------------------------------------
//====================================================================================================================
	
	
	@Override
	public String markLongestTime() {
		int longestTime = 0;
		long x = ms.get(0);
		
		for (int i = 1; i < ms.size(); i++) {
			if (ms.get(i) > x) {
				longestTime = i;
			}
 		}
		
		return laps.get(longestTime);
	}

	@Override
	public String markShortestTime() {
		int shortestTime = 0;
		long x = ms.get(0);
		
		for (int i = 1; i < ms.size(); i++) {
			if (ms.get(i) < x) {
				shortestTime = i;
			}
 		}
		
		return laps.get(shortestTime);
	}

	@Override
	public String markAverageTime() {
		long x = ms.get(0);
		
		for (int i = 1; i < ms.size(); i++) {
			x = x + ms.get(i);
 		}
		
		long averageTime = x / ms.size();
		
		return showTimeSinceLap(averageTime - startTime);
	}

	@Override
	public String time(String time) {
		return showTime();
	}

	@Override
	public String currentLap(String time) {
		return laps.get(laps.size() - 1);
	}

	@Override
	public void pauseTimer() {
		pauseTime = System.currentTimeMillis() - startTime;
		
	}

	@Override
	public void startTimer() {
		startTime = System.currentTimeMillis();
		startTime();
		
	}

	@Override
	public void unpauseTimer() {
		startTime = (System.currentTimeMillis() - pauseTime) + startTime;
		
	}

	@Override
	public void resetTimer() {
		startTime = (System.currentTimeMillis()) + startTime;
		
	}
}
