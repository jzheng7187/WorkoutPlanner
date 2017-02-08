package workoutPlanner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.components.Action;
import gui.components.Button;

public class NewExercise extends Button implements MouseListener{
	
	private int exercise;
	
	public NewExercise(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}
	public void update(Graphics2D g){
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
}
