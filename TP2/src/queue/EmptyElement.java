package queue;

public class EmptyElement extends Element {

    public boolean isEmpty() {
		return true;
	}
	public Object getName() {
		throw new Error("Queue is empty");
	}
}
