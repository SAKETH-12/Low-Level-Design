class TicTacToe {

    int[] rowSum;
    int[] colSum;
    int diagonalSum;
    int antiDiagonalSum;
    int dimension;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowSum = new int[n];
        colSum = new int[n];
        diagonalSum = 0;
        antiDiagonalSum = 0;
        dimension = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int value = player == 1 ? 1 : -1;
        
        rowSum[row] += value; // update the rowSum value
        colSum[col] += value; // update the colSum value
        
        if (row == col) { // if row == col then that would mean that this cell is on the diagonal
            diagonalSum += value;
        }
        
        if (col == dimension - row - 1) { // the [row, col] cell is located on anti-diagonal
            antiDiagonalSum += value;
        }
        
        // for the player to win by making this move
        // summation of all values in the cells at row index = row must be equal to the dimension
        // or 
        // summation of all values in the cells at column index = col must be equal to the dimension
        // or 
        // summation of all values in the cells located on the diagonal must be equal to the dimension
        // or 
        // summation of all values in the cells located on the anti-diagonal must be equal to the dimension
        if (Math.abs(rowSum[row]) == dimension // row summation
            || Math.abs(colSum[col]) == dimension // column summation
            || Math.abs(diagonalSum) == dimension // diagonal summation
            || Math.abs(antiDiagonalSum) == dimension) { // anti-diagonal summation
            return player;
        }
        
        return 0;
        
    }
}
