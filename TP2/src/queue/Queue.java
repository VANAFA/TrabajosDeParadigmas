package queue;

import java.util.ArrayList;

public class Queue {

	private ArrayList<Element> internalQueue =  new ArrayList<Element>();

	private Element element;

	public Queue() {
		element = new EmptyElement();
		internalQueue.add( element );
	}

	public boolean isEmpty() {
		element = internalQueue.get( this.size() );
		return element.isEmpty();
	}

	public Queue add( Object cargo ) {
		element = new BusyElement();
		internalQueue.add( element );
		element.add( cargo );
		return this;
	}

	public Object take() { // fix this
		element = internalQueue.remove( this.size() );
		return element.head();
	}

	public Object head() {
		element = internalQueue.get( this.size() );
		return element.head();
	}

	public int size() {
		return internalQueue.size() - 1;
	}
}