package iterator;


import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;


public class Iter<T> {
    private List<T> elements;
    private Iterator<T> iter;

    public Iter(List<T> pList) {
        this.elements = new CopyOnWriteArrayList<>(pList);
        this.iter = elements.iterator();
    }

    public T getNext() {
        if (hasNext()) {
            return iter.next();
        } else {
            iter = elements.iterator();
            return iter.next();
        }
    }

    public boolean hasNext() {
        return iter.hasNext();
    }

    public void addElement(T element) {
        elements.add(element);
    }
}
