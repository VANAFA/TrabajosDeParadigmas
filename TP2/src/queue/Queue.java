package queue;

import java.util.ArrayList;
import java.util.List;
public abstract class Queue {

	protected List<String> queue;

	public Queue() {
		queue = new ArrayList<String>();
		
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public void add(String cargo) {
		queue.add(cargo);
	}

	public abstract Object take();
	public abstract Object head();
	public abstract int size();
	
}
