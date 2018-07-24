package queensProblem;

/**
 * this class is used to check whether queen's problem can be solved for the given dimension
 * @author Prakalpa-Rathore
 *
 */
public class NQueens {

    /**
     * this method checks whether solution exists or not
     * @param n dimension of matrix
     * @return true if solution exist, false otherwise
     */
    public boolean nQueensProblem(int n)
    {
        int row = 0; 
        int[][] board = new int[n][n];
        
        // initializing the board with 0 at all places
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = 0;
        
        boolean result = placeQueen(n, board, row);
                
        return result;
        
    }
    
    
    /**
     * checks whether queen can be placed at the given position on the board( board[row][column] ) or not
     * @param board
     * @param row
     * @param column
     * @param n dimension of matrix
     * @return true if queen can be placed at specified position, false otherwise
     */
    private boolean canPlaceQueen(int[][] board, int row, int column, int n)
    {
        int i, j;
        boolean canBePlaced = true; 
        
        //checks if any queen exists in the same column
        for(i = 0; i < row; i++) 
        {
            if(board[i][column] == 1)
                canBePlaced = false;
        }
        
        //checks if any queen exists in the upper left diagonal
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1)
                canBePlaced = false;
        }
        
        //checks if any queen exists in the upper right diagonal
        for (i = row, j = column; i >= 0 && j < n; i--, j++)
        {
            if (board[i][j] == 1)
                canBePlaced = false;
        }
                
        return canBePlaced; 
    }
    
    
    /**
     * places the queens on the board at positions where they can be placed, if possible
     * @param n dimension of matrix
     * @param board
     * @param row
     * @return
     */
    private boolean placeQueen(int n, int[][] board, int row)
    {
        boolean placed = false;
        
        for(int column = 0; column < n; column++)
        {
            placed = canPlaceQueen(board, row, column, n);
            
            if(placed)
            {
                board[row][column] = 1; //placing the queen
                row++;
                
                if(row == n) //all queens have been placed
                {
                    placed = true;
                    break;
                }
                
                if(!placeQueen(n, board, row))
                {
                    row--;
                    board[row][column] = 0; //removing the queen in order to backtrack
                    placed = false;
                }
                else
                    break;
            }
        }
        
        return placed;
    }
}
