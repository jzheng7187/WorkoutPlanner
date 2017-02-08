package mainMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import  java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Action;
import gui.components.TextLabel;

public class CustomButton extends TextLabel {
	private Color color;
	private Action action;
	private Color textColor;

	public CustomButton(int x, int y, int w, int h, String string, Color color, Action action,Color textColor) {
		super(x, y, w, h, string);
		this.action = action;
		this.color = color;
		this.textColor = textColor;
		update();
		// TODO Auto-generated constructor stub
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
		update();
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	
	
	
	public void update(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);//not pixel rendering hint
		g.setColor(color);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		g.setFont(new Font(getFont(),Font.PLAIN,getSize()));//font is private
		if(getText()!=null){
			FontMetrics fm=g.getFontMetrics();
			g.setColor(textColor);
			String t = getText();
			int cutoff = t.length();
			while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
				cutoff--;
				t=t.substring(0, cutoff);
				}
			g.drawString(t, (getWidth()-fm.stringWidth(t))/2,(getHeight()+fm.getHeight()-fm.getDescent())/2);
			}
			
	
		
	}
	
	public boolean isHovered(int x, int y) {
		
		return x>getX() && x<getX()+getWidth() && y > getY() && y < getY() + getHeight();
	}
	public void act(){
		action.act();
	}
}
