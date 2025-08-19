/**
         * Time Complexity:  O(n * (right - left + 1)); n = nums.length
         * Space Complexity: O(1)
 
         * Function: Finds the minimum positive sum of ALL contiguous subarrays whose length 
           is between 'left' and 'right' (inclusive). Returns -1 if no positive sum exists.
*/
public class Solution {
    public int minPositiveSubarraySum(int[] nums, int left, int right) {
        int minSum = Integer.MAX_VALUE;
        boolean found = false;
        
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
                found = true;
            }
            
            // Second Inner Loop: Slides the window to check ALL OTHER windows of that same size
            for (int i = length; i < nums.length; i++) {
                sum = sum - nums[i - length] + nums[i];
                
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                    found = true;
                }
            }
        }
        
        return found ? minSum : -1;
    }
}
