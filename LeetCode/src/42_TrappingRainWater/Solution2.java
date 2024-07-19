class Solution {
    /*
        * time complexity  = O(n)
        * space complexity = O(1)

        same formula = Math.min(leftMax, rightMax) - height[i]
        in the first if statement: leftmax < rightMax
            so we know leftMax is smaller than rightMax
                hence, Math.min(leftMax, rightMax) is SATISFIED
            then we do Math.max(leftMax, height[left])
                this is so we take the max from the left side
            lastly, we do result += leftMax - height[left]
                hence, the full formula = Math.min(leftMax, rightMax) - height[left] is SATISFIED
    */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
            }
        }

        return result;
    }
}