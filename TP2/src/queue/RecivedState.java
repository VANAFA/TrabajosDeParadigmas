package queue;

public class RecivedState implements QueueState {

	@Override
	public void prev(Queue queue) {
		queue.setState(new DeliveredState());
	}

	@Override
	public void next(Queue queue) {
		System.out.println("Queue is empty");
	}
