package priorityQueue;

/**
 * class to store the properties of a job to be scheduled on processor
 * @author Prakalpa-Rathore
 *
 */
public class Job {

	final int value;
	final int priority;
	
	//constructor
	public Job(int value, int priority) {
		
		this.value = value;
		this.priority = priority;
	}

	public int getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}
	
	
}
