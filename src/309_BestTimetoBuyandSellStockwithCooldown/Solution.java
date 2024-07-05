public class Solution {
    /*
        * Buy: AFTER A buy, YOU MAY ENTER A hold OR EVENTUALLY A sell BUT NOT IMMEDIATELY ENTER A cooldown; YOU HAVE TO sell FIRST
        * Sell: AFTER A sell, YOU MUST ENTER A cooldown
        * Cooldown: YOU DO NOTHING FOR THE DAY.

        * Time Complexity  = O(n); size of prices == size of dp
        * Space Complexity = O(n)
    */
    public int maxProfit(int[] prices) {
        // If the prices array is empty or only contains one element, we can't make any transactions, so the profit is 0
        if (prices.length <= 1) {
            return 0;
        } 
        
        // Array to hold the maximum profit for each day
        int[] dp = new int[prices.length];
        
        /*
            * Variable to hold the maximum profit of the previous cooldown state
            * Before cooldown, comes selling
                * After selling, you have to take cooldown
            * Initially 0, because you haven't sold anything
        */
        int prevCooldownProfit = 0;
        
        /*
            * Variable to hold the maximum profit if we buy on the previous day. 
            * Initialized to negative of first day's price to simulate buying on the first day.
        */
        int prevBuy = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            // If we end the day with a cooldown, we could have either done nothing from the previous cooldown state, or sold a stock the previous day
            int newCooldownProfit = Math.max(prevCooldownProfit, dp[i - 1]);
            
            // If we end the day with a buy, we could have either done nothing from the previous buy state, or bought a stock from the previous cooldown state
            int newBuy = Math.max(prevBuy, prevCooldownProfit - prices[i]);
            
            // If we end the day with a sell, it means we must have sold the stock from the previous buy state
            dp[i] = newBuy + prices[i];
            
            // Update the previous cooldown and buy states
            prevCooldownProfit = newCooldownProfit;
            prevBuy = newBuy;
        }
        
        // The maximum profit is the maximum of the cooldown and sell states on the last day
        return Math.max(prevCooldownProfit, dp[prices.length - 1]);
    }
}
