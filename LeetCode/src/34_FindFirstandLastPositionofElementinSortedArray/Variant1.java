/**
        * Time Complexity:  O(log n) 
        * Space Complexity: O(1) 

        * Variant: What if you had to return the number of occurrences of a target number?
*/
class Solution {
    public int searchRangeFirstVariant(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return 0;
        }

        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) / 2) + left;

            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] != target) {
            return 0;
        }

        result[0] = left;
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) / 2) + left;

            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[1] = right;
        
        return result[1] - result[0] + 1;
    }
}
