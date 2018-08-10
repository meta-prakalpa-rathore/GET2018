package stack;

/**
 * Class for the array implementation of the Stack class
 * @author Prakalpa-Rathore
 *
 * @param <E> defines the type of value to be stored in the stack
 */
public class StackArray<E> implements Stack<E> {
	
    private Object[] stack;
	int top, capacity;
	
	//constructor
	public StackArray(int capacity)
	{
	    this.capacity = capacity;
	    stack = new Object[capacity];
		top = -1;
	}
	

    /**
     * method to add a value at the top of the stack
     * @param value
     * @return true if element is inserted, false otherwise
     */
	public boolean push(E value)
	{
		try
		{
			if(!isFull())
			{
			    top++;
		        stack[top] = value;
			}
			else
			    throw new AssertionError("The stack is full");
			
			return true;
		}
		catch(AssertionError error)
		{
			return false;
		}
	}
	
	
	/**
     * method to remove a value from the top of the stack
     * @return value that is removed
     */
	public E pop() throws AssertionError
	{
	    E value = null;
	    
		if(!isEmpty())
		{
		    value = get(top);
	        top--;
		}
		else
		    throw new AssertionError("The stack is empty");
		
		return value;
	}
	
	
	/**
     * method to view the value at the top of the stack
     * @return value at top of stack
     */
	public E peek() throws AssertionError
	{
		if(!isEmpty())
			return get(top);
		else
		    throw new AssertionError("The stack is empty");
	}
	
	
	/**
     * method to check if the stack is empty
     * @return boolean value
     */
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	
	/**
	 * method to check if the stack is full
	 * @return
	 */
	public boolean isFull()
	{
	    return top == capacity - 1;
	}
	
	
	/**
     * method to return the value at the given index in the stack
     * @param index
     * @return value at index
     */
    private E get(int index) {
        
        @SuppressWarnings("unchecked")
        final E value = (E) this.stack[index]; //type cast from Object to required type
        
        return value;
    }
    
}


