class Solution {
    /*
        * When I do cols in for loop, cols stay consistent
            * c is consistent since it's cols
                * board[0][c]
                * board[rows - 1][c]
        * When I do rows in for loop, rows stay consistent
            * r is consistent since it's rows
                * board[r][0]
                * board[r][cols - 1]
        
    
        * Time Complexity  = O(nm)
        * Space Complexity = O(nm)
    */
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // 1a) Capture unsurrounded regions AKA border 'O's; top and bottom row (O -> T)
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if (board[rows - 1][i] == 'O') {
                dfs(board, rows - 1, i);
            }
        }

        // 1b) Capture unsurrounded regions AKA border 'O's; left and right cols (O -> T)
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 2) capture surrounded regions (O -> X)
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                // 3) uncapture unsurrounded regions (T -> O)
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
