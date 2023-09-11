package queue;

import java.util.ArrayList;
import java.util.List;
class Queue {

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

	public ArrayList<String> internalQueue; // change to private

	public BusyQueue() {
		internalQueue = new ArrayList<String>();
	}

	@Override public boolean isEmpty() {
		return false;
	}

	@Override public Queue add( String cargo ) { 
		internalQueue.add( cargo );
		return this;
	}

	@Override public Object take() { // send to Queue class
		return internalQueue.remove(0);
	}

	@Override public Object head() {
		return internalQueue.get(0);
	}

	@Override public int size() {
			return internalQueue.size();
	}
}

// class EmptyQueue extends Queue {
	
// 	public boolean isEmpty() {
// 		return true;
// 	}
	
// 	public Queue add( String cargo ) {
// 		return new BusyQueue().add(cargo);
// 	}

// 	public Object take() {
// 			throw new Error("Queue is empty");
// 	}
// 	public Object head() {
// 			throw new Error("Queue is empty");
// 	}
// 	public int size() {
// 			return 0;
// 	}

// 	protected Object give( Object head ) {
// 		return head;
// 	}
// }