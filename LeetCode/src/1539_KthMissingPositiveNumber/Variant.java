/*
    * Time Complexity  = O(logn)
    * Space Complexity = O(1)

    * formula
        * nums[middle] - nums[0] - middle
        * count of missing numbers up until index middle
            * starting from nums[0]
*/
class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int missing = nums[middle] - nums[0] - middle;

            if (missing < k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        // right = index of last element where we had < k missing elements
        return nums[0] + k + right;      // left + k ----> right + k + nums[0]
    }
}
