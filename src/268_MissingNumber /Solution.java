class Solution {
    public int missingNumber(int[] nums) {
        /* add all numbers from 0 to nums.length, including 0 and nums.length
         * AKA add numbers in the range [0, nums.length] including both 0 and nums.length
         */
        int sum = 0;
        for(int i = 0; i <= nums.length; i++) {
            sum += i;
        }

        int numsTotal = 0;
        for(int i = 0; i < nums.length; i++) {
            numsTotal += nums[i];
        }

        // subtracting them gives the missing number
        return sum - numsTotal;
    }
}