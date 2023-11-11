package logic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.SwingUtilities;

import model.DotPainter;
import view.ShapesPanel;

public class DotStrat implements IDrawableStrat{
	private DotPainter dot;
	
	public DotStrat(DotPainter dot) {
		this.dot = dot;
	}
	public void draw(ShapesPanel panel) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("hii");
                panel.addComponent(DotStrat.this); 
            }
        });	
//		System.out.println("hii");
//		panel.addComponent(this);
	}
	@Override
	public void paintComp(Graphics g) {
		System.out.println("drawing a Dot");
//		System.out.println(dot.getX());
//		System.out.println(dot.getY());	
//		System.out.println(dot.getSize());
		Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(dot.getX(), dot.getY(), 10, 10);

        g2d.setColor(dot.getColor());
        g2d.fill(circle);
	}

}
