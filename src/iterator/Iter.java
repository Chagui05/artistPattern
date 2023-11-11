package iterator;


import java.util.Iterator;	
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;


public class Iter<T> {
    private volatile List<T> elements;
    private volatile Iterator<T> iter;

    public Iter(List<T> pList) {
        this.elements = new CopyOnWriteArrayList<>(pList);
        this.iter = elements.iterator();
    }

    public synchronized T getNext() {
        if (hasNext()) {
            return iter.next();
        } else {
            iter = elements.iterator();
            return getNext();
        }
    }

    public synchronized boolean hasNext() {
        return iter.hasNext();
    }

    public synchronized void addElement(T element) {
        elements.add(element);
    }
}
