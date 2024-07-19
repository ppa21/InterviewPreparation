class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = modifiedBinarySearch(nums, target, true);
        int right = modifiedBinarySearch(nums, target, false);

        return new int[]{left, right};
    }

    /*
        leftBias = [true / false] -> if false, then it's rightBias
            * if leftBias == true, we're looking for the left most index
            * if leftBias == false, we're looking for the right most index
     */
    private int modifiedBinarySearch(int[] nums, int target, boolean leftBias) {
        int left = 0;
        int right = nums.length - 1;
        int value = -1;

        while(left <= right) {
            int middle = (left + right) / 2;

            if(target > nums[middle]) {
                // we're looking for the right most index -> shift the left pointer to middle + 1
                left = middle + 1;
            } else if(target < nums[middle]) {
                // we're looking for the left most index -> shift the right pointer to middle - 1
                right = middle - 1;
            } else {
                value = middle;     // if we break here, and return value -> that's regular BS

                if(leftBias) {
                    // if leftBias == true, we're looking for the left most index -> shift the right pointer to middle - 1
                    right = middle - 1;
                } else {
                    // if rightBias == true, we're looking for the right most index -> shift the left pointer to middle + 1
                    left = middle + 1;
                }
            }
        }

        return value;
    }
}