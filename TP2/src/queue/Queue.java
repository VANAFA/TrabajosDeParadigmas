package queue;

import java.util.ArrayList;
// import java.util.List;

public class Queue {

	protected ArrayList<Element> internalQueue =  new ArrayList<Element>();

	protected Element element; // ver si alguno puede ser private

	public Queue() {
		element = new EmptyElement();
		internalQueue.add( element );
	}

	public boolean isEmpty() {
		element = internalQueue.get(0);
		return element.isEmpty();
	}

	public Queue add( Object cargo ) {
		internalQueue.add( new BusyElement() );
		element = new BusyElement();
		return element.add( cargo );
	}

	public Object take() {
		return element.take();
	}

	public Object head() {
		internalQueue.get(0);
		return element.head();
	}

	public int size() {
		element = internalQueue.get(0);
		return element.size();
	}
}