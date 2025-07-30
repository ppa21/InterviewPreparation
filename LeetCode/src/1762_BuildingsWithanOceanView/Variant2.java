/*
         * Time Complexity:  O(n)
         * Space Complexity: O(1)

         * Variant: What if you had to return all of the buildings that either have an ocean view
           to its left and/or its right? This becomes very similar to Leetcode 42 Trapping Rain Water
         * similar to TRAPPING RAIN WATER solution 2
 */
class Solution {
    public List<Integer> findBuildingsWithOceanView(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0;   // Max height seen from left
        int rightMax = 0;  // Max height seen from right
        
        while (left <= right) {
            if (leftMax < rightMax) {
                // Process from left side
                if (heights[left] > leftMax) {
                    result.add(left);
                }
                leftMax = Math.max(leftMax, heights[left]);
                left++;
            } else {
                if (heights[right] > rightMax) {
                    result.add(right);
                }
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }
        
        Collections.sort(result);
        return result;
    }
}
