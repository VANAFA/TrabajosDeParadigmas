package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;


public class mytest {

    @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = new Queue().add( "Something" );
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }
}
