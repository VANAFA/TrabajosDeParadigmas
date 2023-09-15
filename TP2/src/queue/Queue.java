package queue;

import java.util.ArrayList;

public class Queue {

	private ArrayList<Element> internalQueue =  new ArrayList<Element>();

	public Queue() {
		internalQueue.add( new EmptyElement() );
	}
	
	public boolean isEmpty() {
		return internalQueue.get( size() ).isEmpty();
	}

	public Queue add( Object cargo ) {
		internalQueue.add( 1, new BusyElement( cargo ) );
		return this;
	}

	public Object take() {
		return internalQueue.remove( size() ).getName();
	}

	public Object head() {
		return internalQueue.get( size() ).getName();
	}

	public int size() {
		return internalQueue.size() - 1;
	}
}