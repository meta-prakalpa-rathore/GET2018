package assignment5;

public class ArrOperation {

    /**
     * finds the place to split the input array so that the sum of the numbers on one side
     * is equal to the sum of the numbers on the other side,
     * throws AssertionError if array is empty
     * @param inputArray
     * @return index at which to split the array(if possible), otherwise -1;
     */
	public int splitArray(int[] inputArray)
	{
		int index = -1;
		int mid = 1;

		if(inputArray.length == 0)
			throw new AssertionError("Array is empty");
		
		while(mid<inputArray.length)
		{
			int sumLeft = Utility.sumArray(inputArray, 0, mid-1);
			int sumRight = Utility.sumArray(inputArray, mid, inputArray.length-1);
			
			if(sumLeft == sumRight)
			{
				index = mid;
				break;
			}
			else
				if(sumLeft > sumRight)
					break;
				else
					mid++;
		}
				
		return index;
	}
	
	
	/**
	 * rearranges the inputArray so that every X is immediately followed by a Y without moving X within array
	 * @param inputArray
	 * @param X
	 * @param Y
	 * @return the rearranged array(if possible), otherwise throws an AssertionError
	 */
	public int[] fixXY(int[] inputArray, int X, int Y)
	{
	    int[] fixedArray = inputArray;
	    
	    if(inputArray.length == 0)
	        throw new AssertionError("Array is empty");
	    
	    for(int i=0; i<fixedArray.length; i++)
	    {
	        if(fixedArray[i] == X)
	        {
	            if((i+1) != fixedArray.length && fixedArray[i+1] != X)
	                fixedArray = Utility.swap(fixedArray, i+1, X, Y);
	            else
	                throw new AssertionError("Wrong input");
	        }
	            
	    }
	    
	    return fixedArray;
	}
	
	
	/**
	 * finds the number of clumps in the input array, 
	 * Clump in an array is a series of 2 or more adjacent elements of the same value.
	 * @param inputArray
	 * @return number of clumps
	 */
	public int noOfClumps(int[] inputArray)
	{
	    int noOfClumps = 0;
	    
	    if(inputArray.length == 0)
            throw new AssertionError("Array is empty");
	    
	    for(int i=0; i<inputArray.length; i++)
	    {
	        int clump = inputArray[i];
	        
	        if(i+1 != inputArray.length && inputArray[i+1] == clump)
	        {
	            noOfClumps++;
	            while(i!=inputArray.length && inputArray[i] == clump)
	                i++;
	            i--;
	        }
	        
	    }
	    
	    return noOfClumps;
	}
	
	
	/**
	 * finds the size of the largest mirror section found in the input array, throws AssertionError if array is empty
	 * @param inputArray
	 * @return size of the largest mirror section
	 */
	public int largestMirrorSection(int[] inputArray)
	{
	    int largestMirrorSection = 0;
	    int mirrorSection;
	    
	    if(inputArray.length == 0)
            throw new AssertionError("Array is empty");
	      
	    for(int i=0; i<inputArray.length; i++)
	    {
	        for(int j=inputArray.length-1; j>=0; j--)
	        {
	            int k=i,l=j;
	            mirrorSection = 0;
	                  
	            while(k < inputArray.length && l >= 0 && inputArray[k] == inputArray[l])
	            {
	                mirrorSection++;
	                k++;
	                l--;
	            }
	                  
	            if(mirrorSection > largestMirrorSection)
	                largestMirrorSection = mirrorSection;	             
	        }
	        
	    }
	    
	    return largestMirrorSection;
	}
}
