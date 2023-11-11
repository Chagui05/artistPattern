package logic;

import java.awt.Graphics;

import model.PolygonPainter;

public class PolygonStrat implements IDrawableStrat {
	PolygonPainter polygon;
	
	public PolygonStrat(PolygonPainter polygon) {
		this.polygon = polygon;
	}

	@Override
	public void draw(Graphics g) {
		System.out.println("drawing a polygon");
		System.out.println(polygon.getX());
		System.out.println(polygon.getY());	
		System.out.println(polygon.getSides());	
	}
	

}
