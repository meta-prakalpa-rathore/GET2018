package queensProblem;

import static org.junit.Assert.*;

public class Test {

    NQueens nQueen = new NQueens();
    
    /**
     * Test case for n = 4 (solution exists)
     */
    @org.junit.Test
    public void testNQueens1() {
        
        boolean result = nQueen.nQueensProblem(4);
        assertTrue(result);
    }
    
    /**
     * Test case for n = 2 (solution does'nt exist)
     */
    @org.junit.Test
    public void testNQueens2() {
        
        boolean result = nQueen.nQueensProblem(2);
        assertFalse(result);
    }

}
