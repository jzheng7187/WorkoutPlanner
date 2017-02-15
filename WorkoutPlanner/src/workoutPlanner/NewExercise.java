package workoutPlanner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;

public class NewExercise extends Button implements MouseListener{
	
	//allExercises ArrayList has all the exercises
	private static ArrayList<String> allExercises;
	//myExercises ArrayList has all the exercises you added
	private static ArrayList<String> myExercises = new ArrayList<String>();
	
	//private ArrayList<ButtonInterfaceMatthewN> ;
	private boolean[] clicked;
	private int[] value;
	private String clickedGraphic;
	
	//new exercise adds exercises into a list
	public NewExercise(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}
	
	public static void main(String[] args) {
		getExercises();
		for(int i = 0; i < allExercises.length(); i++){
			value[i] = 1;
			clicked[i] = false;
		}
		for(int i = 0; i < allExercises.length(); i++){
			System.out.println(allExercises[i]);
			System.out.println(value[i]);
			System.out.println(clicked[i]);
		}
	}
	
	public void update(Graphics2D g){
		value = new int[allExercises.length()];
		clicked  = new boolean[allExercises.length()];
		addExercise(allExercises);
		allExercises.remove(clickedGraphic);
	}
	@Override
	public void mouseClicked(MouseEvent g) {
		if(isHovered(getX(),getY())){
			
		}
		
	}
	
	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}
	
	//highlights picture when mouse hovers over image
	public boolean highlight(){
		for(int i = 0; i <  allExercises.length(); i++){
			if(isHovered(getX(),getY())){
				return allExercises[i].setColor(new Color(255, 255, 255, 25));
			}else{
				return false;
			}
		}
	}
	
	//checks if exercise that is clicked on was already clicked on or not.  
	//If it was not yet clicked on it will set the value to 0
	public boolean isClicked(){
		for(int i = 0; i < value.length; i++){
			if(value[i] == 1){
				value[i]--;
				return true;
			}
		}
		return false;
	}
	
	//adds exercises to myExercises
	public void addExercise(ArrayList<String> exercises){
		boolean clickedAgain = false;
		
		for(int i = 0; i < value.length; i++){
			if(value[i] == 0 && isHovered()){
				System.out.println("You have already chosen this exercise.");
				exercises.highlight();
			}else{
				myExercises.add(allExercises[i]);
				allExercises.remove(allExercises[i]);
			}
		}
		update();
	}
	
	public static void getExercises(){
		allExercises = new ArrayList<String>();
		allExercises.add("Push-up");
		allExercises.add("Curl-up");
		allExercises.add("Sit-up");
		allExercises.add("Bench Press");
		allExercises.add("Plank");
		allExercises.add("Dips");
		allExercises.add("Squats");
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
