/**
 * 
 */
package timer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import components.ThemedBorder;
import components.ThemedBorder2;
import components.ThemedTextLabel;
import gui.components.Action;
import gui.components.Button;
import gui.components.DrawLines;
import gui.components.Rect;
import gui.components.TextHeadder;
import gui.components.TextLabel;
import gui.components.ThemedButton;
import gui.components.Visible;
import gui.screens.ClickableScreen;
import main.workoutPlanner;


/**
 * @author Alam
 *
 *
 */
public class TimerApplication extends ClickableScreen implements Runnable{

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
	
	//refresh rate
	public static final int REFRESH = 150;
	
	//background
	private ThemedBorder border1;
	private ThemedBorder2 border2;
	
	
	//TODO  removed if unnecessary
	private ArrayList<Visible> viewObjects;
	
	//lime green color temp out of service until background is fixed.
	//TODO
	//Color g = new Color (180,225,50);
	public static final Color G = new Color (102,204,0);
	public static final Color T = new Color (0,0,0);
	public static final Color W = new Color (255,255,255);
	public static final Color B = new Color (0,0,0);
	
	//rect
	private static Rect rect;
	private static Rect rect2;
	
	//Timer boolean
	private static boolean pauseTimer = false;
	//completion boolean
	private static boolean complete = false;
	
	//getters for Hunter
	public static boolean getTimerStatus(){
		return pauseTimer;
	}
	
	
	
	public static String getTime(){
		return timer.time();	
	}
	public static boolean getCompletionStatus(){
		return complete;
	}
	
	//implements interface
	public static Timer timer = new Timer(800, 600);

	
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
				complete = false;
				Thread startTimer = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							pauseTimer = false;
							while(pauseTimer == false){
								Thread.sleep(REFRESH);
								tt.setText(timer.time());
								cl.setText(timer.currentLap());
								update();	
							}
							
							
						}catch(InterruptedException e) {
							e.printStackTrace(); 	
						}
					}
				});
				startTimer.start();
				rect = new Rect(50,SPACE*7,300,getHeight()-(SPACE*7));
				rect2 = new Rect(MARGINX-30,MARGINY+(SPACE*8),300,150);
				v.add(rect);
				v.add(rect2);
			}

		}, Color.WHITE);
		v.add(start);
		
		//stop button
		stop = new ThemedButton(MARGINX+180, MARGINY, WIDTH, HEIGHT, "Stop", G ,new Action(){
			@Override
			public void act() {
				pauseTimer = true;
				complete = true;
				timer.pauseTimer();
				
				ThemedTextLabel stats = new ThemedTextLabel(MARGINX-30,MARGINY+(SPACE*8),200,30, "Stats: ", W);
				v.add(stats);
				
				ThemedTextLabel longest = new ThemedTextLabel(MARGINX-30,MARGINY+(SPACE*9),200,30, "Worst ", W);
				ThemedTextLabel longest2 = new ThemedTextLabel(MARGINX+27,MARGINY+(SPACE*9),200,30, "Lap: "+timer.markLongestTime(), G);
				ThemedTextLabel Shortest = new ThemedTextLabel(MARGINX-30,MARGINY+(SPACE*10),200,30,"Best" , W);
				ThemedTextLabel Shortest2 = new ThemedTextLabel(MARGINX+16,MARGINY+(SPACE*10),200,30, "Lap: "+timer.markShortestTime(), G);
				ThemedTextLabel average = new ThemedTextLabel(MARGINX-30,MARGINY+(SPACE*11),200,30, "Average", W);
				ThemedTextLabel average2 = new ThemedTextLabel(MARGINX+47,MARGINY+(SPACE*11),200,30, "Lap: "+timer.markAverageTime(), G);
				v.add(longest);
				v.add(Shortest);
				v.add(average);
				v.add(longest2);
				v.add(Shortest2);
				v.add(average2);
				
				update();	
				timer.resetTimer();
				
			}
		}, Color.WHITE);
		v.add(stop);
		
		
		//lap button
		lap = new ThemedButton(MARGINX-30, MARGINY+140, WIDTH, HEIGHT, "Lap", G ,new Action(){
			@Override
			public void act() {
				timer.addLap();
				for (int i = 0, s = 7; i < timer.laps.size(); i++, s++) {
				ThemedTextLabel localLap1 = new ThemedTextLabel(50,SPACE*s,200,30, "Lap ", G);
				ThemedTextLabel localLap2 = new ThemedTextLabel(87,SPACE*s,200,30, (i+1) + ": " + timer.laps.get(i), W);
				v.add(localLap1);
				v.add(localLap2);
				update();
				}
					
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
									Thread.sleep(REFRESH);
									tt.setText(timer.time());
									cl.setText(timer.currentLap());
									update();	
								}
								
								
							}catch(InterruptedException e) {
								e.printStackTrace(); 	
							}
						}
					});
					startTimer.start();
				}else{
					pauseTimer = true;
					timer.pauseTimer();
					
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
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
