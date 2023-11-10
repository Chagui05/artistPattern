package thread;

import java.util.Vector;

import iterator.Iter;
import logic.*;
import model.Painter;

public class MainThread extends Thread{
	private Iter<PainterThread> painters;
	private ObserverNotifier notifier;
	private PainterFac factory;
	private boolean running;
	private boolean creatingProcces;

	public MainThread(Painter fPainter,int amountOfDrawings, int amountOfPainters) {
		this.running = true;
		this.creatingProcces = true;
		notifier = ObserverNotifier.getInstance();
		painters = new Iter<PainterThread>(new Vector<PainterThread>()); 
		factory = PainterFac.getInstance();
		
		PainterThread firstPainter = new PainterThread(fPainter);
		firstPainter.start();
		painters.addElement(firstPainter);
		notifier.addObserver(Event.NEXTPAINTER, firstPainter);
		notifier.addObserver(Event.DRAWINGMADE, new StopCreatingDraws(amountOfDrawings, this));
		notifier.addObserver(Event.PAINTERCREATED, new StopCreatingPainters(amountOfPainters, this));
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}

	public void setCreatingProcces(boolean creatingProcces) {
		this.creatingProcces = creatingProcces;
	}


	@Override
	public void run() {
		while(running) {
			System.out.println("run run");
			if(creatingProcces) {
				Painter newPaint = painters.getNext().getPainter();
				System.out.println("paint" );
				System.out.println(newPaint == null);
				PainterThread newPainter = new PainterThread(newPaint) ;//poner painter actual
				painters.addElement(newPainter);
				notifier.addObserver(Event.NEXTPAINTER, newPainter);
				newPainter.start();
				
				notifier.notify(Event.PAINTERCREATED);
				System.out.println("sirvio");
			}
			
			painters.getNext().update(Event.NEXTPAINTER);
			System.out.println("trying to draw");
			notifier.notify(Event.DRAWINGMADE);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
