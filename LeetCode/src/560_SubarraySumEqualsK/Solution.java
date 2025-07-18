/*
        * Time Complexity  = O(n);
        * Space Complexity = O(n);
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currPrefixSum = 0;
        Map<Integer, Integer> prefixSumToFreq = new HashMap<>();

        // base case
        prefixSumToFreq.put(0, 1);

        for (int n : nums) {
            currPrefixSum += n;

            // currPrefixSum - k ----> previous prefix sum that CANCELS OUT currPrefixSum and LEAVES remainder k
            if (prefixSumToFreq.containsKey(currPrefixSum - k)) {
                count += prefixSumToFreq.get(currPrefixSum - k);
            }

            prefixSumToFreq.put(currPrefixSum, prefixSumToFreq.getOrDefault(currPrefixSum, 0) + 1);
        }

        return count;
    }
}
