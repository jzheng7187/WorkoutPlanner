/**
 * 
 */
package timer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.components.Visible;
import gui.screens.ClickableScreen;

/**
 * @author Alam
 *
 *gf
 */
public class TimerApplication extends ClickableScreen implements KeyListener, Runnable{

	//private BufferedImage image = new BufferedImage(getWidth(), getHeight(), 0);
	private ArrayList<Visible> viewObjects;
	Color c = new Color (180,225,50);
	
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
	public void drawBackground(){
//		Graphics2D g = new Graphics2D(drawRect());
//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g.fillRect(0, 0, getWidth(), getHeight());
//		g.setColor(Color.black);

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
		drawBackground();
		
	}
	@Override
	public void run() {
		
		
	}
	
}
