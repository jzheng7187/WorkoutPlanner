/**
 * 
 */
package workoutPlanner;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.components.Visible;
import gui.screens.ClickableScreen;

/**
 * @author Jonathan Zheng
 *
 */
public class JonathanPlans extends ClickableScreen implements ExercisesInterfaceJonathanZ{

	private ArrayList<ExercisesInterfaceJonathanZ> exercises;
	private int value;
	private int x;
	private int y;
	private int input;
	public JonathanPlans(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	
	public void runMethod(){
		if(isHovered() && isClicked()){
			
		}
		editExercises();
	}
	private boolean isClicked() {
		if(isHovered()){
		return true;
		}
		return false;
	}

	private void MouseClicked(MouseEvent g) {
		// TODO Auto-generated method stub;
	}

	public void changeOrder(){
		int i = exercises.size();
		if(i > 0) {
			ExercisesInterfaceJonathanZ toMove = exercises.get(i);
			exercises.set(i, exercises.get(i-1));
			exercises.set(i-1, toMove);
		}
	}
	
	public void editExercises(){
		System.out.println("What would you like to edit within the exercise?");
		if(getX() == 100 && getY() == 100){
			removeExercise();
		}else{
			changeOrder();
		}
		
	}
	
	private void removeExercise() {
		System.out.println("Which exercise would you like to remove?(Choose from the number corresponding to exercise)");
		int i =2;
		exercises.remove(i);
	}

	private int getY() {
		return y;
	}

	private int getX() {
		return x;
	}

	public void FinishExercise(){
		for (ExercisesInterfaceJonathanZ temp : exercises) {
			if(value == 2){
				exercises.remove(temp);
			}
		}
	}
	
	public boolean isHovered(){
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}

	@Override
	public void getExercises() {
	//	exercises.add(NewExercise.getExercises());
	}
}
