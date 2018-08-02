package sparseMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSparseMatrix {

    /**
     * Test for invalid input
     */
    @Test(expected = AssertionError.class)
    public void sparseMatrixTest() {
        new SparseMatrix(null);
              
    }
    
    
    /**
     * Positive Test case for transpose of the matrix
     */
    @Test
    public void transposeTest1() {
        SparseMatrix matrix = new SparseMatrix(new int[][]{{0, 0, 0, 4}, {5, 0 ,0 ,0}, {0, 0, 0, 0}});
        SparseMatrix transpose = matrix.transpose();
                
        assertArrayEquals(new int[][]{{0, 5, 0}, {0 ,0 ,0}, {0, 0, 0}, {4, 0, 0}}, transpose.getSparseMatrix());
        
    }
    

    /**
     * Positive test case for isSymmetrical()
     */
    @Test
    public void isSymmetricalTest1() {
        SparseMatrix matrix = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}});
        boolean isSymmetrical = matrix.isSymmetrical();
        
        assertTrue(isSymmetrical);
        
    }
    
    
    /**
     * Negative test case for isSymmetrical()
     */
    @Test
    public void isSymmetricalTest2() {
        SparseMatrix matrix = new SparseMatrix(new int[][]{{4, 0, 3}, {0, 5, 0}, {0, 0, 2}});
        boolean isSymmetrical = matrix.isSymmetrical();
        
        assertFalse(isSymmetrical);
        
    }
    
    
    /**
     * Test case for addMatrices when matrices have same dimensions
     */
    @Test
    public void addMatricesTest1() {
        SparseMatrix matrix1 = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}});
        SparseMatrix matrix2 = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}});
        
        SparseMatrix addition = SparseMatrix.addMatrices(matrix1, matrix2);
        assertArrayEquals(new int[][]{{8, 0, 0}, {0, 10, 0}, {0, 0, 4}}, addition.getSparseMatrix());
    }
    
    
    /**
     * Test case for addMatrices when matrices do'nt have same dimensions
     */
    @Test(expected = AssertionError.class)
    public void addMatricesTest2() {
        SparseMatrix matrix1 = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}, {0, 0, 2}});
        SparseMatrix matrix2 = new SparseMatrix(new int[][]{{4, 0}, {0, 5}, {0, 0}});
        
        SparseMatrix.addMatrices(matrix1, matrix2);
    }
    
    
    /**
     * Test case for multiplyMatrices when matrices have multiplication compatible dimensions
     */
    @Test
    public void multiplyMatricesTest1() {
        SparseMatrix matrix1 = new SparseMatrix(new int[][]{{0, 0}, {5, 0}, {0, 2}});
        SparseMatrix matrix2 = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}});
        
        SparseMatrix multiplication = SparseMatrix.multiplyMatrices(matrix1, matrix2);
        assertArrayEquals(new int[][]{{0, 0, 0}, {20, 0, 0}, {0, 10, 0}}, multiplication.getSparseMatrix());
    }
    
    
    /**
     * Test case for multiplyMatrices when matrices do'nt have multiplication compatible dimensions
     */
    @Test(expected = AssertionError.class)
    public void multiplyMatricesTest2() {
        SparseMatrix matrix1 = new SparseMatrix(new int[][]{{0}, {5}, {0}});
        SparseMatrix matrix2 = new SparseMatrix(new int[][]{{4, 0, 0}, {0, 5, 0}});
        
        SparseMatrix.multiplyMatrices(matrix1, matrix2);
    }
    
}
