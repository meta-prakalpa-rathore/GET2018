package search;

import static org.junit.Assert.*;

public class Test {

    Search search = new Search();
    
    /**
     * Test case for linear search when element exists in array
     */
    @org.junit.Test
    public void testLinearSearch1() {
        int index = search.linearSearch(new int[]{3, 20, 4, 17, 23, 19}, 0, 20);
        assertEquals(1, index);
    }
    
    /**
     * Test case for linear search when element does'nt exist in array
     */
    @org.junit.Test
    public void testLinearSearch2() {
        int index = search.linearSearch(new int[]{3, 20, 4, 17, 23, 19}, 0, 10);
        assertEquals(-1, index);
    }
    
    /**
     * Test case for linear search when array is empty
     */
    @org.junit.Test(expected = AssertionError.class)
    public void testLinearSearch3() {
        int index = search.linearSearch(new int[]{}, 0, 10);
        assertEquals(-1, index);
    }
    
    /**
     * Test case for binary search when element exists in array
     */
    @org.junit.Test
    public void testBinarySearch1() {
        int index = search.binarySearch(new int[]{2,3,5,7,9,10,12}, 0, 6, 10);
        assertEquals(5, index);
    }

    
    /**
     * Test case for binary search when element does'nt exist in array
     */
    @org.junit.Test
    public void testBinarySearch2() {
        int index = search.binarySearch(new int[]{2,3,5,7,9,10,12}, 0, 6, 1);
        assertEquals(-1, index);
    }
    
    
    /**
     * Test case for binary search when array is empty
     */
    @org.junit.Test(expected = AssertionError.class)
    public void testBinarySearch() {
        int index = search.binarySearch(new int[]{}, 0, 6, 10);
        assertEquals(-1, index);
    }
}
