package timer;

/**
 * 
 * @author Nikita Smirnov 
 *
 */

public interface TimeDisplay {
	
	public String markLongestTime();
	
	public String markShortestTime();
	
	public String markAverageTime();

	public String time(String time);
	
	public String currentLap(String time);
	
	public void pauseTimer();
	
	public void startTimer();
	
	public void unpauseTimer();
	
	public void resetTimer();
}

