package assignment5;

import static org.junit.Assert.*;

public class Test {

    ArrOperation arrayOperation = new ArrOperation();
    
    /**
     * Test case for splitArray if array can be split
     */
	@org.junit.Test
	public void splitArrayTest1() {
		
		int splitIndex = arrayOperation.splitArray(new int[]{1, 1, 1, 2, 1});
		assertEquals(3, splitIndex);
		
		splitIndex = arrayOperation.splitArray(new int[]{10, 10});
        assertEquals(1, splitIndex);
	}
	
	
	/**
	 * Test case for splitArray if array cannot be split
	 */
	@org.junit.Test
	public void splitArrayTest2() {
		
		int splitIndex = arrayOperation.splitArray(new int[]{2, 1, 1, 2, 1});
		assertEquals(-1, splitIndex);
	}
	
	
	/**
	 * Test case for splitArray if array is empty
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void splitArrayTest3() {
		
		int splitIndex = arrayOperation.splitArray(new int[]{});
		assertEquals(1, splitIndex);
	}
    
	
	/**
	 * Test case for fixXY if array can be rearranged
	 */
    @org.junit.Test
    public void fixXYTest1() {
        
        int[] fixXY = arrayOperation.fixXY(new int[]{5, 4, 9, 4, 9, 5}, 4, 5);
        assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9}, fixXY);
    }
    
    
    /**
     * Test case for fixXY if array is empty
     */
    @org.junit.Test(expected = AssertionError.class)
    public void fixXYTest2() {
       
        int[] fixXY = arrayOperation.fixXY(new int[]{},4,5);
    }
    
    
    /**
     * Test case for fixXY if array cannot be rearranged because of two adjacent X
     */
    @org.junit.Test(expected = AssertionError.class)
    public void fixXYTest3() {
   
        int[] fixXY = arrayOperation.fixXY(new int[]{1, 4, 4, 5, 3, 5, 1}, 4, 5);
    }
    
    
    /**
     * Test case for fixXY if array cannot be rearranged because X is at last position
     */
    @org.junit.Test(expected = AssertionError.class)
    public void fixXYTest4() {
   
        int[] fixXY = arrayOperation.fixXY(new int[]{1, 5, 1, 4}, 4, 5);
    }
    
    
    /**
     * Test case for fixXY if array cannot be rearranged because of unequal X & Y
     */
    @org.junit.Test(expected = AssertionError.class)
    public void fixXYTest5() {
   
        int[] fixXY = arrayOperation.fixXY(new int[]{1, 4, 1, 5, 3, 4, 1}, 4, 5);
    }
    
    
    /**
     * Test case for noOfClumps if array is not empty
     */
    @org.junit.Test
    public void noOfClumpsTest1() {
        
        int noOfClumps = arrayOperation.noOfClumps(new int[]{1, 2, 2, 3, 4, 4});
        assertEquals(2, noOfClumps);
        
        noOfClumps = arrayOperation.noOfClumps(new int[]{1, 1, 2, 1, 1});
        assertEquals(2, noOfClumps);
        
        noOfClumps = arrayOperation.noOfClumps(new int[]{1, 1, 1, 1, 1});
        assertEquals(1, noOfClumps);
    }
    
    
    /**
     * Test case for noOfClumps if array is empty
     */
    @org.junit.Test(expected = AssertionError.class)
    public void noOfClumpsTest2() {
        
        int noOfClumps = arrayOperation.noOfClumps(new int[]{});
    }
    
    
    /**
     * Test case for largestMirrorSection if array is not empty
     */
    @org.junit.Test
    public void largestMirrorSectionTest1() {
        
        int largestMirrorSection = arrayOperation.largestMirrorSection(new int[]{1, 4, 5, 3, 5, 4, 1});
        assertEquals(7 , largestMirrorSection);
        
        largestMirrorSection = arrayOperation.largestMirrorSection(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
        assertEquals(3 , largestMirrorSection);
        
        largestMirrorSection = arrayOperation.largestMirrorSection(new int[]{7, 1, 4, 9, 7, 4, 1});
        assertEquals(2 , largestMirrorSection);
        
        largestMirrorSection = arrayOperation.largestMirrorSection(new int[]{1, 2, 1, 4});
        assertEquals(3 , largestMirrorSection);
        
        largestMirrorSection = arrayOperation.largestMirrorSection(new int[]{1, 2, 3, 4, 5, 3, 2, 1, 2, 2, 1});
        assertEquals(4 , largestMirrorSection);
    }
    
    
    /**
     * Test case for largestMirrorSection if array is empty
     */
    @org.junit.Test(expected = AssertionError.class)
    public void largestMirrorSectionTest2() {
        
        int largestMirrorSection = arrayOperation.largestMirrorSection(new int[]{});
    }

}
