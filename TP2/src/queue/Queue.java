package queue;

// import java.util.ArrayList;
import java.util.ArrayList;

public class Queue {

	public boolean isEmpty() {
		return true;
	}
	
	public Queue add( String cargo ) {
		return new BusyQueue( cargo ); //
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

	private ArrayList<String> queue;

	public BusyQueue( String cargo ) {
		queue = new ArrayList<String>();
		this.add( cargo );
	}

	@Override public boolean isEmpty() {
		return false;
	}

	@Override public Queue add( String cargo ) { 
		queue.add(cargo);
		return this;
	}

	@Override public Object take() {
		return queue.remove(0);
	}

	@Override public Object head() {
		return queue.get(0);
	}

	@Override public int size() {
			return queue.size();
	}
}

