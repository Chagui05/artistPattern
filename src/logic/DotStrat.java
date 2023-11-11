package logic;

import java.awt.Graphics;

import model.DotPainter;
import view.ShapesPanel;

public class DotStrat implements IDrawableStrat{
	private DotPainter dot;
	
	public DotStrat(DotPainter dot) {
		this.dot = dot;
	}
	public void draw(ShapesPanel panel) {
		System.out.println("hii");
		panel.addComponent(this);
	}
	@Override
	public void paintComp(Graphics g) {
		System.out.println("drawing a Dot");
		System.out.println(dot.getX());
		System.out.println(dot.getY());	
		System.out.println(dot.getSize());
	}

}
