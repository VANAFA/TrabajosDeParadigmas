package queue;

public class BusyElement extends Element {

	private Object name;

	public BusyElement( Object cargo ) {
		name = cargo;
	}
    public boolean isEmpty() {
		return false;
	}
	public Object getName() {
    	return name;
	}
}