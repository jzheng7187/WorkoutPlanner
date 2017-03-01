package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class ThemedButton extends Button {

	private Color color;
	private Action action;
	private Color textColor;
	
	public ThemedButton(int x, int y, int w, int h, String text, Color color, Action action, Color c) {
		super(x, y, w, h, text, color, action);
		this.action = action;
		this.color = color;
		this.textColor = c;
		update();
	}
	
	@Override
	public void update(Graphics2D g){
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 25, 25);
		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		FontMetrics fm = g.getFontMetrics();
		if(getText() != null){
			g.setColor(textColor);
			String t = getText();
			int cutoff = t.length();
			while(cutoff > 0 && fm.stringWidth(t) > getWidth()){
				cutoff --;
				t = t.substring(0,cutoff); 
			}
			g.drawString(t, (getWidth()-fm.stringWidth(t))/2, (getHeight()+fm.getHeight()-fm.getDescent())/2);
//			g.drawString(getText(), 4, (getHeight()-5));
		}	
	}
}
