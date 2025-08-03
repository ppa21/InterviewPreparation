/*
        * Problem: Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
            * The diagonal traversal follows a zigzag pattern:
            * Start from top-left (0,0)
            * Move diagonally up-right, then when hitting boundary, switch to down-left
            * Continue alternating directions for each diagonal

        * Time Complexity:  O(mn)
        * Space Complexity: O(1) 
*/
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        
        int rows = mat.length;
        int cols = mat[0].length;
        int row = 0;
        int col = 0;
        int[] result = new int[rows * cols];
        boolean goingUp = true;
        
        for (int i = 0; i < rows * cols; i++) {
            result[i] = mat[row][col];
            
            if (goingUp) {
                // Moving diagonally up-right
                if (col == cols - 1) {
                    // Hit right boundary, move down and switch direction
                    row++;
                    goingUp = false;
                } else if (row == 0) {
                    // Hit top boundary, move right and switch direction
                    col++;
                    goingUp = false;
                } else {
                    // Normal diagonal movement up-right
                    row--;
                    col++;
                }
            } else {
                // Moving diagonally down-left
                if (row == rows - 1) {
                    // Hit bottom boundary, move right and switch direction
                    col++;
                    goingUp = true;
                } else if (col == 0) {
                    // Hit left boundary, move down and switch direction
                    row++;
                    goingUp = true;
                } else {
                    // Normal diagonal movement down-left
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}
