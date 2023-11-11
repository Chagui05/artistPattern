package model;

import java.awt.Color;

import javax.swing.SwingUtilities;

import logic.IDrawableStrat;
import view.ShapesPanel;

public abstract class Painter {
	protected Color color;
	protected int x,y; //position 
	protected int size;
	protected PainterType type;
	protected IDrawableStrat drawer;
	
	public Painter(int x, int y,int size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	public void drawByPainter() {
		SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            ShapesPanel panel = ShapesPanel.getInstance();
	            drawer.draw(panel);
	        }
	    });
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public PainterType getType() {
		return type;
	}
	
}
