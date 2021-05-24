class Solution {
    public int maxProfit(int[] prices) {
        /*
            prices = [7,1,5,3,6,4]

            * Solution: Use TWO POINTERS PATTERN

            * left = 0
            * right = 1
            * profit = 0
            * maxProfit = 0

            * Follow Rules **while right < prices.length:**
                Rules:
                    1) if prices[left] < prices[right]:
                        * profit = prices[right] - prices[left]
                        * maxProfit = Math.max(maxProfit, profit)
                    2) else:
                        * Meaning prices[left] >= prices[right]
                        * left = right
                    3) Only re-assign the left pointer as the right pointer if profit[left] >= profit[right]
                        * This is the **ELSE** case described in **STEP 2**
                        * left = right only when prices[left] >= prices[right]
                    4) Always increment the right pointer

            * return maxProfit
         */

        int left = 0;
        int right = 1;
        int profit = 0;
        int maxProfit = 0;

        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}