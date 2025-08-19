/**
         * Time Complexity: O(n * (right - left + 1)) where n = nums.length
         * Space Complexity: O(1) - only uses a few variables
  
         * Function: Finds the start and end indexes of contiguous subarray with minimum positive sum whose length 
           is between 'left' and 'right' (inclusive). Returns {-1, -1} if no positive sum exists.
 */
public class Solution {
    public int[] minPositiveSubarrayIndexes(int[] nums, int left, int right) {
        int minSum = Integer.MAX_VALUE;
        boolean found = false;
        int start = -1, end = -1;
        
        // Outer Loop: Tries every valid window size
        for (int length = left; length <= right; length++) {
            
            // First Inner Loop: Calculates the sum of the VERY FIRST window of that size
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += nums[i];
            }
            
            // Check if this sum is positive
            if (sum > 0) {
                minSum = Math.min(minSum, sum);
                if (sum == minSum) { start = 0; end = length - 1; }
                found = true;
            }
            
            // Second Inner Loop: Slides the window to check ALL OTHER windows of that same size
            for (int i = length; i < nums.length; i++) {
                sum = sum - nums[i - length] + nums[i];
                
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                    if (sum == minSum) { start = i - length + 1; end = i; }
                    found = true;
                }
            }
        }
        
        return found ? new int[]{start, end} : new int[]{-1, -1};
    }
}
