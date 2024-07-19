class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int middle = (left + right) / 2;

            if(target == nums[middle]) {
                return middle;
            } else if(nums[left] <= nums[middle]) {
                if(target < nums[middle] && target >= nums[left]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if(target > nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}