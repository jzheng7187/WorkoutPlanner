/**
 * 
 */
package workoutPlanner;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import gui.components.Action;
import gui.components.Visible;
import gui.screens.ClickableScreen;

/**
 * @author Jonathan Zheng
 *
 */
public class JonathanPlans extends ClickableScreen implements ExercisesInterfaceJonathanZ, MouseListener{

	private ArrayList<String> exercises = NewExercise.getMyExercises();
	private int value;
	private int x;
	private int y;
	private int input;
	private Color color;
	private String b;
	private Object displayColor;
	private boolean highlight;
	private Action action;
	public JonathanPlans(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	
	private void runMethods(){
		for(int i = 0; i < exercises.size(); i++){	
			b = exercises.get(i);
		}
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
//		int i = exercises.size();
//		if(i > 0) {
//			String toMove = exercises.get(i);
//			exercises.set(i, exercises.get(i-1));
//			exercises.set(i-1, toMove);
//		}
		for(int i = 0; i < exercises.size(); i++){
			Color[] colors = {Color.red, Color.blue, Color.yellow, Color.green};
			int j = exercises.indexOf(exercises.get(i));
			b.setAction(new Action(){

				@Override
				public void act() {
					b.highlight();
				}
				
			}
					);
			int k = exercises.indexOf(exercises.get());
			Collections.swap(exercises, j, k);
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
	
	public void dim() {
		displayColor = Color.gray;
		highlight = false;
		update();
	}
	private void removeExercise() {
		if(isHovered()){
			b.highlight();
			NewExercise.getMyExercises().remove(b);
		}
	}

	private int getY() {
		return y;
	}

	private int getX() {
		return x;
	}
	
	public boolean isHovered(){
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}

	public void act() {
		action.act();
	}

	@Override
	public void highlight() {
		if(color != null) 
			displayColor = color;
		highlight = true;
		update();
	}
	
	public void setAction(Action action) {
		this.action = action;
	}

	public void setColor(Color color) {
		this.color = color;
		displayColor = color;
		update();
	}
}
