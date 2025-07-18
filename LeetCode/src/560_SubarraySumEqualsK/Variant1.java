/*
        * Time Complexity  = O(n);
        * Space Complexity = O(n);

        * variant: what if you had to return true or false if there exists at least one subarray that equals K?
*/
class Solution {
    public boolean subarraySum(int[] nums, int k) {
        int currPrefixSum = 0;
        Set<Integer> prefixSums = new HashSet<>();
        
        // base case
        prefixSums.add(0);
        
        for (int n : nums) {
            currPrefixSum += n;
            
            // currPrefixSum - k ----> previous prefix sum that CANCELS OUT currPrefixSum and LEAVES remainder k
            if (prefixSums.contains(currPrefixSum - k)) {
                return true;
            }
            
            prefixSums.add(currPrefixSum);
        }
        
        return false;
    }
}
