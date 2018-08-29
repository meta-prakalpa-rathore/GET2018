package circularQueue;

import static org.junit.Assert.*;
import org.junit.Test;

public class CircularQueueTest {

    /**
     * test case to enqueue a value in queue (return true when element is enqueueed and returns false when queue is full)
     */
    @Test
    public void circularQueueenqueueTest() {
        
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        assertTrue(queue.enqueue(1));
        assertTrue(queue.enqueue(2));
        assertTrue(queue.enqueue(3));
        assertTrue(queue.enqueue(4));
        assertTrue(queue.enqueue(5));
        assertFalse(queue.enqueue(6));
    }
    
    
    /**
     * test case to dequeue a value from the queue
     */
    @Test
    public void circularQueuedequeueTest1() {
        
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int dequeuedValue = queue.dequeue();
        assertEquals(1, dequeuedValue);
    }
    
    
    /**
     * test case to dequeue a value from the queue when it is empty
     */
    @Test(expected = AssertionError.class)
    public void circularQueuedequeueTest2() {
        
        CircularQueue<String> queue = new CircularQueue<>(5);
        queue.enqueue("hello");
        queue.dequeue();
        queue.dequeue();
    }
    
    
    /**
     * test case to check if the queue is empty when actually the queue is not empty
     */
    @Test
    public void circularQueueIsEmptyTest1() {
        
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.enqueue(2);
        assertFalse(queue.isEmpty());
    }
    
    
    /**
     * test case to check if the queue is empty when actually the queue is empty
     */
    @Test
    public void circularQueueIsEmptyTest2() {
        
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        
        assertTrue(queue.isEmpty());
    }
    
    
    /**
     * test case to check if the queue is full when actually the queue is full
     */
    @Test
    public void circularQueueIsFullTest1() {
        
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        assertTrue(queue.isFull());
    }
    
    
    /**
     * test case to check if the queue is full when actually the queue is not full
     */
    @Test
    public void circularQueueIsFullTest2() {
        
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        assertFalse(queue.isFull());
        
        queue.enqueue(3);
        assertFalse(queue.isFull());
        
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
        assertFalse(queue.isFull());
    }

}

