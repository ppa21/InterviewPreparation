/*
        * time complexity  = O(n)
        * space complexity = O(1)

        * Variant: What if you had to return the minimum cost to buy a roundtrip flight?
          Note you cannot fly somewhere and back on the same day.
*/
class Solution {
    public int findCheapestTickets(int[] departures, int[] returns) {
        int left = 0;    // departure
        int right = 1;   // arrival
        int cost = 0;
        int minCost = Integer.MAX_VALUE;

        while(right < departures.length) {
            cost = returns[right] + departures[left];  // roundtrip cost: depart on left day, return on right day
            minCost = Math.min(minCost, cost);
            
            // found a cheaper departure day
            if(departures[right] < departures[left]) {
                left = right;
            }
            right++;
        }

        return minCost;
    }
}
