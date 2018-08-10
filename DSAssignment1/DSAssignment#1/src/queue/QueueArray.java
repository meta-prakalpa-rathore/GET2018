package queue;

/**
 * Class for the array implementation of the Queue class
 * @author Prakalpa-Rathore
 *
 * @param <E> defines the type of value to be stored in the queue
 */
public class QueueArray<E> implements Queue<E>{

    private Object[] queue;
    private int rear, front, maxSize;
    
    //constructor
    public QueueArray(int maxSize)
    {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        rear = 0;
        front = 0;
        
    }
    

    /**
     * method to add a value at the rear of the queue
     * @param value
     * @return true if element is added to the queue, false otherwise
     */
    @Override
    public boolean enqueue(E value) {
        
    	try
    	{
    		if(!isFull())
            {
                queue[rear] = value;
                rear++;
            }
            else
                throw new AssertionError("The queue is full!");
    		
    		return true;
    	}
    	catch(AssertionError error)
    	{
    		return false;
    	} 
    }

    
    /**
     * method to remove a value from the front of the queue
     * @return value that is removed, and throws an AssertionError if queue is empty
     */
    @Override
    public E dequeue() throws AssertionError
    {        
        E value = null;
        
        if(!isEmpty())
        {
            value = get(front);
            front++;
        }
        else
            throw new AssertionError("The queue is empty!");
        
        return value;
    }

    
    /**
     * method to check if the queue is empty
     * @return boolean value
     */
    @Override
    public boolean isEmpty() {
        
        return rear == front;
    }

    
    /**
     * method to check if the queue is full
     * @return boolean value
     */
    @Override
    public boolean isFull() {
        
        return rear == maxSize;
    }
    
    
    /**
     * method to get the value at the specific index from the queue
     * @param index
     * @return
     */
    private E get(int index) {
        
        @SuppressWarnings("unchecked")
        final E value = (E) this.queue[index];
        
        return value;
    }
}
