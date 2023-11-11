package model;

import java.awt.Color;

import logic.*;

public class DotPainter extends Painter {
	
	public DotPainter(int x, int y,int size, Color color) {
		super(x, y,size, color);
		this.drawer = new DotStrat(this);
		type = PainterType.DOT;
	}
	
}
