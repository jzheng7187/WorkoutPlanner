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

import components.ThemedBorder;
import components.ThemedBorder2;
import components.ThemedTextLabel;
import gui.components.Action;
import gui.components.Button;
import gui.components.DrawLines;
import gui.components.TextHeadder;
import gui.components.TextLabel;
import gui.components.ThemedButton;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import main.workoutPlanner;
import timer.TimeDisplay;


/**
 * @author Alam
 *
 *
 */
public class TimerApplication extends ClickableScreen implements KeyListener, Runnable{

	//Buttons
	private Button start;
	private Button stop;
	private Button lap;
	private Button pause;
	
	//Static text (Non Changing text fields)
	private static TextHeadder title1;
	private static TextHeadder title2;
	private static TextLabel totalTime1;
	private static TextLabel totalTime2;
	private static TextLabel lapTime1;
	private static TextLabel lapTime2;
	//private static ThemedBorder 1;
	
	//Dynamic changing text fields
	private TextLabel tt; //Total time
	private TextLabel cl; //Current lap
	
	//lines
	private DrawLines line;
	
	
	//Buttons Dimensions
	public static final int MARGINX=400;
	public static final int MARGINY=200;
	public static final int WIDTH=200;
	public static final int HEIGHT=120;
	public static final int SPACE=35;
	
	//background
	private ThemedBorder border1;
	private ThemedBorder2 border2;
	
	
	//TODO  removed if unnecessary
	private ArrayList<Visible> viewObjects;
	
	//lime green color temp out of service until background is fixed.
	//TODO
	//Color g = new Color (180,225,50);
	public static final Color G = new Color (180,225,50);
	public static final Color T = new Color (0,0,0);
	public static final Color W = new Color (255,255,255);
	public static final Color B = new Color (0,0,0);
	
	//Timer boolean
	private boolean pauseTimer = false;
	
	
//implements interface
	Timer timer = new Timer(800, 600);

	
	public TimerApplication(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> v) {
		//NOTICE Each letter is 40 space is 20
		
		//Creates titles
		title1 = new TextHeadder(50,SPACE*2,120,50, "Stop", G, new Action(){
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.ws);
			}
		}); 
		//adds title to the page
		v.add(title1);
		title2 = new TextHeadder(185,SPACE*2,160,50, "Watch", W, new Action(){
			@Override
			public void act() {
				workoutPlanner.app.setScreen(workoutPlanner.ws);
			}
		}); 
		v.add(title2);
		
		//Creates Total time and current lap
		totalTime1 = new ThemedTextLabel(50,SPACE*5,50,30, "Total", G);
		v.add(totalTime1);
		totalTime2 = new ThemedTextLabel(105,SPACE*5,50,30, "Time:", W);
		v.add(totalTime2);
		tt = new ThemedTextLabel(160,SPACE*5,100,30, "00:00:00", W);
		v.add(tt);  
		
		lapTime1 = new ThemedTextLabel(50,SPACE*6,70,30, "Current", G);
		v.add(lapTime1);
		lapTime2 = new ThemedTextLabel(125,SPACE*6,40,30, "Lap:", W);
		v.add(lapTime2);
		cl = new ThemedTextLabel(170,SPACE*6,100,30, "00:00:00", W);
		v.add(cl);
		
		
		//Start button
		start = new ThemedButton(MARGINX-30, MARGINY, WIDTH, HEIGHT, "Start", G ,new Action(){
			@Override
			public void act() {
				timer.startTimer();
				Thread startTimer = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try{
							pauseTimer = false;
							while(pauseTimer == false){
								Thread.sleep(150);
								tt.setText(timer.time());
								update();	
							}
							
							
						}catch(InterruptedException e) {
							e.printStackTrace(); 	
						}
					}
				});
				startTimer.start();
				
					
			}

		}, Color.WHITE);
		v.add(start);
		
		//stop button
		stop = new ThemedButton(MARGINX+180, MARGINY, WIDTH, HEIGHT, "Stop", G ,new Action(){
			@Override
			public void act() {
				timer.pauseTimer();
				tt.setText(timer.time());
				update();	
				pauseTimer = true;
				timer.resetTimer();
			}
		}, Color.WHITE);
		v.add(stop);
		
		
		//lap button
		lap = new ThemedButton(MARGINX-30, MARGINY+140, WIDTH, HEIGHT, "Lap", G ,new Action(){
			@Override
			public void act() {
				timer.addLap();
			}
		}, Color.WHITE);
		v.add(lap);
		
		
		//pause button
		pause = new ThemedButton(MARGINX+180, MARGINY+140, WIDTH, HEIGHT, "Pause", G ,new Action(){
			@Override
			public void act() {
				if(pauseTimer){
					timer.unpauseTimer();
					pauseTimer = false;
					Thread startTimer = new Thread(new Runnable() {
						@Override
						public void run() {
							try{
								pauseTimer = false;
								while(pauseTimer == false){
									Thread.sleep(150);
									tt.setText(timer.time());
									update();	
								}
								
								
							}catch(InterruptedException e) {
								e.printStackTrace(); 	
							}
						}
					});
					startTimer.start();
				}else{
					timer.pauseTimer();
					pauseTimer = true;
				}
			}
		}, Color.WHITE);
		v.add(pause);
		
		
		//add lines
		border1 = new ThemedBorder(G,new Action() {
			@Override
			public void act() {

			}
		});
		v.add(border1);
		
		border2 = new ThemedBorder2(G, new Action() {
			@Override
			public void act() {

			}
		});
		v.add(border2);


	}

	private static void createButton(String string, int w, int h, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawBackground(Graphics2D g){
		Color c = new Color(0,0,0);
		g.setColor(c);
		g.fillRect(0, 0, getWidth(), getHeight());
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
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
