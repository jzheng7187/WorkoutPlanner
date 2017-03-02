package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.TextLabel;

public class ThemedTextLabel extends TextLabel {

	private Color color;
	
	public ThemedTextLabel(int x, int y, int w, int h, String text, Color c) {
		super(x, y, w, h, text);
		this.color = c;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();//delete previous text
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(color);

		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		if(getText() != null){
			g.drawString(getText(), 4, (getHeight()-5));
		}	
	}
	
}
