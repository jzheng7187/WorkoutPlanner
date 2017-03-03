package workoutPlanner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.Clickable;

public class NewExercise extends Button implements MouseListener{
	
	//allExercises has all the exercises //ButtonInterfaceMatthewN
	private static ArrayList<String> allExercises;
	//myExercises  has all the exercises you decide to add
	private static ArrayList<String> myExercises = new ArrayList<String>();
	private static boolean isInitialize = false;//used to initialize variables for the first time
	private static boolean[] clicked;//used to check if exercise was clicked
	private static boolean[] inMyExercise;//used to check if exercise is already added
	private static int[] value;// an array of ids to keep track of each exercise
	private String clickedGraphic;
	
	//new exercise adds exercises into a list
	public NewExercise(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		getExercises();
	}
	//used for debugging
	/*
	public static void main(String[] args) {
		getExercises();
		value = new int[allExercises.size()];
		inMyExercise  = new boolean[allExercises.size()];
		clicked  = new boolean[allExercises.size()];
		for(int i = 0; i < allExercises.size(); i++){
			value[i] = i;
			inMyExercise[i] = false;
			clicked[i] = false;
		}
		
		System.out.println("All exercises and attributes");
		for(int i = 0; i < allExercises.size(); i++){
			System.out.println(allExercises.get(i));
			System.out.println(value[i]);
			System.out.println(clicked[i]);
		}
		clicked[0] = true;
		addExercise(allExercises);
		System.out.println("My exercises");
		for(int i = 0; i < myExercises.size(); i++){
			System.out.println(myExercises.get(i));
			System.out.println(value[i]);
		}
		
	}
	*/
	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}
	//highlights picture when mouse hovers over image
	public boolean highlight(){
		for(int i = 0; i <  allExercises.size(); i++){
			if(isHovered(getX(),getY())){
				return allExercises.get(i).setColor(new Color(180,225,50, 25));
			}else{
				return allExercises.get(i).setColor(new Color(0, 0, 0, 0));;
			}
		}
	}
	
	
	
	
	
	public static void getExercises(){
		allExercises = new ArrayList<String>();
		//swap with images 
		allExercises.add("Treadmill");
		allExercises.add("Squats");
		allExercises.add("Crunches");
		allExercises.add("Cycling");
		allExercises.add("Pushup");
		allExercises.add("Jumprope");
		value = new int[allExercises.size()];
		inMyExercise  = new boolean[allExercises.size()];
		clicked   = new boolean[allExercises.size()];
	}
	//checks if the exercise was clicked on.  
	public static boolean isClicked(int index){
		return clicked[index];
	}
	//checks if the exercise is already in myExercises.  
	public static boolean isInMyExercises(int index){
		return inMyExercise[index];
	}
	//checks if an exercise has been clicked on and adds it to myExercises. if the exercise is already in myExercises, it will not be added.
	public static ArrayList<String> addExercise(ArrayList<String> g){
		for(int i = 0; i <  allExercises.size(); i++){
			if(isClicked(i) && !isInMyExercises(i)){
				myExercises.add(allExercises.get(i));
				inMyExercise[i] = true;
				System.out.println(allExercises.get(i)+" was added to my exercise.");
			}else{
				if(isInMyExercises(i)){
					System.out.println(allExercises.get(i)+" was already included in your exercise");
				}else{
					System.out.println("Nothing done to "+allExercises.get(i));
				}
			}
		}
		System.out.println(myExercises);
		return myExercises;
	}
	public ArrayList<String> showExercises(){
		return myExercises;
	}
	public static void clickTreadmill(){
		if(!isInitialize){
			isInitialize = true;
			getExercises();
		}
		clicked[0] = true;
		addExercise(allExercises);
	}
	public static void clickSquats(){
		if(!isInitialize){
			isInitialize = true;
			getExercises();
		}
		clicked[1] = true;
		addExercise(allExercises);
	}
	public static void clickCrunches(){
		if(!isInitialize){
			isInitialize = true;
			getExercises();
		}
		clicked[2] = true;
		addExercise(allExercises);
	}
	public static void clickCycling(){
		if(!isInitialize){
			isInitialize = true;
			getExercises();
		}
		clicked[3] = true;
		addExercise(allExercises);
	}
	public static void clickPushup(){
		if(!isInitialize){
			isInitialize = true;
			getExercises();
		}
		clicked[4] = true;
		addExercise(allExercises);
	}
	public static void clickJumprope(){
		if(!isInitialize){
			isInitialize = true;
			getExercises();
		}
		clicked[5] = true;
		addExercise(allExercises);
	}
	/*
	public static void clickTest(){
		System.out.println("Sucessful");
	}
	*/
	@Override
	public void mouseClicked(MouseEvent g) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override 
	public void mouseExited(MouseEvent arg0) { 
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
