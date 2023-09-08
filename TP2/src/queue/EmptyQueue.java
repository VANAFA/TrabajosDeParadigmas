package queue;

public class EmptyQueue extends Queue {

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
