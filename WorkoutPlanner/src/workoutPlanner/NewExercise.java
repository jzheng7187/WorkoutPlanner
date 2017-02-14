package workoutPlanner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;

public class NewExercise extends Button implements MouseListener{
	
	//exercises ArrayList has all the exercises
	private ArrayList<ButtonInterfaceMatthewN> exercises;
	//private ArrayList<ButtonInterfaceMatthewN> ;
	private boolean clicked;
	private int value;
	private ButtonInterfaceMatthewN clickedGraphic;
	
	//new exercise adds exercises into a list
	public NewExercise(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}
	public void update(Graphics2D g){
		for(int i = 0; i < exercises.length(); i++){
			value = 1;
			clicked = false;
		}
		addExercise(exercises);
		exercises.remove(clickedGraphic);
	}
	@Override
	public void mouseClicked(MouseEvent g) {
		return 
		
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
	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}
	
	//highlights picture when mouse hovers over image
	public boolean highlight(){
		for(int i = 0; i <  exercises.length(); i++)
		if(isHovered(getX(),getY())){
			return exercises[i].setColor(new Color(255, 255, 255, 25));
		}else{
			return false;
		}
	}
	public boolean isClicked(){
		return true;
	}
	
	
	public void addExercise(ArrayList<ButtonInterfaceMatthewN> g){
		boolean clickedAgain = false;
		if(isClicked()){
			System.out.println("You have already chosen this exercise.");
			g.highlight();
		}else{
			exercises.add(clickedGraphic);
		}
	}
}
