public class Solution {
    /*
        * Time Complexity  = O(n * sum); n = size of nums
        * Space Complexity = O(sum)
    */
    public boolean canPartition(int[] nums) {
        // Calculate the sum of all elements in the array
        int sum = Arrays.stream(nums).sum();

        // If the sum is odd, it's impossible to partition the array into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // The target sum for each subset is half of the total sum
        int target = sum / 2;

        // Initialize a boolean array dp where dp[i] will be 'true' if there exists a subset whose sum is i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // There is always an empty set with sum 0

        for (int n : nums) {
            // Iterate from the target down to the current number
            for (int i = target; i >= n; i--) {
                // If there exists a subset whose sum is (i - n), then we can form a subset with sum i by including the current number
                if (dp[i - n] == true) {
                    // If i equals the target sum, we found a subset whose sum is the target sum
                    if (i == target) {
                        return true;
                    }
                    
                    // Mark dp[i] as true
                    dp[i] = true;
                }
            }
        }
        // If no subset with sum equal to the target sum is found, return false
        return false;
    }
}
