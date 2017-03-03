package gui.components;

public class ClickableGraphic extends Graphic implements Clickable {
	
	private Action action;

	public ClickableGraphic(int x, int y, String imageLocation, Action action) {
		super(x, y, imageLocation);
		this.action = action;
	}

	public ClickableGraphic(int x, int y, int w, int h, String imageLocation, Action action) {
		super(x, y, w, h, imageLocation);
		this.action = action;
	}

	public ClickableGraphic(int x, int y, double scale, String imageLocation, Action action) {
		super(x, y, scale, imageLocation);
		this.action = action;
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}

	public void setAction(Action a){
		this.action = a;
	}
	
	@Override
	public void act() {
		action.act();
	}

}
