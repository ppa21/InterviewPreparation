class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        /*
            public static short[] copyOfRange(short[] original, int from, int to)
                * original − This is the array from which a range is to to be copied.
                * from − This is the initial index of the range to be copied, INCLUSIVE.
                * to − This is the final index of the range to be copied, EXCLUSIVE.


            Input: nums = [1, 2, 3, 4, 5, 6, 7] -----> length = 7

            Arrays.copyOfRange(nums, 0, nums.length - 1)
                * (nums, 0, 6)
                    * INDEXES 0 - 5 BOTH INCLUDED
                        * [1, 2, 3, 4, 5, 6] -----> max = 6
            Arrays.copyOfRange(nums, 1, nums.length)
                * (nums, 1, 7)
                    * INDEXES 1 - 6 BOTH INCLUDED
                        * [2, 3, 4, 5, 6, 7] -----> max = 7

            max(6, 7) = 7
         */
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    // Solution to 198. House Robber
    private int helper(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}