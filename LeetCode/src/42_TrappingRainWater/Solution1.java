class Solution {
    /*
        * time complexity  = O(n)
        * space complexity = O(n)

        if one side is smaller, that's the bottleneck;
        meaning that's the max height you can have;
        otherwise, the water will overflow;
        hence, formula: Math.min(left[i], right[i]) - height[i]
        height   = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        left  = [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
        right = [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
    */
    public int trap(int[] height) {
        public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = height[0];
        for (int i = 0; i < height.length; i++) {
            left[i] = Math.max(height[i], max);        // MUST have max in Math.max() function
            max = left[i];
        }

        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(height[i], max);
            max = right[i];
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result = result + Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
    }
}
