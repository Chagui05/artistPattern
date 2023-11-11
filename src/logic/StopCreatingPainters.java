package logic;

import thread.MainThread;

public class StopCreatingPainters implements IDrawObserver {
	private int numberOfPainters;
	private MainThread mThread;

	public StopCreatingPainters(int painters, MainThread thread) {
		this.numberOfPainters = painters;
		this.mThread = thread;
	}
	
	@Override
	public void update(Event type) {
		System.out.println("painters: " +numberOfPainters);
		if(numberOfPainters < 0) {
			mThread.setCreatingProcces(false);
		}	
		else {
			numberOfPainters--;
		}
	}

}