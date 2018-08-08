package cricketMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class provides a way for minimizing the number of runs scored by Virat Kohli.
 * It assumes that Virat scores maximum runs on the ball of the bowler with minimum no. of balls left to bowl.
 * @author Prakalpa-Rathore
 *
 */
public class CricketMatch {

	Map<String, Integer> bowlerMap; //used to store no. of balls per bowler
	int noOfBallsViratPlay, totalNoOfBowlers;
	
	//constructor
	public CricketMatch(int totalNoOfballs, Map<String, Integer> bowlerMap)
	{
		if(sum(bowlerMap) >= totalNoOfballs) 
		{
			this.noOfBallsViratPlay = totalNoOfballs; 
			this.bowlerMap = bowlerMap;
			this.totalNoOfBowlers = bowlerMap.size();
		}
		else
			throw new AssertionError("Insufficient bowlers!!");
	}
	
	
	/**
	 * calculates the bowling order in order to minimize the runs scored by Virat Kohli
	 * @return bowlingOrder
	 */
	public List<String> bowlingOrder()
	{
		List<String> bowlingOrder = new ArrayList<>();
		
		for(int i = 0; i < noOfBallsViratPlay; i++)
		{
			String bowler = findBowler();
			bowlingOrder.add(bowler);
			bowlerMap.put(bowler, bowlerMap.get(bowler) - 1);
		}
		
		return bowlingOrder;
	}
	
	
	/**
	 * helper method to find the bowler with the maximum number of balls left to bowl
	 * @return
	 */
	private String findBowler()
	{
		int maxBalls = 0;
		String bowler = null;
		
		for(String bowlerName: bowlerMap.keySet())
		{
			int balls = bowlerMap.get(bowlerName);
			if(maxBalls < balls)
			{
				maxBalls = balls;
				bowler = bowlerName;
			}
		}
		
		return bowler;
	}
	
	
	/**
	 * helper method to add the total number of balls of all the bowlers
	 * @param bowlerMap
	 * @return sum
	 */
	private int sum(Map<String, Integer> bowlerMap)
	{
		int sum = 0;
		
		for(String bowler: bowlerMap.keySet())
			sum += bowlerMap.get(bowler);
		
		return sum;
	}
}
