/*
    * Time Complexity  = O(n)
    * Space Complexity = O(1) 
*/
class Solution {
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int result = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest reachable index of this jump.
            right = Math.max(right, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == left) {
                result++;
                left = right;
            }
        }

        return result;
    }
}
