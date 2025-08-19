/**
         * Time Complexity:  O(n * (right - left + 1)) where n = nums.length
         * Space Complexity: O(min subarray length) - for storing the result array
 
         * Function: Finds the contiguous subarray elements with minimum positive sum whose length 
           is between 'left' and 'right' (inclusive). Returns empty array if no positive sum exists.
 */
public class Solution {
    public int[] minPositiveSubarray(int[] nums, int left, int right) {
        int minSum = Integer.MAX_VALUE;
        boolean found = false;
        int bestStart = -1, bestLength = -1;
        
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
                if (sum == minSum) { bestStart = 0; bestLength = length; }
                found = true;
            }
            
            // Second Inner Loop: Slides the window to check ALL OTHER windows of that same size
            for (int i = length; i < nums.length; i++) {
                sum = sum - nums[i - length] + nums[i];
                
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                    if (sum == minSum) { bestStart = i - length + 1; bestLength = length; }
                    found = true;
                }
            }
        }
        
        return found ? Arrays.copyOfRange(nums, bestStart, bestStart + bestLength) : new int[0];
    }
}
