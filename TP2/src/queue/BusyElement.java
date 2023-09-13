package queue;

public class BusyElement extends Element {

    public boolean isEmpty() {
		return false;
	}

	public Object take() {
		return thing; // maybe get rid of this
	}

	public Object head() {
    return thing;
	}

	public int size() {
		return 0;
	}

}
