class Solution {
    /*
     * time complexity  = O(n)
     * space complexity = O(n)
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices
        int maxArea = 0; // Initialize the maximum area

        // Loop through each bar in the histogram
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                /*
                 * When the current bar's height (heights[i]) is less than the height of the bar
                 * at the top of the stack (heights[stack.peek()]), we pop the stack.
                    * This indicates that the popped bar cannot extend further to the right, and we calculate the area
                    * for the popped bar.
                 * The width of the rectangle is determined by the difference in
                 * indices (i - stack.peek() - 1).
                 * The height of the rectangle is the height of the popped bar.
                 * We then update the maximum area if necessary.
                 */
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i); // Push the current bar index onto the stack
        }

        // Process any remaining bars in the stack
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}