package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	PriorityQueue priorityQueue;
	
	/**
     * test case to enqueue a value in queue (return true when element is enqueued and returns false when queue is full)
     */
    @Test
    public void PriorityQueueenqueueTest() {
        
        PriorityQueue queue = new PriorityQueueArray(5);
        assertTrue(queue.enqueue(new Job(1, 2)));
        assertTrue(queue.enqueue(new Job(2, 5)));
        assertTrue(queue.enqueue(new Job(3, 4)));
        assertTrue(queue.enqueue(new Job(4, 1)));
        assertTrue(queue.enqueue(new Job(5, 1)));
        assertFalse(queue.enqueue(new Job(6, 5))); //the queue will already be full this time
    }
    
    
    /**
     * test case to dequeue a value from the queue
     */
    @Test
    public void PriorityQueuedequeueTest1() {
        
        PriorityQueue queue = new PriorityQueueArray(5);
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(3, 1));
        queue.enqueue(new Job(4, 5));
        assertEquals(4, queue.dequeue().getValue());
    }
    
    
    /**
     * test case to dequeue a value from the queue when it is empty
     */
    @Test(expected = AssertionError.class)
    public void PriorityQueuedequeueTest2() {
        
        PriorityQueue queue = new PriorityQueueArray(5);
        queue.enqueue(new Job(2, 2));
        queue.dequeue();
        queue.dequeue();
    }
    
    
    /**
     * test case to check if the queue is empty when actually the queue is not empty
     */
    @Test
    public void PriorityQueueIsEmptyTest1() {
        
        PriorityQueue queue = new PriorityQueueArray(5);
        queue.enqueue(new Job(2, 2));
        assertFalse(queue.isEmpty());
    }
    
    
    /**
     * test case to check if the queue is empty when actually the queue is empty
     */
    @Test
    public void PriorityQueueIsEmptyTest2() {
        
        PriorityQueue queue = new PriorityQueueArray(5);
        
        assertTrue(queue.isEmpty());
    }
    
    
    /**
     * test case to check if the queue is full when actually the queue is full
     */
    @Test
    public void PriorityQueueIsFullTest1() {
        
        PriorityQueue queue = new PriorityQueueArray(5);
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        assertTrue(queue.isFull());
    }
    
    
    /**
     * test case to check if the queue is full when actually the queue is not full
     */
    @Test
    public void PriorityQueueIsFullTest2() {
        
        PriorityQueue queue = new PriorityQueueArray(5);
        assertFalse(queue.isFull());
        
        queue.enqueue(new Job(2, 2));
        assertFalse(queue.isFull());
        
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        queue.enqueue(new Job(2, 2));
        queue.dequeue();
        queue.dequeue();
        assertFalse(queue.isFull());
    }
    
}
