package queue;

public class BusyElement extends Element {
    
    @Override public boolean isEmpty() {
		return false;
	}

	@Override public Queue add( Object cargo ) { 
		internalQueue.add( cargo );
		return this;
	}

	@Override public Object take() {
		return internalQueue.remove(0);
	}

	@Override public Object head() {
		return internalQueue.get(0);
	}

	@Override public int size() {
			return internalQueue.size();
	}
}
