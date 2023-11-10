package model;

import java.awt.Color;

import logic.PolygonStrat;

public class PolygonPainter extends Painter{
	private int sides;

	public PolygonPainter(int x, int y,int size,int sides, Color color) {
		super(x, y,size, color);
		this.drawer = new PolygonStrat(this);
		this.sides = sides;
		type = PainterType.POLYGON;
	}


	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
	
}
