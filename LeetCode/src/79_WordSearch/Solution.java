class Solution {
    /*
                * Time Complexity:        O(n * m * dfs) -----> O(n * m * (4 ^ word.length()))
                                            * O(dfs) = 4 ^ word.length()
                                                * 4 because 4 RECURSIVE CALLS in dfs
                * Space Complexity:       O(n * m)
                                            * We could need all letters on the board to create the word
     */
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                /*
                        * if the cell we're on == first letter of the word
                                              &&
                        * we can find the remainder of the word
                            * if we can find all the other characters in the word
                 */
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    // BACKTRACKING
    private boolean dfs(char[][] board, int i, int j, int foundLettersCount, String word) {
        if(foundLettersCount == word.length()) {
            return true;
        }

        /*
                * Bound checks
                * The cell we're on doesn't have the letter we're looking for
         */
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(foundLettersCount)) {
            return false;
        }

        /*
                * The same letter cell MAY NOT be used more than once
                    * Save the value at board[i][j]
                        * We need to add it back to the cell after RECURSIVE CALLS
                    * Mark the value at board[i][j] as EMPTY
         */
        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i + 1, j, foundLettersCount + 1, word) ||
                dfs(board, i - 1, j, foundLettersCount + 1, word) ||
                dfs(board, i, j + 1, foundLettersCount + 1, word) ||
                dfs(board, i, j - 1, foundLettersCount + 1, word);
        board[i][j] = tmp;

        return found;
    }
}