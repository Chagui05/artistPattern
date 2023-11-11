package logic;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingUtilities;

import model.PolygonPainter;
import view.ShapesPanel;

public class PolygonStrat implements IDrawableStrat {
	PolygonPainter polygon;
	
	public PolygonStrat(PolygonPainter polygon) {
		this.polygon = polygon;
	}

	@Override
	public void draw(ShapesPanel panel) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("hii");
                panel.addComponent(PolygonStrat.this); 
            }
        });
		//		System.out.println("hii");
//		panel.addComponent(this);
	}

	@Override
	public void paintComp(Graphics g) {
//		System.out.println("drawing a polygon");
//		System.out.println(polygon.getX());
//		System.out.println(polygon.getY());	
//		System.out.println(polygon.getSides());	
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(polygon.getColor());

        int[] xPoints = new int[polygon.getSides()];
        int[] yPoints = new int[polygon.getSides()];

        for (int i = 0; i < polygon.getSides(); i++) {
            double angle = 2 * Math.PI * i / polygon.getSides();
            xPoints[i] = polygon.getX() + (int) (polygon.getSize() * Math.cos(angle));
            yPoints[i] = polygon.getY() + (int) (polygon.getSize() * Math.sin(angle));
        }

        g.fillPolygon(xPoints, yPoints, polygon.getSides());
    }
	
}
