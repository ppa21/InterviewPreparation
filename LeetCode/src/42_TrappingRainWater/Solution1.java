class Solution {
    /*
        * time complexity  = O(n)
        * space complexity = O(n)

        if one side is smaller, that's the bottleneck;
        meaning that's the max height you can have;
        otherwise, the water will overflow;
        hence, formula: Math.min(leftMax[i], rightMax[i]) - height[i]
        height   = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
        leftMax  = [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
        rightMax = [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
    */
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = height[0];
        for (int i = 0; i < leftMax.length; i++) {
            leftMax[i] = Math.max(height[i], max);
            max = leftMax[i];
        }

        max = height[height.length - 1];
        for (int i = rightMax.length - 1; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], max);
            max = rightMax[i];
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result = result + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }
}
