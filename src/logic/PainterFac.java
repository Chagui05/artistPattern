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
		System.out.println(size+" "+x+" "+prevPainter.getType());
		
		if(prevPainter.getType() == PainterType.DOT) {
			x += 100;
			y += 100;
			size += 10;
			result = new LinePainter(x,y,lineThickness.getNext(),size,colors.getNext());
		}
		else if(prevPainter.getType()== PainterType.LINE){
			x += 100;
			y += 100;
			if(x<0) {
				x= (x+(-x))+30;
			}
			if (y<0) {
				y = (y+(-y))+30;
			}
			size += 30;
			result = new PolygonPainter(x, y, size,polygonSides.getNext(),colors.getNext());
		}
		else if(prevPainter.getType()== PainterType.POLYGON){
			x += 60;
			y -=50;
			if (y<0) {
				y = (y+(-y))+30;
			}
			size -=10;
			if (size <0) {
				size = (size+(-size))+30;
			}
			result = new DotPainter(x, y, size,colors.getNext());
		}
		System.out.println("result "+size+" "+x+" "+" "+y+" "+prevPainter.getType());
		return result;
	}
	
}
