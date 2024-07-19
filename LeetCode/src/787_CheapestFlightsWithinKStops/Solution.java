class Solution {
    /*
        * Time Complexity  = O(k * n)
        * Space Complexity = O(n)
    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize an array with max value of size n. This array represents the minimum cost to reach each city.
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;    // The price from source to source is always 0

        // We iterate k+1 times. Each iteration represents the state after i flights.
        // It also says at most k stops
            // so we have to include k
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, prices.length);

            for (int j = 0; j < flights.length; j++) {
                int s = flights[j][0]; // from
                int d = flights[j][1]; // to
                int p = flights[j][2]; // price

                // If the source city has not been visited yet, skip this flight
                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }

                // If the current flight provides a cheaper way to reach the destination city, update the cost
                if (prices[s] + p < temp[d]) {
                    temp[d] = prices[s] + p;
                }
            }

            // Update the prices array to the state after i flights
            prices = temp;
        }

        // If the destination city can be reached within k stops, return the cost. Otherwise, return -1.
        if (prices[dst] != Integer.MAX_VALUE) {
            return prices[dst];
        }

        return -1;
    }
}
