package assignment5;

public class Utility {

    /**
     * method to find sum of elements between indexes start & end
     * @param array
     * @param start
     * @param end
     * @return sum
     */
	public static int sumArray(int[] array, int start, int end)
	{
		int sum = 0;
		
		for(int i=start; i<=end; i++)
			sum += array[i];
		
		return sum;
	}
	
	
	/**
	 * finds Y & swaps it with the element at specified index
	 * @param array
	 * @param index
	 * @param X
	 * @param Y
	 * @return the changed array
	 */
	public static int[] swap(int[] array, int index, int X, int Y)
	{
	    boolean flag = false;
	    
	    for(int i=0; i<array.length; i++)
	    {
	        if(array[i] == Y && (i==0 || array[i-1] != X))
	        {
	            flag = true;
	            int temp = array[i];
	            array[i] = array[index];
	            array[index] = temp;
	            break;
	        }
	    }
	    
	    if(!flag)
	        throw new AssertionError("Unequal X & Y");
	    
	    return array;
	}
}
