/*
        * time complexity  = O(logn)
        * space complexity = O(1)

        * Variant: What if you had to find the valley element, no longer a peak element?
*/
class Solution {
    public int findValleyElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
        
            // Check if mid is a valley: smaller than both neighbors
            // Boundaries are treated as positive infinity, so edge elements only need one comparison
            if ((mid == nums.length - 1 || nums[mid + 1] > nums[mid]) &&
                (mid == 0 || nums[mid - 1] > nums[mid])) {
                return mid;
            }
        
            if (nums[mid + 1] < nums[mid]) {        // If right neighbor is smaller, valley must be on the right side
                left = mid + 1;
            } else {                                // If left neighbor is smaller, valley must be on the left side
                right = mid - 1;
            }
        }
    
        return -1; // Should never reach here given problem constraints
    }
}
