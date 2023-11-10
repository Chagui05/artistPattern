package logic;

import java.awt.Color;
import java.util.Vector;

import iterator.Iter;
import model.*;

public class PainterFac {
	private Iter<Color> colors;
	private Iter<Integer> polygonSides;
	private Iter<Integer> lineThickness;
	private static volatile PainterFac instance;
	
	
	private PainterFac() {
	}
	
	public static PainterFac getInstance() {
		PainterFac result = instance;
		
		if(result == null) {
			synchronized(PainterFac.class) {
				result = instance;
				if(result == null) {
					instance = result = new PainterFac();
				}
			}
		}
		return result; 
	}
	
	
	public void addColors(Vector<Color> colors) {
		this.colors= new Iter<Color>(colors);
	}
	
	public void addPolygonSides(Vector<Integer> sides) {
		this.polygonSides= new Iter<Integer>(sides);
	}
	
	public void addLineThickness(Vector<Integer> thick) {
		this.lineThickness= new Iter<Integer>(thick);
	}
	
	
	public Painter create(Painter prevPainter) {
		Painter result = null;
		int size = prevPainter.getSize();
		int x = prevPainter.getX();
		int y = prevPainter.getY();
		Color color = prevPainter.getColor();
		
		if(prevPainter.getType() == PainterType.DOT) {
			x += 30;
			y += 40;
			size += 10;
			result= new LinePainter(x,y,lineThickness.getNext(),size,colors.getNext());
		}
		else if(prevPainter.getType()== PainterType.LINE){
			x -= 20;
			y -= 30;	
			size += 30;
			result = new PolygonPainter(x, y, size,polygonSides.getNext(),colors.getNext());
		}
		else if(prevPainter.getType()== PainterType.POLYGON){
			x += 30;
			y -=10;
			size -=10;
			result = new DotPainter(x, y, size,colors.getNext());
		}
		
		return result;
	}
	
}
