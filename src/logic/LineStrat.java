package logic;

import model.LinePainter;

public class LineStrat implements IDrawableStrat{
	private LinePainter line;
	
	public LineStrat(LinePainter line) {
		this.line = line;
	}
	@Override
	public void draw() {
		System.out.println("drawing a line");
		System.out.println(line.getSize());
		System.out.println(line.getThickness());	
	}

}
