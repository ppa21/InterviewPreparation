class Solution {
    /*
        * Dynamic Programming with Memoization

        * Time complexity  = O(n^3); one outer loop; 2 recursive calls
        * Space Complexity = O(n^2); 2d dp array
    */
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        return dfs(nums, 0, nums.length - 1, dp);
    }

    private int dfs(int[] nums, int left, int right, int[][] dp) {
        // If there are no more balloons left to burst (left > right), we can't get any more coins, so we return 0.
        if (left > right) {
            return 0;
        }
        // If we've already solved this subproblem before, we return the stored answer to avoid redundant computation.
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        // We try every balloon (from 'left' to 'right') as the last one to burst.
        for (int i = left; i <= right; i++) {
            // The coins we get for bursting balloon 'i' is its value...
            int coins = nums[i];

            // If left - 1 >= 0, it means there’s a balloon to the left of the subarray, so we multiply the current balloon’s value by the value of this left balloon
            if (left - 1 >= 0) {
                coins *= nums[left - 1];
            }
            // If right + 1 < nums.length, it means there’s a balloon to the right of the subarray, so we multiply the current balloon’s value by the value of this right balloon.
            if (right + 1 < nums.length) {
                coins *= nums[right + 1];
            }

            // We add the maximum coins we can get from bursting the remaining balloons on the left and right of 'i'.
            coins += dfs(nums, left, i - 1, dp) + dfs(nums, i + 1, right, dp);

            // We update our DP table with the maximum coins we can get for this subproblem.
            dp[left][right] = Math.max(dp[left][right], coins);
        }

        // We return the maximum coins we can get for this subproblem.
        return dp[left][right];
    }
}
