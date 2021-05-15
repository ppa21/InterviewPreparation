class Solution {
    public int climbStairs(int n) {
        // don't have to worry about n < 1 because we have a constraint of 1 <= n <= 45
        if(n == 1) {
            return n;
        }

        // n + 1 because we want to return number of distinct ways to reach step n
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}