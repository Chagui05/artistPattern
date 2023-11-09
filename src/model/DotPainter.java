package model;

import java.awt.Color;

import logic.*;

public class DotPainter extends Painter {
	private int size;
	
	public DotPainter(int x, int y,int size, Color color) {
		super(x, y, color);
		this.size = size;
		this.drawer = new DotStrat(this);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
