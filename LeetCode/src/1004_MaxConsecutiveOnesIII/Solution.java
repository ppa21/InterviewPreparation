/*
        * time complexity  = O(n)
        * space complexity = O(1)
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            // flip 0 to 1
            if (nums[right] == 0) {
                k--;
            }

            while (k < 0) {
                // shrink the window and unflip 0 to 1
                if (nums[left] == 0) {
                    k++;
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
