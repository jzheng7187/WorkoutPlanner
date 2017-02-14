package timer;

import gui.GUIApplication;
import gui.Screen;
/*
 * Author Alam
 */
public class TimerStarter extends GUIApplication{

	public TimerStarter(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		TimerApplication timer = new TimerApplication(getWidth(), getHeight());
		setScreen(timer);
	}
	public static void main(String[] args){
		TimerStarter timer = new TimerStarter(800,600);
		Thread timeKeeper = new Thread (timer);
		timeKeeper.start();
		
	}
}
