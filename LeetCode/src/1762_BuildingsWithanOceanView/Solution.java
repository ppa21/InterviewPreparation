/*
         * Time Complexity:  O(n)
         * Space Complexity: O(1)
 */
class Solution {
    public List<Integer> findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int rightMax = 0;
        
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > rightMax) {
                result.add(i);
                rightMax = heights[i];
            }
        }
        
        // Reverse to get increasing order of indices
        Collections.reverse(result);
        return result;
    }
}
