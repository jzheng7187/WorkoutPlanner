/**
 * 
 */
package timer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.components.Visible;
import gui.screens.ClickableScreen;

/**
 * @author Alam
 *
 */
public class TimerApplication extends ClickableScreen implements KeyListener, Runnable{

	public TimerApplication(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}


	private static void createButton(String string, int w, int h, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	public void update(Graphics2D g){
		
	}
	public void drawbackground(Graphics2D g){
		g.setColor(Color.green);
		g.fillRect(0,0, getWidth(), getHeight());
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
//	public KeyListener getKeyListner(){
//		return this;
//	}
		
	}
	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
