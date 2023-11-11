package thread;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import iterator.Iter;
import logic.*;
import model.Painter;
import view.ShapesPanel;

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
		System.out.println("first painter"+firstPainter.id);////fepoo
		painters.addElement(firstPainter);
		notifier.addObserver(Event.NEXTPAINTER, firstPainter);
		notifier.addObserver(Event.DRAWINGMADE, new StopCreatingDraws(amountOfDrawings,amountOfPainters, this));
		notifier.addObserver(Event.PAINTERCREATED, new StopCreatingPainters(amountOfPainters, this));
		firstPainter.start();
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
			PainterThread oldPainter = painters.getNext();
			System.out.println("old painter"+oldPainter.id);////fepoo
			if(creatingProcces) {
				System.out.println("paint: "+(oldPainter.getPainter() == null));
				PainterThread newPainter = new PainterThread(oldPainter.getPainter());
				System.out.println("New painter"+newPainter.id+(newPainter.getPainter().getSize()));////fepoo
				painters.addElement(newPainter);;
				notifier.addObserver(Event.NEXTPAINTER, newPainter);
				newPainter.start();
				notifier.notify(Event.PAINTERCREATED);
				System.out.println("sirvio");
			}
			
			oldPainter.update(Event.NEXTPAINTER);
			notifier.notify(Event.DRAWINGMADE);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" ");
		}
		
		for (IDrawableStrat shape : ShapesPanel.getInstance().getShapes()) {
        	System.out.println(1);
        }
	}
}
