package queue;

public abstract class Element {
	
	protected Object thing;

	public void add( Object  cargo ) {
		thing = cargo;
	}
	public abstract boolean isEmpty();
	public abstract Object head();
	public abstract int size();
}