package cricketMatch;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CricketMatchTest {

	Map<String, Integer> bowlerMap;
	
	/**
	 * this test case is used to  create and initialize the bowler map
	 */
	@Before
	public void createObject() {
		bowlerMap = new LinkedHashMap<String, Integer>();
		
		bowlerMap.put("deekshika", 7);
		bowlerMap.put("prakalpa", 9);
		bowlerMap.put("arjita", 5);
	}

	
	/**
	 * test case for testing the bowling order returned by the cricketMatch() method
	 */
	@Test
	public void cricketMatchTest1() {
		CricketMatch cricketMatch = new CricketMatch(10, bowlerMap);
		List<String> expectedBowlingOrder = new ArrayList<String>(){{
											add("prakalpa");
											add("prakalpa");
											add("deekshika");
											add("prakalpa");
											add("deekshika");
											add("prakalpa");
											add("deekshika");
											add("prakalpa");
											add("arjita");
											add("deekshika");
											}};
		assertEquals(expectedBowlingOrder, cricketMatch.bowlingOrder());
	}
	
	
	/**
	 * test case when no of balls that virat would play is greater than the number of balls the bowlers can bowl combined
	 */
	@Test(expected = AssertionError.class)
	public void cricketMatchTest2() {
		
		new CricketMatch(40, bowlerMap);
	}
	
	
	/**
     * test case when no of balls that virat would play is negative
     */
    @Test(expected = AssertionError.class)
    public void cricketMatchTest4() {
        
        new CricketMatch(-20, bowlerMap);
    }
    
    
    /**
     * test case when no of balls that virat would play is 0
     */
    @Test(expected = AssertionError.class)
    public void cricketMatchTest5() {
        
        new CricketMatch(0, bowlerMap);
    }
    
    
    /**
     * test case when no of balls to be bowled by a bowler is negative
     */
    @Test(expected = AssertionError.class)
    public void cricketMatchTest6() {
        
        Map<String, Integer> newBowlerMap = new LinkedHashMap<String, Integer>();
        
        newBowlerMap.put("deekshika", 7);
        newBowlerMap.put("prakalpa", 9);
        newBowlerMap.put("arjita", -2);
        new CricketMatch(10, newBowlerMap);
    }
}
