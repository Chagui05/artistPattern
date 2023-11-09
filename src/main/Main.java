package main;

import java.awt.Color;

import javax.swing.SwingUtilities;

import controller.WindowController;
import model.*;
import view.PolygonWindow;

public class Main {

	public static void main(String[] args) {
		
		int redValue = 255; // Maximum value for red in RGB
		int greenValue = 0; // No green component
		int blueValue = 0;  // No blue component

		Color red = new Color(redValue, greenValue, blueValue);
		
		DotPainter circle = new DotPainter(200,200,40, red);
		PolygonPainter poly = new PolygonPainter(100, 100, 33,5,red);
		LinePainter line = new LinePainter(10000, 2, 900, 1, red);
		
		circle.drawByPainter();
		System.out.println(" ");
		poly.drawByPainter();
		System.out.println(" ");
		line.drawByPainter();

		PolygonWindow window = new PolygonWindow();
		
		WindowController control = new WindowController(window);
		window.setVisible(true);
	
	}

}
