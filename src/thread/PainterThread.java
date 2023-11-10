package thread;

import logic.Event;
import logic.IDrawObserver;
import logic.PainterFac;
import model.Painter;

public class PainterThread extends Thread implements IDrawObserver {
	
	private boolean turnToDraw;
	private boolean drawing = true;
	private Painter painter;

	public PainterThread(Painter pPainter) {
		PainterFac factory = PainterFac.getInstance();
		painter = factory.create(pPainter);
		this.turnToDraw = false;
	}
	public void turnOffDrawing() {
		drawing = false;
	}
	
	@Override
	public void update(Event type) {
		System.out.println("updated");
			this.turnToDraw = true;
	}
	
	public void tryingToDraw() {
		if(turnToDraw) {
			painter.drawByPainter();
			turnToDraw = false;
		}
	}
	public Painter getPainter() {
		return painter;
	}
	public void run() {
		
		while(drawing) {
			tryingToDraw();
			System.out.println("in a subThread "+(this.turnToDraw == false));
			
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
