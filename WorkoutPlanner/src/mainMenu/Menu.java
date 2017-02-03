package mainMenu;

import java.awt.Color;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class Menu extends ClickableScreen {
	private Button timer;
	private Button exercises;
	private Button stop;
	public static final int MARGINX=500;
	public static final int MARGINY=100;
	public static final int WIDTH=100;
	public static final int HEIGHT=60;
	public static final int SPACE=80;
	public static final Color BUTTON_COLOR=  new Color(0,255,0);

	public Menu(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		timer = new Button(MARGINX, MARGINY, WIDTH, HEIGHT, "Timer",BUTTON_COLOR , new Action(){

			@Override
			public void act() {
				// TODO Auto-generated method stub

			}
		});
	}


}
