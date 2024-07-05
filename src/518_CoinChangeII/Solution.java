class Solution {
    /*
        * Time Complexity  = O(n * amount); n = size of coins
        * Space Complexity = O(amount)
    */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // coin : coins in the outer loop because we want to avoid counting the same combination multiple times
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    /*
                        * Ways to reach amount i is stored at dp[i]
                        * New amount = i - coin;
                            * Ways to reach amount i - coin is stored at dp[i - coin];
                        * So, we:
                            * dp[i] += dp[i - coin];
                                * This will give us all ways to reach amount i, stored at dp[i] without counting the same coin more than once
                    */
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }
}
