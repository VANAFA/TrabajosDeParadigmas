package queue;

public class BusyElement extends Element {

    public boolean isEmpty() {
		return false;
	}
	public Object head() {
    	return thing;
	}
	public int size() {
		return 0;
	}
}