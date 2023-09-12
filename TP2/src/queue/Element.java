package queue;

import java.util.ArrayList;

public abstract class Element { // super class for EmptyElement and BusyElement

    protected ArrayList<Object> internalQueue;

	Element Empty = new EmptyElement();

    // these methods should be abstract
    public Element() {
		internalQueue = new ArrayList<Object>();
	}
	
	public boolean isEmpty() {
		return true;
	}

	public Queue add( Object cargo ) {
		return new BusyQueue().add( cargo );
	}

	public Object take() {
		throw new Error("Queue is empty");
	}

	public Object head() {
		throw new Error("Queue is empty");
	}

	public int size() {
		return 0;
	}

}
