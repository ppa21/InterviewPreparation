class Solution {
    /*
        * time complexity:  O(n^2)
        * space complexity: O(n)
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = null;
        Set<Character> cols = null;

        for (int i = 0; i < board.length; i++) {
            rows = new HashSet<>();
            cols = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                char r = board[i][j];
                char c = board[j][i];

                if (r != '.') {
                    if (!rows.add(r)) {
                        return false;
                    }
                }

                if (c != '.') {
                    if (!cols.add(c)) {
                        return false;
                    }
                }
            }
        }

        /*
            if 9 x 9
                i = 0, 3, 6
                j = 0, 3, 6
                    0, 0; 0, 3; 0, 6;
                    3, 0; 3, 3; 3, 6;
                    6, 0; 6, 3; 6, 6;
            goes through sub box 0, 1, 2
        */
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!checkSubbox(i, j, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkSubbox(int r, int c, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = r + 3;
        int cols = c + 3;

        /*
            if r = 3; c = 3
            rows = 6; cols = 6
            i = 3, 4, 5; i < rows
            j = 3, 4, 5; j < cols
            goes through elements in each sub box

            if r = 6; c = 3
            rows = 9; cols = 6
            i = 6, 7, 8; i < rows
            j = 3, 4, 5; j < cols
            goes through elements in each sub box
        */
        for (int i = r; i < rows; i++) {
            for (int j = c; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (blockSet.contains(board[i][j])) {
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }
}