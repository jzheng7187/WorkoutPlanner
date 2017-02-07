package workoutPlanner;

import java.awt.Color;

import gui.components.Action;
import gui.components.Button;

public class NewExercise extends Button {

	private Color color;
	private Action action;
	
	public NewExercise(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		this.color = color;
		this.action = action;
		update();
	}

}
