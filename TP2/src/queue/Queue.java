package queue;

import java.util.ArrayList;
// TODO: pasar a formato de eclipse
public class Queue {

	private ArrayList<Element> internalQueue =  new ArrayList<Element>();
	private static Element element;

	public Queue() {
		internalQueue.add( new EmptyElement() );
	}

	public boolean isEmpty() {
		element = internalQueue.get( size() );
		return element.isEmpty();
	}

	public Queue add( Object cargo ) {
		element = new BusyElement();
		// internalQueue.add( element ); // add the new element to index: 1
		internalQueue.add( 1, element );
		element.add( cargo );
		return this;
	}

	public Object take() {
		element = internalQueue.remove( size() );
		return element.head();
	}

	public Object head() {
		element = internalQueue.get( size() );
		return element.head();
	}

	public int size() {
		return internalQueue.size() - 1;
	}
}