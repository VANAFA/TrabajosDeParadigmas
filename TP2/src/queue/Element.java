package queue;

import java.util.ArrayList;

public abstract class Element { // super class for EmptyElement and BusyElement

    protected ArrayList<Object> internalQueue;

	Element Empty = new EmptyElement();

    // these methods should be abstract
    public Element() {
		internalQueue = new ArrayList<Object>();
	}
	

	class EmptyElement extends Element {
		public boolean isEmpty() {
			return false;
		}
		// aca solo que tire el error de "queue is empty" si llaman a la queue que tiene esto
	}
	class BusyElement extends Element {
		public boolean isEmpty() {
			return false;
		}
	
		public Queue add( Object cargo ) { 
			// aca no se si hay que ponerle para que agregue especificamente BusyElements  
			internalQueue.add( cargo );
			return this;
		}
	
		public Object take() {
			return internalQueue.remove(0);
		}
	
		public Object head() {
			return internalQueue.get(0);
		}
	
		public int size() {
			return internalQueue.size();
		}
	}
}
	