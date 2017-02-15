package timer;

import java.util.ArrayList;
import java.util.Objects;

import gui.components.Visible;
import gui.screens.ClickableScreen;

public class Timer extends ClickableScreen {

	public static long startTime;
	public static long currentTimeM;
	public static String newLapTime;
	public static long newLapTimeM;
	public static String currentTime;
	public static ArrayList<String> laps;
	
	public Timer(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		startTimer();
		try {
			
			for(int i = 0; i < 300; i++){
				Thread.sleep(1000);
				addLap();
				System.out.println(currentTime);
				System.out.println(laps);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void startTimer() {
		startTime = System.currentTimeMillis(); //Start keeping track of startTime.
		laps = new ArrayList<String>(); //Instantiate ArrayList.
		currentTimeM = 0;
	}
	
	public static void currentTimeM() {
		currentTimeM = System.currentTimeMillis() - startTime; // Set the time since the start of timer.
	}
	
	public static void newLapTimeM() {
		newLapTimeM = System.currentTimeMillis() - currentTimeM; // Set the time since the new lap of timer.
	}
	
	public static void addLap() {
		newLapTimeM();
		// newLapTimeM = System.currentTimeMillis() - currentTimeM;
		currentTimeM(); // Set the time since the start of timer.
		long elapsedSeconds = currentTimeM / 1000; // Convert time (milliseconds) to seconds.
		
		long secondsDisplay = elapsedSeconds % 60; // Set the current amount of seconds.
		long minutesDisplay = elapsedSeconds / 60; // Set the current amount of minutes.
		String seconds = Objects.toString(secondsDisplay, null); // Convert seconds to string.
		String minutes = Objects.toString(minutesDisplay, null); // Convert minutes to string.
		
		currentTime = minutes + ":" + seconds; //Set currentTime to a standard clock string.
		
		
		laps.add(minutes + ":" + seconds); // Makes the current time a string and adds it to ArrayList.
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
	}
}
