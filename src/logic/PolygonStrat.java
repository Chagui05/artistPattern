package logic;

import java.awt.Graphics;

import model.PolygonPainter;
import view.ShapesPanel;

public class PolygonStrat implements IDrawableStrat {
	PolygonPainter polygon;
	
	public PolygonStrat(PolygonPainter polygon) {
		this.polygon = polygon;
	}

	@Override
	public void draw(ShapesPanel panel) {
		System.out.println("hii");
		panel.addComponent(this);
	}

	@Override
	public void paintComp(Graphics g) {
		System.out.println("drawing a polygon");
		System.out.println(polygon.getX());
		System.out.println(polygon.getY());	
		System.out.println(polygon.getSides());	
	}
	
}
