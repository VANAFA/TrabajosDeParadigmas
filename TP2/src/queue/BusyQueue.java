package queue;

import java.util.ArrayList;

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

