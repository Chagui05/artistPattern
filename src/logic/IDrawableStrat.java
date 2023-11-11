package logic;


import java.awt.Graphics;

import view.ShapesPanel;

public interface IDrawableStrat {


	public void paintComp(Graphics g);
	public void draw(ShapesPanel panel);
}
