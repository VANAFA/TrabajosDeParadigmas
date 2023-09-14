package queue;

import java.util.ArrayList;
// TODO: pasar a formato de eclipse
public class Queue {

	private ArrayList<Element> internalQueue =  new ArrayList<Element>();
	private Element element;

	public Queue() {
		internalQueue.add( new EmptyElement() );
	}

	public boolean isEmpty() {
		element = internalQueue.get( size() );
		return element.isEmpty();
	}

	public Queue add( Object cargo ) {
		element = new BusyElement();
		internalQueue.add( element );
		element.add( cargo );
		return this;
	}

	public Object take() {
		System.out.println( "size: " + size() + " " + internalQueue); // debug only TODO: remove
		element = internalQueue.remove( 1 % ( size() + 1 ) );
		return element.head();
	}

	public Object head() {
		element = internalQueue.get( 1 % ( size() + 1 ) );
		return element.head();
	}

	public int size() {
		return internalQueue.size() - 1;
	}
}