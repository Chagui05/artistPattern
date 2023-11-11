package logic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import model.LinePainter;
import view.PolygonWindow;

public class LineStrat implements IDrawableStrat{
	private LinePainter line;
	private PolygonWindow view = PolygonWindow.getInstance();
	
	public LineStrat(LinePainter line) {
		this.line = line;
	}
	@Override
	public void draw(Graphics g) {
		System.out.println("drawing a line");
		System.out.println(line.getSize());
		System.out.println(line.getThickness());
		paintComponent(g);
	}
	
	 protected void paintComponent(Graphics g) {
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(line.getColor());
	        g2d.setStroke(new BasicStroke(line.getThickness()));
	        g2d.drawLine(50, 50, 50 + line.getSize(), 50);
	 }
}
