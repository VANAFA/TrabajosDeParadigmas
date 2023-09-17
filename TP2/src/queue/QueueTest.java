package queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( queueWithThingOne().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {

    assertEquals( thingOne, queueWithThingOne().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queueWithThingOne();
    queue.take();

    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    assertEquals( thingOne, queueWithThingOne().take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = queueWithThingOneAndTwo();

    assertEquals( queue.take(), thingOne );
    assertEquals( queue.take(), thingTwo );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    assertEquals( queueWithThingOneAndTwo().head(), thingOne );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queueWithThingOne();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, queueWithThingOneAndTwo().size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    errorThrowingTester(queue::take);
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = queueWithThingOne();
    queue.take();
    errorThrowingTester(queue::take);
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    errorThrowingTester(queue::head);
  }

  private Queue queueWithThingOne() {
    return new Queue().add( thingOne );
  }
  private Queue queueWithThingOneAndTwo() {
    return queueWithThingOne().add( thingTwo );
  }
  private void errorThrowingTester(Executable runnable_function) {
    Throwable thrown = assertThrows(Throwable.class, runnable_function);
    assertEquals(QueueTest.errorMessage, thrown.getMessage());
  }
  private static final String thingOne = "First";
  private static final String thingTwo = "Second";
  private static final String errorMessage = "Queue is empty";
}
