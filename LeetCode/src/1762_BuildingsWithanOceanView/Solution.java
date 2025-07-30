/*
         * Time Complexity:  O(n)
         * Space Complexity: O(n)
 */
class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int rightMax = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > rightMax) {
                list.add(i);
                rightMax = heights[i];
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(list.size() - 1 - i);
        }

        return result;
    }
}
