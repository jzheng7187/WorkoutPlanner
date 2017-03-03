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
	
	//allExercises ArrayList has all the exercises //ButtonInterfaceMatthewN
	private static ArrayList<String> allExercises;
	//myExercises ArrayList has all the exercises you added
	private static ArrayList<String> myExercises = new ArrayList<String>();
	
	//private ArrayList<ButtonInterfaceMatthewN> ;
	private static boolean[] clicked;//used to check if exercise was clicked
	private static boolean[] inMyExercise;//used to check if exercise is already added
	private static int[] value;// an array of ids to keep track of each exercise
	private String clickedGraphic;
	
	//new exercise adds exercises into a list
	public NewExercise(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}
	
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
	
	public void update(Graphics2D g){
		value = new int[allExercises.size()];
		inMyExercise  = new boolean[allExercises.size()];
		clicked  = new boolean[allExercises.size()];
		addExercise(allExercises);
		allExercises.remove(clickedGraphic);
		showExercises();
	}  
	
//	public boolean mouseClicked() {
//		if(isHovered(getX(),getY())){
//			return true;
//		}
//		return false;
//		
//	}
	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}
	//highlights picture when mouse hovers over image
	public boolean highlight(){
		for(int i = 0; i <  allExercises.size(); i++){
			if(isHovered(getX(),getY())){
				return allExercises.get(i).setColor(new Color(255, 255, 255, 25));
			}else{
				return false;
			}
		}
	}
	//checks if exercise that is clicked on was already clicked on or not.  
	//If it was not yet clicked on it will set the value to 0
	public boolean isClicked(){
		return false;
	}
	@Override
	public void mouseClicked(MouseEvent g) {
		for(Clickable c: allExercises){
			if(c.isHovered(g.getX(), g.getY())){
				c.act();
				break;
			}
		}
	}
	
	//adds exercises to myExercises
	public static ArrayList<String> addExercise(ArrayList<String> g){
		for(int i = 0; i <  allExercises.size(); i++){
			if(clicked[i] == true && inMyExercise[i] == false){
				myExercises.add(allExercises.get(i));
				inMyExercise[i] = true;
				value[i] = myExercises.size()-1;
				System.out.println(allExercises.get(i)+" was added to my exercise.");
			}else{
				if(inMyExercise[i] == true){
					System.out.println("You have already added "+allExercises.get(i));
				}else{
					System.out.println("Nothing done to "+allExercises.get(i));
				}
			}
		}
		//update();
		return myExercises;
	}
	public ArrayList<String> showExercises(){
		return myExercises;
	}
	public static void getExercises(){
		allExercises = new ArrayList<String>();
		//swap with images 
		allExercises.add("Treadmill");
		allExercises.add("Squats");
		allExercises.add("Crunches");
		allExercises.add("Cycling");
		allExercises.add("Push-up");
		allExercises.add("Jump Rope");
		//treadmill
		//squat
		//crunch
		//cycling
		//push-up
		//jump rope
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
