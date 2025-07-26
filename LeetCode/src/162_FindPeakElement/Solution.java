/*
        * time complexity  = O(logn)
        * space complexity = O(1)

        questions to ask:
            1) does each value in the array only have unique values neighbouring it? YES
            2) are we given at least 1 element in the array? YES
            3) are there multiple peaks in the array? THERE CAN BE
            4) are we guaranteed at least one peak in the array? YES
            5) are the edges of our array negative infinity? YES   
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
        
            // Check if mid is a peak: greater than both neighbors
            // Boundaries are treated as negative infinity, so edge elements only need one comparison
            if ((mid == nums.length - 1 || nums[mid + 1] < nums[mid]) &&
                (mid == 0 || nums[mid - 1] < nums[mid])) {
                return mid;
            }
        
            if (nums[mid + 1] > nums[mid]) {        // If right neighbor is greater, peak must be on the right side
                left = mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {       // If left neighbor is greater, peak must be on the left side
                right = mid - 1;
            }
        }
    
        return -1; // Should never reach here given problem constraints
    }
}
