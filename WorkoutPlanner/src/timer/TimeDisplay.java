package timer;

import gui.components.TextLabel;

/**
 * 
 * @author Nikita Smirnov 
 *
 */

public interface TimeDisplay {
	
	public void markLongestTime(String time);
	
	public void markShortestTime(String time);
	
	public void markAverageTime(String time);

	public void time(String time);
	
	public void currentLap(String time);
	
	public void pauseTimer();
	
	public TextLabel startTimer();
	
	public void unpauseTimer();
	
	public void resetTimer();
}

