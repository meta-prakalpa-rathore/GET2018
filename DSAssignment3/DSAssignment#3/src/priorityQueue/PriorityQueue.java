package priorityQueue;

/**
 * interface for defining the priority queue
 * @author Prakalpa-Rathore
 *
 */
public interface PriorityQueue {

    /**
     * method to add a job in the queue
     * @param job
     * @return true if added, false otherwise
     */
	public boolean enqueue(Job job);
	
	
	/**
	 * method to remove an element from the queue
	 * @return the removed job
	 */
	public Job dequeue();
	
	
	/**
	 * method to check if the queue is empty
	 * @return boolean value
	 */
	public boolean isEmpty();
	
	
	/**
	 * method to check if the queue is full
	 * @return boolean value
	 */
	public boolean isFull();
}
