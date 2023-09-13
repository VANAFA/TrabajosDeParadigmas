package queue;

public abstract class Element { // super class for EmptyElement and BusyElement

	public abstract boolean isEmpty();
	public abstract Queue add( Object cargo );
	public abstract Object take();
	public abstract Object head();
	public abstract int size();
}
	