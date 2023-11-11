package logic;

import thread.MainThread;

public class StopCreatingDraws implements IDrawObserver {
	private int numberOfDrawings;
	private MainThread mThread;

	public StopCreatingDraws(int draw, int paintersAmount,MainThread thread) {
		this.numberOfDrawings = draw*paintersAmount;
		this.mThread = thread;
	}
	
	@Override
	public void update(Event type) {
		System.out.println("drawings: " +numberOfDrawings);
		if(numberOfDrawings <= 0) {
			mThread.setRunning(false);
			try {
				mThread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		else {
			numberOfDrawings--;
		}
	}

}
