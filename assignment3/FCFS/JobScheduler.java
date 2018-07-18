package FCFS;

/**
 * this class is used to simulate First Come First Serve scheduling algorithm 
 * @author Prakalpa-Rathore
 *
 */
public class JobScheduler {

	int noOfProcesses;
	int[][] inputArray; //contains the arrival time & burst time of each process
	
	public int getNoOfProcesses() {
		return noOfProcesses;
	}
	public void setNoOfProcesses(int noOfProcesses) {
		this.noOfProcesses = noOfProcesses;
	}
	public int[][] getInputArray() {
		return inputArray;
	}
	public void setInputArray(int[][] inputArray) {
		this.inputArray = inputArray;
	}
	
	
	/**
	 * calculates the completion time of each process
	 * Completion time is the time taken for the execution to complete, starting from arrival time of first process.
	 * @return array containing completion time of each process
	 */
	public int[] calculateCompletionTime()
	{
		int[] completionTime = new int[noOfProcesses];
		completionTime[0] = inputArray[0][1];
		
		for(int i=1; i<noOfProcesses; i++)
		{
			if(inputArray[i][0] > completionTime[i-1])
			{
				completionTime[i] = inputArray[i][0] + inputArray[i][1];
			}
			else
			{
				completionTime[i] = completionTime[i-1] + inputArray[i][1];
			}
		}
		return completionTime;
	}
	
	
	/**
	 * calculates the waiting time of each process
	 * Waiting time is the total time the process has to wait before it's execution begins. It is the difference between the Turn Around time and the Burst time of the process.
	 * @return array containing waiting time of each process
	 */
	public int[] calculateWaitingTime()
	{
		int[] WaitingTime = new int[noOfProcesses];
		int[] completionTime = calculateCompletionTime();
		WaitingTime[0] = 0;
		
		for(int i=1; i<noOfProcesses; i++)
		{
			if(inputArray[i][0] > completionTime[i-1])
				WaitingTime[i] = 0;
			else
				WaitingTime[i] = completionTime[i-1] - inputArray[i][0];
		}
		
		return WaitingTime;
	}
	
	
	/**
	 * calculates the turn around time of each process
	 * Turn around time is the time taken to complete after arrival. In simple words, it is the difference between the Completion time and the Arrival time.
	 * @return array containing turn around time of each process
	 */
	public int[] calculateTurnAroundTime()
	{
		int[] TurnAroundTime = new int[noOfProcesses];
		int[] waitingTime = calculateWaitingTime();
		
		for(int i=0; i<noOfProcesses; i++)
		{
			TurnAroundTime[i] = inputArray[i][1] + waitingTime[i];
		}
		
		return TurnAroundTime;
	}
	
	
	/**
	 * calculates the average waiting time of all the processes
	 * @return average waiting time
	 */
	public double averageWaitingTime()
	{
		double averageWaitingTime = 0;
		int[] waitingTime = calculateWaitingTime();
		
		for(int i=0; i<noOfProcesses; i++)
		{
			averageWaitingTime += waitingTime[i];
		}
		
		averageWaitingTime /= noOfProcesses;
		
		return averageWaitingTime;
	}
	
	
	/**
	 * calculates maximum waiting time
	 * @return maximum waiting time
	 */
	public int maxWaitingTime()
	{
		int maxWaitingTime;
		int[] waitingTime = calculateWaitingTime();
		
		maxWaitingTime = waitingTime[0];
		for(int i=1; i<noOfProcesses; i++)
		{
			if(waitingTime[i] > maxWaitingTime)
				maxWaitingTime = waitingTime[i];
		}
				
		return maxWaitingTime;
	}
}
