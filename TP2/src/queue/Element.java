package queue;

public abstract class Element {
	
	protected Object name;

	public void add( Object  cargo ) {
		name = cargo;
	}
	public abstract boolean isEmpty();
	public abstract Object head();
	public abstract int size();
}