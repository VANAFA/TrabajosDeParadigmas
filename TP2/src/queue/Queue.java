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

	public Object take() { // fix, preguntar Emilio/Julio
		element = internalQueue.remove( 1 );
		return element.take();
	}

	public Object head() { // fix, preguntar Emilio/Julio
		element = internalQueue.get( 1 );
		return element.head();
	}

	public int size() {
		return internalQueue.size() - 1;
	}
}