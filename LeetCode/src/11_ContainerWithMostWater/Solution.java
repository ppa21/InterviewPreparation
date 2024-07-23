class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int pointerA = 0;
        int pointerB = height.length - 1;

        while(pointerA < pointerB) {
            if(height[pointerA] < height[pointerB]) {
                /*
                 * consider height = [2, 3, 1, 4, 6, 5, 3] -> length = 7
                 * we want to create a bucket such that it holds the most water;
                 * meaning we want to find area by choosing the smallest height of
                 * the 2, so water doesn't overflow from the smallest side and
                 * finding the distance (width) between 2 indexes;
                 *
                 * In the first iteration, we have these values:
                 * pointerA = index 0 -> height[0] = 2;
                 * pointerB = index 6 -> height[6] = 3;
                 * maxArea = Math.max(0, 2 * (6 - 0)) = 12;
                 * pointerA++ -> index 1;
                 */
                maxArea = Math.max(maxArea, height[pointerA] * (pointerB - pointerA));
                pointerA++;
            } else {
                /*
                 * In the second iteration, we have these values:
                 * pointerA = index 1 -> height[1] = 3;
                 * pointerB = index 6 -> height[6] = 3;
                 * maxArea = Math.max(12, 3 * (6 - 1)) = 15;
                 * pointerB-- -> index 5;
                 */
                maxArea = Math.max(maxArea, height[pointerB] * (pointerB - pointerA));
                pointerB--;
            }
        }

        return maxArea;
    }
}
