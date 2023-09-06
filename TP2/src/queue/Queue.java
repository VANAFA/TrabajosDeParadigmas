package queue;

import java.util.ArrayList;
import java.util.List;
public class Queue {

	private List<String> queue;

	public Queue() {
		queue = new ArrayList<String>();
	}

    public boolean isEmpty() {
		if (queue.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public Queue add( String cargo ) {
		queue.add((String) cargo);
		return this;
	}

	public Object take() {
		if (this.isEmpty()) {
			throw new Error("Queue is empty");
		}
		else {
			return queue.remove(0);
		}
	}

	public Object head() {
		if (this.isEmpty()) {
    		throw new Error("Queue is empty");
		}
		else {
			return queue.get(0);
		}
	}

	public int size() {
		if (this.isEmpty()) {
			return 0;
		}
		else {
			return queue.size();
		}
	}

}
