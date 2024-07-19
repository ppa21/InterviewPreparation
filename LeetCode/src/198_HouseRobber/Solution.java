class Solution {
    public int rob(int[] nums) {
        // If you have no houses to rob, you will not make any money.
        if(nums == null || nums.length == 0) {
            return 0;
        }

        /*
            If you only have 1 house to rob, the max amount of money you
            will make is by robbing the only house available.
         */
        if(nums.length == 1) {
            return nums[0];
        }

        /*
            If you have 2 houses to rob, you can only choose to rob 1 house.
            This is because you can't rob adjacent houses or you will trigger
            the alarm. So, you want to chose 1 house that will give you the
            most amount of money.
         */
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];        // dp represents max amount of money that we can rob upto some index
        dp[0] = nums[0];                        // dp[0] = max amount of money that we can rob upto 0th house, which is just robbing that house
        dp[1] = Math.max(nums[0], nums[1]);     // dp[1] = max amount of money that we can rob upto 1st house, which is choosing the house that we make more money off of, so either robbing nums[0] or nums[1]

        for(int i = 2; i < nums.length; i++) {
            /*
                Option 1:
                    Robbing the current house: nums[i]
                                +
                    dp[i - 2] = max amount of money that we can rob upto i - 2 house (house i - 1 is not included because it'll trigger the alarm since it'll be adjacent)

                Option 2:
                    dp[i - 1] = max amount of money that we can rob upto i - 1 house (house i is not included because it'll trigger the alarm since it'll be adjacent)
             */
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}