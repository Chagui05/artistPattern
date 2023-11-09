package model;

import java.awt.Color;

import logic.PolygonStrat;

public class PolygonPainter extends Painter{
	private int radius;
	private int sides;

	public PolygonPainter(int x, int y, int radius,int sides, Color color) {
		super(x, y, color);
		this.drawer = new PolygonStrat(this);
		this.radius = radius;
		this.sides = sides;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
	
}
