package gui.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawLines extends Component{

	private Color color;
	
	public DrawLines (int x, int y, int w, int h, Color color){
		super(x, y, w, h);
		this.color = color;
		update();
		}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawRect(0,10,1000,15);
		g.fillRect(0, 10, 1000, 15);
		
		g.drawRect(10,0,15,1000);
		g.fillRect(10, 0, 15, 1000);

	}
}


