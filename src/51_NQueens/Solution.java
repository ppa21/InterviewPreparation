/*
    * Time Complexity  = O(n!)
    * Space Complexity = O(n)
*/
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>(); // Stores all solutions we find

        // Initialize the board with '.'
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeQueens(solutions, board, 0); // Start with empty board, column 0

        return solutions;
    }

    // This method tries placing queens recursively, exploring all possibilities
    private void placeQueens(List<List<String>> solutions, char[][] board, int col) {
        // If all columns are filled (reached the end), we found a solution!
        if (col == board.length) {
            solutions.add(convertBoardToStringList(board)); // Add this solution to the list
            return;
        }

        // Try placing a queen in each empty row of the current column
        for (int row = 0; row < board.length; row++) {
            // Check if it's safe to put a queen here (no attacks)
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen
                // Try placing queens in the next column recursively
                placeQueens(solutions, board, col + 1);
                // If placing a queen here didn't lead to a solution (backtracking)
                board[row][col] = '.'; // Remove the queen (undo the step)
            }
        }
    }

    // This simplified version checks if placing a queen is safe (no attacks)
    // (We can improve this for efficiency, but it's clear for now)
    private boolean isSafe(char[][] board, int row, int col) {
        // Check same row and column (obvious attacks)
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q' || board[i][col] == 'Q') {
                return false;
            }
        }

        // Check diagonals in a simpler way (imagine walking on the board)
        int i = row;
        int j = col;
        // Check upper left diagonal (walk backwards-left, upwards)
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;
        // Check lower left diagonal (walk backwards-left, downwards)
        while (i < board.length && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }

        return true; // No attacks found, safe to place queen here
    }

    // Utility function to convert the board (char array) to a list of strings (easier to read)
    private List<String> convertBoardToStringList(char[][] board) {
        List<String> stringBoard = new ArrayList<>();
        for (char[] row : board) {
            stringBoard.add(new String(row));
        }
        return stringBoard;
    }
}
