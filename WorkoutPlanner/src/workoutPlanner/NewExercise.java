package workoutPlanner;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Action;
import gui.components.Button;

public class NewExercise extends Button {
	
	private int exercise;
	
	public NewExercise(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}
	public void update(Graphics2D g){
		
	}
}
