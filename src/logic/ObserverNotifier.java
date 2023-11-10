package logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ObserverNotifier {
	private final Map<Event, Vector<IDrawObserver>> observers;
	private static volatile ObserverNotifier instance;
	
	private ObserverNotifier() {
		observers = new HashMap<>();
		Arrays.stream(Event.values()).forEach(event ->
		observers.put(event, new Vector<IDrawObserver>())
		);
	}
	
	public static ObserverNotifier getInstance() {
		ObserverNotifier result = instance;
		
		if(result == null) {
			synchronized(ObserverNotifier.class) {
				result = instance;
				if(result == null) {
					instance = result = new ObserverNotifier();
				}
			}
		}
		return result; 
	}
	
	public void addObserver(Event type, IDrawObserver observer) {
		observers.get(type).add(observer);
	}
	
	public void notify(Event type) {
		observers.get(type).forEach(observer ->
		observer.update(type));
	}
}
