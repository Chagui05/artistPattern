package logic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingUtilities;

import model.LinePainter;
import view.ShapesPanel;

public class LineStrat implements IDrawableStrat{
	private LinePainter line;;
	
	public LineStrat(LinePainter line) {
		this.line = line;
	}
	@Override
	public void draw(ShapesPanel panel) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("hii");
                panel.addComponent(LineStrat.this); 
            }
        });
	}
	
	 public void paintComp(Graphics g) {
//		System.out.println("drawing a line");
//		System.out.println(line.getSize());
//		System.out.println(line.getThickness());
			
        Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(line.getColor());
	    g2d.setStroke(new BasicStroke(line.getThickness()));
	    g2d.drawLine(50, 50, 50 + line.getSize(), 50);
	 }
}
