/*
         * Time Complexity:  O(n)
         * Space Complexity: O(n)

         * Variant: What if you had to return all of the buildings that either have an ocean view
           to its left and/or its right? This becomes very similar to Leetcode 42 Trapping Rain Water
         * similar to TRAPPING RAIN WATER solution 2
 */
class Solution {
    public int[] findBuildingViewCount_second_variant_1762(int[] heights) {
        int n = heights.length;
        if (n == 0 || n == 1) {
            return new int[0];
        }

        int left = 0;
        int right = n - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();
        
        leftView.add(left);
        rightView.add(right);

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (left < right && heights[left] > leftMax) {
                    leftView.add(left);
                    leftMax = heights[left];
                }
            } else {
                right--;
                if (left < right && heights[right] > rightMax) {
                    rightView.add(right);
                    rightMax = heights[right];
                }
            }
        }

        Collections.reverse(rightView);
        leftView.addAll(rightView);

        int[] result = new int[leftView.size()];
        for (int i = 0; i < leftView.size(); i++) {
            result[i] = leftView.get(i);
        }
        
        return result;
    }
}
