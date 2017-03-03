/**
 * 
 */
package workoutPlanner;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextArea;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import gui.components.Action;
import gui.components.Clickable;
import gui.components.Visible;
import gui.screens.ClickableScreen;

/**
 * @author Jonathan Zheng
 *
 */
public class JonathanPlans extends ClickableScreen implements ExercisesInterfaceJonathanZ, MouseListener{

	private static ArrayList<String> exercises = NewExercise.getMyExercises();
	private int value;
	private int x;
	private int y;
	private int input;
	private Color color;
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
	
	private static boolean isClicked() {
		if(isHovered()){
			return true;
		}
		return false;
	}

	private void MouseClicked(MouseEvent g) {
		for(Clickable c: getClickables()){
			if(c.isHovered(g.getX(), g.getY())){
				c.act();
				break;
			}
		}
	}

	public static void changeOrder(){
		String[] swap = new String[2];
		for(int i = 0; i < swap.length; i++){
			for(int k = 0; k < exercises.size(); k++){
				if(isHovered() && isClicked()){
					swap[i] += exercises.indexOf(exercises.get(k));
					Collections.swap(exercises, i, k);
				}
			}
		}
	}
	
	public void dim() {
		displayColor = Color.gray;
		highlight = false;
		update();
	}
	
	public static void removeExercise() {
		int[] remove = new int[1];
		for(int i = 0; i < remove.length; i++){
			for(int j = 0; j < exercises.size(); j++){
				if(isClicked()){
					remove[i] += exercises.indexOf(exercises.get(j));
					exercises.remove(remove[i]);
				}
			}
		}
	}

	
	private int getY() {
		return y;
	}

	private int getX() {
		return x;
	}
	
	public boolean isHovered(){
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+ getHeight();
	}

	public void act() {
		action.act();
	}

	@Override
	public void highlight() {
//		if(color != null) 
//		displayColor = color;
//		highlight = true;
//		update();
		 DefaultHighlighter.DefaultHighlightPainter highlightPainter = 
			        new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
			    textPane.getHighlighter().addHighlight(0, exercises.get(i).length, 
			            highlightPainter);
		//trouble
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
