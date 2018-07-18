package FCFS;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		JobScheduler scheduler = new JobScheduler();
		int[][] inputArray;
		int[] waitingTime, completionTime, turnAroundTime;
		double averageWaitingTime;
		int maxWaitingTime;
		
		System.out.println("Please enter the number of processes:");
		int noOfProcesses = scanner.nextInt();
		inputArray = new int[noOfProcesses][2];
		System.out.println("Enter the arrival time and burst time of processes:");
		
		for(int i=0; i<noOfProcesses; i++)
		{
			System.out.println("Process "+ (i+1) +":");
			for(int j=0; j<2 ;j++)
			{
				inputArray[i][j] = scanner.nextInt();
			}
		}
		
		scheduler.setNoOfProcesses(noOfProcesses);
		scheduler.setInputArray(inputArray);
		waitingTime = scheduler.calculateWaitingTime();
		completionTime = scheduler.calculateCompletionTime();
		turnAroundTime = scheduler.calculateTurnAroundTime();
		averageWaitingTime = scheduler.averageWaitingTime();
		maxWaitingTime = scheduler.maxWaitingTime();
		
		System.out.println("Process\t\tArrival Time\tBurst Time\tWaiting Time\tCompletion Time\t\tTurn Around Time");
		
		for(int i=0; i<noOfProcesses; i++)
		{
			System.out.println((i+1) + "\t\t" + inputArray[i][0] + "\t\t" + inputArray[i][1] + "\t\t" + waitingTime[i] + "\t\t" +completionTime[i] + "\t\t\t" + turnAroundTime[i]);
		}

		System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
		System.out.println("Maximum Waiting Time: " + maxWaitingTime);
	}

}
