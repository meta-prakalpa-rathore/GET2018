package queue;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

	/**
	 * test case to enqueue a value in queue (return true when element is enqueueed and returns false when queue is full)
	 */
	@Test
	public void queueArrayenqueueTest() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
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
	public void queueArraydequeueTest1() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
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
	public void queueArraydequeueTest2() {
		
		QueueArray<String> queue = new QueueArray<>(5);
		queue.enqueue("hello");
		queue.dequeue();
		queue.dequeue();
	}
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is not empty
	 */
	@Test
	public void queueArrayIsEmptyTest1() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		queue.enqueue(2);
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
	public void queueArrayIsFullTest2() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		assertFalse(queue.isFull());
		
		queue.enqueue(3);
		assertFalse(queue.isFull());
	}

	
	/**
	 * test case to enqueue a value in queue
	 */
	@Test
	public void queueLinkedListenqueueTest() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		assertTrue(queue.enqueue(1));
		assertTrue(queue.enqueue(2));
		assertTrue(queue.enqueue(3));
	}
		
	
	/**
	 * test case to dequeue a value from the queue
	 */
	@Test
	public void queueLinkedListdequeueTest1() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		int dequeuedValue = queue.dequeue();
		assertEquals(1, dequeuedValue);
	}

	
	/**
	 * test case to dequeue a value from the queue when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void queueLinkedListdequeueTest2() {
		
		QueueLinkedList<Double> queue = new QueueLinkedList<>();
		queue.enqueue(2.4);
		queue.dequeue();
		queue.dequeue();
	}	
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is not empty
	 */
	@Test
	public void queueLinkedListIsEmptyTest1() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		queue.enqueue(2);
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
		queue.enqueue(2);
		assertFalse(queue.isFull());
		
		queue.enqueue(2);
		queue.enqueue(2);
		queue.enqueue(2);
		assertFalse(queue.isFull());
	}


}
