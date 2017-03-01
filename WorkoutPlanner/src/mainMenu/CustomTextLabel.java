package mainMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;

public class CustomTextLabel extends Component {
	private String text;
	private String font;
	private int size;
	private Color color;
	

	public CustomTextLabel(int x, int y, int w, int h, String text,Color color) {
		super(x, y, w, h);
		this.text = text;
		this.font = "Courier New";
		this.size = 20;
		this.color = color;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();//delete previous text
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(color);
		g.setFont(new Font(font, Font.PLAIN, size));
		if(text != null){
			g.drawString(text, 4, (getHeight()-5));
		}	
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		update();
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
		update();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		update();
	}


}
