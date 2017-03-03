/**
 * 
 */
package gui.components;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author Alam
 *
 */
public class Rect extends Component {

	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Rect(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gui.components.Component#update(java.awt.Graphics2D)
	 */
	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());

	}

}
