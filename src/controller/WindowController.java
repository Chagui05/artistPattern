package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PolygonWindow;

public class WindowController  {
	private PolygonWindow view;
	
	public WindowController(PolygonWindow view) {
		this.view = view;
		this.view.startDrawing(new DrawButtonListener());
		System.out.println("aaa");
	}
	
	public class DrawButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int painters,drawings;
			
			try {
				painters = view.getPainters();
				drawings = view.getDrawings();				
			}
			catch(NumberFormatException ex){
				System.out.println("insert number vaules");
			}
		}

	}

}
