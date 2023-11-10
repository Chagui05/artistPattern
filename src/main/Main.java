package main;

import java.awt.Color;
import java.util.Vector;

import javax.swing.SwingUtilities;

import controller.WindowController;
import logic.PainterFac;
import model.*;
import thread.MainThread;
import view.PolygonWindow;

public class Main {

	public static void main(String[] args) {

		Color red = new Color(255,0,0);
		Color green = new Color(0, 255, 0);
		Color blue = new Color(0, 0, 255);

		Vector<Color> colors = new Vector<>();
		colors.add(red);
		colors.add(green);
		colors.add(blue);
		
		Vector<Integer> sides = new Vector<>();
		sides.add(3);
		sides.add(6);
		sides.add(4);
		sides.add(5);
		Vector<Integer> thicknesses = new Vector<>();
		thicknesses.add(30);
		thicknesses.add(5);
		thicknesses.add(15);
		
		
		
		DotPainter circle = new DotPainter(200,200,40, red);
		PolygonPainter poly = new PolygonPainter(100, 100, 33,5,red);
		LinePainter line = new LinePainter(10000, 2, 900, 1, red);
		PolygonWindow window = new PolygonWindow();
		
		PainterFac factory = PainterFac.getInstance();
		factory.addColors(colors);
		factory.addLineThickness(thicknesses);
		factory.addPolygonSides(sides);
		
		MainThread mThread = new MainThread(circle, 10, 20);
		mThread.start();
		
//		WindowController control = new WindowController(window);
//		window.setVisible(true);
	
	}

}
