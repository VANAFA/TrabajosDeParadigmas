package queue;

import java.util.ArrayList;

// el primer elemeto va a tener el comportamiento de vacío, la lista tiene un solo elemento cuando vacía, que no suma.

public class Queue { // esta clase no es superclase
	
	protected ArrayList<String> internalQueue;
	
	public Queue() {
		internalQueue = new ArrayList<String>();
	}
	
	public boolean isEmpty() {
		return true;
	}

	public Queue add( String cargo ) {
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

class BusyQueue extends Queue {
	
	@Override public boolean isEmpty() {
		return false;
	}

	@Override public Queue add( String cargo ) { 
		internalQueue.add( cargo );
		return this;
	}

	@Override public Object take() {
		return internalQueue.remove(0);
	}

	@Override public Object head() {
		return internalQueue.get(0);
	}

	@Override public int size() {
			return internalQueue.size();
	}
}

// class Elements extends Queue { // esta clase es superclase de EmptyQueue y BusyQueue
	
// 	protected boolean isEmpty() {
// 		return true;
// 	}

// 	@Override public Queue add( String cargo ) {
// 			return new BusyQueue().add( cargo );
// 	}

// 	@Override public Object take() {
// 		throw new Error("Queue is empty");
// 	}

// 	@Override public Object head() {
// 		throw new Error("Queue is empty");
// 	}

// 	@Override public int size() {
// 		return 0;
// 	}
// }
	
// class EmptyQueue extends Elements {
		
// 	protected boolean isEmpty() {
// 		return true;
// 	}

// 		@Override public Queue add( String cargo ) {
// 			return new BusyQueue().add( cargo );
// 	}

// 	@Override public Object take() {
// 		throw new Error("Queue is empty, you attemted take()"); // antes de entregar, eliminar todo después de la coma
// 	}

// 	@Override public Object head() {
// 		throw new Error("Queue is empty, you attemted head()"); // antes de entregar, eliminar todo después de la coma
// 	}

// 	@Override public int size() {
// 		return 0;
// 	}
// }
