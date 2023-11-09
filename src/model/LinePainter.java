package model;

import java.awt.Color;

import logic.LineStrat;

public class LinePainter extends Painter  {
	
	 private int thickness;
	 private int size;
	
	public LinePainter(int x, int y, int size, int thickness, Color color) {
		super(x, y, color);
		this.size = size;
		this.thickness = thickness;
		this.drawer = new LineStrat(this);
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
