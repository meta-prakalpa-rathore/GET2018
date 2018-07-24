package search;

/**
 * this class contains methods to search an element in an array
 * @author Prakalpa-Rathore
 *
 */
public class Search {

    /**
     * searches the element in the array sequentially
     * throws AssertionError if array is empty
     * @param array
     * @param leftIndex
     * @param valueToSearch
     * @return index at which the element is presesnt, -1 if not present
     */
	public int linearSearch(int[] array, int leftIndex, int valueToSearch)
	{
	    if(array.length == 0)
	        throw new AssertionError("Array is empty");
	    
		if(array.length == leftIndex)
			return -1;
		else if(array[leftIndex] == valueToSearch)
			return leftIndex;
		else
			return linearSearch(array, leftIndex + 1, valueToSearch);
	}
	
	
	/**
	 * searches the element in an array using divide and conquer approach 
	 * throws AssertionError if array is empty
	 * @param array, assumes array to be sorted
	 * @param leftIndex
	 * @param rightIndex
	 * @param valueToSearch
	 * @return index at which the element is present, -1 if not present
	 */
	public int binarySearch(int[] array, int leftIndex, int rightIndex, int valueToSearch)
	{
	    if(array.length == 0)
            throw new AssertionError("Array is empty");
	    
		if (leftIndex > rightIndex)
			return -1;
		
		int mid = (leftIndex + rightIndex) / 2;
		
		if (array[mid] == valueToSearch)
		    return mid;
		else if (array[mid] > valueToSearch)
			return binarySearch(array, 0, mid - 1, valueToSearch);
		else
			return binarySearch(array, mid + 1, rightIndex, valueToSearch);
	}
}
