package queue;

public class EmptyElement extends Element {

    public boolean isEmpty() {
		return true;
	}

	public Queue add( Object  cargo ) {
		return null;
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
