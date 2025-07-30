/*
         * Time Complexity:  O(n)
         * Space Complexity: O(1)

         * VARIANT: What if you had to return the number of buildings with an ocean view?
 */
class Solution {
    public int countBuildingsWithOceanView(int[] heights) {
        int count = 0;
        int rightMax = 0;
        
        // Traverse from right to left
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > rightMax) {
                count++;
                rightMax = heights[i];
            }
        }
        
        return count;
    }
}
