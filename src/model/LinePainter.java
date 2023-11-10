package model;

import java.awt.Color;

import logic.LineStrat;

public class LinePainter extends Painter  {
	
	 private int thickness;
	 private PainterType type;
	
	public LinePainter(int x, int y, int thickness, int size, Color color) {
		super(x, y,size,color);
		this.thickness = thickness;
		this.drawer = new LineStrat(this);
		type = PainterType.LINE;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
}
