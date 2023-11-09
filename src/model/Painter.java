package model;

import java.awt.Color;

import logic.IDrawableStrat;

public abstract class Painter {
	protected Color color;
	protected int x,y; //position 
	protected IDrawableStrat drawer;
	
	public Painter(int x, int y,Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void drawByPainter() {
		drawer.draw();
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
	
}
