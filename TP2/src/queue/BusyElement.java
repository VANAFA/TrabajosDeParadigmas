package queue;

public class BusyElement extends Element {

    public boolean isEmpty() {
		return false;
	}
	public Object head() {
    	return name;
	}
	public int size() {
		return 0;
	}
}