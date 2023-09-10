package queue;

class DeliveredState implements QueueState {

	@Override
	public void prev(Queue queue) {
		queue.setState(new RecivedState());
	}

	@Override
	public void next(Queue queue) {
		queue.setState(new RecivedState());
	}

}