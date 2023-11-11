package logic;

import java.awt.Graphics;

import model.DotPainter;

public class DotStrat implements IDrawableStrat{
	private DotPainter dot;
	
	public DotStrat(DotPainter dot) {
		this.dot = dot;
	}
	public void draw(Graphics g) {
		System.out.println("drawing a Dot");
		System.out.println(dot.getX());
		System.out.println(dot.getY());	
		System.out.println(dot.getSize());	
	}

}
