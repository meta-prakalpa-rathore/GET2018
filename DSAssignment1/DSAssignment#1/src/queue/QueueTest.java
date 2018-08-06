package queue;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

	/**
	 * test case to enQueue a value in queue (return true when element is enQueueed and returns false when queue is full)
	 */
	@Test
	public void queueArrayenQueueTest() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(4));
		assertTrue(queue.enQueue(5));
		assertFalse(queue.enQueue(6));
	}
	
	
	/**
	 * test case to deQueue a value from the queue
	 */
	@Test
	public void queueArraydeQueueTest1() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		int deQueuedValue = queue.deQueue();
		assertEquals(1, deQueuedValue);
	}
	
	
	/**
	 * test case to deQueue a value from the queue when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void queueArraydeQueueTest2() {
		
		QueueArray<String> queue = new QueueArray<>(5);
		queue.enQueue("hello");
		queue.deQueue();
		queue.deQueue();
	}
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is not empty
	 */
	@Test
	public void queueArrayIsEmptyTest1() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		queue.enQueue(2);
		assertFalse(queue.isEmpty());
	}
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is empty
	 */
	@Test
	public void queueArrayIsEmptyTest2() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		
		assertTrue(queue.isEmpty());
	}
	
	
	/**
	 * test case to check if the queue is full when actually the queue is full
	 */
	@Test
	public void queueArrayIsFullTest1() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		queue.enQueue(2);
		queue.enQueue(2);
		queue.enQueue(2);
		queue.enQueue(2);
		queue.enQueue(2);
		assertTrue(queue.isFull());
	}
	
	
	/**
	 * test case to check if the queue is full when actually the queue is not full
	 */
	@Test
	public void queueArrayIsFullTest2() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		assertFalse(queue.isFull());
		
		queue.enQueue(3);
		assertFalse(queue.isFull());
	}

	
	/**
	 * test case to enQueue a value in queue
	 */
	@Test
	public void queueLinkedListenQueueTest() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
	}
		
	
	/**
	 * test case to deQueue a value from the queue
	 */
	@Test
	public void queueLinkedListdeQueueTest1() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		int deQueuedValue = queue.deQueue();
		assertEquals(1, deQueuedValue);
	}

	
	/**
	 * test case to deQueue a value from the queue when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void queueLinkedListdeQueueTest2() {
		
		QueueLinkedList<Double> queue = new QueueLinkedList<>();
		queue.enQueue(2.4);
		queue.deQueue();
		queue.deQueue();
	}	
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is not empty
	 */
	@Test
	public void queueLinkedListIsEmptyTest1() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		queue.enQueue(2);
		assertFalse(queue.isEmpty());
	}
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is empty
	 */
	@Test
	public void queueLinkedListIsEmptyTest2() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		
		assertTrue(queue.isEmpty());
	}
	
	
	/**
	 * test case to check if the queue is full when actually the queue is not full
	 */
	@Test
	public void queueLinkedListIsFullTest() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		queue.enQueue(2);
		assertFalse(queue.isFull());
		
		queue.enQueue(2);
		queue.enQueue(2);
		queue.enQueue(2);
		assertFalse(queue.isFull());
	}


}
