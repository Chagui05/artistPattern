package logic;

import thread.MainThread;

public class StopCreatingDraws implements IDrawObserver {
	private int numberOfDrawings;
	private MainThread mThread;

	public StopCreatingDraws(int draw, MainThread thread) {
		this.numberOfDrawings = draw;
		this.mThread = thread;
	}
	
	@Override
	public void update(Event type) {
		System.out.println("drawings: " +numberOfDrawings);
		if(numberOfDrawings < 0) {
			mThread.setCreatingProcces(false);
		}	
		else {
			numberOfDrawings--;
		}
	}

}
