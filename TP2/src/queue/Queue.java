package queue;

import java.util.ArrayList;

// el primer elemeto va a tener el comportamiento de vacío, la lista tiene un solo elemento cuando vacía, que no suma.

public class Queue { // esta clase no es superclase
	
	protected ArrayList<String> internalQueue;

	protected Queue queue = new EmptyQueue();
	
	public Queue() {
		internalQueue = new ArrayList<String>();
	}
	
	public Queue add( String cargo ) {
		queue = new BusyQueue();
		return this.add( cargo );
	}

	public Object take() { //take, vuelve a estados anteriores, no elimina, solo regresa
		// regresar al estado anterior de la lista
		queue = new EmptyQueue();
		return queue.take();
	}

	public Object head() {
		throw new Error("Queue is empty");
	}

	public int size() {
		return 0;
	}

}

class Elements extends Queue { // esta clase es superclase de EmptyQueue y BusyQueue
	
	protected boolean isEmpty() {
		return true;
	}

	@Override public Queue add( String cargo ) {
			return new BusyQueue().add( cargo );
	}

	@Override public Object take() {
		throw new Error("Queue is empty");
	}

	@Override public Object head() {
		throw new Error("Queue is empty");
	}

	@Override public int size() {
		return 0;
	}
}
	
class EmptyQueue extends Elements {
		
	protected boolean isEmpty() {
		return true;
	}

		@Override public Queue add( String cargo ) {
			return new BusyQueue().add( cargo );
	}

	@Override public Object take() {
		throw new Error("Queue is empty, you attemted take()"); // antes de entregar, eliminar todo después de la coma
	}

	@Override public Object head() {
		throw new Error("Queue is empty, you attemted head()"); // antes de entregar, eliminar todo después de la coma
	}

	@Override public int size() {
		return 0;
	}
}

class BusyQueue extends Elements {
	
	protected boolean isEmpty() {
		return true;
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