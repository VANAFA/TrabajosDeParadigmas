package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Queue {

	private List<String> queue;

	public Queue() {
		queue = new LinkedList<String>();
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
		// if (this.isEmpty()) {
		// 	this.add((String) cargo);
		// }
		// else {
		// 	this.add((String) cargo);
		// }
		queue.add((String) cargo);
		return this;
	}

	public Object take() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return queue.remove(0);
		}
	}

	public Object head() {
		if (this.isEmpty()) {
    		return null;
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
