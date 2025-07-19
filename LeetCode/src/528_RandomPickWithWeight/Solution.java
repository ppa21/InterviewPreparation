/*
        * time complexity  = O(logn)
        * space complexity = O(n)
*/
class Solution {
    private List<Integer> prefixSum = new ArrayList<>(); // Cumulative weights for range mapping; [1, 2, 3] -> [1, 3, 6]
    private Random random = new Random();

    public Solution(int[] w) {
        for (int weight : w) {
            if (prefixSum.isEmpty()) {
                prefixSum.add(weight);
            } else {
                prefixSum.add(prefixSum.get(prefixSum.size() - 1) + weight);
            }
        }
    }
    
    public int pickIndex() {
        int roll = random.nextInt(prefixSum.get(prefixSum.size() - 1)); // Random number in [0, totalWeight)
        int left = 0;
        int right = prefixSum.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (roll < prefixSum.get(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
