package sparseMatrix;

import java.util.HashMap;
import java.util.Map;

/**
 * an immutable class for representing two-dimensional sparse matrices
 * @author Prakalpa-Rathore
 *
 */
public class SparseMatrix {

    private final Map<Integer, Integer> sparseMatrix = new HashMap<>(); //for storing non-zero elements of matrix
    private final int rows, columns; // for storing the dimensions of the matrix
    
    
    /**
     * constructor of the class
     * @param matrix
     * @param rows
     * @param columns
     */
    public SparseMatrix(int[][] matrix)
    {
        int position = 0;
                
        if(matrix == null)
            throw new AssertionError("Invalid input");
        
        rows = matrix.length;
        columns = matrix[0].length;
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(matrix[i][j] != 0)
                    sparseMatrix.put(position, matrix[i][j]);
                
                position++;
            }
        }         
    }
    
    
    /**
     * getter method for sparseMatrix
     * @return the sparseMatrix in array form 
     */
    public int[][] getSparseMatrix() {
        
        int[][] matrix = mapToMatrix();
        return matrix;
    }


    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }


    /**
     * computes transpose of the matrix
     * @return transpose of the matrix
     */
    public SparseMatrix transpose()
    {
        int[][] originalMatrix = mapToMatrix();
        int[][] transposeMatrix = new int[columns][rows];
        
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                transposeMatrix[j][i] = originalMatrix[i][j];
        
        return new SparseMatrix(transposeMatrix);
        
    }
    
    
    /**
     * checks if matrix is symmetrical
     * @return boolean value
     */
    public boolean isSymmetrical()
    {
        boolean isSymmetrical = false;
        SparseMatrix transpose = transpose();
        
        if(sparseMatrix.equals(transpose.sparseMatrix))
            isSymmetrical = true;
        
        return isSymmetrical;
    }
    
    
    /**
     * adds two sparse matrices
     * @param matrix1
     * @param matrix2
     * @return resultant addition matrix
     */
    public static SparseMatrix addMatrices(SparseMatrix matrix1, SparseMatrix matrix2)
    {
        if(matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns)
            throw new AssertionError("Dimensions not same! Cannot add!");
        
        int[][] addition = new int[matrix1.rows][matrix1.columns];
        int[][] matrixArray1 = matrix1.getSparseMatrix();
        int[][] matrixArray2 = matrix2.getSparseMatrix();
        
        for(int i = 0; i < matrix1.rows; i++)
            for(int j = 0; j < matrix1.columns; j++)
                addition[i][j] = matrixArray1[i][j] + matrixArray2[i][j];
        
        return new SparseMatrix(addition);
        
    }
    
    
    /**
     * multiplies two sparse matrices
     * @param matrix1
     * @param matrix2
     * @return resultant multiplication matrix 
     */
    public static SparseMatrix multiplyMatrices(SparseMatrix matrix1, SparseMatrix matrix2)
    {
        if(matrix1.columns != matrix2.rows)
            throw new AssertionError("Dimensions not compatible for multiplication! Cannot multiply!");
        
        int[][] multiplication = new int[matrix1.rows][matrix2.columns];
        int[][] matrixArray1 = matrix1.getSparseMatrix();
        int[][] matrixArray2 = matrix2.getSparseMatrix();
        
        for(int i = 0; i < matrix1.rows; i++)
            for(int j = 0; j < matrix2.columns; j++)
                for(int k = 0; k < matrix1.columns; k++)
                    multiplication[i][j] += matrixArray1[i][k] * matrixArray2[k][j];
        
        return new SparseMatrix(multiplication);
        
    }
    
    
    /**
     * helper method to convert map into sparse matrix
     * @return
     */
    private int[][] mapToMatrix()
    {
        int position = 0;
        int[][] matrix = new int[rows][columns];
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(sparseMatrix.containsKey(position))
                    matrix[i][j] = sparseMatrix.get(position);
                              
                position++;
            }
        } 
        
        return matrix;
    }
    
}
