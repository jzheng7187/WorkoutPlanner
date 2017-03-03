package timer;

import java.util.ArrayList;

import gui.components.TextLabel;

/**
 * 
 * @author Nikita Smirnov 
 *
 */

public interface TimeDisplay {
	
	public String markLongestTime();
	
	public String markShortestTime();
	
	public String markAverageTime();

	public String time();
	
	public String currentLap();
	
	public ArrayList<String> laps();
	
	public void addNewLap();
	
	public void pauseTimer();
	
	public void startTimer();
	
	public void unpauseTimer();
	
	public void resetTimer();
}

