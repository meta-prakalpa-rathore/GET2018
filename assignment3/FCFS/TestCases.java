package FCFS;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCases {

    JobScheduler scheduler = new JobScheduler();
    
    @Before
    public void testFCFS() {
       scheduler.setNoOfProcesses(4);
       scheduler.setInputArray(new int[][]{{0, 4}, {2, 3}, {3, 4}, {5, 8}});
    }
    
    @Test
    public void testCalculateCompletionTime()
    {
        int[] result = scheduler.calculateCompletionTime();
        assertArrayEquals(new int[]{4, 7, 11, 19}, result);
    }

    @Test
    public void testCalculateWaitingTime()
    {
        int[] result = scheduler.calculateWaitingTime();
        assertArrayEquals(new int[]{0, 2, 4 ,6}, result);
    }
    
    @Test
    public void testCalculateTurnAroundTime()
    {
        int[] result = scheduler.calculateTurnAroundTime();
        assertArrayEquals(new int[]{4, 5, 8, 14}, result);
    }
    
    @Test
    public void testAverageWaitingTime()
    {
        double result = scheduler.averageWaitingTime();
        assertEquals(3.0, result, 0.001);
    }
    
    @Test
    public void testMaxWaitingTime()
    {
        int result = scheduler.maxWaitingTime();
        assertEquals(6, result);
    }
}
