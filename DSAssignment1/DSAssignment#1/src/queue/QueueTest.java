package queue;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {

	/**
	 * test case to add a value in queue (return true when element is added and returns false when queue is full)
	 */
	@Test
	public void queueArrayAddTest() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		assertTrue(queue.add(1));
		assertTrue(queue.add(2));
		assertTrue(queue.add(3));
		assertTrue(queue.add(4));
		assertTrue(queue.add(5));
		assertFalse(queue.add(6));
	}
	
	
	/**
	 * test case to delete a value from the queue
	 */
	@Test
	public void queueArrayDeleteTest1() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		int deletedValue = queue.delete();
		assertEquals(1, deletedValue);
	}
	
	
	/**
	 * test case to delete a value from the queue when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void queueArrayDeleteTest2() {
		
		QueueArray<String> queue = new QueueArray<>(5);
		queue.add("hello");
		queue.delete();
		queue.delete();
	}
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is not empty
	 */
	@Test
	public void queueArrayIsEmptyTest1() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		queue.add(2);
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
		queue.add(2);
		queue.add(2);
		queue.add(2);
		queue.add(2);
		queue.add(2);
		assertTrue(queue.isFull());
	}
	
	
	/**
	 * test case to check if the queue is full when actually the queue is not full
	 */
	@Test
	public void queueArrayIsFullTest2() {
		
		QueueArray<Integer> queue = new QueueArray<>(5);
		assertFalse(queue.isFull());
		
		queue.add(3);
		assertFalse(queue.isFull());
	}

	
	/**
	 * test case to add a value in queue
	 */
	@Test
	public void queueLinkedListAddTest() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		assertTrue(queue.add(1));
		assertTrue(queue.add(2));
		assertTrue(queue.add(3));
	}
		
	
	/**
	 * test case to delete a value from the queue
	 */
	@Test
	public void queueLinkedListDeleteTest1() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		int deletedValue = queue.delete();
		assertEquals(1, deletedValue);
	}

	
	/**
	 * test case to delete a value from the queue when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void queueLinkedListDeleteTest2() {
		
		QueueLinkedList<Double> queue = new QueueLinkedList<>();
		queue.add(2.4);
		queue.delete();
		queue.delete();
	}	
	
	
	/**
	 * test case to check if the queue is empty when actually the queue is not empty
	 */
	@Test
	public void queueLinkedListIsEmptyTest1() {
		
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		queue.add(2);
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
		queue.add(2);
		assertFalse(queue.isFull());
		
		queue.add(2);
		queue.add(2);
		queue.add(2);
		assertFalse(queue.isFull());
	}


}
