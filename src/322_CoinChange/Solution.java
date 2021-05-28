class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
            Ex:
                * amount = 7 -> dp.length = amount + 1 = 8 -> dp goes from index 0 to index 7 -> return dp[amount] because:
                    * For instance:
                        * dp[amount] = min number of coins needed to reach amount -> Stored at index amount
                        * Because Array starts at 0, and let's say amount = 7
                            * dp[7] = min number of coins needed to reach amount 7
                            * if dp.length == amount -> dp.length = 7:
                                * dp[7] = OUT OF BOUNDS
         */
        int[] dp = new int[amount + 1];

        /*
         * Fill it with some invalid amount -> amount + 1 because:
         * dp[3] = min number of coins needed to reach amount 3 -> 7 + 1 -> 8
         * Invalid because you can reach amount 3 ($3, for instance) with just 2 coins
         * 1 $1 coin and 1 $2 coin = 2 coins to reach amount 3
         * So, 8 is invalid which we filled dp with
         */
        Arrays.fill(dp, amount + 1);

        // dp[0] = min number of coins needed to reach amount 0
        dp[0] = 0;

        for(int i = 0; i <= amount; i++) {
            for(int coin : coins) {
                /*
                    Want amount i >= coin value because if your coin value > amount i,
                    you are not going to reach amount i. You are going to exceed the goal amount
                 */
                if(i >= coin) {
                    /*
                     * Simulate having taken coin -> + 1
                     * What does our new amount that we need to reach become?
                     * amount i - coin
                     * i - coin
                     * dp[i - coin]
                     * Hoping this is a sub-problem we've solved
                     */
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        /*
         * Min number of coins needed to reach amount will be stored at dp[amount]
         * Initially, we set every value in dp to amount + 1
         * So now, we check if dp[amount] != amount + 1
         * If dp[amount] != amount + 1:
         * dp[amount] = min number of coins needed to reach amount
         * Otherwise:
         * You can't reach amount
         * return -1
         */
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}