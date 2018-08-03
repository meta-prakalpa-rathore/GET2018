package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	/**
	 * test case to push a value in stack (return true when element is pushed and returns false when stack is full)
	 */
	@Test
	public void stackArrayPushTest() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		assertTrue(stack.push(1));
		assertTrue(stack.push(2));
		assertTrue(stack.push(3));
		assertTrue(stack.push(4));
		assertTrue(stack.push(5));
		assertFalse(stack.push(6));
	}
	
	
	/**
	 * test case to pop a value from the stack
	 */
	@Test
	public void stackArrayPopTest1() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		int poppedValue = stack.pop();
		assertEquals(5, poppedValue);
	}
	
	
	/**
	 * test case to pop a value from the stack when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void stackArrayPopTest2() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		stack.push(1);
		stack.pop();
		stack.pop();
	}
	
	
	/**
	 * test case to peek the top value of the stack
	 */
	@Test
	public void stackArrayPeekTest1() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		stack.push(2);
		int topValue = stack.peek();
		assertEquals(2, topValue);
	}
	
	
	/**
	 * test case to peek the top value of the stack when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void stackArrayPeekTest2() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		stack.peek();
	}
	
	
	/**
	 * test case to check if the stack is empty when actually the stack is not empty
	 */
	@Test
	public void stackArrayIsEmptyTest1() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		stack.push(2);
		assertFalse(stack.isEmpty());
	}
	
	
	/**
	 * test case to check if the stack is empty when actually the stack is empty
	 */
	@Test
	public void stackArrayIsEmptyTest2() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		
		assertTrue(stack.isEmpty());
	}
	
	
	/**
	 * test case to check if the stack is full when actually the stack is full
	 */
	@Test
	public void stackArrayIsFullTest1() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		stack.push(2);
		stack.push(2);
		stack.push(2);
		stack.push(2);
		stack.push(2);
		assertTrue(stack.isFull());
	}
	
	
	/**
	 * test case to check if the stack is full when actually the stack is not full
	 */
	@Test
	public void stackArrayIsFullTest2() {
		
		StackArray<Integer> stack = new StackArray<>(5);
		assertFalse(stack.isFull());
		
		stack.push(3);
		assertFalse(stack.isFull());
	}

	
	/**
	 * test case to push a value in stack
	 */
	@Test
	public void stackLinkedListPushTest() {
		
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		assertTrue(stack.push(1));
		assertTrue(stack.push(2));
		assertTrue(stack.push(3));
	}
		
	
	/**
	 * test case to pop a value from the stack
	 */
	@Test
	public void stackLinkedListPopTest1() {
		
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		int poppedValue = stack.pop();
		assertEquals(5, poppedValue);
	}

	
	/**
	 * test case to pop a value from the stack when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void stackLinkedListPopTest2() {
		
		StackLinkedList<Double> stack = new StackLinkedList<>();
		stack.push(2.4);
		stack.pop();
		stack.pop();
	}	
	
	
	/**
	 * test case to peek the top value of the stack
	 */
	@Test
	public void stackLinkedListPeekTest1() {
		
		StackLinkedList<Character> stack = new StackLinkedList<>();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		int topValue = stack.peek();
		assertEquals('c', topValue);
	}
	
	
	/**
	 * test case to peek the top value of the stack when it is empty
	 */
	@Test(expected = AssertionError.class)
	public void stackLinkedListPeekTest2() {
		
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		stack.peek();
	}
	
	
	/**
	 * test case to check if the stack is empty when actually the stack is not empty
	 */
	@Test
	public void stackLinkedListIsEmptyTest1() {
		
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		stack.push(2);
		assertFalse(stack.isEmpty());
	}
	
	
	/**
	 * test case to check if the stack is empty when actually the stack is empty
	 */
	@Test
	public void stackLinkedListIsEmptyTest2() {
		
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		
		assertTrue(stack.isEmpty());
	}

}
