package queue;

// import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.List;

public class Queue {

	public boolean isEmpty() {
		return true;
	}
	
	public Queue add( String cargo ) {
		return new BusyQueue( cargo );
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

	private LinkedList<String> queue;

	public BusyQueue( String cargo ) {
		queue = new LinkedList<String>();
		this.add( cargo );
	}

	@Override Queue add( String cargo ) { 
		queue.add(cargo);
		return this;
	}

	@Override Object take() {
		return queue.remove(0);
	}

	@Override Object head() {
		return queue.get(0);
	}

	@Override int size() {
			return queue.size();
	}
}

