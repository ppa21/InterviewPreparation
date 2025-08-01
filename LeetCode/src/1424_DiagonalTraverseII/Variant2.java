/*
        * time complexity  = O(n)
        * space complexity = O(1)
        
        * rotate matrix 45deg and you get a tree structure and 
          you can do level order traversal
        
        * VARIANT: What if you're given a full matrix and you had to print out the anti-diagonal order?
*/
class Solution {
    public void findAntiDiagonalOrder(int[][] nums) {
        // Start from each column in first row, go diagonally down-left
        for (int col = 0; col < nums[0].length; col++) {
            helper(nums, 0, col);
        }
        
        // Start from each row in last column (skip first row to avoid duplicates)
        for (int row = 1; row < nums.length; row++) {
            helper(nums, row, nums[row].length - 1);
        }
    }
    
    private void helper(int[][] nums, int row, int col) {
        // Print one anti-diagonal: start from given position, go down-left until boundary
        while (row < nums.length && col >= 0) {
            System.out.print(nums[row][col] + " ");
            row++; // next row down
            col--; // next column left
        }
        System.out.println(); // new line after each diagonal
    }
}
