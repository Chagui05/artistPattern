package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Painter;
import thread.MainThread;
import view.PolygonWindow;

public class WindowController  {
	private PolygonWindow view;
	private Painter initiatingFigure;
	
	public WindowController(PolygonWindow view, Painter painter) {
		this.view = view;
		this.view.startDrawing(new DrawButtonListener());
		this.initiatingFigure = painter;
		System.out.println("aaa");
	}
	
	public class DrawButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int painters,drawings;
			
			try {
				painters = view.getPainters();
				drawings = view.getDrawings();
				MainThread mThread = new MainThread(initiatingFigure, drawings, painters);
				mThread.start();
			}
			catch(NumberFormatException ex){
				System.out.println("insert number vaules");
			}
		}

	}

}
